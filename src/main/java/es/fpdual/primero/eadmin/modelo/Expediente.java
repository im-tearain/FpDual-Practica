package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Expediente extends AdministracionElectronicaBase {

	private final TipoExpediente tipoExpediente;
	private final List<Documento> documentos;

	public Expediente(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, TipoExpediente tipoExpediente,
			List<Documento> documentos) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}

	public TipoExpediente getTipoExpediente() {
		return tipoExpediente;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public List<Integer> obtenerLongitudNombresDocumentos() {
		if (documentos.size() == 0) {
			throw new AdministacionElectronicaException();
		}
		return documentos.stream().filter(this::esDocumentoContable).map(Documento::getNombre).map(String::length)
				.collect(Collectors.toList());
	}

	private boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			final Expediente expediente = (Expediente) obj;
			return expediente.getId() == this.id;
		}
		return false;
	}

}
