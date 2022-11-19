package edu.uco.stl.service.usecase.implementation.lending;

import java.util.List;
import java.util.UUID;

import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.service.usecase.lending.FindLendingUseCase;
import edu.uco.stl.domain.LendingDTO;

public class FindLendingUseCaseImpl implements FindLendingUseCase{
	
	private final DAOFactory factory;
	
	public FindLendingUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public LendingDTO execute(UUID id) {
		
		LendingDTO result = new LendingDTO();
		final LendingDTO lending = LendingDTO.create(id);
		final List<LendingDTO> results = factory.getLendingDAO().find(lending);
		
		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
		
}


