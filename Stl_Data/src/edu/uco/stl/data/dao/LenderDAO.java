package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.LenderDTO;

public interface LenderDAO {
	
	void create(LenderDTO lender);

	List<LenderDTO> find(LenderDTO lender);

	void update(LenderDTO lender);
	

}
