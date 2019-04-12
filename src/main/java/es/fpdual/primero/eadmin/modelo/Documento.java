package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Documento extends AdministracionElectronicaBase {

	private final TipoDocumento tipoDocumento;
	private static final Logger logger = LogManager.getLogger(DocumentoContable.class);

	public Documento(Integer id, String nombre, Usuario usuario, LocalDate fechaActual, TipoDocumento tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaActual;
		this.tipoDocumento = tipoDocumento;
		logger.trace("Documento creado");
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			final Documento documento = (Documento) obj;
			return documento.getId() == this.id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		return "\n----------------------------------------------------------" + "\nID: " + this.getId() + "\nNOMBRE: "
				+ this.getNombre() + "\nUSUARIO: " + this.getUsuario() + "\nFECHA DE CREACION: "
				+ this.getFechaCreacion() + "\nTIPO DE DOCUMENTO: " + this.getTipoDocumento()
				+ "\n----------------------------------------------------------\n";
	}

	@SuppressWarnings("static-access")
	public static DocumentoBuilder builder() {
		return new DocumentoBuilder().builder();
	}

	public static class DocumentoBuilder {
		private int id;
		private String nombre;
		private Usuario usuario;
		private LocalDate fechaCreacion;
		private TipoDocumento tipoDocumento;

		public static DocumentoBuilder builder() {
			return new DocumentoBuilder();
		}

		private DocumentoBuilder() {
		}

		public Documento build() {
			return new Documento(this.id, this.nombre, this.usuario, this.fechaCreacion, this.tipoDocumento);
		}

		public DocumentoBuilder clone(Documento documento) {
			this.id = documento.getId();
			this.nombre = documento.getNombre();
			this.usuario = documento.getUsuario();
			this.fechaCreacion = documento.getFechaCreacion();
			this.tipoDocumento = documento.getTipoDocumento();
			return this;
		}

		public DocumentoBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public DocumentoBuilder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public DocumentoBuilder withUsuario(Usuario usuario) {
			this.usuario = usuario;
			return this;
		}

		public DocumentoBuilder withFechaCreacion(LocalDate fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
			return this;
		}

		public DocumentoBuilder withTipoDocumento(TipoDocumento tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

	}
}
