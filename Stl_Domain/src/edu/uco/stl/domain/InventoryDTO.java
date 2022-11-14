package edu.uco.stl.domain;

import static edu.uco.stl.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.stl.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.stl.crosscutting.helper.NumberHelper.ZERO;
import java.util.UUID;

public class InventoryDTO {

	private UUID id;
	private String name;
	private int productQuantity;
	private boolean status;
	
	public InventoryDTO() {
		setId(getDefaultUUID(getId()));
		setName(EMPTY);
		setProductQuantity(ZERO);
		setStatus(true);	
	}
	
	public InventoryDTO(final UUID id, final String name, final int productQuantity,final boolean status) {
		setId(getDefaultUUID(getId()));
		setName(name);
		setProductQuantity(productQuantity);
		setStatus(status);	
	}
	public static InventoryDTO create(UUID id, String name,int productQuantity, boolean status) {
		return new InventoryDTO(id, name, 0, true);
	}
	
	public static final InventoryDTO create(String id, String name,int productQuantity, boolean status){
		return new InventoryDTO(getUUIDFromString(id), name, 0, true);
	}
	
	public UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	public String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = (name == null)? " " : name.trim();
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	public final void setProductQuantity(final int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public boolean isStatus() {
		return status;
	}
	public final void setStatus(final boolean status) {
		this.status = status;
	}
	public final String getIDAsString() {
		return getUUIDAsString(null);
	}
}
