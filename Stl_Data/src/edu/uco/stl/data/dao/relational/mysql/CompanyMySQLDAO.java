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
import edu.uco.stl.data.dao.CompanyDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.CompanyDTO;
import edu.uco.stl.domain.AdminDTO;

public class CompanyMySQLDAO extends DAORelational implements CompanyDAO {

	public CompanyMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(CompanyDTO company) {
		final var sql = "INSERT INTO company(id, name) VALUES (?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, company.getIDAsString());
			preparedStatement.setString(2, company.getName());
			preparedStatement.setString(3, company.getAdminId().getIDAsString());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_CREATE_COMPANY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_COMPANY, exception);
		}

	}

	@Override
	public List<CompanyDTO> find(CompanyDTO company) {
		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, company, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT com.id AS CompanyId, ");
		sqlBuilder.append("       com.name AS CompanyName ");
		sqlBuilder.append("       com.adminId AS CompanyAdminId ");
		sqlBuilder.append("       ad.identification AS AdminIdentification ");
		sqlBuilder.append("       ad.firstName AS AdminFirstName ");
		sqlBuilder.append("       ad.secondName AS AdminSecondName ");
		sqlBuilder.append("       ad.firstSurname AS AdminFirstSurname");
		sqlBuilder.append("       ad.secondSurname AS AdminSecondSurname");
		sqlBuilder.append("FROM company com ");
		sqlBuilder.append("JOIN admin ad ON com.adminId = ad.id ");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final CompanyDTO company,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(company)) {
			if (!UUIDHelper.isDefaultUUID(company.getId())) {
				sqlBuilder.append("WHERE CompanyId = ? ");
				setWhere = false;
				parameters.add(company.getIDAsString());
			}
			if (!isDefaultString(company.getName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("name = ? ");
				setWhere = false;
				parameters.add(company.getName());
			}
			if (!ObjectHelper.isNull(company.getAdminId())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("idAdmin = ? ");
				setWhere = false;
				parameters.add(company.getAdminId());
			}
		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY com.id");
	}

	private final List<CompanyDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
			final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_COMPANY, exception);
		}
	}

	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_COMPANY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_COMPANY, exception);
		}
	}

	private final List<CompanyDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_COMPANY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_COMPANY, exception);
		}
	}

	private final List<CompanyDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<CompanyDTO>();

			while (resultSet.next()) {
				results.add(fillCompanyDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_COMPANY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_COMPANY, exception);
		}
	}

	private final CompanyDTO fillCompanyDTO(final ResultSet resultSet) {

		try {
			return CompanyDTO.create(resultSet.getString("CompanyId"), resultSet.getString("CompanyName"), fillAdminDTO(resultSet));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_FILLING_COMPANYDTO_COMPANY, exception);
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
	public void update(CompanyDTO company) {
		final var sql = "UPDATE company SET id = ?, name = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, company.getIDAsString());
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(1, company.getAdminId().getIDAsString());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.CompanyMySQLDAO.TECHNICAL_PROBLEM_UPDATE_COMPANY, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.CompanyMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_COMPANY, exception);
		}
	}

}
