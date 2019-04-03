package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.EadminApplication;
import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento{

	private static final Logger logger = LogManager.getLogger(EadminApplication.class);
	private final List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento))
			logger.warn("El documento ya existe", new AdministacionElectronicaException());
		
		documentos.add(documento);
		logger.info("Documento " + documento.getNombre() + " almacenado correctamente"+documento.toString());
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento))
			logger.warn("El documento no existe", new AdministacionElectronicaException());
			
		documentos.set(documentos.indexOf(documento), documento);
		logger.info("Documento " + documento.getNombre() + " modificado correctamente"+documento.toString());
	}

	@Override
	public void eliminarDocumento(int id) {
		
		//solucion 1
		Documento documentoAEliminar = new Documento(id, null, null, null, null);
		
		//solucion 2(spaguetti)
		//documentos.stream().filter(d -> d.getId()==id).findAny().orElse(null);
		
		final int indice = documentos.indexOf(documentoAEliminar);
		
		if(indice >= 0) {
			documentos.remove(indice);
			logger.info("Documento con ID {" + indice + "} eliminado correctamente");
		}
		logger.warn("No se ha encontrado el documento");
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		logger.info("Obteniendo todos los documentos...");
		return this.documentos.stream().collect(Collectors.toList());
	}

	@Override
	public int siguienteId() {
		logger.info("Obteniendo siguiente ID...");
		if (documentos.isEmpty()) {
			logger.info("La lista esta vacia");
			return 1;
		}
		logger.info("Siguiente ID obtenido");
		return documentos.get(documentos.size()-1).getId()+1;
	}

	@Override
	public Documento getDocumentoById(int id) {
		Documento documento = documentos.stream().filter(d -> d.getId()==id).findFirst().orElse(null);
		if (documento == null) {
			logger.warn("No se ha encontrado el documento", new AdministacionElectronicaException());
		}
			
		logger.info("Documento con ID {" + documento.getId() + "} obtenido correctamente");
		return documento;
	}
}
