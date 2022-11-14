package edu.uco.stl.controller.validator;

import java.util.List;

import edu.uco.stl.crosscutting.messages.Message;

public interface Validator<T> {

	List<Message> validate(T dto);
	
	
}
