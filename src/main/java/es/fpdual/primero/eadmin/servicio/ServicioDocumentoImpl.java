package es.fpdual.primero.eadmin.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento{
	
	private final RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		final int siguienteId = repositorioDocumento.siguienteId();
		final LocalDate fechaActual = LocalDate.now();
		
		Documento documentoModificado = new Documento(siguienteId, documento.getNombre(), documento.getUsuario(), fechaActual, documento.getTipoDocumento());
		
		repositorioDocumento.altaDocumento(documentoModificado);
		return documentoModificado;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		repositorioDocumento.modificarDocumento(documento);
		return documento;
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		repositorioDocumento.eliminarDocumento(codigoDocumento);
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return repositorioDocumento.obtenerTodosDocumentos();
	}

	@Override
	public Documento getDocumentoById(int id) {
		return repositorioDocumento.getDocumentoById(id);
	}

}
