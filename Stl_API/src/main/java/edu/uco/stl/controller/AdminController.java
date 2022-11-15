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
import edu.uco.stl.crosscutting.execption.StlCustomException;
import edu.uco.stl.crosscutting.messages.Messages;
import edu.uco.stl.domain.AdminDTO;
import edu.uco.stl.service.usecase.command.admin.CreateAdminCommand;
import edu.uco.stl.service.usecase.command.implementation.admin.CreateAdminCommandImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private CreateAdminCommand createAdminCommand = new CreateAdminCommandImpl();
	
	@GetMapping
	public AdminDTO admin() {
		return new AdminDTO();
	}

	@PostMapping("/create")
	public ResponseEntity<Response<AdminDTO>> create(@RequestBody AdminDTO admin) {

		Response<AdminDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			
			createAdminCommand.execute(admin);
			List<AdminDTO> data = new ArrayList<>();
			data.add(admin);
			response.setData(data);

			response.addSuccessMessage(Messages.AdminController.USER_ADMIN_CREATE_SUCCESSFULLY);
		} catch (StlCustomException exception) {
			httpStatus = HttpStatus.BAD_REQUEST;
			if (exception.isTechinalException()) {
				response.addSuccessMessage(Messages.AdminController.USER_ADMIN_CREATE_ERROR);
			} else {
				response.addErrorMessage(exception.getMessage());
			}
			exception.printStackTrace();
		} catch (Exception exception) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage(Messages.AdminController.USER_ADMIN_CREATE_UNEXPECTED_ERROR);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, httpStatus);
	}

}
