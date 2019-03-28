package es.fpdual.primero.eadmin.servicio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;

public class ServicioDocmentoImplTest {

	private RepositorioDocumento repositorioDocumento;
	private ServicioDocumentoImpl servicioDocumento;
	private Documento documento;
	
	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioDocumento = mock(RepositorioDocumento.class);
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
		this.documento = mock(Documento.class);
	}
	
	@Test
	public void DeberiaObtenerTodosDocumentos() {
		List<Documento> listaDevueltaPorRepositorio = new ArrayList<>();
		
		when(repositorioDocumento.obtenerTodosDocumentos()).thenReturn(listaDevueltaPorRepositorio);
		
		final List<Documento> resultado = servicioDocumento.obtenerTodosDocumentos();
		
		assertEquals(listaDevueltaPorRepositorio, resultado);
	}
	
	@Test
	public void deberiaModificarDocumento() {
		servicioDocumento.modificarDocumento(documento);
		verify(this.repositorioDocumento).modificarDocumento(documento);
	}
	
	@Test
	public void deberiaEliminarDocumento() {
		this.servicioDocumento.eliminarDocumento(2);
		verify(this.repositorioDocumento).eliminarDocumento(2);
	}
	
	@Test
	public void deberiaDarAltaDocumento() {
		this.servicioDocumento.altaDocumento(documento);
		when(this.repositorioDocumento.siguienteId()).thenReturn(10);
	}
	
}
