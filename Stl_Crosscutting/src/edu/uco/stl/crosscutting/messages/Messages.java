package edu.uco.stl.crosscutting.messages;

public class Messages {

	private Messages() {
		super();
	}

	public static class DAOFactory {

		private DAOFactory() {
			super();
		}

		public static final String TECHNICAL_MONGODB_NOT_IMPLEMENTED = "DAOFactory Mongobd is not implemented yet";
		public static final String TECHNICAL_CASSANDRA_NOT_IMPLEMENTED = "DAOFactory Cassandra is not implemented yet";
		public static final String TECHNICAL_MARIADB_NOT_IMPLEMENTED = "DAOFactory Mariadb is not implemented yet";
		public static final String TECHNICAL_ORACLE_NOT_IMPLEMENTED = "DAOFactory Oracle is not implemented yet";
		public static final String TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED = "DAOFactory Postgresql is not implemented yet";
		public static final String TECHNICAL_SQL_NOT_IMPLEMENTED = "DAOFactory Sql is not implemented yet";
		public static final String TECHNICAL_UNEXPECTED_DAOFACTORY = "Unexpected DAOFactor is not implemented yet";

	}

	public static class DAORelational {

		private DAORelational() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection already is closed";

	}

	public static class MySQLConnectionHelper {

		private MySQLConnectionHelper() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_ALREADY_IS_OPEN = "Connection already is open";
		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "There was a problem trying to close connection";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is closed to init the current transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection is closed to rollback the current transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed to commit the current transaction";
		public static final String TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION = "There was a problem trying to init transaction";
		public static final String TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION = "There was a problem trying to close connection";
		public static final String TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION = "There was a problem trying to rollback trasaction";
		public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init trasaction with the current connection in MySqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CLOSE_CONNECTION = "There was a problem trying to close connection with the current connection in MySqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CONFIRM_TRANSACTION = "There was a problem trying to confirm trasaction with the current connection in MySqlDAOFactory";
	}

	public static class MySqlFactory {

		private MySqlFactory() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_INIT_TRANSACTION = "There was a problem trying to init transaction with the connection in MySqlDAOFactory";
		public static final String TECHNICAL_CONNECTION_CLOSE_CONNECTION = "There was a problem trying to close connection with the current connection in MySqlDAOFactory";
		public static final String TECHNICAL_CONNECTION_CONFIRM_TRANSACTION = "There was a problem trying to confirm trasaction with the current connection in MySqlDAOFactory";
		public static final String TECHNICAL_CONNECTION_CONNECT_DATABASE = "There was a problem trying to connect to Data base ";
		public static final String TECHNICAL_CONNECTION_ROLLBACK_TRANSACTION = "There was a problem trying to rollback transaction";
		public static final String TECHNICAL_PROBLEM_CONNECT_DATABASE="There was a problem connecting the database";
	}

	public static class UUIDHelper {
		private UUIDHelper() {
			super();
		}

		public static final String TECHNICAL_UUID_FROM_STRING_INVALID = "The UUID to convert doesn't have a correct format";
		public static final String TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = "There was an unexpected error";
	}

	public static class AdminMySQLDAO {

		private AdminMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_ADMIN = "There was a problem trying to create an admin";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_ADMIN = "There was an unexpected problem trying to create an admin";

		public static final String TECHNICAL_PROBLEM_UPDATE_ADMIN = "There was a problem trying to update admin";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_ADMIN = "There was an unexpected problem trying to update admin";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_ADMIN = "There was a problem trying to prepare and execute query of an admin";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_ADMIN = "There was a problem trying to setting parameters values of an admin";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_ADMIN = "There was an unexpected problem trying to setting parameters values of an admin";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_ADMIN = "There was a problem trying to execute query of an admin";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_ADMIN = "There was an unexpected problem trying to execute query of an admin";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_ADMIN = "There was a problem trying to fill results of an admin";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_ADMIN = "There was an unexpected problem trying to execute query of an admin";
		public static final String TECHNICAL_PROBLEM_FILLING_ADMINDTO_ADMIN = "There was a problem trying to fill adminDTO of an admin";

	}

