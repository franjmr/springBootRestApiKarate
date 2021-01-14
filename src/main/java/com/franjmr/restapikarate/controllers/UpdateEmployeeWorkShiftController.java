package com.franjmr.restapikarate.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.franjmr.restapikarate.models.ProcedureUpdateWorkShift;
import com.franjmr.restapikarate.utils.*;

import javax.persistence.*;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping(ApplicationConstants.API_VERSION + "/workshift")
@RestController
@CrossOrigin

public class UpdateEmployeeWorkShiftController {
	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("finally")
	@PostMapping(
		value = "/update",
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String updateEmployeeWorkShift(@Valid @RequestBody ProcedureUpdateWorkShift procedureUpdateWorkShift) {
		try {
			StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("POL_ActualizacionTurno");
			if (procedureUpdateWorkShift.getPCodigoEmpleado() == null) {
				procedureUpdateWorkShift.setPCodigoEmpleado("");
			}
			if (procedureUpdateWorkShift.getPFechaInicio() == null) {
				procedureUpdateWorkShift.setPFechaInicio("");
			}
			if (procedureUpdateWorkShift.getPFechaFin() == null) {
				procedureUpdateWorkShift.setPFechaFin("");
			}
			if (procedureUpdateWorkShift.getPTurno() == null) {
				procedureUpdateWorkShift.setPTurno("");
			}
			procedureUpdateWorkShift.setPSCodigoError("");
			procedureUpdateWorkShift.setPSDescripcionError("");
			storedProcedure.setParameter("PCodigoEmpleado", procedureUpdateWorkShift.getPCodigoEmpleado());
			storedProcedure.setParameter("PFechaInicio", procedureUpdateWorkShift.getPFechaInicio());
			storedProcedure.setParameter("PFechaFin", procedureUpdateWorkShift.getPFechaFin());
			storedProcedure.setParameter("PTurno", procedureUpdateWorkShift.getPTurno());
			storedProcedure.setParameter("PSCodigoError", procedureUpdateWorkShift.getPSCodigoError());
			storedProcedure.setParameter("PSDescripcionError", procedureUpdateWorkShift.getPSDescripcionError());
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