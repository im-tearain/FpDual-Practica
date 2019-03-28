package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento{
	
	private final List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento))
			throw new AdministacionElectronicaException("El documento ya existe");
		
		documentos.add(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento))
			throw new AdministacionElectronicaException("El documento no existe");
			
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		if (!documentos.contains(documentos.get(codigoDocumento)))
			throw new AdministacionElectronicaException("El documento no existe");
		
		//solucion 1
		Documento documentoAEliminar = new Documento(codigoDocumento, null, null, null, null);
		
		//solucion 2
		//documentos.stream().filter(d -> d.getId().intValue==codigoDocumento).findAny().orElse(null);
		
		final int indice = documentos.indexOf(documentoAEliminar);
		documentos.remove(indice);
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int siguienteId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
