package com.application.pidev.Repository.BankAccount;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.application.pidev.Entity.BankAccount.*;
public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	/*
	 * @Query("select o from Operation o where o.compte.codeCompte =:x order by o.dateOperation desc"
	 * ) public List<Operation> listOperation(@Param("x")String codeCpte);
	 */

}
