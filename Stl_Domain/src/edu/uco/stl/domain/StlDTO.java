package edu.uco.stl.domain;

import java.util.UUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.*;

public class StlDTO {
	
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
	
	public StlDTO() {
		setId(getNewUUID());
	}
	
	public StlDTO(final UUID id,final MonitorDTO person, final AdminDTO admin,final AreaDTO area, final CompanyDTO empresa,
			final InventoryDTO inventario, final LenderDTO lender, final ObservationDTO observation,final ProductDTO product,
			final LendingDTO loan) {
		setId(getDefaultUUID(getId()));
		setPerson(person);
		setAdmin(admin);
		setArea(area);
		setEmpresa(empresa);
		setInventario(inventario);
		setLender(lender);
		setObservation(observation);
		setProduct(product);
		setLoan(loan);
	}
	
	public static final StlDTO create(UUID id, MonitorDTO person, AdminDTO admin, AreaDTO area, CompanyDTO empresa,
			InventoryDTO inventario, LenderDTO lender, ObservationDTO observation, ProductDTO product,
			LendingDTO loan) {
		return new StlDTO(id, person, admin, area, empresa, inventario, lender, observation, product, loan);
	}
	
	public static final StlDTO create(String id, MonitorDTO person, AdminDTO admin, AreaDTO area, CompanyDTO empresa,
			InventoryDTO inventario, LenderDTO lender, ObservationDTO observation, ProductDTO product,
			LendingDTO loan) {
		return new StlDTO(getNewUUID(), person, admin, area, empresa, inventario, lender, observation, product, loan);
	}
	
	public final void setId(UUID id) {
		this.id = id;
	}
	public final void setPerson(MonitorDTO person) {
		this.person = person;
	}
	public final void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	public final void setArea(AreaDTO area) {
		this.area = area;
	}
	public final void setEmpresa(CompanyDTO empresa) {
		this.empresa = empresa;
	}
	public final void setInventario(InventoryDTO inventario) {
		this.inventario = inventario;
	}
	public final void setLender(LenderDTO lender) {
		this.lender = lender;
	}
	public final void setObservation(ObservationDTO observation) {
		this.observation = observation;
	}
	public final void setProduct(ProductDTO product) {
		this.product = product;
	}
	public final void setLoan(LendingDTO loan) {
		this.loan = loan;
	}
	
	public UUID getId() {
		return id;
	}
	public MonitorDTO getPerson() {
		return person;
	}
	public AdminDTO getAdmin() {
		return admin;
	}
	public AreaDTO getArea() {
		return area;
	}
	public CompanyDTO getEmpresa() {
		return empresa;
	}
	public InventoryDTO getInventario() {
		return inventario;
	}
	public LenderDTO getLender() {
		return lender;
	}
	public ObservationDTO getObservation() {
		return observation;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public LendingDTO getLoan() {
		return loan;
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(getId());
	}
	

}
