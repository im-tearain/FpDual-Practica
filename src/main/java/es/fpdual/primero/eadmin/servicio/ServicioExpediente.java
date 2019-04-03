package es.fpdual.primero.eadmin.servicio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Expediente;

public interface ServicioExpediente {
	Expediente altaExpediente(Expediente expediente);
	Expediente modificarExpediente(Expediente expediente);
	void eliminarExpediente(int codigoExpediente);
	List<Expediente> obtenerTodosExpedientes();
	Expediente getExpedienteById(int id);
}
