package com.application.pidev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.Edit.UserEdit;
import com.application.pidev.Entity.In.UserIn;
import com.application.pidev.Entity.Out.UserOut;
import com.application.pidev.Entity.User.JwtToken;
import com.application.pidev.Entity.User.UserRole;
import com.application.pidev.Service.Interfaces.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserOut create(@Valid @RequestBody UserIn userIn) {
        return userService.create(userIn);
    }

    @PostMapping("/create/employee")
    @Secured("ROLE_ADMIN")
    public UserOut createEmployee(@RequestBody @Valid UserIn userIn) {
        return userService.createEmployee(userIn);
    }

    @GetMapping("/type/{type}")
    public List<UserOut> findByUserType(@PathVariable("type") UserRole.UserType userType,
                                        @RequestParam("disabledOnly")  Optional<String> disabledOnly ){
      if(disabledOnly.isPresent()){
          return userService.findAllByUserTypeAndNotEnabled(userType);
      }else{
          return userService.findAllByUserType(userType);
      }
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserOut findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public UserOut update(@PathVariable("id") Long id,
                          @RequestBody @Valid UserEdit userEdit) {
        return userService.update(id, userEdit);
    }

    @GetMapping("/byIdentifier/{identifier}")
    public UserOut findByIdentifier(@PathVariable("identifier") String identifier) {
        return userService.findByIdentifier(identifier);
    }

    @PatchMapping("/{id}/status")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public UserOut changeLockStatus(@PathVariable("id") Long id) {
        return userService.changeStatus(id);
    }

    @PatchMapping("/{id}/activate")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public UserOut changeEnableStatus(@PathVariable("id") Long id){
        return userService.changeEnableStatus(id);
    }

    @GetMapping("/auth/current")
    @PreAuthorize("isAuthenticated()")
    public UserOut findCurrentUser(){
        return userService.findCurrentUser();
    }

   
}
