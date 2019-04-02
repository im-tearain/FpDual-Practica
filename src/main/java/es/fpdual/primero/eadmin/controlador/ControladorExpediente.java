package es.fpdual.primero.eadmin.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.servicio.ServicioExpediente;

public class ControladorExpediente {
	private ServicioExpediente servicioExpediente;

	@Autowired
	public ControladorExpediente(ServicioExpediente servicioExpediente) {
		this.servicioExpediente = servicioExpediente;
	}
	
	@PostMapping("/expedientes")
	public Expediente altaExpediente(@RequestBody ExpedienteRequest expedienteRequest) {
		final Expediente expedienteAInsertar = ExpedienteRequestMapper.toExpediente(expedienteRequest);
		return this.servicioExpediente.altaExpediente(expedienteAInsertar);
	}
	
	@GetMapping("/expedientes")
	public List<Expediente> obtenerTodosLosExpedientes() {
		return this.servicioExpediente.obtenerTodosExpedientes();
	}
	
	@PutMapping("/expdientes")
	public Expediente modificarExpediente(ExpedienteRequest expedienteRequest) {
		final Expediente expedienteAModificar = ExpedienteRequestMapper.toExpediente(expedienteRequest);
		return this.servicioExpediente.modificarExpediente(expedienteAModificar);
	}
	
	@DeleteMapping("/expedientes")
	public void eliminarExpediente(ExpedienteRequest expedienteRequest) {
		this.servicioExpediente.eliminarExpediente(expedienteRequest.getId());
	}
}
