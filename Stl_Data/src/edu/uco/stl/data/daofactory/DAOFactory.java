package edu.uco.stl.data.daofactory;

import edu.uco.stl.data.dao.AdminDAO;
import edu.uco.stl.data.dao.AreaDAO;
import edu.uco.stl.data.dao.CompanyDAO;
import edu.uco.stl.data.dao.InventoryDAO;
import edu.uco.stl.data.dao.LenderDAO;
import edu.uco.stl.data.dao.LendingDAO;
import edu.uco.stl.data.dao.MonitorDAO;
import edu.uco.stl.data.dao.ObservationDAO;
import edu.uco.stl.data.dao.ProductDAO;
import edu.uco.stl.data.dao.StlDAO;
import edu.uco.stl.data.enumeration.DAOFactoryType;
import edu.uco.stl.crosscutting.exception.crosscutting.DataCustomException;
import edu.uco.stl.crosscutting.messages.Messages;

public abstract class DAOFactory {

	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {

		DAOFactory daoFactory;

		switch (factory) {
		case SQLSERVER:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_SQL_NOT_IMPLEMENTED);
		case CASSANDRA:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENTED);
		case MARIADB:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENTED);
		case MONGODB:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_MONGODB_NOT_IMPLEMENTED);
		case ORACLE:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_ORACLE_NOT_IMPLEMENTED);
		case MYSQL:
			daoFactory = new MySQLDAOFactory();
			break;
		case POSTGRESQL:
			throw DataCustomException
					.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED);

		default:
			throw DataCustomException.CreateTechnicalException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
		}

		return daoFactory;
	}

	protected abstract void openConnection();

	public abstract void initTransction();

	public abstract void confirmTransaction();

	public abstract void cancelTransaction();

	public abstract void closeTransaction();

	public abstract AdminDAO getAdminDAO();

	public abstract AreaDAO getAreaDAO();

	public abstract CompanyDAO getCompanyDAO();

	public abstract InventoryDAO getInventoryDAO();

	public abstract LenderDAO getLenderDAO();

	public abstract LendingDAO getLendingDAO();

	public abstract MonitorDAO getMonitorDAO();

	public abstract ObservationDAO getObservationDAO();

	public abstract ProductDAO getProductDAO();

	public abstract StlDAO getStlDAO();
}
