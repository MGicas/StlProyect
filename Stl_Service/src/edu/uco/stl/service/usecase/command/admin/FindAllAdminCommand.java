package edu.uco.stl.service.usecase.command.admin;

import java.util.List;

import edu.uco.stl.domain.AdminDTO;

public interface FindAllAdminCommand {
	List<AdminDTO> get();

}
