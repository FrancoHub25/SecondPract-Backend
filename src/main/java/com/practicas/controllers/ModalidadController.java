package com.practicas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.entities.Modalidad;
import com.practicas.services.ModalidadService;
import com.practicas.utils.Constantes;

@RestController
@RequestMapping("rest/crudModalidad")
@CrossOrigin(origins = "http://localhost:4200")
public class ModalidadController {

	@Autowired
	private ModalidadService serv;
	
	@GetMapping("/listaModalidadNom/{nom}")
	@ResponseBody
	public ResponseEntity<List<Modalidad>> listaModalidadNom(@PathVariable("nom") String nom) {
		List<Modalidad> lista = null;
		
		try {
			if(nom.equals("todos")) {
				lista = serv.listarModalidadLike("%");
			} else {
				lista = serv.listarModalidadLike("%" + nom + "%");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/registrarModalidad")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarModalidad(@RequestBody Modalidad obj) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			obj.setIdModalidad(0);
			obj.setNombre("");
			obj.setEdadMaxima("");
			obj.setEdadMinima("");
			obj.setNumHombres("");
			obj.setNumMujeres("");
			obj.setSede("");
			Modalidad objSalida = serv.insertarActualizarModalidad(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			} 
		} catch(Exception e) {
		   e.printStackTrace();
		   salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	
	@PutMapping("/actualizarModalidades")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarModalidades(@RequestBody Modalidad obj) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Modalidad objSalida = serv.insertarActualizarModalidad(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			} 
		} catch(Exception e) {
		   e.printStackTrace();
		   salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@DeleteMapping("/eliminarMod/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarModalidades(@PathVariable("id") int id) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Optional<Modalidad> opt = serv.buscaModalidad(id);
			if(opt.isPresent()) {
				serv.eliminarModalidad(id);
				Optional<Modalidad> optModalidad = serv.buscaModalidad(id);
				if (optModalidad.isEmpty()) {
					salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
				} else {
					salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
				}
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ELI_NO_EXISTE_ID);
			}
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
}
