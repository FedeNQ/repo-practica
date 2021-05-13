package ejercicio01;

import java.util.Calendar;

public class EmpleadoEnConvenio extends Empleado {
	protected int antiguedad;
	protected double sueldoBasico;
	
	// getters and setters
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public double getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	//methods
	@Override
	public double costo() {
		double auxPago = sueldoBasico;
		for(Venta unaVenta: listaVentas) {
			auxPago += unaVenta.getMonto();
		}
		if(fechaNacimiento.MONTH == Calendar.getInstance().MONTH) auxPago+=20000.0;
		return auxPago;
	}
	
}
