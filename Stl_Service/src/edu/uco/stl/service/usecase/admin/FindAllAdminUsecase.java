package edu.uco.stl.service.usecase.admin;

import java.util.List;

import edu.uco.stl.domain.AdminDTO;

public interface FindAllAdminUsecase {
	List<AdminDTO> execute();

}
