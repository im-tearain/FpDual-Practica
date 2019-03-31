package es.fpdual.primero.eadmin.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Expediente;

public class RepositorioExpedienteEnListaTest {
	
	private RepositorioExpediente repositorioExpediente;
	private Expediente expediente;
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioExpediente = new RepositorioExpedienteEnLista();
		this.expediente = mock(Expediente.class);
	}
	
	@Test
	public void deberiaAlmacenarNuevoExpediente() {
		when(expediente.getId()).thenReturn(2);
		this.repositorioExpediente.altaExpediente(expediente);
		
		assertTrue(this.repositorioExpediente.obtenerTodosExpedientes().contains(expediente));
	}
	
	@Test (expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarExpedienteExistente() {
		when(expediente.getId()).thenReturn(2);
		this.repositorioExpediente.altaExpediente(expediente);
		this.repositorioExpediente.altaExpediente(expediente);
		
		assertTrue(this.repositorioExpediente.obtenerTodosExpedientes().contains(expediente));
	}
	
	@Test
	public void deberiaModificarNuevoExpediente() {
		Expediente expedienteModificado = new Expediente(2, "Expediente Modificado", null, null, null, null);
		
		when(expediente.getId()).thenReturn(2);
		
		this.repositorioExpediente.altaExpediente(expediente);
		this.repositorioExpediente.modificarExpediente(expedienteModificado);
		
		assertEquals("Expediente Modificado", this.repositorioExpediente.obtenerTodosExpedientes().get(0).getNombre());
	}
	
	@Test (expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlModificarExpedienteExistente() {
		this.repositorioExpediente.modificarExpediente(this.expediente);
	}
	
	@Test
	public void deberiaEliminarExpediente() {
		when(this.expediente.getId()).thenReturn(2);
		
		this.repositorioExpediente.altaExpediente(expediente);
		this.repositorioExpediente.eliminarExpediente(2);
		
		assertTrue(this.repositorioExpediente.obtenerTodosExpedientes().isEmpty());
	}
	
	@Test
	public void deberiaNoHacerNadaSiNoEstaElExpediente() {
		this.repositorioExpediente.eliminarExpediente(2);
	}
	
	@Test
	public void deberiaDevolverIdUnoSiLaListaEstaVacia() {
		final int resultado = this.repositorioExpediente.siguienteId();
		assertEquals(1, resultado);
	}
	
	@Test
	public void deberiaDevolverElPrimerIdDisponible() {
		when(expediente.getId()).thenReturn(2);
		
		this.repositorioExpediente.altaExpediente(expediente);
		
		final int resultado = this.repositorioExpediente.siguienteId();
		assertEquals(3, resultado);
	}
	
}
