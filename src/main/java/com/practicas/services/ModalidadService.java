package com.practicas.services;

import java.util.List;
import java.util.Optional;

import com.practicas.entities.Modalidad;


public interface ModalidadService {

	public abstract Modalidad insertarActualizarModalidad(Modalidad modalidad);
	public abstract List<Modalidad> listarModalidadLike(String nombre);
	public abstract void eliminarModalidad(int id);
	public abstract Optional<Modalidad> buscaModalidad(int id);
	
}
