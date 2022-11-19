package edu.uco.stl.service.usecase.command.lending.implementation;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.data.enumeration.DAOFactoryType;
import edu.uco.stl.domain.LendingDTO;
import edu.uco.stl.service.usecase.command.lending.CreateLendingCommand;
import edu.uco.stl.service.usecase.implementation.lending.CreateLendingUseCaseImpl;
import edu.uco.stl.service.usecase.lending.CreateLendingUseCase;

public class CreateLendingCommandImpl implements CreateLendingCommand {

	private DAOFactory factory;
	private final CreateLendingUseCase usecase = new CreateLendingUseCaseImpl(factory);

	@Override
	public void execute(LendingDTO lending) {
		try {
			factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
			factory.initTransction();
			usecase.execute(lending);
			factory.confirmTransaction();
		} catch (UseCaseCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (StlCustomException exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.wrapException(Messages.UseCaseCommand.TECHNICAL_PROBLEM_CREATING_LENDING,
					exception);
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.CreateBusinessException(
					Messages.UseCaseCommand.TECHNICAL_UNEXPECTED_PROBLEM_CREATING_LENDING, exception);
		} finally {
			factory.closeTransaction();
		}
	}

}
