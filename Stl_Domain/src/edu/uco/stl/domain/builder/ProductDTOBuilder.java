package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.ProductDTO;

public class ProductDTOBuilder {
	
	private UUID id;
	private String name;
	private String description;
	
	private ProductDTOBuilder() {
		super();
	}
	
	public static final ProductDTOBuilder getProductDTOBuilder() {
		return new ProductDTOBuilder();
	}

	public ProductDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public ProductDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public ProductDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public final ProductDTO build() {
		return ProductDTO.create(id, name, description);
	}
	
}
