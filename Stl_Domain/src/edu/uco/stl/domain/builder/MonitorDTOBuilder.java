package edu.uco.stl.domain.builder;

import edu.uco.stl.domain.MonitorDTO;

public class MonitorDTOBuilder {

	private String id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	private MonitorDTOBuilder() {
		super();
	}
	
	public static final MonitorDTOBuilder getMonitorDTObuilder() {
		return new MonitorDTOBuilder();
	}

	public MonitorDTOBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public MonitorDTOBuilder setIdentification(String identification) {
		this.identification = identification;
		return this;
	}

	public MonitorDTOBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public MonitorDTOBuilder setSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public MonitorDTOBuilder setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
		return this;
	}

	public MonitorDTOBuilder setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
		return this;
	}
	
	public final MonitorDTO build() {
		return MonitorDTO.create(id, identification, firstName, secondName, firstSurname, secondSurname);
	}
}
