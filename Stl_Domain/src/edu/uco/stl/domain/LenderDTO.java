package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class LenderDTO {

	private UUID id;
	private String identification;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	private String city;
	private String neighborhood;
	private String address;
	private int phone;
	private String mail;
	
	
	
	public LenderDTO(UUID id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname, String city, String neighborhood, String address, int phone, String mail) {
		setId(getDefaultUUID(getId()));
		setIdentification(identification);
		setFirstname(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
		setCity(city);
		setNeighborhood(neighborhood);
		setAddress(address);
		setPhone(phone);
		setMail(mail);
	}
	
	public static LenderDTO create(UUID id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname, String city, String neighborhood, String address, int phone, String mail) {
		return new LenderDTO(id, identification, firstName, secondName, firstSurname, secondSurname, city, neighborhood, address, phone, mail);
	}
	
	public static final LenderDTO create(String id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname, String city, String neighborhood, String address, int phone, String mail) {
		return new LenderDTO(getUUIDFromString(id), identification, firstName, secondName, firstSurname, secondSurname, city, neighborhood, address, phone, mail);
	}
	public UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getIdentification() {
		return identification;
	}
	public final void setIdentification(String identification) {
		this.identification = (identification == null)? " " : identification.trim();
	}
	public String getFirstName() {
		return firstName;
	}
	public final void setFirstname(String firstName) {
		this.firstName = (firstName == null)? " " : firstName.trim();
	}
	public String getSecondName() {
		return secondName;
	}
	public final void setSecondName(String secondName) {
		this.secondName = (secondName == null)? " " : secondName.trim();
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public final void setFirstSurname(String firstSurname) {
		this.firstSurname = (firstSurname == null)? " " : firstSurname.trim();
	}
	public String getSecondSurname() {
		return secondSurname;
	}
	public final void setSecondSurname(String secondSurname) {
		this.secondSurname = (secondSurname == null)? " " : secondSurname.trim();
	}
	public String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = (city == null)? " " : city.trim();
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public final void setNeighborhood(String neighborhood) {
		this.neighborhood = (neighborhood == null)? " " : neighborhood.trim();
	}
	public String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = (address == null)? " " : address.trim();
	}
	public int getPhone() {
		return phone;
	}
	public final void setPhone(int phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public final void setMail(String mail) {
		this.mail = (mail == null)? " " : mail.trim();
	}
	
	public final String getSurname() {
		return getFirstSurname()+" " + getSecondSurname().trim();
	}
	
	public final String getName() {
		return getFirstName()+" " + getSecondName().trim() + " " + getSurname();
	}
	
	public final String getDireccionCompleta() {
		return getCity()+" " + getNeighborhood().trim()+ getAddress();
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
