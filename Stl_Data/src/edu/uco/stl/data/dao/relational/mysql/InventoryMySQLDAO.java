package edu.uco.stl.data.dao.relational.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.stl.crosscutting.exception.crosscutting.DataCustomException;
import edu.uco.stl.crosscutting.helper.ObjectHelper;
import edu.uco.stl.crosscutting.helper.UUIDHelper;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.dao.InventoryDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.InventoryDTO;

public class InventoryMySQLDAO extends DAORelational implements InventoryDAO{
	
	public InventoryMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(InventoryDTO inventory) {
		final var sql = "INSERT INTO inventory(id, name, productQuantity, status) VALUES (?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, inventory.getIDAsString());
			preparedStatement.setString(2, inventory.getName());
			preparedStatement.setInt(3, inventory.getProductQuantity());
			preparedStatement.setBoolean(4, inventory.isStatus());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_CREATE_INVENTORY,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_INVENTORY, exception);
		}
		
	}

	@Override
	public List<InventoryDTO> find(InventoryDTO inventory) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, inventory, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT in.id AS InventoryId, ");
		sqlBuilder.append("       in.name AS InventoryName ");
		sqlBuilder.append("       in.firstName AS InventoryProductQuantity ");
		sqlBuilder.append("       in.secondName AS InventoryStatus ");
		sqlBuilder.append("FROM inventory in ");
	}
	
	private final void createWhere(final StringBuilder sqlBuilder, final InventoryDTO inventory,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(inventory)) {
			if (!UUIDHelper.isDefaultUUID(inventory.getId())) {
				sqlBuilder.append("WHERE InventoryId = ? ");
				setWhere = false;
				parameters.add(inventory.getIDAsString());
			}
			if (!ObjectHelper.isNull(inventory.getName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("name = ? ");
				setWhere = false;
				parameters.add(inventory.getName());
			}
			if (!ObjectHelper.isNull(inventory.getProductQuantity())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("productQuantity = ? ");
				setWhere = false;
				parameters.add(inventory.getProductQuantity());
			}
			if (!ObjectHelper.isNull(inventory.isStatus())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("status = ? ");
				setWhere = false;
				parameters.add(inventory.isStatus());
			}
		}
	}
	
	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY in.id");
	}
	
	private final List<InventoryDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_INVENTORY, exception);
		}
	}
	
	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_INVENTORY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_INVENTORY, exception);
		}
	}
	
	private final List<InventoryDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_INVENTORY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_INVENTORY, exception);
		}
	}
	
	private final List<InventoryDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<InventoryDTO>();

			while (resultSet.next()) {
				results.add(fillInventoryDTO(resultSet));
			}
			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_INVENTORY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_INVENTORY, exception);
		}
	}
	
	private final InventoryDTO fillInventoryDTO(final ResultSet resultSet) {

		try {
			return InventoryDTO.create(resultSet.getString("InventoryId"), resultSet.getString("InventoryName"),
					resultSet.getInt("InventoryProductQuantity"), resultSet.getBoolean("InventoryStatus"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_FILLING_INVENTORYDTO_INVENTORY, exception);
		}
	}


	@Override
	public void update(InventoryDTO inventory) {
		final var sql = "UPDATE inventory SET id = ?, name = ?, productQuantity = ? , status = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, inventory.getIDAsString());
			preparedStatement.setString(1, inventory.getName());
			preparedStatement.setInt(1, inventory.getProductQuantity());
			preparedStatement.setBoolean(1, inventory.isStatus());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.InventoryMySQLDAO.TECHNICAL_PROBLEM_UPDATE_INVENTORY,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.InventoryMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_INVENTORY, exception);
		}
		
	}

	@Override
	public void activate(InventoryDTO inventory) {
		// TODO Auto-generated method stub
		
	}

}
