package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.In.UserIn;
import com.application.pidev.Entity.Out.UserOut;
import com.application.pidev.Entity.User.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userInToUser(UserIn userIn);
    UserOut userToUserOut(User user);
}
