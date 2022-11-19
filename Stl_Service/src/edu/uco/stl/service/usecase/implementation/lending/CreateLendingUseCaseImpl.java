package edu.uco.stl.service.usecase.implementation.lending;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

import edu.uco.stl.crosscutting.exception.crosscutting.UseCaseCustomException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.helper.ObjectHelper;
import edu.uco.stl.crosscutting.helper.StringHelper;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.daofactory.DAOFactory;
import edu.uco.stl.domain.LendingDTO;
import edu.uco.stl.service.usecase.lending.CreateLendingUseCase;

public class CreateLendingUseCaseImpl implements CreateLendingUseCase{
	
	private final DAOFactory factory;
	
	public CreateLendingUseCaseImpl (DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void execute(LendingDTO lending) {
		try {
			final UUID id = getNewUUID();
			final String product = validateProduct(lending.getProduct());
			final int loanQuantity = validateloanQuantity(lending.getLoanQuantity());
			final String monitorRecieve = validateMonitorRecieve(lending.getMonitorRecieve());
			final String monitorGive = validateMonitorGive(lending.getMonitorGive());
			final String lenderName = validateLenderName(lending.getLenderName());
			
			lending.setId(id);
			lending.setProduct(product);
			lending.setLoanQuantity(loanQuantity);
			lending.setMonitorRecieve(monitorRecieve);
			lending.setMonitorGive(monitorGive);
			lending.setLenderName(lenderName);
			
			factory.getLendingDAO().create(lending);
			
		} catch (UseCaseCustomException exception) {
			throw exception;
		}catch (StlCustomException exception) {
			throw exception;
		}catch (Exception exception) {
			throw exception;
		}
		
	}
	
	private final String validateProduct(String product) {
		if(StringHelper.isDefaultString(product)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseLendingImpl.TECHNICAL_PROBLEM_VALIDATE_LENDING_PRODUCT);
		}
		return product;
	}
	
	private final int validateloanQuantity(int loanQuantity) {
		if(ObjectHelper.isNull(loanQuantity)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseLendingImpl.TECHNICAL_PROBLEM_VALIDATE_LENDING_LOANQUANTITY);
		}
		return loanQuantity;
	}
	
	
	private final String validateMonitorRecieve(String monitorRecieve) {
		if(StringHelper.isDefaultString(monitorRecieve)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseLendingImpl.TECHNICAL_PROBLEM_VALIDATE_LENDING_MONITOR_RECIEVE);
		}
		return monitorRecieve;
	}
	
	private final String validateMonitorGive(String monitorGive) {
		if(StringHelper.isDefaultString(monitorGive)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseLendingImpl.TECHNICAL_PROBLEM_VALIDATE_LENDING_MONITOR_GIVE);
		}
		return monitorGive;
	}
	
	private final String validateLenderName(String lenderName) {
		if(StringHelper.isDefaultString(lenderName)) {
			throw UseCaseCustomException.CreateTechnicalException(Messages.UseCaseLendingImpl.TECHNICAL_PROBLEM_VALIDATE_LENDING_LENDER_NAME);
		}
		return lenderName;
	}

}