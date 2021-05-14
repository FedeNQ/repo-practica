package isi.died.parcial01.ejercicio02.dominio;

import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;

public class Alumno {
	
	private static Integer ID_GENERATOR=0;
	
	private Integer id;
	private String nombre;

	private List<Inscripcion> materiasCursadas;
	private List<Examen> examenes;
	
	public Alumno() {
		this.id = ID_GENERATOR++;
		this.materiasCursadas = new ArrayList<Inscripcion>();
		this.examenes = new ArrayList<Examen>();
	}
	
	
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addExamen(Examen e) {
		this.examenes.add(e);
		e.setAlumno(this);
	}
	
	public void addCursada(Inscripcion e) {
		this.materiasCursadas.add(e);
		e.setInscripto(this);
	}
	
	public void promocionarMateria(Materia m) {
		int shouldChange = -1;
		int actualIndex = 0;
		for(Inscripcion ins : materiasCursadas) {
			if(ins.getMateria() == m) shouldChange = actualIndex; 
			actualIndex++;
		}
		//deberia hacer un assert de que shouldChange es dif de -1 ?
		// asumo que no lo piden 
		Inscripcion aux = materiasCursadas.get(shouldChange);
		aux.setEstado(Estado.PROMOCIONADO);
		materiasCursadas.set(shouldChange, aux);
		return;
	}
	
	public Integer contarAplazos() {
		Integer cont = 0;
		for(Examen e: examenes) {
			if(e.getNota() < 6) cont++;
		}
		return cont;
	}
	
	public boolean esRegular(Materia m) {
		boolean ok = false;
		for(Inscripcion i: materiasCursadas) {
			if(i.getMateria() == m) {
				if(i.getEstado() == Estado.REGULAR) ok = true;
			}
		}
		return ok;
	}
	
}

















