package ejercicio01;

import java.util.Calendar;

public class EmpleadoContratado extends Empleado{
	protected double horasTrabajadas;
	protected double costoPorHora;
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	
	//methods
	@Override
	public double costo() {
		double auxCosto = horasTrabajadas*(this.costoPorHora);
		double auxPorVenta = 10*costoPorHora;
		for(Venta unaVenta : listaVentas) {
			if(unaVenta.getMonto() > 10000.0) {
				auxCosto += auxPorVenta;
			}
		}
		// puedo hacer un stream que cuente la cantidad pero es mas riesgo que no compile

		if(fechaNacimiento.MONTH == Calendar.getInstance().MONTH) auxCosto+=20000.0;
		return auxCosto;
	}
	
}
