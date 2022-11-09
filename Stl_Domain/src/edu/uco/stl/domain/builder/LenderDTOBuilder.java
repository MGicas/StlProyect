package edu.uco.stl.domain.builder;

import java.util.UUID;

public class LenderDTOBuilder {
	
	private String id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	private String ciudad;
	private String barrio;
	private String direccion;
	private int telefono;
	private String correo;

	private LenderDTOBuilder() {
		super();
	}
	
	public static final LenderDTOBuilder getLenderDTOBuilder() {
		return new LenderDTOBuilder();
	}
	
	
}
