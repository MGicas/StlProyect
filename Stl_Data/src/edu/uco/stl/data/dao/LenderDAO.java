package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.LenderDTO;

public interface LenderDAO {
	
	void create(LenderDTO inventory);

	List<LenderDTO> find(LenderDTO inventory);

	void update(LenderDTO inventory);
	

}
