package com.practicas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.entities.Deporte;
import com.practicas.repository.DeporteInterface;

@Service
public class DeporteServiceImpl implements DeporteService{
	
	@Autowired
	private DeporteInterface repo;

	@Override
	public List<Deporte> listDeporte() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

}
