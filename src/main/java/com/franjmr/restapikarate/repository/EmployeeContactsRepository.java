package com.franjmr.restapikarate.repository;

import javax.persistence.StoredProcedureQuery;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;

public class EmployeeContactsRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public EmployeeContactsRepository() {}
	
	@ResponseBody
	public String updateContact() {
		StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("POL_ActualizaDatosContacto");
		storedProcedure.execute();
		String errorCode = (String) storedProcedure.getOutputParameterValue("PSCodigoError");
		String errorDesc = (String) storedProcedure.getOutputParameterValue("PSDescripcionError");
		return "{\"errorCode\":\"test_contact\"}";
	}
}