package com.application.pidev.Service.Interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.application.pidev.Entity.Edit.UserEdit;
import com.application.pidev.Entity.In.UserIn;
import com.application.pidev.Entity.Out.UserOut;
import com.application.pidev.Entity.User.JwtToken;
import com.application.pidev.Entity.User.UserRole;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserOut create(UserIn userIn);

    UserOut findCurrentUser();

    List<UserOut> findAllByUserType(UserRole.UserType userType);

    UserOut findById(Long id);

    UserOut update(Long id, UserEdit userEdit);

    UserOut createEmployee(UserIn userIn);

    UserOut changeStatus(Long id);

    UserOut findByIdentifier(String identifier);

    List<UserOut> findAllByUserTypeAndNotEnabled(UserRole.UserType userType);

    UserOut changeEnableStatus(Long id);

}
