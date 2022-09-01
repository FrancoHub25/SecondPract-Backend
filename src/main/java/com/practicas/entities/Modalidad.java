package com.practicas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modalidad")
public class Modalidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModalidad;
	private String nombre;
	private String numHombres;
	private String numMujeres;
	private String edadMaxima;
	private String edadMinima;
	private String sede;
	
	@ManyToOne
	@JoinColumn(name = "idDeporte")
	private Deporte deporte;

	public int getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumHombres() {
		return numHombres;
	}

	public void setNumHombres(String numHombres) {
		this.numHombres = numHombres;
	}

	public String getNumMujeres() {
		return numMujeres;
	}

	public void setNumMujeres(String numMujeres) {
		this.numMujeres = numMujeres;
	}

	public String getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(String edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public String getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(String edadMinima) {
		this.edadMinima = edadMinima;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
	

}
