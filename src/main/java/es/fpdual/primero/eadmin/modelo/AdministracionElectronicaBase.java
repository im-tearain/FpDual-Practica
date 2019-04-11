package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;

public abstract class AdministracionElectronicaBase {
	//No hay que poner private ni final
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected LocalDate fechaCreacion;
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	
}
