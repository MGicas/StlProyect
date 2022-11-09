package edu.uco.stl.domain.builder;

import edu.uco.stl.domain.AdministratorDTO;

public class AdministratorDTOBuilder {

	private String id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	private AdministratorDTOBuilder() {
		super();
	}
	
	public static final AdministratorDTOBuilder getAdministratorDTObuilder() {
		return new AdministratorDTOBuilder();
	}

	public AdministratorDTOBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public AdministratorDTOBuilder setIdentification(String identification) {
		this.identification = identification;
		return this;
	}

	public AdministratorDTOBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public AdministratorDTOBuilder setSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public AdministratorDTOBuilder setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
		return this;
	}

	public AdministratorDTOBuilder setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
		return this;
	}
	
	public final AdministratorDTO build() {
		return AdministratorDTO.create(id, identification, firstName, secondName, firstSurname, secondSurname);
	}
}
