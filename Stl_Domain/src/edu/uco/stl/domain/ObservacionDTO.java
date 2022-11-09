package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.Date;
import java.util.UUID;

public class ObservacionDTO {

	private UUID id;
	private boolean returnComplete;
	private Date loanExtencion;
	private String description;
	private boolean returnOnTime;
	
	public ObservacionDTO(final UUID id, final boolean returnComplete, final Date loanExtencion, final String description, final boolean returnOnTime) {
		setId(getDefaultUUID(getId()));
		setReturnComplete(returnComplete);
		
	}
	public static ObservacionDTO create(UUID id, boolean returnComplete, Date loanExtencion, String description,boolean returnOnTime) {
		return new ObservacionDTO(id,returnComplete,loanExtencion,description,returnOnTime);
	}
	
	public static final ObservacionDTO create(String id, boolean returnComplete, Date loanExtencion, String description,boolean returnOnTime){
		return new ObservacionDTO(getUUIDFromString(id), returnComplete,loanExtencion,description,returnOnTime);
	}
	
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public final void setReturnComplete(boolean returnComplete) {
		this.returnComplete = returnComplete;
	}
	public final void setLoanExtencion(Date loanExtencion) {
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
