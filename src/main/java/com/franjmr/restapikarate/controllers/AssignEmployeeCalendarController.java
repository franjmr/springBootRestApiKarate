package com.franjmr.restapikarate.controllers;

import com.franjmr.restapikarate.models.ProcedureAssignCalendar;
import com.franjmr.restapikarate.services.EmployeeService;
import com.franjmr.restapikarate.utils.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@CrossOrigin
@RestController
@RequestMapping(ApplicationConstants.API_VERSION + "/employeeCalendar")
public class AssignEmployeeCalendarController {
	
	@Autowired
    private EmployeeService employeeService;

	@PostMapping(
		value = "/assign",
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<String> assignEmployeeCalendar(@Valid @RequestBody ProcedureAssignCalendar procedureAssignCalendar) {
		try {
			String jsonResponse = employeeService.assignEmployeeCalendar(procedureAssignCalendar);
			return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.OK).body("Ha ocurrido un error ejecutando la petición con http status " + HttpStatus.BAD_REQUEST);
		}
	}
}