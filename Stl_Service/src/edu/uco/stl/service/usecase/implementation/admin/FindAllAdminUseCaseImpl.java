package edu.uco.stl.service.usecase.implementation.admin;

import java.util.List;

import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.admin.FindAllAdminUsecase;

public class FindAllAdminUseCaseImpl implements FindAllAdminUsecase{
	private DAOFactory factory;
	
	public FindAllAdminUseCaseImpl(DAOFactory factory) {
		this.factory=factory;
	}

	@Override
	public List<AdminDTO> execute() {
		return factory.getAdminDAO().find(null);
	}

}
