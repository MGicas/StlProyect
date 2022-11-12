package edu.uco.stl.data.daofactory;

import java.sql.Connection;

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

final class MySQLDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	 public MySQLDAOFactory(){
	        openConnection();
	    }

	@Override
	protected void openConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initTransction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminDAO getAdminDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaDAO getAreaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyDAO getCompanyDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryDAO getInventoryDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public LenderDAO getLenderDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LendingDAO getLendingDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonitorDAO getMonitorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservationDAO getObservationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDAO getProductDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StlDAO getStlDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
