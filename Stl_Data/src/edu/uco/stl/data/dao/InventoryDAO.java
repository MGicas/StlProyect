package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.InventoryDTO;

public interface InventoryDAO {
	
	void create(InventoryDTO inventory);

	List<InventoryDTO> find(InventoryDTO inventory);

	void update(InventoryDTO inventory);
	
	void activate (InventoryDTO inventory);

}
