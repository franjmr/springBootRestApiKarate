package com.franjmr.restapikarate.utils;

public class ApplicationConstants {
	public static final String API_VERSION = "/api/v1";
	public static final String PROCEDURE_PACKAGE = "PKG_FJMR";
	
	public class PROCEDURE_NAMES {
		public static final String ASSIGN_CALENDAR 		= "PR_UpdateCalendar";
		public static final String UPDATE_CONTACTS		= "PR_UpdateContactInformation";
		public static final String UPDATE_WORKSHIFT 	= "PR_UpdateWorkshift";
	}

	public class PROCEDURE_PARAMS {
		public static final String P_CODIGO_EMPLEADO 	= "PCodigoEmpleado";
		public static final String P_FECHA_INICIO 		= "PFechaInicio";
		public static final String P_FECHA_FIN 			= "PFechaFin";
		public static final String P_CALENDARIO_1 		= "PCalendario1";
		public static final String P_CALENDARIO_2 		= "PCalendario2";
		public static final String P_CALENDARIO_3 		= "PCalendario3";
		public static final String P_SECUENCIA 			= "PSecuencia";
		public static final String P_TELEFONO_FIJO		= "PTelefonoFijo";
		public static final String P_TELEFONO_MOVIL		= "PTelefonoMovil";
		public static final String P_EMAIL	 			= "PEMail";
		public static final String P_TIPO_DOMICILIO		= "PTipoDomicilio";
		public static final String P_CODIGO_DOMICILIO	= "PCodigoDomicilio";
		public static final String P_TURNO				= "PTurno";
		public static final String PS_CODIGO_ERROR 		= "PSCodigoError";
		public static final String PS_DESCRIPCION_ERROR	= "PSDescripcionError";
	}
}