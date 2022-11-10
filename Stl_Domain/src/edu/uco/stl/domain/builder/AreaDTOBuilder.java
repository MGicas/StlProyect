package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.AreaDTO;

public class AreaDTOBuilder {
	
	private UUID id;
	private String nombre;
	
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

	public AreaDTOBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public final AreaDTO build() {
		return AreaDTO.create(id, nombre);
	}

}
