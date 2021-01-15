package com.franjmr.restapikarate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.franjmr.restapikarate.models.ProcedureAssignCalendar;
import com.franjmr.restapikarate.models.ProcedureUpdateContacts;
import com.franjmr.restapikarate.models.ProcedureUpdateWorkShift;
import com.franjmr.restapikarate.utils.ApplicationConstants;

@Repository
public class EmployeeRepository {

	@PersistenceContext
	EntityManager em;
	
	public void assignEmployeeCalendar(ProcedureAssignCalendar procedureAssignCalendar) throws Exception {
		try {
			StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery(ApplicationConstants.PROCEDURE_NAMES.ASSIGN_CALENDAR);
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO, procedureAssignCalendar.getPCodigoEmpleado());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_INICIO, procedureAssignCalendar.getPFechaInicio());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_FIN, procedureAssignCalendar.getPFechaFin());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CALENDARIO_1, procedureAssignCalendar.getPCalendario1());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CALENDARIO_2, procedureAssignCalendar.getPCalendario2());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CALENDARIO_3, procedureAssignCalendar.getPCalendario3());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_SECUENCIA, procedureAssignCalendar.getPSecuencia());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR, procedureAssignCalendar.getPSCodigoError());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR, procedureAssignCalendar.getPSDescripcionError());
			storedProcedure.execute();

			String pSCodigoError = storedProcedure.getOutputParameterValue(ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR).toString();
			String pSDescripcionError = storedProcedure.getOutputParameterValue(ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR).toString();

			procedureAssignCalendar.setPSCodigoError(pSCodigoError);
			procedureAssignCalendar.setPSDescripcionError(pSDescripcionError);

		}catch (Exception e){
			throw new Exception("Ha ocurrido un error ejecutando la petición con http status " + HttpStatus.BAD_REQUEST);
		}finally {
			em.close();
		}
	}
	
	public void updateEmployeeContact(ProcedureUpdateContacts procedureUpdateContacts) throws Exception {
		try {
			StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery(ApplicationConstants.PROCEDURE_NAMES.UPDATE_CONTACTS);

			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO, procedureUpdateContacts.getPCodigoEmpleado());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_TELEFONO_FIJO, procedureUpdateContacts.getPTelefonoFijo());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_TELEFONO_MOVIL, procedureUpdateContacts.getPTelefonoMovil());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_EMAIL, procedureUpdateContacts.getPEMail());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_TIPO_DOMICILIO, procedureUpdateContacts.getPTipoDomicilio());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_DOMICILIO, procedureUpdateContacts.getPCodigoDomicilio());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR, procedureUpdateContacts.getPSCodigoError());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR, procedureUpdateContacts.getPSDescripcionError());
			storedProcedure.execute();

			String pSCodigoError = storedProcedure.getOutputParameterValue("PSCodigoError").toString();
			String pSDescripcionError = storedProcedure.getOutputParameterValue("PSDescripcionError").toString();

			procedureUpdateContacts.setPSCodigoError(pSCodigoError);
			procedureUpdateContacts.setPSDescripcionError(pSDescripcionError);
			
		}catch (Exception e){
			throw new Exception("Ha ocurrido un error ejecutando la petición con http status " + HttpStatus.BAD_REQUEST);
		}finally {
			em.close();
		}
	}
	
	public void updateEmployeeWorkShift(ProcedureUpdateWorkShift procedureUpdateWorkShift) throws Exception {
		try {
			StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery(ApplicationConstants.PROCEDURE_NAMES.UPDATE_WORKSHIFT);
			
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO, procedureUpdateWorkShift.getPCodigoEmpleado());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_INICIO, procedureUpdateWorkShift.getPFechaInicio());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_FIN, procedureUpdateWorkShift.getPFechaFin());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.P_TURNO, procedureUpdateWorkShift.getPTurno());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR, procedureUpdateWorkShift.getPSCodigoError());
			storedProcedure.setParameter(ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR, procedureUpdateWorkShift.getPSDescripcionError());
			storedProcedure.execute();
			
			String pSCodigoError = storedProcedure.getOutputParameterValue(ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR).toString();
			String pSDescripcionError = storedProcedure.getOutputParameterValue(ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR).toString();
	
			procedureUpdateWorkShift.setPSCodigoError(pSCodigoError);
			procedureUpdateWorkShift.setPSDescripcionError(pSDescripcionError);
		}catch (Exception e){
			throw new Exception("Ha ocurrido un error ejecutando la petición con http status " + HttpStatus.BAD_REQUEST);
		}finally {
			em.close();
		}
	}
}
