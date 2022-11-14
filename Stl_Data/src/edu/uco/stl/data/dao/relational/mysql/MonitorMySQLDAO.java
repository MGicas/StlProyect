package edu.uco.stl.data.dao.relational.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.stl.crosscutting.exception.crosscutting.DataCustomException;
import edu.uco.stl.crosscutting.helper.ObjectHelper;
import edu.uco.stl.crosscutting.helper.UUIDHelper;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.dao.MonitorDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import edu.uco.stl.domain.MonitorDTO;
import static edu.uco.stl.crosscutting.helper.StringHelper.isDefaultString;

public class MonitorMySQLDAO extends DAORelational implements MonitorDAO{
	
	public MonitorMySQLDAO (Connection connection) {
		super(connection);
	}

	@Override
	public void create(MonitorDTO monitor) {
		final var sql = "INSERT INTO monitor(id, identification, firstName, secondName, firstSurname, secondSurname) VALUES (?, ?, ?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, monitor.getIDAsString());
			preparedStatement.setString(2, monitor.getIdentification());
			preparedStatement.setString(3, monitor.getFirstname());
			preparedStatement.setString(4, monitor.getSecondName());
			preparedStatement.setString(5, monitor.getFirstSurname());
			preparedStatement.setString(6, monitor.getSecondSurname());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_CREATE_MONITOR,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_MONITOR, exception);
		}
		
	}

	@Override
	public List<MonitorDTO> find(MonitorDTO monitor) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, monitor, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT mon.id AS MonitorId, ");
		sqlBuilder.append("       mon.identification AS MonitorIdentification ");
		sqlBuilder.append("       mon.firstName AS MonitorFirstName ");
		sqlBuilder.append("       mon.secondName AS MonitorSecondName ");
		sqlBuilder.append("       mon.firstSurname AS MonitorFirstSurname");
		sqlBuilder.append("       mon.secondSurname AS MonitorSecondSurname");
		sqlBuilder.append("FROM monitor mon ");
	}
	
	private final void createWhere(final StringBuilder sqlBuilder, final MonitorDTO monitor,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(monitor)) {
			if (!UUIDHelper.isDefaultUUID(monitor.getId())) {
				sqlBuilder.append("WHERE MonitorId = ? ");
				setWhere = false;
				parameters.add(monitor.getIDAsString());
			}
			if (!isDefaultString(monitor.getIdentification())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("identification = ? ");
				setWhere = false;
				parameters.add(monitor.getIdentification());
			}
			if (!isDefaultString(monitor.getFirstname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstName = ? ");
				setWhere = false;
				parameters.add(monitor.getFirstname());
			}
			if (!isDefaultString(monitor.getSecondName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondName = ? ");
				setWhere = false;
				parameters.add(monitor.getSecondName());
			}
			if (!isDefaultString(monitor.getFirstSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstSurname = ? ");
				setWhere = false;
				parameters.add(monitor.getFirstSurname());
			}
			if (!isDefaultString(monitor.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondSurname = ? ");
				setWhere = false;
				parameters.add(monitor.getSecondSurname());
			}
		}
	}
	
	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY mon.id");
	}

	private final List<MonitorDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_MONITOR, exception);
		}
	}
	
	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_MONITOR, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_MONITOR, exception);
		}
	}
	
	private final List<MonitorDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_MONITOR, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_MONITOR, exception);
		}
	}
	
	private final List<MonitorDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<MonitorDTO>();

			while (resultSet.next()) {
				results.add(fillMonitorDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_MONITOR, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_MONITOR, exception);
		}
	}
	
	private final MonitorDTO fillMonitorDTO(final ResultSet resultSet) {

		try {
			return MonitorDTO.create(resultSet.getString("MonitorId"), resultSet.getString("MonitorIdentification"),
					resultSet.getString("MonitorFirstName"), resultSet.getString("MonitorSecondName"),
					resultSet.getString("MonitorFirstSurname"), resultSet.getString("MonitorSecondSurname"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_FILLING_MONITORDTO_MONITOR, exception);
		}
	}

	@Override
	public void update(MonitorDTO monitor) {
		final var sql = "UPDATE monitor SET id = ?, identification = ?, firstName = ? , secondName = ? , firstSurname = ? , secondSurname = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, monitor.getIDAsString());
			preparedStatement.setString(1, monitor.getIdentification());
			preparedStatement.setString(1, monitor.getFirstname());
			preparedStatement.setString(1, monitor.getSecondName());
			preparedStatement.setString(1, monitor.getFirstSurname());
			preparedStatement.setString(1, monitor.getSecondSurname());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_UPDATE_MONITOR,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.MonitorMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_MONITOR, exception);
		}
		
	}

	@Override
	public void delete(UUID id) {
		final var sql = "DELETE FROM MONITOR WHERE id = ?";

        try (final var preparedStatement = getConnection().prepareStatement(sql)) {
            
            preparedStatement.setString(1, getUUIDAsString(id));

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw DataCustomException.CreateTechnicalException(Messages.MonitorMySQLDAO.TECHNICAL_PROBLEM_DELETE_MONITOR, exception); 
        } catch (Exception exception) {
            throw DataCustomException.CreateTechnicalException(Messages.MonitorMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_MONITOR, exception); 
        }
		
	}

}
