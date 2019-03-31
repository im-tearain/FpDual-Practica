package es.fpdual.primero.eadmin.controlador;

import java.util.Date;
import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public class ExpedienteRequest {
	
	private final int id;
	private final String nombre;
	private final String usuario;
	private final Date fechaCreacion;
	private final String tipoExpediente;
	private final List<Documento> documentos;
	
	public ExpedienteRequest(int id, String nombre, String usuario, Date fechaCreacion, String tipoExpediente,
			List<Documento> documentos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}

	protected int getId() {
		return id;
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getUsuario() {
		return usuario;
	}

	protected Date getFechaCreacion() {
		return fechaCreacion;
	}

	protected String getTipoExpediente() {
		return tipoExpediente;
	}

	protected List<Documento> getDocumentos() {
		return documentos;
	}
	
}
