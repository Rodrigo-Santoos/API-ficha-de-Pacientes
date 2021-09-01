package com.paciente.pacientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paciente.pacientes.models.Pacientes;
import com.paciente.pacientes.repository.PacienteRepository;

@RestController
@RequestMapping(value="/api")
public class PacientesResources {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	
	@GetMapping("/pacientes")
	public List<Pacientes> listarPacientes(){
		return pacienteRepository.findAll();
		
	}
	
	@GetMapping("/paciente/{id}")
	public Pacientes listarUnicoPacientes(@PathVariable(value="id") long id){
		return pacienteRepository.findById(id);
		
	}
	
	@PostMapping("/paciente")
	public Pacientes salvarPacientes(@RequestBody Pacientes paciente){
		return pacienteRepository.save(paciente);
		
	}
	
	

}
