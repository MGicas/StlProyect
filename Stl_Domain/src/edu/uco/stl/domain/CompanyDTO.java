package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;
import java.util.UUID;

public class CompanyDTO {
	
	private UUID id;
	private String name;
	private AdminDTO adminId;
	
	public CompanyDTO() {
		setId(getDefaultUUID(getId()));
		setName(EMPTY);
		setAdminId(new AdminDTO());
	}
	
	public CompanyDTO(final UUID id, final String name, AdminDTO adminId) {
		setId(getDefaultUUID(getId()));
		setName(name);
		setAdminId(adminId);
	}
	public static CompanyDTO create(UUID id, String name, AdminDTO adminId) {
		return new CompanyDTO(id,name,adminId);
	}
	
	public static final CompanyDTO create(String id, String name, AdminDTO adminId){
		return new CompanyDTO(getUUIDFromString(id), name,adminId);
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
	
	public AdminDTO getAdminId() {
		return adminId;
	}

	public final void setAdminId(AdminDTO adminId) {
		this.adminId = adminId;
	}

	public final String getIDAsString() {
		return getUUIDAsString(null);
	}

}
