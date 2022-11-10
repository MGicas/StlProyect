package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.CompanyDTO;

public interface CompanyDAO {

	void create(CompanyDTO company);

	List<CompanyDTO> find(CompanyDTO company);

	void update(CompanyDTO company);

}
