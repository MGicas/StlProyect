package edu.uco.stl.data.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uco.stl.crosscutting.exception.crosscutting.CrosscuttingCustomException;
import edu.uco.stl.crosscutting.exception.crosscutting.DataCustomException;
import edu.uco.stl.crosscutting.helper.SqlConnectionHelper;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.dao.AdminDAO;
import edu.uco.stl.data.dao.AreaDAO;
import edu.uco.stl.data.dao.CompanyDAO;
import edu.uco.stl.data.dao.InventoryDAO;
import edu.uco.stl.data.dao.LenderDAO;
import edu.uco.stl.data.dao.LendingDAO;
import edu.uco.stl.data.dao.MonitorDAO;
import edu.uco.stl.data.dao.ObservationDAO;
import edu.uco.stl.data.dao.ProductDAO;
import edu.uco.stl.data.dao.relational.mysql.AdminMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.AreaMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.CompanyMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.InventoryMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.LenderMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.LendingMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.MonitorMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.ObervationMySQLDAO;
import edu.uco.stl.data.dao.relational.mysql.ProductMySQLDAO;

final class MySQLDAOFactory extends DAOFactory {

	private Connection connection;

	private String database = "bd_conexionstl";
	private String user = "root";
	private String password = "admin";

	public MySQLDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		
		final String url = "jdbc:mysql://localhost:3306/" + database;

		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.MySqlFactory.TECHNICAL_PROBLEM_CONNECT_DATABASE,
					exception);
		}

	}

	@Override
	public void initTransction() {
		try {
			SqlConnectionHelper.initTrasaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.MySqlFactory.TECHNICAL_CONNECTION_INIT_TRANSACTION, exception);
		}
	}

	@Override
	public void confirmTransaction() {
		try {
			SqlConnectionHelper.commitTrasaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MySqlFactory.TECHNICAL_CONNECTION_CONFIRM_TRANSACTION, exception);
		}
	}

	@Override
	public void cancelTransaction() {
		try {
			SqlConnectionHelper.rollbackTrasaction(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MySqlFactory.TECHNICAL_CONNECTION_ROLLBACK_TRANSACTION, exception);
		}
	}

	@Override
	public void closeTransaction() {
		try {
			SqlConnectionHelper.closeConnection(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.MySqlFactory.TECHNICAL_CONNECTION_CLOSE_CONNECTION, exception);
		}
	}

	@Override
	public AdminDAO getAdminDAO() {
		return new AdminMySQLDAO(connection);
	}

	@Override
	public AreaDAO getAreaDAO() {
		return new AreaMySQLDAO(connection);
	}

	@Override
	public CompanyDAO getCompanyDAO() {
		return new CompanyMySQLDAO(connection);
	}

	@Override
	public InventoryDAO getInventoryDAO() {
		return new InventoryMySQLDAO(connection);
	}

	@Override
	public LenderDAO getLenderDAO() {
		return new LenderMySQLDAO(connection);
	}

	@Override
	public LendingDAO getLendingDAO() {
		return new LendingMySQLDAO(connection);
	}

	@Override
	public MonitorDAO getMonitorDAO() {
		return new MonitorMySQLDAO(connection);
	}

	@Override
	public ObservationDAO getObservationDAO() {
		return new ObervationMySQLDAO(connection);
	}

	@Override
	public ProductDAO getProductDAO() {
		return new ProductMySQLDAO(connection);
	}

}
