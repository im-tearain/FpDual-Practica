package es.fpdual.primero.eadmin.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.servicio.ServicioExpediente;

public class ControladorExpediente {
	private ServicioExpediente servicioExpediente;

	@PostMapping("/documentos")
	public Expediente altaExpediente(@RequestBody ExpedienteRequest expedienteRequest) {
		final Expediente expedienteAInsertar = ExpedienteRequestMapper.toExpediente(expedienteRequest);
		return this.servicioExpediente.altaExpediente(expedienteAInsertar);
	}
	
	@GetMapping("/expedientes")
	public List<Expediente> obtenerTodosLosExpedientes() {
		return this.servicioExpediente.obtenerTodosExpedientes();
	}
	
	@GetMapping("/expedientes/{id}")
	public Expediente getExpedienteById(@PathVariable("id") int id) {
		return this.servicioExpediente.getExpedienteById(id);
	}
	
	@PutMapping("/expedientes/{id}")
	public Expediente modificarExpediente(@PathVariable("id") int id, @RequestBody ExpedienteRequest expedienteRequest) {
		final Expediente expediente = this.servicioExpediente.getExpedienteById(id);
		final Expediente expedienteAModificar = ExpedienteRequestMapper.toExpedienteCompleto(expedienteRequest, id, expediente.getFechaCreacion());
		
		return this.servicioExpediente.modificarExpediente(expedienteAModificar);
	}
	
	@DeleteMapping("/expedientes/{id}")
	public void eliminarExpediente(@PathVariable("id") int id) {
		this.servicioExpediente.eliminarExpediente(id);
	}
}
