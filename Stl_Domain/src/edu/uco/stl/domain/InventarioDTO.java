package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class InventarioDTO {

	private UUID id;
	private String nombre;
	private int productQuantity;
	private boolean status;
	
	
	public InventarioDTO(final UUID id, final String nombre, final int productQuantity,final boolean status) {
		setId(getDefaultUUID(getId()));
		setNombre(nombre);
		setProductQuantity(productQuantity);
		setStatus(status);
		
	}
	public static AreaDTO create(UUID id, String nombre) {
		return new AreaDTO(id,nombre);
	}
	
	public static final AreaDTO create(String id, String nombre){
		return new AreaDTO(getUUIDFromString(id), nombre);
	}
	
	public UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getNombre() {
		return nombre;
	}
	public final void setNombre(final String nombre) {
		this.nombre = (nombre == null)? " " : nombre.trim();
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	public final void setProductQuantity(final int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public boolean isStatus() {
		return status;
	}
	public final void setStatus(final boolean status) {
		this.status = status;
	}
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
