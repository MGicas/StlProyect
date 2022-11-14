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
import edu.uco.stl.data.dao.ProductDAO;
import edu.uco.stl.data.dao.relational.DAORelational;
import edu.uco.stl.domain.ProductDTO;
import static edu.uco.stl.crosscutting.helper.StringHelper.isDefaultString;

public class ProductMySQLDAO extends DAORelational implements ProductDAO {

	public ProductMySQLDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ProductDTO product) {
		final var sql = "INSERT INTO product(id, name, description) VALUES (?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, product.getIDAsString());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_CREATE_PRODUCT, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PRODUCT, exception);
		}

	}

	@Override
	public List<ProductDTO> find(ProductDTO product) {

		var parameters = new ArrayList<Object>();
		final var sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, product, parameters);
		createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {

		sqlBuilder.append("SELECT pro.id AS ProductId, ");
		sqlBuilder.append("       pro.name AS ProductName ");
		sqlBuilder.append("       pro.description AS ProductDescription ");
		sqlBuilder.append("FROM product pro ");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final ProductDTO product,
			final List<Object> parameters) {
		var setWhere = true;

		if (!ObjectHelper.isNull(product)) {
			if (!UUIDHelper.isDefaultUUID(product.getId())) {
				sqlBuilder.append("WHERE MonitorId = ? ");
				setWhere = false;
				parameters.add(product.getIDAsString());
			}
			if (!isDefaultString(product.getName())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("name = ? ");
				setWhere = false;
				parameters.add(product.getName());
			}
			if (!isDefaultString(product.getDescription())) {
				sqlBuilder.append(setWhere ? "WHERE " : "AND ").append("description = ? ");
				setWhere = false;
				parameters.add(product.getDescription());
			}
		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY pro.id");
	}

	private final List<ProductDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
			final List<Object> parameters) {

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParametersValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_PREPARING_AND_EXECUTING_QUERY_PRODUCT, exception);
		}
	}

	private void setParametersValues(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_SETTING_PARAMETERS_VALUES_PRODUCT, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SETTING_PARAMETERS_VALUES_PRODUCT, exception);
		}
	}

	private final List<ProductDTO> executeQuery(PreparedStatement preparedStatement) {

		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_EXECUTING_QUERY_PRODUCT, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTING_QUERY_PRODUCT, exception);
		}
	}

	private final List<ProductDTO> fillResults(final ResultSet resultSet) {

		try {
			var results = new ArrayList<ProductDTO>();

			while (resultSet.next()) {
				results.add(fillProductDTO(resultSet));
			}

			return results;
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_FILLING_RESULTS_PRODUCT, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILLING_RESULTS_PRODUCT, exception);
		}
	}

	private final ProductDTO fillProductDTO(final ResultSet resultSet) {

		try {
			return ProductDTO.create(resultSet.getString("ProductId"), resultSet.getString("ProductName"),
					resultSet.getString("ProductDescription"));
		} catch (SQLException exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_FILLING_PRODUCTDTO_PRODUCT, exception);
		}
	}

	@Override
	public void update(ProductDTO product) {
		final var sql = "UPDATE product SET id = ?, name = ?, description = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, product.getIDAsString());
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(1, product.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_UPDATE_PRODUCT, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PRODUCT, exception);
		}

	}

	@Override
	public void delete(UUID id) {
		final var sql = "DELETE FROM product WHERE id = ?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, getUUIDAsString(id));

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw DataCustomException
					.CreateTechnicalException(Messages.ProductMySQLDAO.TECHNICAL_PROBLEM_DELETE_PRODUCT, exception);
		} catch (Exception exception) {
			throw DataCustomException.CreateTechnicalException(
					Messages.ProductMySQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PRODUCT, exception);
		}
	}

	@Override
	public void lend(ProductDTO product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deplete(ProductDTO product) {
		// TODO Auto-generated method stub

	}

}
