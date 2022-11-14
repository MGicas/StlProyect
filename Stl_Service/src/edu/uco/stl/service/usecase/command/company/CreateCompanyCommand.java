package edu.uco.stl.service.usecase.command.company;

import edu.uco.stl.domain.CompanyDTO;

public interface CreateCompanyCommand {
	
	void execute(CompanyDTO company);

}
