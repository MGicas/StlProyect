package edu.uco.stl.service.usecase.implementation.admin;

import java.sql.SQLException;
import java.util.UUID;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.helper.StringHelper;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.admin.CreateAdminUseCase;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getNewUUID;


public class CreateAdminUseCaseImpl implements CreateAdminUseCase{

	private final DAOFactory factory;
	
	public CreateAdminUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public void execute(AdminDTO admin) {
		
		try {
			final UUID id = getNewUUID();
			final String identification = validateIdentification(admin.getIdentification());
			final String firstName = validateFirstName(admin.getFirstname());
			final String secondName = admin.getSecondName();
			final String firstSurname = validateFirstSurname(admin.getFirstSurname());
			final String secondSurname= admin.getSecondSurname();
			
			admin.setId(id);
			admin.setIdentification(identification);
			admin.setFirstname(firstName);
			admin.setFirstname(firstName);
			admin.setSecondName(secondName);
			admin.setFirstSurname(firstSurname);
			admin.setSecondSurname(secondSurname);
			
			factory.getAdminDAO().create(admin);
		}catch (UseCaseCustomException exception) {
			// TODO: handle exception
		}catch (StlCustomException exception) {
			// TODO: handle exception
		}catch (Exception exception) {
			// TODO: handle exception
		}
			
		
	}
	
	private final String validateFirstName(String firstName) {
		if(StringHelper.isDefaultString(firstName)) {
			throw UseCaseCustomException.CreateTechnicalException("El primer nombre es un dato obligatorio");
		}
		return firstName;
	}
	
	private final String validateIdentification(String identification) {
		if(StringHelper.isDefaultString(identification)) {
			throw UseCaseCustomException.CreateTechnicalException("La identificacion es un dato obligatorio");
		}
		return identification;
	}
	
	private final String validateFirstSurname(String firstSurname) {
		if(StringHelper.isDefaultString(firstSurname)) {
			throw UseCaseCustomException.CreateTechnicalException("El primer apellido es un dato obligatorio");
		}
		return firstSurname;
	}

}
