package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class AreaDTO {

	private UUID id;
	private String nombre;
	
	
	public AreaDTO(final UUID id, final String nombre) {
		setId(getDefaultUUID(getId()));
		setNombre(nombre);
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
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
	
}
