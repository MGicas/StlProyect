package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.LendingDTO;

public interface LendingDAO {
	
	void create(LendingDTO inventory);

	List<LendingDTO> find(LendingDTO inventory);

	void update(LendingDTO inventory);
	
	void close(LendingDTO inventory);
	
	void overcome(LendingDTO inventory);

}