	public static class AreaMySQLDAO {

		private AreaMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_AREA = "There was a problem trying to create an area";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_AREA = "There was an unexpected problem trying to create an area";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_AREA = "There was a problem trying to prepare and execute query of an area";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_AREA = "There was a problem trying to setting parameters values of an area";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_AREA = "There was an unexpected problem trying to setting parameters values of an area";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_AREA = "There was a problem trying to execute query of an area";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_AREA = "There was an unexpected problem trying to execute query of an area";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_AREA = "There was a problem trying to fill results of an area";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_AREA = "There was an unexpected problem trying to execute query of an area";
		public static final String TECHNICAL_PROBLEM_FILLING_AREADTO_AREA = "There was a problem trying to fill areaDTO of an area";

	}

	public static class CompanyMySQLDAO {

		private CompanyMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_COMPANY = "There was a problem trying to create a company";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_COMPANY = "There was an unexpected problem trying to create a company";

		public static final String TECHNICAL_PROBLEM_UPDATE_COMPANY = "There was a problem trying to update company";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_COMPANY = "There was an unexpected problem trying to update company";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_COMPANY = "There was a problem trying to prepare and execute query of an company";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_COMPANY = "There was a problem trying to setting parameters values of an company";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_COMPANY = "There was an unexpected problem trying to setting parameters values of an company";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_COMPANY = "There was a problem trying to execute query of an company";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_COMPANY = "There was an unexpected problem trying to execute query of an company";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_COMPANY = "There was a problem trying to fill results of an company";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_COMPANY = "There was an unexpected problem trying to execute query of an company";
		public static final String TECHNICAL_PROBLEM_FILLING_COMPANYDTO_COMPANY = "There was a problem trying to fill companyDTO of an company";

	}

	public static class InventoryMySQLDAO {

		private InventoryMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_INVENTORY = "There was a problem trying to create a inventory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_INVENTORY = "There was an unexpected problem trying to create a inventory";

		public static final String TECHNICAL_PROBLEM_UPDATE_INVENTORY = "There was a problem trying to update inventory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_INVENTORY = "There was an unexpected problem trying to update inventory";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_INVENTORY = "There was a problem trying to prepare and execute query of an inventory";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_INVENTORY = "There was a problem trying to setting parameters values of an inventory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_INVENTORY = "There was an unexpected problem trying to setting parameters values of an inventory";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_INVENTORY = "There was a problem trying to execute query of an inventory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_INVENTORY = "There was an unexpected problem trying to execute query of an inventory";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_INVENTORY = "There was a problem trying to fill results of an inventory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_INVENTORY = "There was an unexpected problem trying to execute query of an inventory";
		public static final String TECHNICAL_PROBLEM_FILLING_INVENTORYDTO_INVENTORY = "There was a problem trying to fill inventoryDTO of an inventory";

	}

	public static class LenderMySQLDAO {

		private LenderMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_LENDER = "There was a problem trying to create a lender";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_LENDER = "There was an unexpected problem trying to create a lender";

		public static final String TECHNICAL_PROBLEM_UPDATE_LENDER = "There was a problem trying to update lender";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_LENDER = "There was an unexpected problem trying to update lender";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_LENDER = "There was a problem trying to prepare and execute query of an lender";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_LENDER = "There was a problem trying to setting parameters values of an lender";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_LENDER = "There was an unexpected problem trying to setting parameters values of an lender";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_LENDER = "There was a problem trying to execute query of an lender";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_LENDER = "There was an unexpected problem trying to execute query of an lender";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_LENDER = "There was a problem trying to fill results of an lender";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_LENDER = "There was an unexpected problem trying to execute query of an lender";
		public static final String TECHNICAL_PROBLEM_FILLING_LENDERDTO_LENDER = "There was a problem trying to fill lenderDTO of an lender";

	}

	public static class LendingMySQLDAO {

		private LendingMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_LENDING = "There was a problem trying to create a lending";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_LENDING = "There was an unexpected problem trying to create a lending";

		public static final String TECHNICAL_PROBLEM_UPDATE_LENDING = "There was a problem trying to update lending";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_LENDING = "There was an unexpected problem trying to update lending";

