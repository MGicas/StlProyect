package edu.uco.stl.service.usecase.lending;

import java.util.UUID;

import edu.uco.stl.domain.LendingDTO;

public interface FindLendingUseCase {

	LendingDTO execute(UUID id);
}
