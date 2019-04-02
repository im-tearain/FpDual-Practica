package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		System.out.println("Documento " + documento.getNombre() +  " almacenado correctamente");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento))
			throw new AdministacionElectronicaException("El documento no existe");
			
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int id) {
		
		//solucion 1
		Documento documentoAEliminar = new Documento(id, null, null, null, null);
		
		//solucion 2(spaguetti)
		//documentos.stream().filter(d -> d.getId()==id).findAny().orElse(null);
		
		final int indice = documentos.indexOf(documentoAEliminar);
		
		if(indice >= 0)
			documentos.remove(indice);
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return this.documentos.stream().collect(Collectors.toList());
	}

	@Override
	public int siguienteId() {
		if (documentos.isEmpty())
			return 1;
		return documentos.get(documentos.size()-1).getId()+1;
	}

	@Override
	public Documento getDocumentoById(int id) {
		Documento documento = documentos.stream().filter(d -> d.getId()==id).findFirst().orElse(null);
		if (documento == null)
			throw new AdministacionElectronicaException("No se ha encontrado el documento");
		return documento;
	}
}
