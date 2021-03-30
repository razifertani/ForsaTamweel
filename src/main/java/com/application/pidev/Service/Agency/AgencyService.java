package com.application.pidev.Service.Agency;

import java.util.List;

import com.application.pidev.Entity.Agency.Agency;

public interface AgencyService {
	
	public List<Agency> getAllAgency();
	
	public Agency getById(long id);
	
	public Agency addAgency (Agency agency);
	
	public Agency updateAgency (Agency agency);
	
	public void deleteAgency(long id);

}
