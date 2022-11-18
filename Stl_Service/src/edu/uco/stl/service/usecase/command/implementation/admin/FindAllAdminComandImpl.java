package edu.uco.stl.service.usecase.command.implementation.admin;

import java.util.List;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.data.enumeration.DAOFactoryType;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.admin.FindAllAdminUsecase;
import edu.uco.stl.service.usecase.command.admin.FindAllAdminCommand;
import edu.uco.stl.service.usecase.implementation.admin.FindAllAdminUseCaseImpl;

public class FindAllAdminComandImpl implements FindAllAdminCommand {
	
	private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
	private final FindAllAdminUsecase useCase = new FindAllAdminUseCaseImpl(factory);


	@Override
	public List<AdminDTO> execute() {
		try {
			factory.initTransction();
			List<AdminDTO> admin = useCase.execute();
			factory.confirmTransaction();
			return factory.getAdminDAO().find(null);
		} catch (UseCaseCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (StlCustomException exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.wrapException(Messages.UseCaseCommand.TECHNICAL_PROBLEM_CREATING_ADMIN,
					exception);
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw exception;
		} finally {
			factory.closeTransaction();
		}
	}
}
