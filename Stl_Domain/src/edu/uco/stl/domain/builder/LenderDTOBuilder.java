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

	public LenderDTOBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public LenderDTOBuilder setIdentification(String identification) {
		this.identification = identification;
		return this;
	}

	public LenderDTOBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public LenderDTOBuilder setSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public LenderDTOBuilder setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
		return this;
	}

	public LenderDTOBuilder setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
		return this;
	}

	public LenderDTOBuilder setCiudad(String ciudad) {
		this.ciudad = ciudad;
		return this;
	}

	public LenderDTOBuilder setBarrio(String barrio) {
		this.barrio = barrio;
		return this;
	}

	public LenderDTOBuilder setDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public LenderDTOBuilder setTelefono(int telefono) {
		this.telefono = telefono;
		return this;
	}

	public LenderDTOBuilder setCorreo(String correo) {
		this.correo = correo;
		return this;
	}
	
	
	
	
}
