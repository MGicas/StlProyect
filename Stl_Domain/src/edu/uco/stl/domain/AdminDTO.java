package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;

import java.util.UUID;

public class AdminDTO {

	private UUID id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	public AdminDTO(){
		setId(getDefaultUUID(getId()));
		setIdentification(EMPTY);
		setFirstname(EMPTY);
		setSecondName(EMPTY);
		setFirstSurname(EMPTY);
		setSecondSurname(EMPTY);
	}
	
	public AdminDTO(final UUID id, final String identification, final String firstName, final String secondName, final String firstSurname, final String secondSurname){
		setId(getDefaultUUID(getId()));
		setIdentification(identification);
		setFirstname(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static AdminDTO create(UUID id, String identification, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new AdminDTO(id, identification, firstName, secondName, firstSurname, secondSurname);
	}
	
	public static final AdminDTO create(String id, String identification, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new AdminDTO(getUUIDFromString(id), identification, firstName, secondName, firstSurname, secondSurname);
	}
	
	public static final AdminDTO create(UUID id) {
		return new AdminDTO(getDefaultUUID(id), EMPTY, EMPTY, EMPTY, EMPTY, EMPTY);
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
