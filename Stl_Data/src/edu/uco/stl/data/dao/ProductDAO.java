package edu.uco.stl.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.stl.domain.ProductDTO;

public interface ProductDAO {
	
	void create(ProductDTO product);

	List<ProductDTO> find(ProductDTO product);

	void update(ProductDTO product);
	
	void delete (UUID id);
	
	void lend (ProductDTO product);
	
	void deplete (ProductDTO product);

}
