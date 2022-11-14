package edu.uco.stl.data.dao.relational.mysql;

import java.sql.Connection;

import edu.uco.stl.data.dao.StlDAO;
import edu.uco.stl.data.dao.relational.DAORelational;

public class StlMySQLDAO extends DAORelational implements StlDAO{

	public StlMySQLDAO(Connection connection) {
		super(connection);
	}
	
}
