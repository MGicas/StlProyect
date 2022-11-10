package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.InventoryDTO;

public class InventoryDTOBuilder {

	private UUID id;
	private String nombre;
	private int productQuantity;
	private boolean status;
	
	private InventoryDTOBuilder() {
		super();
	}
	
	public static final InventoryDTOBuilder getInventoriyDTOBuilder() {
		return new InventoryDTOBuilder();
	}

	public InventoryDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public InventoryDTOBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public InventoryDTOBuilder setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
		return this;
	}

	public InventoryDTOBuilder setStatus(boolean status) {
		this.status = status;
		return this;
	}
	
	public final InventoryDTO build() {
		return InventoryDTO.create(id, nombre, productQuantity, status);
	}
}
