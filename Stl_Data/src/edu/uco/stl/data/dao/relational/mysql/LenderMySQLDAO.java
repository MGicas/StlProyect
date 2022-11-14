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
import edu.uco.stl.data.dao.LenderDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.LenderDTO;

public class LenderMySQLDAO extends DAORelational implements LenderDAO{
	
	public LenderMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(LenderDTO lender) {
		final var sql = "INSERT INTO lender(id, identification, firstName, secondName, firstSurname, secondSurname, ciudad, barrio, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, lender.getIDAsString());
			preparedStatement.setString(2, lender.getIdentification());
			preparedStatement.setString(3, lender.getFirstName());
			preparedStatement.setString(4, lender.getSecondName());
			preparedStatement.setString(5, lender.getFirstSurname());
			preparedStatement.setString(6, lender.getSecondSurname());
			preparedStatement.setString(7, lender.getCiudad());
			preparedStatement.setString(8, lender.getBarrio());
			preparedStatement.setString(9, lender.getDireccion());
			preparedStatement.setInt(10, lender.getTelefono());
			preparedStatement.setString(11, lender.getCorreo());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_CREATE_LENDER,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_LENDER, exception);
		}

	}

	@Override
	public List<LenderDTO> find(LenderDTO lender) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, lender, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT ler.id AS LenderId, ");
		sqlBuilder.append("       ler.identification AS LenderIdentification ");
		sqlBuilder.append("       ler.firstName AS LenderFirstName ");
		sqlBuilder.append("       ler.secondName AS LenderSecondName ");
		sqlBuilder.append("       ler.firstSurname AS LenderFirstSurname");
		sqlBuilder.append("       ler.secondSurname AS LenderSecondSurname");
		sqlBuilder.append("       ler.ciudad AS LenderCiudad");
		sqlBuilder.append("       ler.barrio AS LenderBarrio");
		sqlBuilder.append("       ler.direccion AS LenderDireccion");
		sqlBuilder.append("       ler.telefono AS LenderTelefono");
		sqlBuilder.append("       ler.correo AS LenderCorre");
		sqlBuilder.append("FROM lender ler ");
	}
	
	private final void createWhere(final StringBuilder sqlBuilder, final LenderDTO lender,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(lender)) {
			if (!UUIDHelper.isDefaultUUID(lender.getId())) {
				sqlBuilder.append("WHERE LenderId = ? ");
				setWhere = false;
				parameters.add(lender.getIDAsString());
			}
			if (!ObjectHelper.isNull(lender.getIdentification())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("identification = ? ");
				setWhere = false;
				parameters.add(lender.getIdentification());
			}
			if (!ObjectHelper.isNull(lender.getFirstName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstName = ? ");
				setWhere = false;
				parameters.add(lender.getFirstName());
			}
			if (!ObjectHelper.isNull(lender.getSecondName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondName = ? ");
				setWhere = false;
				parameters.add(lender.getSecondName());
			}
			if (!ObjectHelper.isNull(lender.getFirstSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstSurname = ? ");
				setWhere = false;
				parameters.add(lender.getFirstSurname());
			}
			if (!ObjectHelper.isNull(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondSurname = ? ");
				setWhere = false;
				parameters.add(lender.getSecondSurname());
			}
			if (!ObjectHelper.isNull(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("ciudad = ? ");
				setWhere = false;
				parameters.add(lender.getCiudad());
			}
			if (!ObjectHelper.isNull(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("barrio = ? ");
				setWhere = false;
				parameters.add(lender.getBarrio());
			}
			if (!ObjectHelper.isNull(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("direccion = ? ");
				setWhere = false;
				parameters.add(lender.getDireccion());
			}
			if (!ObjectHelper.isNull(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("telefono = ? ");
				setWhere = false;
				parameters.add(lender.getTelefono());
			}
			if (!ObjectHelper.isNull(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("correo = ? ");
				setWhere = false;
				parameters.add(lender.getCorreo());
			}
		}
	}
	
	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY ler.id");
	}
	
	private final List<LenderDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_LENDER, exception);
		}
	}
	
	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_LENDER, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_LENDER, exception);
		}
	}
	
	private final List<LenderDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_LENDER, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_LENDER, exception);
		}
	}
	
	private final List<LenderDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<LenderDTO>();

			while (resultSet.next()) {
				results.add(fillLenderDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_LENDER, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_LENDER, exception);
		}
	}
	
	private final LenderDTO fillLenderDTO(final ResultSet resultSet) {

		try {
			return LenderDTO.create(resultSet.getString("LenderId"), resultSet.getString("LenderIdentification"),
					resultSet.getString("LenderFirstName"), resultSet.getString("LenderSecondName"),
					resultSet.getString("LenderFirstSurname"), resultSet.getString("LenderSecondSurname"), resultSet.getString("LenderCiudad"), resultSet.getString("LenderBarrio"), resultSet.getString("LenderDireccion"), resultSet.getInt("LenderTelefono"), resultSet.getString("LenderCorreo"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_FILLING_LENDERDTO_LENDER, exception);
		}
	}

	@Override
	public void update(LenderDTO lender) {
		final var sql = "UPDATE lender SET id = ?, identification = ?, firstName = ? , secondName = ? , firstSurname = ? , secondSurname = ?, ciudad = ?, barrio = ?, direccion = ?, telefono = ?, correo = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, lender.getIDAsString());
			preparedStatement.setString(1, lender.getIdentification());
			preparedStatement.setString(1, lender.getFirstName());
			preparedStatement.setString(1, lender.getSecondName());
			preparedStatement.setString(1, lender.getFirstSurname());
			preparedStatement.setString(1, lender.getSecondSurname());
			preparedStatement.setString(1, lender.getCiudad());
			preparedStatement.setString(1, lender.getBarrio());
			preparedStatement.setString(1, lender.getDireccion());
			preparedStatement.setInt(1, lender.getTelefono());
			preparedStatement.setString(1, lender.getCorreo());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.LenderMySQLDAO.TECHNICAL_PROBLEM_UPDATE_LENDER,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.LenderMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_LENDER, exception);
		}
		
	}

}
