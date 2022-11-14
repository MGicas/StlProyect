package edu.uco.stl.service.usecase.command;

import edu.uco.stl.domain.AdminDTO;

public interface CreateAdminCommand {
	
	void execute(AdminDTO admin);

}
