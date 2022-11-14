package edu.uco.stl.domain;

import java.util.UUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.*;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;

public class MonitorDTO {

	private UUID id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	public MonitorDTO(){
		setId(getDefaultUUID(getId()));
		setIdentification(EMPTY);
		setFirstname(EMPTY);
		setSecondName(EMPTY);
		setFirstSurname(EMPTY);
		setSecondSurname(EMPTY);
	}
	
	public MonitorDTO(final UUID id, final String identification, final String firstName, final String secondName, final String firstSurname, final String secondSurname){
		setId(getDefaultUUID(getId()));
		setIdentification(identification);
		setFirstname(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static MonitorDTO create(UUID id, String identification, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new MonitorDTO(id, identification, firstName, secondName, firstSurname, secondSurname);
	}
	
	public static final MonitorDTO create(String id, String identification, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new MonitorDTO(getUUIDFromString(id), identification, firstName, secondName, firstSurname, secondSurname);
	}
	
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final void setIdentification(final String identification) {
		this.identification = (identification == null)? " " : identification.trim();
	}

	public final void setFirstname(String firstName) {
		this.firstName = (firstName == null)? " " : firstName.trim();
	}

	public final void setSecondName(String secondName) {
		this.secondName = (secondName == null)? " " : secondName.trim();
	}

	public final void setFirstSurname(String firstSurname) {
		this.firstSurname = (firstSurname == null)? " " : firstSurname.trim();
	}
	
	public final void setSecondSurname(String secondSurname) {
		this.secondSurname = (secondSurname == null)? " " : secondSurname.trim();
	}


	public final UUID getId() {
		return id;
	}

	public final String getIdentification() {
		return identification;
	}

	public final String getFirstname() {
		return firstName;
	}

	public final String getSecondName() {
		return secondName;
	}

	public final String getFirstSurname() {
		return firstSurname;
	}
	
	public final String getSecondSurname() {
		return secondSurname;
	}
	
	public final String getSurname() {
		return getFirstSurname()+" " + getSecondSurname().trim();
	}
	
	public final String getName() {
		return getFirstname()+" " + getSecondName().trim() + " " + getSurname();
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
