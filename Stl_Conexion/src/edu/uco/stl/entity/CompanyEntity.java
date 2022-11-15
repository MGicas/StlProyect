package edu.uco.stl.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Company")
public class CompanyEntity {
	
	@Id
	@Column(name="id")
	private UUID id;
	@ManyToOne
	@JoinColumn(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="idAdmin")
	private AdminEntity admin;
	
	public CompanyEntity() {
		setAdmin(new AdminEntity());
	}


	public CompanyEntity(final String name, final AdminEntity admin) {
		setName(name);
		setAdmin(admin);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		if(name == null) {
			setName("");
		}
		return name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdminEntity getAdmin() {
		if(admin==null) {
			setAdmin(new AdminEntity());
		}
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", admin=" + admin + "]";
	}
	
	
}
