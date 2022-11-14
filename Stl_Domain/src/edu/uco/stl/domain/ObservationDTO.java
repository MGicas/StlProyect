package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;
import java.util.Date;
import java.util.UUID;

public class ObservationDTO {

	private UUID id;
	private boolean returnComplete;
	private Date loanExtencion;
	private String description;
	private boolean returnOnTime;
	
	public ObservationDTO() {
		setId(getDefaultUUID(getId()));
		setReturnComplete(true);
		setDescription(EMPTY);
		setLoanExtencion(loanExtencion);
		setReturnOnTime(true);
		
		
	}
	
	public ObservationDTO(final UUID id, final boolean returnComplete, final Date loanExtencion, final String description, final boolean returnOnTime) {
		setId(getDefaultUUID(getId()));
		setReturnComplete(returnComplete);
		setDescription(description);
		setLoanExtencion(loanExtencion);
		setReturnOnTime(returnOnTime);
		
	}
	public static ObservationDTO create(UUID id, boolean returnComplete, Date loanExtencion, String description,boolean returnOnTime) {
		return new ObservationDTO(id,returnComplete,loanExtencion,description,returnOnTime);
	}
	
	public static final ObservationDTO create(String id, boolean returnComplete, Date loanExtencion, String description,boolean returnOnTime){
		return new ObservationDTO(getUUIDFromString(id), returnComplete,loanExtencion,description,returnOnTime);
	}
	
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public final void setReturnComplete(boolean returnComplete) {
		this.returnComplete = returnComplete;
	}
	public void setLoanExtencion(Date loanExtencion) {
		this.loanExtencion = loanExtencion;
	}
	public final void setDescription(String description) {
		this.description = (description == null)? " " : description.trim();
	}
	public final void setReturnOnTime(boolean returnOnTime) {
		this.returnOnTime = returnOnTime;
	}
	public UUID getId() {
		return id;
	}
	
	public boolean isReturnComplete() {
		return returnComplete;
	}
	public Date getLoanExtencion() {
		return loanExtencion;
	}
	public String getDescription() {
		return description;
	}
	public boolean isReturnOnTime() {
		return returnOnTime;
	}
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
