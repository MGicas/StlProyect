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
import static edu.uco.stl.crosscutting.helper.StringHelper.isDefaultString;

public class LenderMySQLDAO extends DAORelational implements LenderDAO{
	
	public LenderMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(LenderDTO lender) {
		final var sql = "INSERT INTO lender(id, identification, firstName, secondName, firstSurname, secondSurname, city, neighborhood, address, phone, mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, lender.getIDAsString());
			preparedStatement.setString(2, lender.getIdentification());
			preparedStatement.setString(3, lender.getFirstName());
			preparedStatement.setString(4, lender.getSecondName());
			preparedStatement.setString(5, lender.getFirstSurname());
			preparedStatement.setString(6, lender.getSecondSurname());
			preparedStatement.setString(7, lender.getCity());
			preparedStatement.setString(8, lender.getNeighborhood());
			preparedStatement.setString(9, lender.getAddress());
			preparedStatement.setInt(10, lender.getPhone());
			preparedStatement.setString(11, "'"+lender.getMail()+"'");
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
		sqlBuilder.append("       ler.city AS LenderCity");
		sqlBuilder.append("       ler.neighborhood AS LenderNeighborhood");
		sqlBuilder.append("       ler.address AS LenderAddress");
		sqlBuilder.append("       ler.phone AS LenderPhone");
		sqlBuilder.append("       ler.mail AS LenderMail");
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
			if (!isDefaultString(lender.getIdentification())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("identification = ? ");
				setWhere = false;
				parameters.add(lender.getIdentification());
			}
			if (!isDefaultString(lender.getFirstName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstName = ? ");
				setWhere = false;
				parameters.add(lender.getFirstName());
			}
			if (!isDefaultString(lender.getSecondName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondName = ? ");
				setWhere = false;
				parameters.add(lender.getSecondName());
			}
			if (!isDefaultString(lender.getFirstSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstSurname = ? ");
				setWhere = false;
				parameters.add(lender.getFirstSurname());
			}
			if (!isDefaultString(lender.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondSurname = ? ");
				setWhere = false;
				parameters.add(lender.getSecondSurname());
			}
			if (!isDefaultString(lender.getCity())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("city = ? ");
				setWhere = false;
				parameters.add(lender.getCity());
			}
			if (!isDefaultString(lender.getNeighborhood())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("neighborhood = ? ");
				setWhere = false;
				parameters.add(lender.getNeighborhood());
			}
			if (!isDefaultString(lender.getAddress())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("address = ? ");
				setWhere = false;
				parameters.add(lender.getAddress());
			}
			if (!ObjectHelper.isNull(lender.getPhone())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("phone = ? ");
				setWhere = false;
				parameters.add(lender.getPhone());
			}
			if (!isDefaultString(lender.getMail())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("mail = ? ");
				setWhere = false;
				parameters.add(lender.getMail());
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
		final var sql = "UPDATE lender SET id = ?, identification = ?, firstName = ? , secondName = ? , firstSurname = ? , secondSurname = ?, city = ?, neighborhood = ?, address = ?, phone = ?, mail = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, lender.getIDAsString());
			preparedStatement.setString(1, lender.getIdentification());
			preparedStatement.setString(1, lender.getFirstName());
			preparedStatement.setString(1, lender.getSecondName());
			preparedStatement.setString(1, lender.getFirstSurname());
			preparedStatement.setString(1, lender.getSecondSurname());
			preparedStatement.setString(1, lender.getCity());
			preparedStatement.setString(1, lender.getNeighborhood());
			preparedStatement.setString(1, lender.getAddress());
			preparedStatement.setInt(1, lender.getPhone());
			preparedStatement.setString(1, lender.getMail());
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
