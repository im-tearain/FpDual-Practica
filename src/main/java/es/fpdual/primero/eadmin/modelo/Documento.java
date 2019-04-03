package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Documento extends AdministracionElectronicaBase {

	private final TipoDocumento tipoDocumento;
	private static final Logger logger = LogManager.getLogger(DocumentoContable.class);

	public Documento(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoDocumento tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
		logger.trace("Documento creado");
	}
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			final Documento documento = (Documento) obj;
			return documento.getId() == this.id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		return "\n----------------------------------------------------------"+
				"\nID: "+this.getId() +
				"\nNOMBRE: "+this.getNombre() +
				"\nUSUARIO: "+this.getUsuario() +
				"\nFECHA DE CREACION: "+this.getFechaCreacion() +
				"\nTIPO DE DOCUMENTO: "+this.getTipoDocumento() +
				"\n----------------------------------------------------------\n";
	}
	
	
}
