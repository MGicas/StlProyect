package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.LendingDTO;

public interface LendingDAO {
	
	void create(LendingDTO lending);

	List<LendingDTO> find(LendingDTO lending);

	void update(LendingDTO lending);
	
	void close(LendingDTO lending);
	
	void overcome(LendingDTO lending);

}
