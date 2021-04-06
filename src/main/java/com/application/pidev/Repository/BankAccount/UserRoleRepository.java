package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.User.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>
{
        UserRole findByUserType ( UserRole.UserType userType );
}
