package edu.uco.stl.service.usecase.admin;

import java.util.UUID;

import edu.uco.stl.domain.AdminDTO;

public interface FindAdminUseCase {
	
	AdminDTO execute(UUID id);

}
