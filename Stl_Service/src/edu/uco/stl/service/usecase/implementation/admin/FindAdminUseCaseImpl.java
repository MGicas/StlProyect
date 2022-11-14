package edu.uco.stl.service.usecase.implementation.admin;

import java.util.List;
import java.util.UUID;

import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.service.usecase.admin.FindAdminUseCase;
import edu.uco.stl.domain.AdminDTO;

public class FindAdminUseCaseImpl implements FindAdminUseCase {

	private final DAOFactory factory;

	public FindAdminUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public AdminDTO execute(UUID id) {

		AdminDTO result = new AdminDTO();
		final AdminDTO admin = AdminDTO.create(id);
		final List<AdminDTO> results = factory.getAdminDAO().find(admin);

		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}

}
