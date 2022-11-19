package edu.uco.stl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.stl.controller.response.Response;
import edu.uco.stl.controller.validator.Validator;
import edu.uco.stl.controller.validator.lending.CreateLendingValidator;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Message;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.domain.LendingDTO;
import edu.uco.stl.service.usecase.command.lending.CreateLendingCommand;
import edu.uco.stl.service.usecase.command.lending.implementation.CreateLendingCommandImpl;

@RestController
@RequestMapping("/api/stl/lending")
public class LendingController {

	private CreateLendingCommand createLendingCommand = new CreateLendingCommandImpl();

	@GetMapping
	public LendingDTO hola() {
		return new LendingDTO();
	}

	@PostMapping
	public ResponseEntity<Response<LendingDTO>> create(@RequestBody LendingDTO lending) {

		final Response<LendingDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			Validator<LendingDTO> validator = new CreateLendingValidator();
			List<Message> messages = validator.validate(lending);

			createLendingCommand.execute(lending);
			List<LendingDTO> data = new ArrayList<>();
			data.add(lending);
			response.setData(data);

			response.addSuccessMessage(Messages.LendingController.USER_LENDING_CREATE_SUCCESSFULLY);

		} catch (StlCustomException exception) {
			httpStatus = HttpStatus.BAD_REQUEST;
			if (exception.isTechinalException()) {
				response.addSuccessMessage(Messages.LendingController.USER_LENDING_CREATE_ERROR);
			} else {
				response.addErrorMessage(exception.getMessage());
			}
			exception.printStackTrace();
		} catch (Exception exception) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage(Messages.LendingController.USER_LENDING_CREATE_UNEXPECTED_ERROR);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, httpStatus);
	}

}
