package edu.uco.stl.service.usecase.admin;

import edu.uco.stl.domain.AdminDTO;

public interface FindAdminByIdentifyUsecase {
	AdminDTO execute(String identify);

}
