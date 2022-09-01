package com.practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practicas.entities.Modalidad;

public interface ModalidadInterface extends JpaRepository<Modalidad, Integer> {
	
	@Query("select m from Modalidad m where m.nombre like ?1")
	public List<Modalidad> listaModalidad(String nombre);

}
