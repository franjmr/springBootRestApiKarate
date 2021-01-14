package com.zara.procedures.models;

import javax.persistence.*;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@NamedStoredProcedureQuery(
    	name = "POL_ActualizaDatosContacto",
        procedureName = "ENLACES_PKG_ZARA_META4.POL_ActualizaDatosContacto",
        parameters = {
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCodigoEmpleado", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PTelefonoFijo", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PTelefonoMovil", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PEMail", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PTipoDomicilio", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "PCodigoDomicilio", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSCodigoError", type = String.class),
          @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSDescripcionError", type = String.class)
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