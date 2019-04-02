package es.fpdual.primero.eadmin.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;

@RestController
public class ControladorDocumento {
	private ServicioDocumento servicioDocumento;

	@Autowired
	public ControladorDocumento(ServicioDocumento servicioDocumento) {
		this.servicioDocumento = servicioDocumento;
	}
	
	@PostMapping("/documentos")
	public Documento altaDocumento(@RequestBody DocumentoRequest documentoRequest) {
		final Documento documentoAInsertar = DocumentoRequestMapper.toDocumento(documentoRequest);
		return this.servicioDocumento.altaDocumento(documentoAInsertar);
	}
	
	@GetMapping("/documentos")
	public List<Documento> obtenerTodosLosDocumentos() {
		return this.servicioDocumento.obtenerTodosDocumentos();
	}
	
	@PutMapping("/docuemntos")
	public Documento modificarDocumento(DocumentoRequest documentoRequest) {
		final Documento documentoAModificar = DocumentoRequestMapper.toDocumento(documentoRequest);
		return this.servicioDocumento.modificarDocumento(documentoAModificar);
	}
	
	@DeleteMapping("/documentos")
	public void eliminarDocumento(DocumentoRequest documentoRequest) {
		this.servicioDocumento.eliminarDocumento(documentoRequest.getId());
	}
	
}
