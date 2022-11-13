package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.AreaDTO;

public class AreaDTOBuilder {
	
	private UUID id;
	private String name;
	
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
	
	public final AreaDTO build() {
		return AreaDTO.create(id, name);
	}

}
