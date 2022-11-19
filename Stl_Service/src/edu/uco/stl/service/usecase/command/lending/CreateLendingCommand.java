package edu.uco.stl.service.usecase.command.lending;

import edu.uco.stl.domain.LendingDTO;

public interface CreateLendingCommand {
	
	void execute(LendingDTO lending);

}
