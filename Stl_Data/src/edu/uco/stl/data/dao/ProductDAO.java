package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.ProductDTO;

public interface ProductDAO {
	
	void create(ProductDTO inventory);

	List<ProductDTO> find(ProductDTO inventory);

	void update(ProductDTO inventory);
	
	void delete (ProductDTO inventory);
	
	void lend (ProductDTO inventory);
	
	void deplete (ProductDTO inventory);

}
