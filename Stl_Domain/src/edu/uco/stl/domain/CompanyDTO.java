package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;
import java.util.UUID;

public class CompanyDTO {
	
	private UUID id;
	private String name;
	private AdminDTO admin;
	
	public CompanyDTO() {
		setId(getDefaultUUID(getId()));
		setName(EMPTY);
		setAdmin(new AdminDTO());
	}
	
	public CompanyDTO(final UUID id, final String name, AdminDTO admin) {
		setId(getDefaultUUID(getId()));
		setName(name);
	}
	public static CompanyDTO create(UUID id, String name, AdminDTO admin) {
		return new CompanyDTO(id,name,admin);
	}
	
	public static final CompanyDTO create(String id, String name, AdminDTO admin){
		return new CompanyDTO(getUUIDFromString(id), name,admin);
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
	
	public AdminDTO getAdmin() {
		return admin;
	}

	public final void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}

	public final String getIDAsString() {
		return getUUIDAsString(null);
	}

}
