package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.pidev.Entity.User.User;
import com.application.pidev.Entity.User.UserRole;

import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdentifier(String identifier);

    @Query("SELECT u " +
        "FROM User u " +
        "JOIN u.userRoles ur " +
        "WHERE ur.userType = :userType")
    List<User> findAllByUserType(@Param("userType") UserRole.UserType userType);

    @Query("SELECT u " +
        "FROM User u " +
        "JOIN u.userRoles ur " +
        "WHERE ur.userType = :userType " +
        "AND u.enabled = false")
    List<User> findAllByUserTypeAndNotEnabled(@Param("userType") UserRole.UserType userType);

    boolean existsByEmail(String email);

    boolean existsByIdentifier(String identifier);
}
