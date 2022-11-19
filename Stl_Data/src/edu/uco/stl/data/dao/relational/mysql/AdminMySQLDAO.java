package edu.uco.stl.data.dao.relational.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static edu.uco.stl.crosscutting.helper.StringHelper.isDefaultString;
import edu.uco.stl.crosscutting.exception.crosscutting.DataCustomException;
import edu.uco.stl.crosscutting.helper.ObjectHelper;
import edu.uco.stl.crosscutting.helper.UUIDHelper;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.data.dao.AdminDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.AdminDTO;

public class AdminMySQLDAO extends DAORelational implements AdminDAO {

	public AdminMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(AdminDTO admin) {
		final var sql = "INSERT INTO bd_conexionstl.admin(id, identification, firstName, secondName, firstSurname, secondSurname) VALUES (?, ?, ?, ?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, admin.getIDAsString());
			preparedStatement.setString(2, admin.getIdentification());
			preparedStatement.setString(3, admin.getFirstName());
			preparedStatement.setString(4, admin.getSecondName());
			preparedStatement.setString(5, admin.getFirstSurname());
			preparedStatement.setString(6, admin.getSecondSurname());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_CREATE_ADMIN,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_ADMIN, exception);
		}

	}

	@Override
	public List<AdminDTO> find(AdminDTO admin) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, admin, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT ad.id AS AdminId, ");
		sqlBuilder.append("       ad.identification AS AdminIdentification, ");
		sqlBuilder.append("       ad.firstName AS AdminFirstName, ");
		sqlBuilder.append("       ad.secondName AS AdminSecondName, ");
		sqlBuilder.append("       ad.firstSurname AS AdminFirstSurname,");
		sqlBuilder.append("       ad.secondSurname AS AdminSecondSurname ");
		sqlBuilder.append("FROM bd_conexionstl.admin ad ");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final AdminDTO admin,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(admin)) {
			if (!UUIDHelper.isDefaultUUID(admin.getId())) {
				sqlBuilder.append("WHERE id = ? ");
				setWhere = false;
				parameters.add(admin.getIDAsString());
			}
			if (!isDefaultString(admin.getIdentification())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("identification = ? ");
				setWhere = false;
				parameters.add(admin.getIdentification());
			}
			if (!isDefaultString(admin.getFirstName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstName = ? ");
				setWhere = false;
				parameters.add(admin.getFirstName());
			}
			if (!isDefaultString(admin.getSecondName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondName = ? ");
				setWhere = false;
				parameters.add(admin.getSecondName());
			}
			if (!isDefaultString(admin.getFirstSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("firstSurname = ? ");
				setWhere = false;
				parameters.add(admin.getFirstSurname());
			}
			if (!isDefaultString(admin.getSecondSurname())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("secondSurname = ? ");
				setWhere = false;
				parameters.add(admin.getSecondSurname());
			}
		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY ad.id");
	}

	private final List<AdminDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_ADMIN, exception);
		}
	}

	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_ADMIN, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_ADMIN, exception);
		}
	}

	private final List<AdminDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_ADMIN, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_ADMIN, exception);
		}
	}

	private final List<AdminDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<AdminDTO>();

			while (resultSet.next()) {
				results.add(fillAdminDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_ADMIN, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_ADMIN, exception);
		}
	}

	private final AdminDTO fillAdminDTO(final ResultSet resultSet) {

		try {
			return AdminDTO.create(resultSet.getString("AdminId"), resultSet.getString("AdminIdentification"),
					resultSet.getString("AdminFirstName"), resultSet.getString("AdminSecondName"),
					resultSet.getString("AdminFirstSurname"), resultSet.getString("AdminSecondSurname"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_FILLING_ADMINDTO_ADMIN, exception);
		}
	}

	@Override
	public void update(AdminDTO admin) {
		final var sql = "UPDATE bd_conexionstl.admin SET id = ?, identification = ?, firstName = ? , secondName = ? , firstSurname = ? , secondSurname = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, admin.getIDAsString());
			preparedStatement.setString(1, admin.getIdentification());
			preparedStatement.setString(1, admin.getFirstName());
			preparedStatement.setString(1, admin.getSecondName());
			preparedStatement.setString(1, admin.getFirstSurname());
			preparedStatement.setString(1, admin.getSecondSurname());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(Messages.AdminMySQLDAO.TECHNICAL_PROBLEM_UPDATE_ADMIN,
					exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.AdminMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_ADMIN, exception);
		}
	}

}
