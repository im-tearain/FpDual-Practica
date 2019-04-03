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
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getCargo() {
		return cargo;
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
		return "\n\tid=" + id + "\n\tnombre=" + nombre + "\n\tcargo=" + cargo;
	}
	
	
	
}
