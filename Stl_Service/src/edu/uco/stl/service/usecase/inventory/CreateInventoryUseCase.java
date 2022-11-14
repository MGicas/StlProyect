package edu.uco.stl.service.usecase.inventory;

import edu.uco.stl.domain.InventoryDTO;

public interface CreateInventoryUseCase {
	
	void execute(InventoryDTO inventory);

}
