package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.User.Address;

public interface AddressRepository extends JpaRepository<Address, Long>
{
}
