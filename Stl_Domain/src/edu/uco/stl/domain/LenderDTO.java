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
	private String ciudad;
	private String barrio;
	private String direccion;
	private int telefono;
	private String correo;
	
	
	
	public LenderDTO(UUID id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname, String ciudad, String barrio, String direccion, int telefono, String correo) {
		setId(getDefaultUUID(getId()));
		setIdentification(identification);
		setFirstname(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
		setCiudad(ciudad);
		setBarrio(barrio);
		setDireccion(direccion);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	public static LenderDTO create(UUID id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname, String ciudad, String barrio, String direccion, int telefono, String correo) {
		return new LenderDTO(id, identification, firstName, secondName, firstSurname, secondSurname, ciudad, barrio, direccion, telefono, correo);
	}
	
	public static final LenderDTO create(String id, String identification, String firstName, String secondName, String firstSurname,
			String secondSurname, String ciudad, String barrio, String direccion, int telefono, String correo) {
		return new LenderDTO(getUUIDFromString(id), identification, firstName, secondName, firstSurname, secondSurname, ciudad, barrio, direccion, telefono, correo);
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
	public String getCiudad() {
		return ciudad;
	}
	public final void setCiudad(String ciudad) {
		this.ciudad = (ciudad == null)? " " : ciudad.trim();
	}
	public String getBarrio() {
		return barrio;
	}
	public final void setBarrio(String barrio) {
		this.barrio = (barrio == null)? " " : barrio.trim();
	}
	public String getDireccion() {
		return direccion;
	}
	public final void setDireccion(String direccion) {
		this.direccion = (direccion == null)? " " : direccion.trim();
	}
	public int getTelefono() {
		return telefono;
	}
	public final void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public final void setCorreo(String correo) {
		this.correo = (correo == null)? " " : correo.trim();
	}
	
	public final String getSurname() {
		return getFirstSurname()+" " + getSecondSurname().trim();
	}
	
	public final String getName() {
		return getFirstName()+" " + getSecondName().trim() + " " + getSurname();
	}
	
	public final String getDireccionCompleta() {
		return getCiudad()+" " + getBarrio().trim()+ getDireccion();
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
