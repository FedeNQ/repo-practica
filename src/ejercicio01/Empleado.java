package ejercicio01;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Empleado{
	
	protected String cuil;
	protected String nombre;
	protected Calendar fechaNacimiento;
	protected String correo;
	protected ArrayList<Venta> listaVentas = new ArrayList<Venta>();
	
	//getters and setters
	public String getCuil() {		return cuil;	}

	public void setCuil(String cuil) {		this.cuil = cuil;	}
	
	public String getNombre() {		return nombre;	}

	public void setNombre(String nombre) {		this.nombre = nombre;	}

	public Calendar getFechaNacimiento() {	return fechaNacimiento;	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {		this.fechaNacimiento = fechaNacimiento;	}

	public String getCorreo() {		return correo;	}

	public void setCorreo(String correo) {		this.correo = correo;	}

	public ArrayList<Venta> getListaVentas() {	return listaVentas;	}

	public void setListaVentas(ArrayList<Venta> listaVentas) {	this.listaVentas = listaVentas;	}



	public abstract double costo();
}
