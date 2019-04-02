package es.fpdual.primero.eadmin.controlador;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;

import org.junit.Before;
import org.junit.Test;

public class ControladorDocumentoTest {

	private ControladorDocumento controlador;
	private ServicioDocumento servicioDocumento;
	private DocumentoRequest documentoRequest;
	
	@Before
	public void inti() {
		this.servicioDocumento = mock(ServicioDocumento.class);
		this.controlador = new ControladorDocumento(servicioDocumento);
		this.documentoRequest = mock(DocumentoRequest.class);
	}
	
	@Test
	public void deberiaAlmacenarDocumento() {
		Documento documentoInsertado = mock(Documento.class);
		when(this.servicioDocumento.altaDocumento(any())).thenReturn(documentoInsertado);
		
		when(this.documentoRequest.getUsuario()).thenReturn("22");
		when(this.documentoRequest.getTipoDocumento()).thenReturn("DOCUMENTO_CONTABLE");
		
		final Documento resultado = this.controlador.altaDocumento(this.documentoRequest);
		
		assertSame(documentoInsertado, resultado);
	}
	
	@Test
	public void deberiaObtenerTodosLosDocumenos() {
		assertTrue(servicioDocumento.obtenerTodosDocumentos().isEmpty());
	}
	
}
