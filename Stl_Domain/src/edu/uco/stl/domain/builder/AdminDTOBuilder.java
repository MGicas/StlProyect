package edu.uco.stl.domain.builder;

import edu.uco.stl.domain.AdminDTO;

public class AdminDTOBuilder {

	private String id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	private AdminDTOBuilder() {
		super();
	}
	
	public static final AdminDTOBuilder getAdministratorDTObuilder() {
		return new AdminDTOBuilder();
	}

	public AdminDTOBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public AdminDTOBuilder setIdentification(String identification) {
		this.identification = identification;
		return this;
	}

	public AdminDTOBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public AdminDTOBuilder setSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public AdminDTOBuilder setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
		return this;
	}

	public AdminDTOBuilder setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
		return this;
	}
	
	public final AdminDTO build() {
		return AdminDTO.create(id, identification, firstName, secondName, firstSurname, secondSurname);
	}
}
