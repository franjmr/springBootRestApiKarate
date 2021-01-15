package com.franjmr.restapikarate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.franjmr.restapikarate.models.ProcedureAssignCalendar;
import com.franjmr.restapikarate.models.ProcedureUpdateContacts;
import com.franjmr.restapikarate.models.ProcedureUpdateWorkShift;
import com.franjmr.restapikarate.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

	public String assignEmployeeCalendar(ProcedureAssignCalendar procedureAssignCalendar) throws Exception {
		if (!StringUtils.hasText(procedureAssignCalendar.getPCodigoEmpleado())) {
			procedureAssignCalendar.setPCodigoEmpleado("");
		}
		if (!StringUtils.hasText(procedureAssignCalendar.getPFechaInicio())) {
			procedureAssignCalendar.setPFechaInicio("");
		}
		if (!StringUtils.hasText(procedureAssignCalendar.getPFechaFin())) {
			procedureAssignCalendar.setPFechaFin("");
		}
		if (!StringUtils.hasText(procedureAssignCalendar.getPCalendario1())) {
			procedureAssignCalendar.setPCalendario1("");
		}
		if (!StringUtils.hasText(procedureAssignCalendar.getPCalendario2())) {
			procedureAssignCalendar.setPCalendario2("");
		}
		if (!StringUtils.hasText(procedureAssignCalendar.getPCalendario3())) {
			procedureAssignCalendar.setPCalendario3("");
		}
		if (procedureAssignCalendar.getPSecuencia() == null) {
			procedureAssignCalendar.setPSecuencia(0);
		}
		procedureAssignCalendar.setPSCodigoError("");
		procedureAssignCalendar.setPSDescripcionError("");
		
		employeeRepository.assignEmployeeCalendar(procedureAssignCalendar);
		
		String jsonExeDetail = createJsonWithExecutionDetail(procedureAssignCalendar.getPSCodigoError(),procedureAssignCalendar.getPSDescripcionError());
		return jsonExeDetail;
	}

	public String updateEmployeeContact(ProcedureUpdateContacts procedureUpdateContacts) throws Exception {
		if (!StringUtils.hasText(procedureUpdateContacts.getPCodigoEmpleado())){
			procedureUpdateContacts.setPCodigoEmpleado("");
		}
		if (!StringUtils.hasText(procedureUpdateContacts.getPTelefonoFijo())){
			procedureUpdateContacts.setPTelefonoFijo("");
		}
		if (!StringUtils.hasText(procedureUpdateContacts.getPTelefonoMovil())){
			procedureUpdateContacts.setPTelefonoMovil("");
		}
		if (!StringUtils.hasText(procedureUpdateContacts.getPEMail())){
			procedureUpdateContacts.setPEMail("");
		}
		if (!StringUtils.hasText(procedureUpdateContacts.getPTipoDomicilio())){
			procedureUpdateContacts.setPTipoDomicilio("");
		}
		if (!StringUtils.hasText(procedureUpdateContacts.getPCodigoDomicilio())){
			procedureUpdateContacts.setPCodigoDomicilio("");
		}
		procedureUpdateContacts.setPSCodigoError("");
		procedureUpdateContacts.setPSDescripcionError("");

		employeeRepository.updateEmployeeContact(procedureUpdateContacts);
		
		String jsonExeDetail = createJsonWithExecutionDetail(procedureUpdateContacts.getPSCodigoError(),procedureUpdateContacts.getPSDescripcionError());
		return jsonExeDetail;
	}
	
	public String updateEmployeeWorkShift(ProcedureUpdateWorkShift procedureUpdateWorkShift) throws Exception {
		if (!StringUtils.hasText(procedureUpdateWorkShift.getPCodigoEmpleado())) {
			procedureUpdateWorkShift.setPCodigoEmpleado("");
		}
		if (!StringUtils.hasText(procedureUpdateWorkShift.getPFechaInicio())) {
			procedureUpdateWorkShift.setPFechaInicio("");
		}
		if (!StringUtils.hasText(procedureUpdateWorkShift.getPFechaFin())) {
			procedureUpdateWorkShift.setPFechaFin("");
		}
		if (!StringUtils.hasText(procedureUpdateWorkShift.getPTurno())) {
			procedureUpdateWorkShift.setPTurno("");
		}
		procedureUpdateWorkShift.setPSCodigoError("");
		procedureUpdateWorkShift.setPSDescripcionError("");
		
		employeeRepository.updateEmployeeWorkShift(procedureUpdateWorkShift);
		
		String jsonExeDetail = createJsonWithExecutionDetail(procedureUpdateWorkShift.getPSCodigoError(),procedureUpdateWorkShift.getPSDescripcionError());
		return jsonExeDetail;
	}
	
	private String createJsonWithExecutionDetail(String pSCodigoError, String pSDescripcionError) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		result.put("PSCodigoError", pSCodigoError);
		result.put("PSDescripcionError", pSDescripcionError);
		
		String jsonStrMapper = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result).toString();
		
		return jsonStrMapper;
	}
}
