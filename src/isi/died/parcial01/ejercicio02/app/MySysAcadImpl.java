package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.dominio.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws AlumnoNoRegularException {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		try {
			if(a.esRegular(m)) DB.guardar(insc);
		}
		catch(AlumnoNoRegularException e){
			e.printStackTrace();
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) throws AlumnoNoRegularException {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		try {
			if(a.esRegular(m)) DB.guardar(insc);
			
		}
		catch(AlumnoNoRegularException e){
			e.printStackTrace();
		}
	}
	@Override
	public void registrarNota(Examen e, Integer nota) {
		e.setNota(nota);
		if(nota>=6) e.getAlumno().promocionarMateria(e.getMateria());
		return;
	}
	
	@Override
	 public Integer cantidadAplazos(Alumno a) {
		 Integer ret = a.contarAplazos();
		 return ret;
	}
	@Override
	public List<Examen> topNExamenes(Materia m, Integer n){
		List<Examen> todos = m.getExamenes();
		Collections.sort(todos);
        Collections.reverse(todos);
        //no se si llego a implementar el sort y el reverse
        List<Examen> ret;
        int cont = 0;
        for(Examen e: todos) {
        	ret.add(e);
        	cont++;
        	if(cont>=n)break;
        }
        return ret;
	}
	

}
