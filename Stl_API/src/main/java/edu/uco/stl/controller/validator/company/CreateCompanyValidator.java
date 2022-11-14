package edu.uco.stl.controller.validator.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.stl.controller.validator.Validator;
import edu.uco.stl.crosscutting.helper.UUIDHelper;
import edu.uco.stl.crosscutting.messages.Message;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.domain.CompanyDTO;

public class CreateCompanyValidator implements Validator<CompanyDTO>{

	@Override
	public List<Message> validate(CompanyDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validateAdminId(dto.getAdminId().getId(), messages);
		return messages;
	}
	
	private void validateAdminId(UUID adminId, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(adminId)) {
			messages.add(Message.createErrorMessage(Messages.CompanyValidator.USER_COMPANY_VALIDATOR_IDADMIN));
		}
	}

}
