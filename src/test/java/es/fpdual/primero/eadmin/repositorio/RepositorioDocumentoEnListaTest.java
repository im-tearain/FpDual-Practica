package es.fpdual.primero.eadmin.repositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

public class RepositorioDocumentoEnListaTest {

	private RepositorioDocumento repositorioDocumento;
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoEnLista();
		this.documento = mock(Documento.class);
	}
	
	@Test
	public void deberiaAlmacenarNuevoDocumento() {
		when(documento.getId()).thenReturn(2);
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test (expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoExistente() {
		when(documento.getId()).thenReturn(2);
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test
	public void deberiaModificarNuevoDocumento() {
		Documento documentoModificado = new Documento(2, "documentoModificado", null, null, null);
		
		when(documento.getId()).thenReturn(2);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		
		assertEquals("documentoModificado", this.repositorioDocumento.obtenerTodosDocumentos().get(0).getNombre());
	}
	
	@Test (expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlModificarDocumentoExistente() {
		this.repositorioDocumento.modificarDocumento(this.documento);
	}
	
	@Test
	public void deberiaEliminarDocumento() {
		when(this.documento.getId()).thenReturn(2);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(2);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().isEmpty());
	}
	
	@Test
	public void deberiaNoHacerNadaSiNoEstaElDocumento() {
		this.repositorioDocumento.eliminarDocumento(2);
	}
	
	@Test
	public void deberiaDevolverIdUnoSiLaListaEstaVacia() {
		final int resultado = this.repositorioDocumento.siguienteId();
		assertEquals(1, resultado);
	}
	
	@Test
	public void deberiaDevolverElPrimerIdDisponible() {
		when(documento.getId()).thenReturn(2);
		
		this.repositorioDocumento.altaDocumento(documento);
		
		final int resultado = this.repositorioDocumento.siguienteId();
		assertEquals(3, resultado);
	}
	
}
