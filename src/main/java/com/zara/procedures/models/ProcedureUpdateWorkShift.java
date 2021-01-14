package com.zara.procedures.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@NamedStoredProcedureQuery(
    	name = "POL_ActualizacionTurno",
        procedureName = "ENLACES_PKG_ZARA_META4.POL_ActualizacionTurno",
        parameters = {
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCodigoEmpleado", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PFechaInicio", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PFechaFin", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PTurno", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSCodigoError", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSDescripcionError", type = String.class)
        }
)

public class ProcedureUpdateWorkShift {
	@JsonProperty("PCodigoEmpleado")  private @Id String PCodigoEmpleado;
	@JsonProperty("PFechaInicio") private String PFechaInicio;
	@JsonProperty("PFechaFin") private String PFechaFin;
	@JsonProperty("PTurno") private String PTurno;;
	@JsonProperty("PSCodigoError") private String PSCodigoError;
	@JsonProperty("PSDescripcionError") private String PSDescripcionError;
	
	ProcedureUpdateWorkShift() {}
	
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
	
	public String getPTurno() {
		return PTurno;
	}

	public void setPTurno(String pTurno) {
		PTurno = pTurno;
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