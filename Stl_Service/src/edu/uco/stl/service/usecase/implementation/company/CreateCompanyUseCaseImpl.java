package edu.uco.stl.service.usecase.implementation.company;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.helper.StringHelper;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.domain.CompanyDTO;
import edu.uco.stl.service.usecase.company.CreateCompanyUseCase;

public class CreateCompanyUseCaseImpl implements CreateCompanyUseCase{
	
	private final DAOFactory factory;
	
	public CreateCompanyUseCaseImpl (DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void execute(CompanyDTO company) {
		
		try {
			
			final UUID id = getNewUUID();
			final String name;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	private final String validateName(String name) {
		if(StringHelper.isDefaultString(name)) {
			throw UseCaseCustomException.CreateTechnicalException("El nombre de la empresa es un dato obligatorio");
		}
		return name;
	}

}
