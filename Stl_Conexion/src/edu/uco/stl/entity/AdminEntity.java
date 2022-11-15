package edu.uco.stl.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.uco.stl.crosscutting.helper.UUIDHelper;

@Entity
@Table(name = "Admin")
public class AdminEntity {
	
	@Id
	@Column(name="id")
	private UUID id;
	@Column(name="identification")
	private String identification;
	@Column(name="firstName")
	private String firstName;
	@Column(name="secondName")
	private String secondName;
	@Column(name="firstSurname")
	private String firstSurname;
	@Column(name="secondSurname")
	private String secondSurname;
	
	public AdminEntity() {
		setId(UUIDHelper.getDefaultUUID(id));
		setIdentification("");
		setFirstName("");
		setSecondName("");
		setFirstSurname("");
		setSecondSurname("");
	}

	public AdminEntity(UUID id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname) {
		setId(id);
		setIdentification(identification);
		setFirstName(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static AdminEntity create() {
		return new AdminEntity();
	}

	public UUID getId() {
		if (id==null) {
			setId(UUIDHelper.getDefaultUUID(id));
		}
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIdentification() {
		if(identification == null) {
			setIdentification("");
		}
		return identification.trim();
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getFirstName() {
		if(firstName == null) {
			setFirstName("");
		}
		return firstName.trim();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		if(secondName == null) {
			setSecondName("");
		}
		return secondName.trim();
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstSurname() {
		if(firstSurname == null) {
			setFirstSurname("");
		}
		return firstSurname.trim();
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		if(secondSurname == null) {
			setSecondSurname("");
		}
		return secondSurname.trim();
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}
	
	

}
