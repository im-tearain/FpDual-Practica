package es.fpdual.primero.eadmin.repositorio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	void altaExpediente(Expediente expediente);
	void modificarExpediente(Expediente expediente);
	void eliminarExpediente(int codigoExpediente);
	List<Expediente> obtenerTodosExpedientes();
	int siguienteId();
}
