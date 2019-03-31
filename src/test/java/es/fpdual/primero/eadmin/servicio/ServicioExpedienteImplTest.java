package es.fpdual.primero.eadmin.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.repositorio.RepositorioExpediente;

public class ServicioExpedienteImplTest {
	
	private RepositorioExpediente repositorioExpediente;
	private ServicioExpedienteImpl servicioExpediente;
	private Expediente expediente;
	
	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioExpediente = mock(RepositorioExpediente.class);
		this.servicioExpediente = new ServicioExpedienteImpl(repositorioExpediente);
		this.expediente = mock(Expediente.class);
	}
	
	@Test
	public void DeberiaObtenerTodosExpedientes() {
		List<Expediente> listaDevueltaPorRepositorio = new ArrayList<>();
		
		when(repositorioExpediente.obtenerTodosExpedientes()).thenReturn(listaDevueltaPorRepositorio);
		
		final List<Expediente> resultado = servicioExpediente.obtenerTodosExpedientes();
		
		assertEquals(listaDevueltaPorRepositorio, resultado);
	}
	
	@Test
	public void deberiaModificarExpediente() {
		servicioExpediente.modificarExpediente(expediente);
		verify(this.repositorioExpediente).modificarExpediente(expediente);
	}
	
	@Test
	public void deberiaEliminarExpediente() {
		this.servicioExpediente.eliminarExpediente(2);
		verify(this.repositorioExpediente).eliminarExpediente(2);
	}
	
	@Test
	public void deberiaDarAltaExpediente() {
		when(this.repositorioExpediente.siguienteId()).thenReturn(10);
		this.servicioExpediente.altaExpediente(expediente);
	}
	
}
