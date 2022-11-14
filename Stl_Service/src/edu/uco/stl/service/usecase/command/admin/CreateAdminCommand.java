package edu.uco.stl.service.usecase.command.admin;

import edu.uco.stl.domain.AdminDTO;

public interface CreateAdminCommand {
	
	void execute(AdminDTO admin);

}
