package com.franjmr.restapikarate.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.franjmr.restapikarate.utils.ApplicationConstants;

@Entity
@NamedStoredProcedureQuery(
	name = ApplicationConstants.PROCEDURE_NAMES.UPDATE_WORKSHIFT,
	procedureName = ApplicationConstants.PROCEDURE_PACKAGE+"."+ApplicationConstants.PROCEDURE_NAMES.UPDATE_WORKSHIFT,
	parameters = {
	  @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO, type = String.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_INICIO, type = String.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_FECHA_FIN, type = String.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_TURNO, type = String.class),
	  @StoredProcedureParameter(mode = ParameterMode.INOUT, name = ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR, type = String.class),
	  @StoredProcedureParameter(mode = ParameterMode.INOUT, name = ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR, type = String.class)
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