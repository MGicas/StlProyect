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
import edu.uco.stl.controller.validator.company.CreateCompanyValidator;
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Message;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.domain.CompanyDTO;
import edu.uco.stl.service.usecase.command.company.CreateCompanyCommand;
import edu.uco.stl.service.usecase.command.implementation.company.CreateCompanyCommandImp;

@RestController
@RequestMapping("/api/stl")
public class CompanyController {

	private CreateCompanyCommand createCompanyCommand = new CreateCompanyCommandImp();

	@GetMapping("/company")
	public CompanyDTO hola() {
		return new CompanyDTO();
	}

	@PostMapping
	public ResponseEntity<Response<CompanyDTO>> create(@RequestBody CompanyDTO company) {

		final Response<CompanyDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			Validator<CompanyDTO> validator = new CreateCompanyValidator();
			List<Message> messages = validator.validate(company);

			if (messages.isEmpty()) {

				createCompanyCommand.execute(company);
				List<CompanyDTO> data = new ArrayList<>();
				data.add(company);
				response.setData(data);

				response.addSuccessMessage(Messages.CompanyController.USER_COMPANY_CREATE_SUCCESSFULLY);
			}else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response.setMessages(messages);
			}
		} catch (StlCustomException exception) {
			httpStatus = HttpStatus.BAD_REQUEST;
			if (exception.isTechinalException()) {
				response.addSuccessMessage(Messages.CompanyController.USER_COMPANY_CREATE_ERROR);
			} else {
				response.addErrorMessage(exception.getMessage());
			}
			exception.printStackTrace();
		} catch (Exception exception) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage(Messages.CompanyController.USER_COMPANY_CREATE_UNEXPECTED_ERROR);
			exception.printStackTrace();
		}
		return new ResponseEntity<>(response, httpStatus);
	}

}
