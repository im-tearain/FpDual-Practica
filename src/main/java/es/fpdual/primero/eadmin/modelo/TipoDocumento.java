package es.fpdual.primero.eadmin.modelo;

public enum TipoDocumento {

	DOCUMENTO_CONTABLE("0"), DOCUMENTO_FACTURA("1"), DOCUMENTO_NOMINA("2"), DOCUMENTO_SUBVENCION("3"), DOCUMENTO_PADRON(
			"4");

	private final String id;

	private TipoDocumento(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

}
