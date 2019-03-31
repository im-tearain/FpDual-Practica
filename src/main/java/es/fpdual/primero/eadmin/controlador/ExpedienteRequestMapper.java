package es.fpdual.primero.eadmin.controlador;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.modelo.TipoExpediente;
import es.fpdual.primero.eadmin.modelo.Usuario;

public class ExpedienteRequestMapper {

	private ExpedienteRequestMapper() {}
	
	public static Expediente toExpediente(ExpedienteRequest expedienteRequest) {
		return new Expediente(expedienteRequest.getId(), expedienteRequest.getNombre(), construyeUsuario(expedienteRequest), 
				expedienteRequest.getFechaCreacion(), construyeTipoExpediente(expedienteRequest.getTipoExpediente()), expedienteRequest.getDocumentos());
	}

	private static TipoExpediente construyeTipoExpediente(String tipoExpediente) {
		TipoExpediente resultado;
		
		switch(tipoExpediente.toUpperCase()) {
			case "Expediente_CONTABLE":
				resultado = TipoExpediente.EXPEDIENTE_LABORAL;
				break;
			case "Expediente_FACTURA":
				resultado = TipoExpediente.EXPEDIENTE_LICENCIA_OBRAS;
				break;
			case "Expediente_NOMINA":
				resultado = TipoExpediente.EXPEDIENTE_NOMINA;
				break;
			case "Expediente_PADRON":
				resultado = TipoExpediente.EXPEDIENTE_SANCIONADOR;
				break;
			case "Expediente_SUBVENCION":
				resultado = TipoExpediente.EXPEDIENTE_SUBVENCIONES;
				break;
			default:
				resultado = TipoExpediente.EXPEDIENTE_LABORAL; 
		}
		
		return resultado;
	}

	private static Usuario construyeUsuario(ExpedienteRequest expedienteRequest) {
		return new Usuario(expedienteRequest.getId(), "usuario"+expedienteRequest.getId(), "cargo"+expedienteRequest.getId());
	}
}
