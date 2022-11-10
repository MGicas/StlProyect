package edu.uco.stl.crosscutting.exception.crosscutting;

import edu.uco.stl.crosscutting.exception.enumeration.LayerException;
import edu.uco.stl.crosscutting.execption.StlCustomException;

public class DataCustomException extends StlCustomException {

	private static final long serialVersionUID = -5908039339245467264L;
	
	protected DataCustomException(String userMessage, String technicalMessage,
			Throwable rootException) {
		super(userMessage, LayerException.DATA, technicalMessage, rootException);
	}
	public static final StlCustomException CreateUserException(final String userMessage) {
		return new DataCustomException(userMessage, userMessage, new Exception());

	}

	public static final StlCustomException CreateTechnicalException(final String technicalMessage) {
		return new DataCustomException(null, technicalMessage, new Exception());

	}

	public static final StlCustomException CreateTechnicalException(final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(null, technicalMessage, rootException);

	}

	public static final StlCustomException Create(final String userMessage, final String technicalMessage) {
		return new DataCustomException(userMessage, technicalMessage, new Exception());

	}

	public static final StlCustomException Create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(userMessage, technicalMessage, rootException);
	}


}
