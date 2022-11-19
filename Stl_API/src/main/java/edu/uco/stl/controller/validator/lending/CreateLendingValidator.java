package edu.uco.stl.controller.validator.lending;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.stl.controller.validator.Validator;
import edu.uco.stl.crosscutting.helper.UUIDHelper;
import edu.uco.stl.crosscutting.messages.Message;
import edu.uco.stl.domain.LendingDTO;

public class CreateLendingValidator implements Validator<LendingDTO>{

	
	public void validateLendingId(UUID lendingId, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(lendingId)) {
			lendingId = UUIDHelper.getNewUUID();
		}
	}

	@Override
	public List<Message> validate(LendingDTO dto) {
		List<Message> messages = new ArrayList<>();
		validateLendingId(dto.getId(),messages);
		return messages;
	}
}
