package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.AreaDTO;

public interface AreaDAO {
	
	void create (AreaDTO area);
	List<AreaDTO> find(AreaDTO area);

}
