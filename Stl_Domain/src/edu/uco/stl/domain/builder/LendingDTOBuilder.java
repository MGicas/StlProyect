package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.LendingDTO;

public class LendingDTOBuilder {

	private UUID id;
	private String product;
	private int loanQuantity;
	private String monitorRecieve; 
	private String monitorGive;
	private String lenderName;
	
	private LendingDTOBuilder() {
		super();
	}
	
	public static final LendingDTOBuilder getPrestamoDTOBuilder() {
		return new LendingDTOBuilder();
	}

	public LendingDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public LendingDTOBuilder setProduct(String product) {
		this.product = product;
		return this;
	}

	public LendingDTOBuilder setLoanQuantity(int loanQuantity) {
		this.loanQuantity = loanQuantity;
		return this;
	}


	public LendingDTOBuilder setMonitorRecieve(String monitorRecieve) {
		this.monitorRecieve = monitorRecieve;
		return this;
	}

	public LendingDTOBuilder setMonitorGive(String monitorGive) {
		this.monitorGive = monitorGive;
		return this;
	}

	public LendingDTOBuilder setLenderName(String lenderName) {
		this.lenderName = lenderName;
		return this;
	}
	
	public final LendingDTO build(){
		return LendingDTO.create(id, product, loanQuantity, monitorRecieve, monitorGive, lenderName);
	}
	
}