		public static final String TECHNICAL_PROBLEM_CLOSE_LENDING = "There was a problem trying to close lending";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CLOSE_LENDING = "There was an unexpected problem trying to close lending";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_LENDING = "There was a problem trying to prepare and execute query of an lending";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_LENDING = "There was a problem trying to setting parameters values of an lending";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_LENDING = "There was an unexpected problem trying to setting parameters values of an lending";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_LENDING = "There was a problem trying to execute query of an lending";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_LENDING = "There was an unexpected problem trying to execute query of an lending";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_LENDING = "There was a problem trying to fill results of an lending";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_LENDING = "There was an unexpected problem trying to execute query of an lending";
		public static final String TECHNICAL_PROBLEM_FILLING_LENDINGDTO_LENDING = "There was a problem trying to fill lenderDTO of an lending";

	}

	public static class MonitorMySQLDAO {

		private MonitorMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_MONITOR = "There was a problem trying to create a monitor";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_MONITOR = "There was an unexpected problem trying to create a monitor";

		public static final String TECHNICAL_PROBLEM_UPDATE_MONITOR = "There was a problem trying to update monitor";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_MONITOR = "There was an unexpected problem trying to update monitor";

		public static final String TECHNICAL_PROBLEM_DELETE_MONITOR = "There was a problem trying to delete monitor";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_MONITOR = "There was an unexpected problem trying to delete monitor";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_MONITOR = "There was a problem trying to prepare and execute query of an monitor";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_MONITOR = "There was a problem trying to setting parameters values of an monitor";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_MONITOR = "There was an unexpected problem trying to setting parameters values of an monitor";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_MONITOR = "There was a problem trying to execute query of an monitor";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_MONITOR = "There was an unexpected problem trying to execute query of an monitor";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_MONITOR = "There was a problem trying to fill results of an monitor";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_MONITOR = "There was an unexpected problem trying to execute query of an monitor";
		public static final String TECHNICAL_PROBLEM_FILLING_MONITORDTO_MONITOR = "There was a problem trying to fill lenderDTO of an monitor";

	}

	public static class ObservationMySQLDAO {

		private ObservationMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_OBSERVATION = "There was a problem trying to create a observation";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_OBSERVATION = "There was an unexpected problem trying to create an observation";

		public static final String TECHNICAL_PROBLEM_UPDATE_OBSERVATION = "There was a problem trying to update observation";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_OBSERVATION = "There was an unexpected problem trying to update observation";

		public static final String TECHNICAL_PROBLEM_DELETE_OBSERVATION = "There was a problem trying to delete observation";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_OBSERVATION = "There was an unexpected problem trying to delete observation";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_OBSERVATION = "There was a problem trying to prepare and execute query of an observation";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_OBSERVATION = "There was a problem trying to setting parameters values of an observation";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_OBSERVATION = "There was an unexpected problem trying to setting parameters values of an observation";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_OBSERVATION = "There was a problem trying to execute query of an observation";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_OBSERVATION = "There was an unexpected problem trying to execute query of an observation";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_OBSERVATION = "There was a problem trying to fill results of an observation";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_OBSERVATION = "There was an unexpected problem trying to execute query of an observation";
		public static final String TECHNICAL_PROBLEM_FILLING_OBSERVATIONDTO_OBSERVATION = "There was a problem trying to fill lenderDTO of an observation";

	}

	public static class ProductMySQLDAO {

		private ProductMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_PRODUCT = "There was a problem trying to create a product";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PRODUCT = "There was an unexpected problem trying to create a product";

		public static final String TECHNICAL_PROBLEM_UPDATE_PRODUCT = "There was a problem trying to update product";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PRODUCT = "There was an unexpected problem trying to update product";

		public static final String TECHNICAL_PROBLEM_DELETE_PRODUCT = "There was a problem trying to delete product";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PRODUCT = "There was an unexpected problem trying to delete product";

