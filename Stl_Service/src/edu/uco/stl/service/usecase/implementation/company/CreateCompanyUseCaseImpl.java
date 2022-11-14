package edu.uco.stl.service.usecase.implementation.company;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.helper.StringHelper;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.domain.CompanyDTO;
import edu.uco.stl.service.usecase.admin.FindAdminUseCase;
import edu.uco.stl.service.usecase.company.CreateCompanyUseCase;
import edu.uco.stl.service.usecase.implementation.admin.FindAdminUseCaseImpl;

public class CreateCompanyUseCaseImpl implements CreateCompanyUseCase{
	
	private final DAOFactory factory;
	private final FindAdminUseCase findAdmin;
	
	public CreateCompanyUseCaseImpl (DAOFactory factory) {
		this.factory = factory;
		findAdmin = new FindAdminUseCaseImpl(factory);
	}

	@Override
	public void execute(CompanyDTO company) {
		
		try {
			
			final UUID id = getNewUUID();
			final String name = validateName(company.getName());
			final AdminDTO admin = validateAdmin(company.getAdminId().getId());
			
			company.setId(id);
			company.setName(name);
			company.setAdminId(admin);
			
			 factory.getCompanyDAO().create(company);
			
		} catch (UseCaseCustomException exception) {
			throw exception;
		}catch (StlCustomException exceptioin) {
			throw exceptioin;
		}catch (Exception exception) {
			throw exception;
		}
	
	}
	
	private final String validateName(String name) {
		if(StringHelper.isDefaultString(name)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseImpl.TECHNICAL_PROBLEM_VALIDATE_COMPANY_NAME);
		}
		return name;
	}
	
	private final AdminDTO validateAdmin(UUID id) {
		
		final AdminDTO admin = findAdmin.execute(id);
		
		if(!admin.exist()){
            throw UseCaseCustomException.CreateUserException("");
        }
		return admin;
	}

}
