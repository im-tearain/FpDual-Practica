package es.fpdual.primero.eadmin.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.servicio.ServicioExpediente;

public class ControladorExpediente {
	private ServicioExpediente servicioExpediente;

	@Autowired
	public ControladorExpediente(ServicioExpediente servicioExpediente) {
		this.servicioExpediente = servicioExpediente;
	}
	
	@PostMapping("/Expedientes")
	public Expediente altaExpediente(@RequestBody ExpedienteRequest ExpedienteRequest) {
		final Expediente ExpedienteAInsertar = ExpedienteRequestMapper.toExpediente(ExpedienteRequest);
		return this.servicioExpediente.altaExpediente(ExpedienteAInsertar);
	}
	
	@GetMapping("/Expedientes")
	public List<Expediente> obtenerTodosLosExpedientes() {
		return this.servicioExpediente.obtenerTodosExpedientes();
	}
}
