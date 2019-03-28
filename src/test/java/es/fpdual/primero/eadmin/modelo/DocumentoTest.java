package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import es.fpdual.primero.eadmin.modelo.Documento;

public class DocumentoTest {
	
	private final Documento documento1 = new Documento(5, null, null, null, TipoDocumento.DOCUMENTO_CONTABLE);
	private final Documento documento2 = mock(Documento.class);
	
	@Test
	public void deberiaDevolverTrueSiLosDocumentosSonIguales() {
		when(documento2.getId()).thenReturn(5);
		assertTrue(documento1.equals(documento2));
	}
	
	@Test
	public void deberiaDevolverFalseElEqualsDeDocumento() {
		when(documento2.getId()).thenReturn(1);
		assertFalse(documento1.equals(documento2));
	}
	
	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		assertFalse(documento1.equals(null));
	}
	
	@Test
	public void deberiaDevolverTrueElHashCodeDelDocumento() {
		assertEquals(5, documento1.hashCode());
	}
	
	@Test
	public void deberiaDevolverElTipoDocumento() {
		assertEquals(TipoDocumento.DOCUMENTO_CONTABLE, documento1.getTipoDocumento());
	}
	
}
