package edu.uco.stl.domain;

import java.util.UUID;

public class StlDTO {
	
	private UUID id;
	private MonitorDTO person;
	
	public StlDTO() {
		setId(id);
	}

	public StlDTO(UUID id, MonitorDTO person) {
		super();
		setId(id);
		setPerson(person);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public MonitorDTO getPerson() {
		return person;
	}

	public void setPerson(MonitorDTO person) {
		this.person = person;
	}
	
	

}
