package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Expediente;

public class RepositorioExpedienteEnLista implements RepositorioExpediente{

	private final List<Expediente> expedientes = new ArrayList<>();
	
	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente))
			throw new AdministacionElectronicaException("El expediente ya se encontraba en nuestra base de datos");
		
		expedientes.add(expediente);
		System.out.println("Expediente almacenado correctamente");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente))
			throw new AdministacionElectronicaException("El expediente no existe");
		
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

}
