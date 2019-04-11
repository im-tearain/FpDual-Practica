package es.fpdual.primero.eadmin.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.repositorio.RepositorioExpediente;

@Service
public class ServicioExpedienteImpl implements ServicioExpediente {

	private RepositorioExpediente repositorioExpediente;
	
	@Autowired
	public ServicioExpedienteImpl(RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}
	
	@Override
	public Expediente altaExpediente(Expediente expediente) {
		final int siguienteId = this.repositorioExpediente.siguienteId();
		final LocalDate fechaActual = LocalDate.now();
		
		Expediente expedienteModificado = new Expediente(siguienteId, expediente.getNombre(), 
				expediente.getUsuario(), fechaActual, expediente.getTipoExpediente(), expediente.getDocumentos());
		
		this.repositorioExpediente.altaExpediente(expedienteModificado);
		return expedienteModificado;
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		this.repositorioExpediente.modificarExpediente(expediente);
		return expediente;
	}

	@Override
	public void eliminarExpediente(int codigoExpediente) {
		this.repositorioExpediente.eliminarExpediente(codigoExpediente);
	}

	@Override
	public List<Expediente> obtenerTodosExpedientes() {
		return this.repositorioExpediente.obtenerTodosExpedientes();
	}

	@Override
	public Expediente getExpedienteById(int id) {
		return repositorioExpediente.getExpedienteById(id);
	}

}
