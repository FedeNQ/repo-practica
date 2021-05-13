package ejercicio01;

import java.util.Calendar;

public class Recibo {
	protected long numeroRecibo;
	protected Calendar fechaPago;
	protected double monto;
	protected Empleado empleado;
	public long getNumeroRecibo() {
		return numeroRecibo;
	}
	public void setNumeroRecibo(long numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	public Calendar getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
