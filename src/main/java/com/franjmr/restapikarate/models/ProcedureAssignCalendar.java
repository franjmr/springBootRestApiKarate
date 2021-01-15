package com.franjmr.restapikarate.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.franjmr.restapikarate.utils.ApplicationConstants;

@Entity
@NamedStoredProcedureQuery(
	name = ApplicationConstants.PROCEDURE_NAMES.ASSIGN_CALENDAR,
    procedureName = ApplicationConstants.PROCEDURE_PACKAGE+"."+ApplicationConstants.PROCEDURE_NAMES.ASSIGN_CALENDAR,
    parameters = {
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_INICIO, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_FIN, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CALENDARIO_1, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CALENDARIO_2, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CALENDARIO_3, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_SECUENCIA, type = Integer.class),	
      @StoredProcedureParameter(mode = ParameterMode.INOUT, name = ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.INOUT, name = ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR, type = String.class)
    }
)

public class ProcedureAssignCalendar {
	@JsonProperty(ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO) private @Id String PCodigoEmpleado;
	@JsonProperty("PFechaInicio") private String PFechaInicio;
	@JsonProperty("PFechaFin") private String PFechaFin;
	@JsonProperty("PCalendario1") private String PCalendario1;
	@JsonProperty("PCalendario2") private String PCalendario2;
	@JsonProperty("PCalendario3") private String PCalendario3;
	@JsonProperty("PSecuencia") private Integer PSecuencia;
	@JsonProperty("PSCodigoError") private String PSCodigoError;
	@JsonProperty("PSDescripcionError") private String PSDescripcionError;
	
	ProcedureAssignCalendar(){}
	
	public String getPCodigoEmpleado() {
		return PCodigoEmpleado;
	}

	public void setPCodigoEmpleado(String pCodigoEmpleado) {
		PCodigoEmpleado = pCodigoEmpleado;
	}
	
	public String getPFechaInicio() {
		return PFechaInicio;
	}

	public void setPFechaInicio(String pFechaInicio) {
		PFechaInicio = pFechaInicio;
	}
	
	public String getPFechaFin() {
		return PFechaFin;
	}

	public void setPFechaFin(String pFechaFin) {
		PFechaFin = pFechaFin;
	}
	
	public String getPCalendario1() {
		return PCalendario1;
	}

	public void setPCalendario1(String pCalendario1) {
		PCalendario1 = pCalendario1;
	}
	
	public String getPCalendario2() {
		return PCalendario2;
	}

	public void setPCalendario2(String pCalendario2) {
		PFechaFin = pCalendario2;
	}
	
	public String getPCalendario3() {
		return PCalendario3;
	}

	public void setPCalendario3(String pCalendario3) {
		PCalendario3 = pCalendario3;
	}
	
	public Number getPSecuencia() {
		return PSecuencia;
	}

	public void setPSecuencia(Integer pSecuencia) {
		PSecuencia = pSecuencia;
	}
	
	public String getPSCodigoError() {
		return PSCodigoError;
	}

	public void setPSCodigoError(String pSCodigoError) {
		PSCodigoError = pSCodigoError;
	}

	public String getPSDescripcionError() {
		return PSDescripcionError;
	}

	public void setPSDescripcionError(String pSDescripcionError) {
		PSDescripcionError = pSDescripcionError;
	}
}