		public static final String TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_PRODUCT = "There was a problem trying to prepare and execute query of an product";
		public static final String TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_PRODUCT = "There was a problem trying to setting parameters values of an product";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_PRODUCT = "There was an unexpected problem trying to setting parameters values of an product";
		public static final String TECHNICAL_PROBLEM_EXECUTING_QUERY_PRODUCT = "There was a problem trying to execute query of an product";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_PRODUCT = "There was an unexpected problem trying to execute query of an product";
		public static final String TECHNICAL_PROBLEM_FILLING_RESULTS_PRODUCT = "There was a problem trying to fill results of an product";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_PRODUCT = "There was an unexpected problem trying to execute query of an product";
		public static final String TECHNICAL_PROBLEM_FILLING_PRODUCTDTO_PRODUCT = "There was a problem trying to fill lenderDTO of an product";

	}

	public static class StlMySQLDAO {

		private StlMySQLDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_STL = "There was a problem trying to create a stl";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_STL = "There was an unexpected problem trying to create a stl";

	}

	public static class UseCaseImpl {

		private UseCaseImpl() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_VALIDATE_ADMIN_IDENTIFICATION = "There was a problem validating the identification, obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_ADMIN_FIRSTNAME = "There was a problem validating the firstname, obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_ADMIN_SECONDSURNAME = "Second surname is an obligatory data*";

		public static final String TECHNICAL_PROBLEM_VALIDATE_COMPANY_NAME = "The name is obligatory data*";

	}
	
	public static class UseCaseLendingImpl {

		private UseCaseLendingImpl() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_VALIDATE_LENDING_LOANQUANTITY = "There was a problem validating the loan quantity, obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_LENDING_DATE = "There was a problem validating the date, obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_LENDING_MONITOR_RECIEVE = "Monitor recieve is an obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_LENDING_MONITOR_GIVE = "Monitor give is an obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_LENDING_LENDER_NAME = "Lender name is an obligatory data*";
		public static final String TECHNICAL_PROBLEM_VALIDATE_LENDING_PRODUCT = "There was a problem validating the product, obligatory data*";

	}

	public static class UseCaseCommand {

		private UseCaseCommand() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATING_ADMIN = "There was a problem creating the admin, try again";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_ADMIN = "There was an unexpected problem creating the admin, try again";

		public static final String TECHNICAL_PROBLEM_CREATING_COMPANY = "There was a problem creating company, try again";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_COMPANY = "There was an unexpected problem creating company, try again";
		
		public static final String TECHNICAL_PROBLEM_CREATING_LENDING = "There was a problem creating lending, try again";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATING_LENDING = "There was an unexpected problem creating lending, try again";

	}
	
	public static class AdminController {

		private AdminController() {
			super();
		}

		public static final String USER_ADMIN_CREATE_SUCCESSFULLY = "The admin has been created successfully";
		public static final String USER_ADMIN_CREATE_ERROR = "There was an error trayig to create the admin, try again";
		public static final String USER_ADMIN_CREATE_UNEXPECTED_ERROR = "There was a unexpected error trayig to create the admin, try again";

	}
	
	public static class CompanyController {

		private CompanyController() {
			super();
		}

		public static final String USER_COMPANY_CREATE_SUCCESSFULLY = "The company has been created successfully";
		public static final String USER_COMPANY_CREATE_ERROR = "There was an error trayig to create the company, try again";
		public static final String USER_COMPANY_CREATE_UNEXPECTED_ERROR = "There was a unexpected error trayig to create the company, try again";

	}
	
	public static class LendingController {

		private LendingController() {
			super();
		}

		public static final String USER_LENDING_CREATE_SUCCESSFULLY = "The company has been created successfully";
		public static final String USER_LENDING_CREATE_ERROR = "There was an error trayig to create the company, try again";
		public static final String USER_LENDING_CREATE_UNEXPECTED_ERROR = "There was a unexpected error trayig to create the company, try again";

	}
	
	public static class CompanyValidator {

		private CompanyValidator() {
			super();
		}

		public static final String USER_COMPANY_VALIDATOR_IDADMIN = "Admin id is equal to default value";
		public static final String USER_COMPANY_CREATE_ERROR = "There was an error trayig to create the company, try again";
		public static final String USER_COMPANY_CREATE_UNEXPECTED_ERROR = "There was a unexpected error trayig to create the company, try again";

	}

}
