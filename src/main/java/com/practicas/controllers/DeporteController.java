package com.practicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.entities.Deporte;
import com.practicas.services.DeporteService;

@RestController
@RequestMapping("rest/dep")
@CrossOrigin(origins = "http://localhost:4200")
public class DeporteController {

	@Autowired
	private DeporteService deporteServ;
	
	@GetMapping("/listDep")
	@ResponseBody
	public List<Deporte> listasDeportes() {
		return deporteServ.listDeporte();
	}
	
}
