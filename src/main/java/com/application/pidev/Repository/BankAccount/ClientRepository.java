package com.application.pidev.Repository.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccount.*;
public interface ClientRepository extends JpaRepository<Client, Long> {

}
