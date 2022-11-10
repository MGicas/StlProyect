package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.ObservationDTO;

public interface ObservationDAO {
	
	void create(ObservationDTO inventory);

	List<ObservationDTO> find(ObservationDTO inventory);

	void update(ObservationDTO inventory);
	
	void delete(ObservationDTO inventory);

}
