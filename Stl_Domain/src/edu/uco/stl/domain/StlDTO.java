package edu.uco.stl.domain;

import java.util.UUID;
import static edu.uco.stl.crosscutting.helper.UUIDHelper.*;

public class StlDTO {
	
	private UUID id;
	private MonitorDTO person;
	private AdministratorDTO admin;
	private AreaDTO area;
	private EmpresaDTO empresa;
	private InventarioDTO inventario;
	private LenderDTO lender;
	private ObservacionDTO observation;
	private ProductoDTO product;
	private PrestamoDTO loan;
	
	public StlDTO() {
		setId(getNewUUID());
	}
	
	public StlDTO(final UUID id,final MonitorDTO person, final AdministratorDTO admin,final AreaDTO area, final EmpresaDTO empresa,
			final InventarioDTO inventario, final LenderDTO lender, final ObservacionDTO observation,final ProductoDTO product,
			final PrestamoDTO loan) {
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
	
	public static final StlDTO create(UUID id, MonitorDTO person, AdministratorDTO admin, AreaDTO area, EmpresaDTO empresa,
			InventarioDTO inventario, LenderDTO lender, ObservacionDTO observation, ProductoDTO product,
			PrestamoDTO loan) {
		return new StlDTO(id, person, admin, area, empresa, inventario, lender, observation, product, loan);
	}
	
	public static final StlDTO create(String id, MonitorDTO person, AdministratorDTO admin, AreaDTO area, EmpresaDTO empresa,
			InventarioDTO inventario, LenderDTO lender, ObservacionDTO observation, ProductoDTO product,
			PrestamoDTO loan) {
		return new StlDTO(getNewUUID(), person, admin, area, empresa, inventario, lender, observation, product, loan);
	}
	
	public final void setId(UUID id) {
		this.id = id;
	}
	public final void setPerson(MonitorDTO person) {
		this.person = person;
	}
	public final void setAdmin(AdministratorDTO admin) {
		this.admin = admin;
	}
	public final void setArea(AreaDTO area) {
		this.area = area;
	}
	public final void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}
	public final void setInventario(InventarioDTO inventario) {
		this.inventario = inventario;
	}
	public final void setLender(LenderDTO lender) {
		this.lender = lender;
	}
	public final void setObservation(ObservacionDTO observation) {
		this.observation = observation;
	}
	public final void setProduct(ProductoDTO product) {
		this.product = product;
	}
	public final void setLoan(PrestamoDTO loan) {
		this.loan = loan;
	}
	
	public UUID getId() {
		return id;
	}
	public MonitorDTO getPerson() {
		return person;
	}
	public AdministratorDTO getAdmin() {
		return admin;
	}
	public AreaDTO getArea() {
		return area;
	}
	public EmpresaDTO getEmpresa() {
		return empresa;
	}
	public InventarioDTO getInventario() {
		return inventario;
	}
	public LenderDTO getLender() {
		return lender;
	}
	public ObservacionDTO getObservation() {
		return observation;
	}
	public ProductoDTO getProduct() {
		return product;
	}
	public PrestamoDTO getLoan() {
		return loan;
	}
	
	public final String getIDAsString() {
		return getUUIDAsString(getId());
	}
	

}
