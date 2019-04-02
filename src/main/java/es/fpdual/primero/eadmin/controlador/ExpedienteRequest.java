package es.fpdual.primero.eadmin.controlador;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public class ExpedienteRequest {
	
	private String nombre;
	private String usuario;
	private String tipoExpediente;
	private List<Documento> documentos;
	
	public ExpedienteRequest(String nombre, String usuario, String tipoExpediente,
			List<Documento> documentos) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}
	
	public ExpedienteRequest() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipoExpediente() {
		return tipoExpediente;
	}

	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
}
