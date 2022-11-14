package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;

import java.util.UUID;

public class AreaDTO {

	private UUID id;
	private String name;
	private CompanyDTO idCompany;

	
	public AreaDTO() {
		setId(getDefaultUUID(getId()));
		setName(EMPTY);
		setIdCompany(new CompanyDTO());
	}
	
	public AreaDTO(final UUID id, final String name, final CompanyDTO idCompany) {
		setId(getDefaultUUID(getId()));
		setName(name);
		setIdCompany(idCompany);
	}
	public static AreaDTO create(UUID id, String name, CompanyDTO idCompany) {
		return new AreaDTO(id,name,idCompany);
	}
	
	public static final AreaDTO create(String id, String name, CompanyDTO idCompany){
		return new AreaDTO(getUUIDFromString(id), name,idCompany);
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

	public CompanyDTO getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(final CompanyDTO idCompany) {
		this.idCompany = idCompany;
	}	
	
}
