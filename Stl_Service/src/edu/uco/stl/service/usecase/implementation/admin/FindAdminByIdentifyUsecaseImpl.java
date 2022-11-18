package edu.uco.stl.service.usecase.implementation.admin;

import java.util.List;

import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.admin.FindAdminByIdentifyUsecase;

public class FindAdminByIdentifyUsecaseImpl implements FindAdminByIdentifyUsecase {
	
	private DAOFactory factory;
	
	public FindAdminByIdentifyUsecaseImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public AdminDTO execute(String identify) {
			AdminDTO result = new AdminDTO();
			final AdminDTO admin = AdminDTO.create(identify);

			final List<AdminDTO> results = factory.getAdminDAO().find(admin);

			if (!results.isEmpty()) {
				result = results.get(0);
			}
			return result;
		}
	}

