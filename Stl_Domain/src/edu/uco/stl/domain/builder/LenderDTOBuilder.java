package edu.uco.stl.domain.builder;

public class LenderDTOBuilder {
	
	private String id;
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

	public LenderDTOBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public LenderDTOBuilder setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
		return this;
	}

	public LenderDTOBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public LenderDTOBuilder setPhone(int phone) {
		this.phone = phone;
		return this;
	}

	public LenderDTOBuilder setMail(String mail) {
		this.mail = mail;
		return this;
	}
	
	
	
	
}
