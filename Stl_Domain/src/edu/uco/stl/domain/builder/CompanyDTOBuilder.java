package edu.uco.stl.domain.builder;

import java.util.UUID;
import edu.uco.stl.domain.CompanyDTO;

public class CompanyDTOBuilder {
	
	private UUID id;
	private String name;
	
	private CompanyDTOBuilder() {
		super();
	}
	
	public static final CompanyDTOBuilder getCompanyDTOBuilder() {
		return new CompanyDTOBuilder();
	}

	public CompanyDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public CompanyDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public final CompanyDTO build() {
		return CompanyDTO.create(id, name);
	}
}
