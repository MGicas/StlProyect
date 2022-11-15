package edu.uco.stl.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uco.stl.entity.AdminEntity;
import edu.uco.stl.repository.AdminRepository;
import edu.uco.stl.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repository;


	@Override
	public List<AdminEntity> listarAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
