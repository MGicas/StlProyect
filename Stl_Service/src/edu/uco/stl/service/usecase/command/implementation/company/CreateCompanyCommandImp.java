package edu.uco.stl.service.usecase.command.implementation.company;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.data.enumeration.DAOFactoryType;
import edu.uco.stl.domain.CompanyDTO;
import edu.uco.stl.service.usecase.command.company.CreateCompanyCommand;
import edu.uco.stl.service.usecase.company.CreateCompanyUseCase;
import edu.uco.stl.service.usecase.implementation.company.CreateCompanyUseCaseImpl;

public class CreateCompanyCommandImp implements CreateCompanyCommand {

	private DAOFactory factory;
	private final CreateCompanyUseCase usecase = new CreateCompanyUseCaseImpl(factory);

	@Override
	public void execute(CompanyDTO company) {

		try {
			factory = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
			factory.initTransction();
			usecase.execute(company);
			factory.confirmTransaction();
		} catch (UseCaseCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (StlCustomException exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.wrapException(Messages.UseCaseCommand.TECHNICAL_PROBLEM_CREATING_COMPANY,
					exception);
		} catch (Exception exception) {
			factory.cancelTransaction();
			throw UseCaseCustomException.CreateBusinessException(
					Messages.UseCaseCommand.TECHNICAL_UNEXPECTED_PROBLEM_CREATING_COMPANY, exception);
		} finally {
			factory.closeTransaction();
		}
	}
}
