package es.fpdual.primero.eadmin.repositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		when(documento.getNombre()).thenReturn("documentoPrueba");
		when(documento.getId()).thenReturn(2);
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test (expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoExistente() {
		when(documento.getNombre()).thenReturn("documentoPrueba");
		when(documento.getId()).thenReturn(2);
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test
	public void deberiaModificarNuevoDocumento() {
		Documento documentoModificado = new Documento(2, "documentoModificado", null, null, null);
		// Deberia ser un mock pero accede al equals del mock en vez de al del objeto y falla el contains
		
		when(documento.getId()).thenReturn(2);
		when(documento.getNombre()).thenReturn("documentoPrueba");
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		
		assertEquals("documentoModificado", this.repositorioDocumento.obtenerTodosDocumentos().get(0).getNombre());
	}
	
	@Test (expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlModificarDocumentoExistente() {
		this.repositorioDocumento.modificarDocumento(documento);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test
	public void deberiaEliminarDocumento() {
		when(documento.getNombre()).thenReturn("documentoPrueba");
		when(documento.getId()).thenReturn(2);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(documento.getId());
		
		assertFalse(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test
	public void deberiaDevolverIdUnoSiLaListaEstaVacia() {
		assertEquals(1, this.repositorioDocumento.siguienteId());
	}
	
	@Test
	public void deberiaDevolverElPrimerIdDisponible() {
		when(documento.getNombre()).thenReturn("documentoPrueba");
		when(documento.getId()).thenReturn(2);
		
		this.repositorioDocumento.altaDocumento(documento);
		
		assertEquals(3, this.repositorioDocumento.siguienteId());
	}
	
}
