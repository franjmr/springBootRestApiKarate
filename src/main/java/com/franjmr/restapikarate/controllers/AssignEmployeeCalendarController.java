package com.franjmr.restapikarate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.franjmr.restapikarate.models.ProcedureAssignCalendar;
import com.franjmr.restapikarate.utils.*;
import javax.persistence.*;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping(ApplicationConstants.API_VERSION + "/employeeCalendar")
@RestController
@CrossOrigin

public class AssignEmployeeCalendarController {
	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("finally")
	@PostMapping(
		value = "/assign",
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String assignEmployeeCalendar(@Valid @RequestBody ProcedureAssignCalendar procedureAssignCalendar) {
		try {
			StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("POL_AsignacionCalendario");
			if (procedureAssignCalendar.getPCodigoEmpleado() == null) {
				procedureAssignCalendar.setPCodigoEmpleado("");
			}
			if (procedureAssignCalendar.getPFechaInicio() == null) {
				procedureAssignCalendar.setPFechaInicio("");
			}
			if (procedureAssignCalendar.getPFechaFin() == null) {
				procedureAssignCalendar.setPFechaFin("");
			}
			if (procedureAssignCalendar.getPCalendario1() == null) {
				procedureAssignCalendar.setPCalendario1("");
			}
			if (procedureAssignCalendar.getPCalendario2() == null) {
				procedureAssignCalendar.setPCalendario2("");
			}
			if (procedureAssignCalendar.getPCalendario3() == null) {
				procedureAssignCalendar.setPCalendario3("");
			}
			if (procedureAssignCalendar.getPSecuencia() == null) {
				procedureAssignCalendar.setPSecuencia(0);
			}
			procedureAssignCalendar.setPSCodigoError("");
			procedureAssignCalendar.setPSDescripcionError("");

			storedProcedure.setParameter("PCodigoEmpleado", procedureAssignCalendar.getPCodigoEmpleado());
			storedProcedure.setParameter("PFechaInicio", procedureAssignCalendar.getPFechaInicio());
			storedProcedure.setParameter("PFechaFin", procedureAssignCalendar.getPFechaFin());
			storedProcedure.setParameter("PCalendario1", procedureAssignCalendar.getPCalendario1());
			storedProcedure.setParameter("PCalendario2", procedureAssignCalendar.getPCalendario2());
			storedProcedure.setParameter("PCalendario3", procedureAssignCalendar.getPCalendario3());
			storedProcedure.setParameter("PSecuencia", procedureAssignCalendar.getPSecuencia());
			storedProcedure.setParameter("PSCodigoError", procedureAssignCalendar.getPSCodigoError());
			storedProcedure.setParameter("PSDescripcionError", procedureAssignCalendar.getPSDescripcionError());
			storedProcedure.execute();

			String PSCodigoError = "";
			String PSDescripcionError = "";
			PSCodigoError = (String) storedProcedure.getOutputParameterValue("PSCodigoError");
			PSDescripcionError = (String) storedProcedure.getOutputParameterValue("PSDescripcionError");
			String json = "Error parsing request result.";
			try {
			    ObjectMapper mapper = new ObjectMapper();
			    ObjectNode result = mapper.createObjectNode();
			    result.put("PSCodigoError", PSCodigoError);
			    result.put("PSDescripcionError",PSDescripcionError);
			    json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			} finally {
			   return json;
			}
		}
		catch (Exception e){
			return "Ha ocurrido un error ejecutando la petición con http status " + HttpStatus.BAD_REQUEST;
		}	
		finally {
			em.close();
		}
	}
	
	
}