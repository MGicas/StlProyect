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
import edu.uco.stl.data.dao.LendingDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.LendingDTO;

public class LendingMySQLDAO extends DAORelational implements LendingDAO {

	public LendingMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(LendingDTO lending) {
		final var sql = "INSERT INTO lending(id, product, loanQuantity, Date, monitorRecieve, monitorGive, lenderName) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, lending.getIDAsString());
			preparedStatement.setString(2, lending.getProduct());
			preparedStatement.setInt(3, lending.getLoanQuantity());
			preparedStatement.setString(4, lending.getDate().toString());
			preparedStatement.setString(5, lending.getMonitorRecieve());
			preparedStatement.setString(6, lending.getMonitorGive());
			preparedStatement.setString(7, lending.getLenderName());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_CREATE_LENDING,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_LENDING, exception);
		}
		
	}

	@Override
	public List<LendingDTO> find(LendingDTO lending) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, lending, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT len.id AS LendingId, ");
		sqlBuilder.append("       len.product AS LendingProduct ");
		sqlBuilder.append("       len.loanQuantity AS LendingLoanQuantity ");
		sqlBuilder.append("       len.date AS LendingDate ");
		sqlBuilder.append("       len.monitorRecieve AS LendingMonitorRecieve");
		sqlBuilder.append("       len.monitorGive AS LendingMonitorGive");
		sqlBuilder.append("       len.lenderName AS LendingLenderName");

		sqlBuilder.append("FROM lending len ");
	}
	
	private final void createWhere(final StringBuilder sqlBuilder, final LendingDTO lending,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(lending)) {
			if (!UUIDHelper.isDefaultUUID(lending.getId())) {
				sqlBuilder.append("WHERE LendingId = ? ");
				setWhere = false;
				parameters.add(lending.getIDAsString());
			}
			if (!ObjectHelper.isNull(lending.getProduct())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("product = ? ");
				setWhere = false;
				parameters.add(lending.getProduct());
			}
			if (!ObjectHelper.isNull(lending.getLoanQuantity())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("loanQuantity = ? ");
				setWhere = false;
				parameters.add(lending.getLoanQuantity());
			}
			if (!ObjectHelper.isNull(lending.getDate())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("Date = ? ");
				setWhere = false;
				parameters.add(lending.getDate());
			}
			if (!ObjectHelper.isNull(lending.getMonitorRecieve())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("monitorRecieve = ? ");
				setWhere = false;
				parameters.add(lending.getMonitorRecieve());
			}
			if (!ObjectHelper.isNull(lending.getMonitorGive())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("monitorGive = ? ");
				setWhere = false;
				parameters.add(lending.getMonitorGive());
			}
			if (!ObjectHelper.isNull(lending.getLenderName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("lenderName = ? ");
				setWhere = false;
				parameters.add(lending.getLenderName());
			}
		}
	}
	
	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY len.id");
	}

	private final List<LendingDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_LENDING, exception);
		}
	}
	
	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_LENDING, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_LENDING, exception);
		}
	}
	
	private final List<LendingDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_LENDING, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_LENDING, exception);
		}
	}
	
	private final List<LendingDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<LendingDTO>();

			while (resultSet.next()) {
				results.add(fillLendingDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_LENDING, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_LENDING, exception);
		}
	}
	
	private final LendingDTO fillLendingDTO(final ResultSet resultSet) {

		try {
			return LendingDTO.create(resultSet.getString("LendingId"), resultSet.getString("LendingProduct"),
					resultSet.getInt("LendingLoanQuantity"), resultSet.getDate("LendingDate"),
					resultSet.getString("LendingMonitorRecieve"), resultSet.getString("LendingMonitorGive"), resultSet.getString("LendingLenderName"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_FILLING_LENDINGDTO_LENDING, exception);
		}
	}


	@Override
	public void update(LendingDTO lending) {
		final var sql = "UPDATE lending SET id = ?, product = ?, loanQuantity = ? , date = ? , monitorRecieve = ? , monitorGive = ?, lenderName = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, lending.getIDAsString());
			preparedStatement.setString(1, lending.getProduct());
			preparedStatement.setInt(1, lending.getLoanQuantity());
			preparedStatement.setString(1, lending.getDate().toString());
			preparedStatement.setString(1, lending.getMonitorRecieve());
			preparedStatement.setString(1, lending.getMonitorGive());
			preparedStatement.setString(1, lending.getLenderName());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.LendingMySQLDAO.TECHNICAL_PROBLEM_UPDATE_LENDING,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LendingMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_LENDING, exception);
		}
		
	}

	@Override
	public void close(LendingDTO lending) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void overcome(LendingDTO lending) {
		// TODO Auto-generated method stub
		
	}
}
