package in.MyProject.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.MyProject.dao.IAdminRepo;
import in.MyProject.model.Admin;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminRepo repo; 
	
	@Override
	public Admin findAdmin(String staffId) {
		Optional<Admin> findById = repo.findById(staffId);
		Admin admin=new Admin();
		if (findById.isPresent() ) {
			admin = repo.findById(staffId).get();
			return admin;
		} else {
			return null;
		}
	}

}
