package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.AdminDTO;

public interface AdminDAO {
	
	void create (AdminDTO admin);
	List<AdminDTO> find(AdminDTO admin);
	void update (AdminDTO admin);

}
