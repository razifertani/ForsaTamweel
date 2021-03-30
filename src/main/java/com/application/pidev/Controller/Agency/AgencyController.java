package com.application.pidev.Controller.Agency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.pidev.Entity.Agency.*;
import com.application.pidev.Service.Agency.*;

@RestController
@EnableAutoConfiguration

public class AgencyController {
	
	@Autowired
	AgencyService service;
	
	@GetMapping("/show-all-agengies")
	@ResponseBody
	public List<Agency> getAgencies() {
		List<Agency> list = service.getAllAgency();
		return list;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public Agency save(@RequestBody Agency ag){
		Agency agency = service.addAgency(ag);
		return agency;
	}
	
	@PutMapping("/update-agency")
	@ResponseBody
	public Agency updateAgency(@RequestBody Agency agency){
		return service.updateAgency(agency);
	}
	
	@DeleteMapping("/remove-agency/{id}")
	@ResponseBody
	public void removeAgency(@PathVariable("id") long id){
		service.deleteAgency(id);
	}

}
