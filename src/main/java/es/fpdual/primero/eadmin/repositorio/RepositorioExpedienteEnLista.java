package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Expediente;

@Repository
public class RepositorioExpedienteEnLista implements RepositorioExpediente{

	private final List<Expediente> expedientes = new ArrayList<>();
	
	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente))
			throw new AdministacionElectronicaException();
		
		expedientes.add(expediente);
		System.out.println("Expediente almacenado correctamente");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente))
			throw new AdministacionElectronicaException();
		
		expedientes.set(expedientes.indexOf(expediente), expediente);
	}

	@Override
	public void eliminarExpediente(int codigoExpediente) {
		Expediente expedienteAEliminar = new Expediente(codigoExpediente, null, null, null, null, null);
		
		if (expedientes.contains(expedienteAEliminar))
			expedientes.remove(expedientes.indexOf(expedienteAEliminar));
	}

	@Override
	public List<Expediente> obtenerTodosExpedientes() {
		return expedientes;
	}

	@Override
	public int siguienteId() {
		if (expedientes.size() == 0)
			return 1;
		
		final int resultado = expedientes.get(expedientes.size()-1).getId()+1;
		return resultado;
	}

	@Override
	public Expediente getExpedienteById(int id) {
		Expediente expediente = expedientes.stream().filter(d -> d.getId()==id).findFirst().orElse(null);
		if (expediente == null)
			throw new AdministacionElectronicaException();
		return expediente;
	}

}
