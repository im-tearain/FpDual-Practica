package es.fpdual.primero.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	@Autowired
	DocumentoMapper mapper;

	Documento documentoPrueba = mock(Documento.class);

	private Usuario usuario;
	private Documento documento;
	private final LocalDate fechaActual = LocalDate.now();

	@Before
	public void inicializarEnCadaTest() {
		this.usuario = mock(Usuario.class);
		this.documento = new Documento(1, "Ejemplo", this.usuario, this.fechaActual, TipoDocumento.DOCUMENTO_CONTABLE);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		when(this.usuario.getId()).thenReturn(1);

		final Integer resultado = this.mapper.insertarDocumento(this.documento);

		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaResctarDocumento() throws Exception {
		when(this.usuario.getId()).thenReturn(1);
		this.mapper.insertarDocumento(this.documento);

		final Documento resultado = this.mapper.getDocumento(1);

		assertThat(resultado, is(this.documento));
	}

	@Test
	public void deberiaModificarDocumento() throws Exception {
		final Documento modificado = Documento.builder().clone(this.documento).withNombre("Nombre actualizado").build();

		this.mapper.insertarDocumento(this.documento);

		final Integer resultado = this.mapper.actualizarDocumento(modificado);

		assertThat(resultado, is(1));
		assertThat(modificado, is(notNullValue()));
		assertThat(modificado.getNombre(), is("Nombre actualizado"));
	}

}
