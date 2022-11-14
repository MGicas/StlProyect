package edu.uco.stl.service.usecase.lending;

import edu.uco.stl.domain.LendingDTO;

public interface CreateLendingUseCase {
	
	void execute(LendingDTO lending);

}
