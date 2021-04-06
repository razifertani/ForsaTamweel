package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.CurrencyType;

import java.util.Optional;

public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long>
{
        Optional<CurrencyType> findByName ( String name );

}
