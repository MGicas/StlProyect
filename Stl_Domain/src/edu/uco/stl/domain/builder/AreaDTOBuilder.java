package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.AreaDTO;
import edu.uco.stl.domain.CompanyDTO;

public class AreaDTOBuilder {
	
	private UUID id;
	private String name;
	private CompanyDTO idCompany;
	
	private AreaDTOBuilder() {
		super();
	}
	
	public static final AreaDTOBuilder getAreaDTOBuilder() {
		return new AreaDTOBuilder();
	}

	public AreaDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public AreaDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public void setIdCompany(CompanyDTO idCompany) {
		this.idCompany = idCompany;
	}

	public final AreaDTO build() {
		return AreaDTO.create(id, name,idCompany);
	}

}
