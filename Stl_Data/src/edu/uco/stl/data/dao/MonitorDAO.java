package edu.uco.stl.data.dao;

import java.util.List;

import edu.uco.stl.domain.MonitorDTO;

public interface MonitorDAO {
	
	void create(MonitorDTO monitor);

	List<MonitorDTO> find(MonitorDTO monitor);

	void update(MonitorDTO monitor);
	
	void delete(MonitorDTO monitor);

}
