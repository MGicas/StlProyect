package edu.uco.stl.crosscutting.exception.crosscutting;

import edu.uco.stl.crosscutting.exception.enumeration.LayerException;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;

public class UseCaseCustomException extends StlCustomException{
	
	private static final long serialVersionUID = -3691429994161697127L;

	protected UseCaseCustomException(String userMessage, String technicalMessage, Throwable rootException) {
		super(userMessage,LayerException.SERVICE, technicalMessage, rootException );
	}

	public static final StlCustomException CreateUserException(final String userMessage) {
	    return new UseCaseCustomException(userMessage, userMessage, new Exception());
	    
	}
	
	public static final StlCustomException CreateTechnicalException(final String technicalMessage) {
	    return new UseCaseCustomException(EMPTY, technicalMessage, new Exception());
	    
	}
	public static final StlCustomException CreateTechnicalException(final String technicalMessage, final Exception rootException) {
	    return new UseCaseCustomException(EMPTY, technicalMessage,rootException);
	    
	}
	public static final StlCustomException CreateBusinessException(final String businessMessage, final Exception rootException) {
	    return new UseCaseCustomException(businessMessage, EMPTY,rootException);
	    
	}
	public static final StlCustomException Create(final String userMessage, final String technicalMessage) {
	    return new UseCaseCustomException(userMessage, technicalMessage, new Exception());
	    
	}
	public static final StlCustomException Create(final String userMessage, final String technicalMessage, final Exception rootException ) {
	    return new UseCaseCustomException(userMessage, technicalMessage, rootException);
	}
	public static final StlCustomException wrapException(final String message, final StlCustomException exception){
            if(exception.isTechinalException()){
                throw UseCaseCustomException.CreateBusinessException(message, exception);
            }
            return exception;
	}

}
