package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;

public class DocumentoNomina extends Documento {

	private final String tipoNomina;

	public DocumentoNomina(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, String tipoNomina) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_NOMINA);
		this.tipoNomina = tipoNomina ;
	}

	public String getTipoNomina() {
		return tipoNomina;
	}
}