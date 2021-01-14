package com.zara.procedures.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@NamedStoredProcedureQuery(
    	name = "POL_AsignacionCalendario",
        procedureName = "ENLACES_PKG_ZARA_META4.POL_AsignacionCalendario",
        parameters = {
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCodigoEmpleado", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PFechaInicio", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PFechaFin", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCalendario1", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCalendario2", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCalendario3", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PSecuencia", type = Number.class),	
          @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSCodigoError", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSDescripcionError", type = String.class)
        }
)

public class ProcedureAssignCalendar {
	@JsonProperty("PCodigoEmpleado") private @Id String PCodigoEmpleado;
	@JsonProperty("PFechaInicio") private String PFechaInicio;
	@JsonProperty("PFechaFin") private String PFechaFin;
	@JsonProperty("PCalendario1") private String PCalendario1;
	@JsonProperty("PCalendario2") private String PCalendario2;
	@JsonProperty("PCalendario3") private String PCalendario3;
	@JsonProperty("PSecuencia") private Number PSecuencia;
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

	public void setPSecuencia(Number pSecuencia) {
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