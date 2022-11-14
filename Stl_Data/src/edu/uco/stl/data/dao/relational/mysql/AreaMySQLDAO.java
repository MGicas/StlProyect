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
import edu.uco.stl.data.dao.AreaDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.AreaDTO;
import edu.uco.stl.domain.CompanyDTO;

public class AreaMySQLDAO extends DAORelational implements AreaDAO {

	public AreaMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(AreaDTO area) {
		final var sql = "INSERT INTO area(id, name, idCompany) VALUES (?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, area.getIDAsString());
			preparedStatement.setString(2, area.getName());
			preparedStatement.setString(3, area.getIdCompany().getIDAsString());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.AreaMySQLDAO.TECHNICAL_PROBLEM_CREATE_AREA,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AreaMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_AREA, exception);
		}

	}

	@Override
	public List<AreaDTO> find(AreaDTO area) {

		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, area, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT ar.id AS AreaId, ");
		sqlBuilder.append("       ar.name AS AreaName ");
		sqlBuilder.append("       ar.idCompany AS AreaIdCompany ");
		sqlBuilder.append("FROM area ar ");
		sqlBuilder.append("JOIN company ");
		sqlBuilder.append("JOIN company ");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final AreaDTO area, final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(area)) {
			if (!UUIDHelper.isDefaultUUID(area.getId())) {
				sqlBuilder.append("WHERE AreaId = ? ");
				setWhere = false;
				parameters.add(area.getIDAsString());
			}
			if (!ObjectHelper.isNull(area.getName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("name = ? ");
				setWhere = false;
				parameters.add(area.getName());
			}
			if (!ObjectHelper.isNull(area.getIdCompany())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("idCompany = ? ");
				setWhere = false;
				parameters.add(area.getIdCompany());
			}
		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY ar.id");
	}

	private final List<AreaDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AreaMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_AREA, exception);
		}
	}

	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AreaMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_AREA, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AreaMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_AREA, exception);
		}
	}

	private final List<AreaDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.AreaMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_AREA, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AreaMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_AREA, exception);
		}
	}

	private final List<AreaDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<AreaDTO>();

			while (resultSet.next()) {
				results.add(fillAreaDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.AreaMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_AREA, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AreaMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_AREA, exception);
		}
	}

	private final AreaDTO fillAreaDTO(final ResultSet resultSet) {

		try {
			return AreaDTO.create(resultSet.getString("AreaId"), resultSet.getString("AreaName"), resultSet.getInt());
		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.AreaMySQLDAO.TECHNICAL_PROBLEM_FILLING_AREADTO_AREA, exception);
		}
	}

}
