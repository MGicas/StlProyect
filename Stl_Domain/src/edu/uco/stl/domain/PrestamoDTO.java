package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.Date;
import java.util.UUID;

public class PrestamoDTO {
	
	private UUID id;
	private String product;
	private int loanQuantity;
	private Date Date;
	private String monitorRecieve; 
	private String monitorGive;
	private String lenderName;
	
	public PrestamoDTO(UUID id, String product, int loanQuantity, java.util.Date date, String monitorRecieve, String monitorGive,
			String lenderName) {
		
		setId(getDefaultUUID(getId()));
		setProduct(product);
		setLoanQuantity(loanQuantity);
		setDate(date);
		setMonitorRecieve(monitorRecieve);
		setMonitorGive(monitorGive);
		setLenderName(lenderName);
	}

	public static PrestamoDTO create(UUID id, String product, int loanQuantity, java.util.Date date, String monitorRecieve, String monitorGive,
			String lenderName) {
		return new PrestamoDTO(id, product, loanQuantity, date, monitorRecieve, monitorGive, lenderName);
	}
	
	public static final PrestamoDTO create (String id, String product, int loanQuantity, java.util.Date date, String monitorRecieve, String monitorGive,
			String lenderName) {
		return new PrestamoDTO(getUUIDFromString(id), product, loanQuantity, date, monitorRecieve, monitorGive, lenderName);
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final void setProduct(String product) {
		this.product = (product == null)? " " : product.trim();
	}

	public final void setLoanQuantity(int loanQuantity) {
		this.loanQuantity = loanQuantity;
	}

	public final void setDate(Date date) {
		Date = date;
	}

	public final void setMonitorRecieve(String monitorRecieve) {
		this.monitorRecieve = (monitorRecieve == null)? " " : monitorRecieve.trim();
	}

	public final void setMonitorGive(String monitorGive) {
		this.monitorGive = (monitorGive == null)? " " : monitorGive.trim();
	}

	public final void setLenderName(String lenderName) {
		this.lenderName = (lenderName == null)? " " : lenderName.trim();
	}

	public UUID getId() {
		return id;
	}
	public String getProduct() {
		return product;
	}

	public int getLoanQuantity() {
		return loanQuantity;
	}

	public Date getDate() {
		return Date;
	}

	public String getMonitorRecieve() {
		return monitorRecieve;
	}

	public String getMonitorGive() {
		return monitorGive;
	}

	public String getLenderName() {
		return lenderName;
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
	

}
