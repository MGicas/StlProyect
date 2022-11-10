package edu.uco.stl.domain.builder;

import java.util.Date;
import java.util.UUID;

import edu.uco.stl.domain.ObservationDTO;

public class ObservacionDTOBuilder {
	
	private UUID id;
	private boolean returnComplete;
	private Date loanExtencion;
	private String description;
	private boolean returnOnTime;
	
	private ObservacionDTOBuilder() {
		super();
	}

	public static final ObservacionDTOBuilder getObservacionDTOBuilder() {
		return new ObservacionDTOBuilder();
	}

	public ObservacionDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public ObservacionDTOBuilder setReturnComplete(boolean returnComplete) {
		this.returnComplete = returnComplete;
		return this;
	}

	public ObservacionDTOBuilder setLoanExtencion(Date loanExtencion) {
		this.loanExtencion = loanExtencion;
		return this;
	}

	public ObservacionDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public ObservacionDTOBuilder setReturnOnTime(boolean returnOnTime) {
		this.returnOnTime = returnOnTime;
		return this;
	}
	
	public final ObservationDTO build() {
		return ObservationDTO.create(id, returnComplete, loanExtencion, description, returnOnTime);
	}
	
}
