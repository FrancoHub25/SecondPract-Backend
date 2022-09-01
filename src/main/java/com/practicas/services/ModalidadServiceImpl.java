package com.practicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.entities.Modalidad;
import com.practicas.repository.ModalidadInterface;

@Service
public class ModalidadServiceImpl implements ModalidadService {
	
	@Autowired
	private ModalidadInterface repo;

	@Override
	public Modalidad insertarActualizarModalidad(Modalidad modalidad) {
		// TODO Auto-generated method stub
		return repo.save(modalidad);
	}

	@Override
	public List<Modalidad> listarModalidadLike(String nombre) {
		// TODO Auto-generated method stub
		return repo.listaModalidad(nombre);
	}

	@Override
	public void eliminarModalidad(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Modalidad> buscaModalidad(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
