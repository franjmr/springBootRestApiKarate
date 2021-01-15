package com.franjmr.restapikarate.controllers;

import com.franjmr.restapikarate.models.ProcedureUpdateWorkShift;
import com.franjmr.restapikarate.services.EmployeeService;
import com.franjmr.restapikarate.utils.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ApplicationConstants.API_VERSION + "/employeeWorkshift")
public class UpdateEmployeeWorkShiftController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@PostMapping(
		value = "/update",
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<String> updateEmployeeWorkShift(@Valid @RequestBody ProcedureUpdateWorkShift procedureUpdateWorkShift) {
		try {
			String jsonResponse = employeeService.updateEmployeeWorkShift(procedureUpdateWorkShift);
			return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.OK).body("Ha ocurrido un error ejecutando la petición con http status " + HttpStatus.BAD_REQUEST);
		}
	}
}