package com.franjmr.restapikarate.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.franjmr.restapikarate.utils.ApplicationConstants;


@Entity
@NamedStoredProcedureQuery(
	name = ApplicationConstants.PROCEDURE_NAMES.UPDATE_CONTACTS,
    procedureName = ApplicationConstants.PROCEDURE_PACKAGE+"."+ApplicationConstants.PROCEDURE_NAMES.UPDATE_CONTACTS,
    parameters = {
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_EMPLEADO, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_TELEFONO_FIJO, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_TELEFONO_MOVIL, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_EMAIL, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_TIPO_DOMICILIO, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.IN, name = ApplicationConstants.PROCEDURE_PARAMS.P_CODIGO_DOMICILIO, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.INOUT, name = ApplicationConstants.PROCEDURE_PARAMS.PS_CODIGO_ERROR, type = String.class),
      @StoredProcedureParameter(mode = ParameterMode.INOUT, name = ApplicationConstants.PROCEDURE_PARAMS.PS_DESCRIPCION_ERROR, type = String.class)
    }
)

public class ProcedureUpdateContacts {
	@JsonProperty("PCodigoEmpleado")  private @Id String PCodigoEmpleado;
	@JsonProperty("PTelefonoFijo") private String PTelefonoFijo;
	@JsonProperty("PTelefonoMovil") private String PTelefonoMovil;
	@JsonProperty("PEMail") private String PEMail;
	@JsonProperty("PTipoDomicilio") private String PTipoDomicilio;
	@JsonProperty("PCodigoDomicilio") private String PCodigoDomicilio;
	@JsonProperty("PSCodigoError") private String PSCodigoError;
	@JsonProperty("PSDescripcionError") private String PSDescripcionError;
	
	ProcedureUpdateContacts() {}
	
	public String getPCodigoEmpleado() {
		return PCodigoEmpleado;
	}

	public void setPCodigoEmpleado(String pCodigoEmpleado) {
		PCodigoEmpleado = pCodigoEmpleado;
	}

	public String getPTelefonoFijo() {
		return PTelefonoFijo;
	}

	public void setPTelefonoFijo(String pTelefonoFijo) {
		PTelefonoFijo = pTelefonoFijo;
	}

	public String getPTelefonoMovil() {
		return PTelefonoMovil;
	}

	public void setPTelefonoMovil(String pTelefonoMovil) {
		PTelefonoMovil = pTelefonoMovil;
	}

	public String getPEMail() {
		return PEMail;
	}

	public void setPEMail(String pEMail) {
		PEMail = pEMail;
	}

	public String getPTipoDomicilio() {
		return PTipoDomicilio;
	}

	public void setPTipoDomicilio(String pTipoDomicilio) {
		PTipoDomicilio = pTipoDomicilio;
	}

	public String getPCodigoDomicilio() {
		return PCodigoDomicilio;
	}

	public void setPCodigoDomicilio(String pCodigoDomicilio) {
		PCodigoDomicilio = pCodigoDomicilio;
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