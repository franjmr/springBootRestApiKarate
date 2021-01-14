package com.zara.procedures.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zara.procedures.models.ProcedureUpdateContacts;
import com.zara.procedures.utils.*;

import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;
import javax.persistence.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//import com.zara.procedures.services.EmployeeContactsServiceImplementation;


@RequestMapping(ApplicationConstants.API_VERSION + "/contact")
@RestController
@CrossOrigin

public class UpdateEmployeeContactsController {
	
	/*private EmployeeContactsServiceImplementation contactsService = new EmployeeContactsServiceImplementation();
	
	@GetMapping(
		value = "/update",
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
	public String updateContacts() {
		return contactsService.updateContacts();
	}*/
	
	/*@RequestMapping(value = "update", method = RequestMethod.GET) 
	public String updateContacts() {
		return contactsService.updateContacts();
	}*/
	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("finally")
	@PostMapping(
		value = "/update",
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String updateContact(@Valid @RequestBody ProcedureUpdateContacts procedureUpdateContacts) {
		try {
			StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("POL_ActualizaDatosContacto");

			if (procedureUpdateContacts.getPCodigoEmpleado() == null) {
				procedureUpdateContacts.setPCodigoEmpleado("");
			}
			if (procedureUpdateContacts.getPTelefonoFijo() == null) {
				procedureUpdateContacts.setPTelefonoFijo("");
			}
			if (procedureUpdateContacts.getPTelefonoMovil() == null) {
				procedureUpdateContacts.setPTelefonoMovil("");
			}
			if (procedureUpdateContacts.getPEMail() == null) {
				procedureUpdateContacts.setPEMail("");
			}
			if (procedureUpdateContacts.getPTipoDomicilio() == null) {
				procedureUpdateContacts.setPTipoDomicilio("");
			}
			if (procedureUpdateContacts.getPCodigoDomicilio() == null) {
				procedureUpdateContacts.setPCodigoDomicilio("");
			}
			procedureUpdateContacts.setPSCodigoError("");
			procedureUpdateContacts.setPSDescripcionError("");

			storedProcedure.setParameter("PCodigoEmpleado", procedureUpdateContacts.getPCodigoEmpleado());
			storedProcedure.setParameter("PTelefonoFijo", procedureUpdateContacts.getPTelefonoFijo());
			storedProcedure.setParameter("PTelefonoMovil", procedureUpdateContacts.getPTelefonoMovil());
			storedProcedure.setParameter("PEMail", procedureUpdateContacts.getPEMail());
			storedProcedure.setParameter("PTipoDomicilio", procedureUpdateContacts.getPTipoDomicilio());
			storedProcedure.setParameter("PCodigoDomicilio", procedureUpdateContacts.getPCodigoDomicilio());
			storedProcedure.setParameter("PSCodigoError", procedureUpdateContacts.getPSCodigoError());
			storedProcedure.setParameter("PSDescripcionError", procedureUpdateContacts.getPSDescripcionError());
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