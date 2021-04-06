package com.application.pidev.Service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.pidev.BankAccountsSettings.Mappers.UserMapper;
import com.application.pidev.BankAccountsSettings.Utils.Constants;
import com.application.pidev.Entity.Edit.UserEdit;
import com.application.pidev.Entity.In.UserIn;
import com.application.pidev.Entity.Out.UserOut;
import com.application.pidev.Entity.User.JwtToken;
import com.application.pidev.Entity.User.User;
import com.application.pidev.Entity.User.UserRole;
import com.application.pidev.Repository.UserRepository;
import com.application.pidev.Repository.UserRoleRepository;
import com.application.pidev.Service.Interfaces.EmailService;
import com.application.pidev.Service.Interfaces.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    private final Constants CONSTANTS;


    private final EmailService emailService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           UserMapper userMapper,
                           BCryptPasswordEncoder passwordEncoder,
                           Constants CONSTANTS,
                           EmailService emailService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;
        this.CONSTANTS = CONSTANTS;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public UserOut create(UserIn userIn) {
        User mapped = userMapper.userInToUser(userIn);
        mapped.setLocked(false);
        mapped.setCredentials(false);
        mapped.setEnabled(false);

        String identifier = generateIdentifier();
        mapped.setIdentifier(identifier);
        mapped.setUserRoles(Collections.singleton(
            userRoleRepository.findByUserType(UserRole.UserType.ROLE_USER))
        );
        mapped.setPassword(passwordEncoder.encode(userIn.getPassword()));

        emailService.sendRegisterMail(mapped.getEmail(), identifier);

        return userMapper.userToUserOut(userRepository.save(mapped));
    }

    private String generateIdentifier() {
        String identifier;
        do {
            identifier = RandomStringUtils.randomNumeric(CONSTANTS.USER_IDENTIFIER_LENGTH);
        } while (identifier.charAt(0) == '0' || userRepository.existsByIdentifier(identifier));

        return identifier;
    }

    @Override
    public UserOut findCurrentUser() {
        return userRepository.findByIdentifier(SecurityContextHolder.getContext().getAuthentication().getName())
            .map(userMapper::userToUserOut)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserOut> findAllByUserType(UserRole.UserType userType) {
        return userRepository.findAllByUserType(userType)
            .stream()
            .map(userMapper::userToUserOut)
            .collect(Collectors.toList());
    }

    @Override
    public UserOut findById(Long id) {
        return userRepository.findById(id)
            .map(userMapper::userToUserOut)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public UserOut update(Long id, UserEdit userEdit) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not foud"));

        if (StringUtils.isNotBlank(userEdit.getEmail()))
            user.setEmail(userEdit.getEmail().trim());

        if (StringUtils.isNotBlank(userEdit.getIdentifier()))
            user.setIdentifier(userEdit.getIdentifier().trim());

       

        return userMapper.userToUserOut(userRepository.save(user));
    }

    @Override
    public UserOut createEmployee(UserIn userIn) {
        User mapped = userMapper.userInToUser(userIn);
        mapped.setLocked(false);
        mapped.setCredentials(false);
        mapped.setEnabled(true);
        String identifier = generateIdentifier();
        mapped.setIdentifier(identifier);
        mapped.setUserRoles(Collections.singleton(
            userRoleRepository.findByUserType(UserRole.UserType.ROLE_EMPLOYEE))
        );
        mapped.setPassword(passwordEncoder.encode(userIn.getPassword()));

        emailService.sendRegisterMail(mapped.getEmail(), identifier);

        return userMapper.userToUserOut(userRepository.save(mapped));
    }

    @Override
    public UserOut changeStatus(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.isLocked()) {
            user.setLocked(false);
        } else if (!user.isLocked()) {
            user.setLocked(true);
        }

        return userMapper.userToUserOut(userRepository.save(user));
    }

    @Override
    public UserOut findByIdentifier(String identifier) {
        return userMapper.userToUserOut(
            userRepository.findByIdentifier(identifier).orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    @Override
    public List<UserOut> findAllByUserTypeAndNotEnabled(UserRole.UserType userType) {
        return userRepository.findAllByUserTypeAndNotEnabled(userType)
            .stream()
            .map(userMapper::userToUserOut)
            .collect(Collectors.toList());
    }

    @Override
    public UserOut changeEnableStatus(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.isEnabled()) {
            user.setEnabled(false);
        } else if (!user.isEnabled()) {
            user.setEnabled(true);
        }

        return userMapper.userToUserOut(userRepository.save(user));
    }

  

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByIdentifier(s)
            .orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }
}
