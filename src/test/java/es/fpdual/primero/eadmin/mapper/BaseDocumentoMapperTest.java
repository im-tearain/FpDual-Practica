package es.fpdual.primero.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.Usuario;

public abstract class BaseDocumentoMapperTest {

	private DocumentoMapper mapper;
	private Usuario usuario;
	private Documento documento;
	private final LocalDate fechaActual = LocalDate.now();

	@Before
	public void init() {
		this.usuario = mock(Usuario.class);
		this.documento = new Documento(1, null, this.usuario, this.fechaActual, null);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		when(this.usuario.getId()).thenReturn(1);
		when(this.usuario.getNombre()).thenReturn("Usuario");
		when(this.usuario.getCargo()).thenReturn("Cargo");

		final Integer resultado = this.mapper.insertarDocumento(this.documento);

		assertThat(resultado, is(1));
	}

}
