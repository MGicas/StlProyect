package edu.uco.stl.controller.validator.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.stl.controller.validator.Validator;
import edu.uco.stl.crosscutting.helper.UUIDHelper;
import edu.uco.stl.crosscutting.messages.Message;
import edu.uco.stl.domain.AdminDTO;

public class CreateAdminValidator implements Validator<AdminDTO> {

	@Override
	public List<Message> validate(AdminDTO dto) {
		List<Message> messages = new ArrayList<>();
		validateAdminId(dto.getId(), messages);
		return messages;
	}
	
	public void validateAdminId(UUID adminId, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(adminId)) {
			adminId = UUIDHelper.getNewUUID();
		}
	}
	

}
