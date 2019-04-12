package es.fpdual.primero.eadmin.modelo;

public class Usuario {

	private final int id;
	private final String nombre;
	private final String cargo;

	public Usuario(int id, String nombre, String cargo) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	@SuppressWarnings("unused")
	private Usuario(Integer id) { // NOSONAR myBatis
		this(id, null, null);
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getCargo() {
		return this.cargo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			final Usuario usuario = (Usuario) obj;
			return usuario.getId() == usuario.getId();
		}
		return false;
	}

	@Override
	public String toString() {
		return "\n\tid=" + this.id + "\n\tnombre=" + this.nombre + "\n\tcargo=" + this.cargo;
	}

}
