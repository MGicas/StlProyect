package edu.uco.stl.data.dao.relational.mysql;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;

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
import edu.uco.stl.data.dao.ObservationDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.ObservationDTO;
import static edu.uco.stl.crosscutting.helper.StringHelper.isDefaultString;

public class ObervationMySQLDAO extends DAORelational implements ObservationDAO {

	public ObervationMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ObservationDTO observation) {
		final var sql = "INSERT INTO observation(id, returnComplete, loanExtencion, description, returnOnTime) VALUES (?, ?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, observation.getIDAsString());
			preparedStatement.setBoolean(2, observation.isReturnComplete());
			preparedStatement.setString(3, observation.getLoanExtencion().toString());
			preparedStatement.setString(4, observation.getDescription());
			preparedStatement.setBoolean(5, observation.isReturnOnTime());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_CREATE_OBSERVATION,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_OBSERVATION, exception);
		}
		
	}

	@Override
	public List<ObservationDTO> find(ObservationDTO observation) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, observation, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT ob.id AS ObservationId, ");
		sqlBuilder.append("       ob.returnComplete AS ObservationReturnComplete ");
		sqlBuilder.append("       ob.loanExtencion AS ObservationLoanExtencion ");
		sqlBuilder.append("       ob.description AS ObservationDescription ");
		sqlBuilder.append("       ob.returnOnTime AS ObservationReturnOnTime");
		sqlBuilder.append("FROM observation ob ");
	}
	
	private final void createWhere(final StringBuilder sqlBuilder, final ObservationDTO observation,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(observation)) {
			if (!UUIDHelper.isDefaultUUID(observation.getId())) {
				sqlBuilder.append("WHERE ObservationId = ? ");
				setWhere = false;
				parameters.add(observation.getIDAsString());
			}
			if (!ObjectHelper.isNull(observation.isReturnComplete())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("returnComplete = ? ");
				setWhere = false;
				parameters.add(observation.isReturnComplete());
			}
			if (!ObjectHelper.isNull(observation.getLoanExtencion())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("loanExtencion = ? ");
				setWhere = false;
				parameters.add(observation.getLoanExtencion());
			}
			if (!isDefaultString(observation.getDescription())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("description = ? ");
				setWhere = false;
				parameters.add(observation.getDescription());
			}
			if (!ObjectHelper.isNull(observation.isReturnOnTime())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("returnOnTime = ? ");
				setWhere = false;
				parameters.add(observation.isReturnOnTime());
			}
		}
	}
	
	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY ob.id");
	}

	private final List<ObservationDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_OBSERVATION, exception);
		}
	}
	
	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_OBSERVATION, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_OBSERVATION, exception);
		}
	}
	
	private final List<ObservationDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_OBSERVATION, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_OBSERVATION, exception);
		}
	}

	private final List<ObservationDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<ObservationDTO>();

			while (resultSet.next()) {
				results.add(fillObservationDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_OBSERVATION, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_OBSERVATION, exception);
		}
	}
	
	private final ObservationDTO fillObservationDTO(final ResultSet resultSet) {

		try {
			return ObservationDTO.create(resultSet.getString("ObservationId"), resultSet.getBoolean("ObservationReturnComplete"),
					resultSet.getDate("ObservationLoanExtencion"), resultSet.getString("ObservationDescription"),
					resultSet.getBoolean("ObservationReturnOnTime"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_FILLING_OBSERVATIONDTO_OBSERVATION, exception);
		}
	}
	
	@Override
	public void update(ObservationDTO observation) {
		final var sql = "UPDATE observation SET id = ?, returnComplete = ?, loanExtencion = ? , description = ? , returnOnTime = ? ";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, observation.getIDAsString());
			preparedStatement.setBoolean(1, observation.isReturnComplete());
			preparedStatement.setString(1, observation.getLoanExtencion().toString());
			preparedStatement.setString(1, observation.getDescription());
			preparedStatement.setBoolean(1, observation.isReturnOnTime());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_UPDATE_OBSERVATION,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ObservationMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_OBSERVATION, exception);
		}
		
	}


	@Override
	public void delete(UUID id) {
		final var sql = "DELETE FROM observacion WHERE id = ?";

        try (final var preparedStatement = getConnection().prepareStatement(sql)) {
            
            preparedStatement.setString(1, getUUIDAsString(id));

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw DataCustomException.CreateTechnicalException(Messages.ObservationMySQLDAO.TECHNICAL_PROBLEM_DELETE_OBSERVATION, exception); 
        } catch (Exception exception) {
            throw DataCustomException.CreateTechnicalException(Messages.ObservationMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_OBSERVATION, exception); 
        }
		
	}
		
}
