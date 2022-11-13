package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class CompanyDTO {
	
	private UUID id;
	private String name;
	
	
	public CompanyDTO(final UUID id, final String name) {
		setId(getDefaultUUID(getId()));
		setName(name);
	}
	public static CompanyDTO create(UUID id, String name) {
		return new CompanyDTO(id,name);
	}
	
	public static final CompanyDTO create(String id, String name){
		return new CompanyDTO(getUUIDFromString(id), name);
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
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}

}
