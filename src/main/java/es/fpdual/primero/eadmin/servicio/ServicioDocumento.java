package es.fpdual.primero.eadmin.servicio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

/**
 * Servicio para almacenar documentos.
 * @param documento Documento completo a falta de
 * id y fechas que serán calculadas automáticamente
 * @return Documento resultado con el id y las fechas completas
 *
 */
public interface ServicioDocumento {
	Documento altaDocumento(Documento documento);
	Documento modificarDocumento(Documento documento);
	void eliminarDocumento(int codigoDocumento);
	List<Documento> obtenerTodosDocumentos();
	Documento getDocumentoById(int id);
}
