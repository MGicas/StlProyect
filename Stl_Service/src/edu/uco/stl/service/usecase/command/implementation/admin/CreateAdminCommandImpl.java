package edu.uco.stl.service.usecase.command.implementation.admin;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.data.enumeration.DAOFactoryType;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.admin.CreateAdminUseCase;
import edu.uco.stl.service.usecase.command.admin.CreateAdminCommand;
import edu.uco.stl.service.usecase.implementation.admin.CreateAdminUseCaseImpl;

public class CreateAdminCommandImpl implements CreateAdminCommand {

	private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
	private final CreateAdminUseCase useCase = new CreateAdminUseCaseImpl(factory);

	@Override
	public void execute(AdminDTO admin) {
		
		try {
			factory.initTransction();
			useCase.execute(admin);
			factory.confirmTransaction();
		} catch (UseCaseCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (StlCustomException exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.wrapException(Messages.UseCaseCommand.TECHNICAL_PROBLEM_CREATING_ADMIN,
					exception);
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.CreateBusinessException(
					Messages.UseCaseCommand.TECHNICAL_UNEXPECTED_PROBLEM_CREATING_ADMIN, exception);
		}
	}
}
