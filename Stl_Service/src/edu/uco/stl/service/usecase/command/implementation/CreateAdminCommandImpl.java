package edu.uco.stl.service.usecase.command.implementation;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.data.enumeration.DAOFactoryType;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.admin.CreateAdminUseCase;
import edu.uco.stl.service.usecase.command.CreateAdminCommand;
import edu.uco.stl.service.usecase.implementation.admin.CreateAdminUseCaseImpl;

public class CreateAdminCommandImpl implements CreateAdminCommand{
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
	private final CreateAdminUseCase useCase = new CreateAdminUseCaseImpl(factory);

	@Override
	public void execute(AdminDTO admin) {
		try {
			factory.initTransction();
			useCase.execute(admin);
			factory.confirmTransaction();
		}catch (UseCaseCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		}catch (StlCustomException exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.wrapException(null, exception);
		}catch (Exception exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.CreateBusinessException(null, exception);
		}finally {
			factory.closeTransaction();
		}
	}

}
