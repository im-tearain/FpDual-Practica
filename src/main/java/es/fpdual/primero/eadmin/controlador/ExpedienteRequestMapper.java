package es.fpdual.primero.eadmin.controlador;

import java.time.LocalDate;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.modelo.TipoExpediente;
import es.fpdual.primero.eadmin.modelo.Usuario;

public class ExpedienteRequestMapper {

	private ExpedienteRequestMapper() {}
	
	public static Expediente toExpediente(ExpedienteRequest expedienteRequest) {
		return new Expediente(0, expedienteRequest.getNombre(), construyeUsuario(expedienteRequest), 
				null, construyeTipoExpediente(expedienteRequest.getTipoExpediente()), expedienteRequest.getDocumentos());
	}
	
	public static Expediente toExpedienteCompleto(ExpedienteRequest expedienteRequest, int id, LocalDate localDate) {
		return new Expediente(id, expedienteRequest.getNombre(), construyeUsuario(expedienteRequest), 
				localDate, construyeTipoExpediente(expedienteRequest.getTipoExpediente()), expedienteRequest.getDocumentos());
	}

	private static Usuario construyeUsuario(ExpedienteRequest expedienteRequest) {
		int id = Integer.parseInt(expedienteRequest.getUsuario());
		return new Usuario(id, "usuario"+id, "cargo"+id);
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
	
}
