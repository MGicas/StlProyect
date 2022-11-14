package edu.uco.stl.service.usecase.implementation.admin;

import java.util.UUID;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.helper.StringHelper;
import edu.uco.stl.crosscutting.messages.Messages;
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
			throw exception;
		}catch (StlCustomException exception) {
			throw exception;
		}catch (Exception exception) {
			throw exception;
		}
			
		
	}
	
	private final String validateFirstName(String firstName) {
		if(StringHelper.isDefaultString(firstName)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseImpl.TECHNICAL_PROBLEM_VALIDATE_ADMIN_FIRSTNAME);
		}
		return firstName;
	}
	
	private final String validateIdentification(String identification) {
		if(StringHelper.isDefaultString(identification)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseImpl.TECHNICAL_PROBLEM_VALIDATE_ADMIN_IDENTIFICATION);
		}
		return identification;
	}
	
	private final String validateFirstSurname(String firstSurname) {
		if(StringHelper.isDefaultString(firstSurname)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseImpl.TECHNICAL_PROBLEM_VALIDATE_ADMIN_SECONDSURNAME);
		}
		return firstSurname;
	}

}
