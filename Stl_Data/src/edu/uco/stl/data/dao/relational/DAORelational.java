package edu.uco.stl.data.dao.relational;

import java.sql.Connection;
import edu.uco.stl.crosscutting.helper.*;
import edu.uco.stl.crosscutting.messages.*;
import edu.uco.stl.crosscutting.exception.crosscutting.DataCustomException;

public class DAORelational {
	
	private Connection connection;
	
	protected DAORelational(final Connection connection) {
		if(!SqlConnectionHelper.connectionIsOpen(connection)) {
			throw DataCustomException.CreateTechnicalException(Messages.DAORelational.TECHNICAL_CONNECTION_IS_CLOSED); 
		}
		this.connection = connection;
	}
	
	protected final Connection getConnection() {
		return connection;
	}

}
