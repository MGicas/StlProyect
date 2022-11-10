package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class ProductDTO {

	private UUID id;
	private String name;
	private String description;
	
	
	public ProductDTO(final UUID id, final String name, final String description) {
		setId(getDefaultUUID(getId()));
		setName(name);
		setDescription(description);
	}
	public static ProductDTO create(UUID id, String nombre, String description) {
		return new ProductDTO(id,nombre,description);
	}
	
	public static final ProductDTO create(String id, String nombre,String description){
		return new ProductDTO(getUUIDFromString(id), nombre, description);
	}
	
	public UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = (name == null)? " " : name.trim();
	}
	
	public String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = (description == null)? " " : description.trim();
	}
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
