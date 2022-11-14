package edu.uco.stl.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.stl.domain.ObservationDTO;

public interface ObservationDAO {
	
	void create(ObservationDTO observation);

	List<ObservationDTO> find(ObservationDTO observation);

	void update(ObservationDTO observation);
	
	void delete(UUID id);

}
