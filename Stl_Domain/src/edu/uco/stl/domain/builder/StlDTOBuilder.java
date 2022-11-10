package edu.uco.stl.domain.builder;

import java.util.UUID;

import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.domain.AreaDTO;
import edu.uco.stl.domain.CompanyDTO;
import edu.uco.stl.domain.InventoryDTO;
import edu.uco.stl.domain.LenderDTO;
import edu.uco.stl.domain.LendingDTO;
import edu.uco.stl.domain.MonitorDTO;
import edu.uco.stl.domain.ObservationDTO;
import edu.uco.stl.domain.ProductDTO;
import edu.uco.stl.domain.StlDTO;

public class StlDTOBuilder {
	
	private UUID id;
	private MonitorDTO person;
	private AdminDTO admin;
	private AreaDTO area;
	private CompanyDTO empresa;
	private InventoryDTO inventario;
	private LenderDTO lender;
	private ObservationDTO observation;
	private ProductDTO product;
	private LendingDTO loan;
	
	private StlDTOBuilder() {
		super();
	}
	
	public static final StlDTOBuilder getStlDTOBuilder() {
		return new StlDTOBuilder();
	}

	public StlDTOBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public StlDTOBuilder setPerson(MonitorDTO person) {
		this.person = person;
		return this;
	}

	public StlDTOBuilder setAdmin(AdminDTO admin) {
		this.admin = admin;
		return this;
	}

	public StlDTOBuilder setArea(AreaDTO area) {
		this.area = area;
		return this;
	}

	public StlDTOBuilder setEmpresa(CompanyDTO empresa) {
		this.empresa = empresa;
		return this;
	}

	public StlDTOBuilder setInventario(InventoryDTO inventario) {
		this.inventario = inventario;
		return this;
	}

	public StlDTOBuilder setLender(LenderDTO lender) {
		this.lender = lender;
		return this;
	}

	public StlDTOBuilder setObservation(ObservationDTO observation) {
		this.observation = observation;
		return this;
	}

	public StlDTOBuilder setProduct(ProductDTO product) {
		this.product = product;
		return this;
	}

	public StlDTOBuilder setLoan(LendingDTO loan) {
		this.loan = loan;
		return this;
	}
	
	public final StlDTO build() {
		return StlDTO.create(id, person, admin, area, empresa, inventario, lender, observation, product, loan);
	}

}
