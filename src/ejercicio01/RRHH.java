package ejercicio01;

import java.util.ArrayList;
import java.util.HashSet;

public class RRHH {
	
	
	// no sabia de donde sacaba los recibos, por lo tanto asumi que nos pasaban una lista con todos los recibos
	// Otra opcion seria que la misma clase RRHH tenga una lista con todos los recibos
	// de todas formas no varia mucho la ejecucion del codigo.
	
	public ArrayList<Recibo> obtenerRecibos(ArrayList<Empleado> listaEmpleados, ArrayList<Recibo> listaRecibos){
		HashSet<Empleado> yaRevise = new HashSet<Empleado>();
		// el set lo uso para chequear si ya revise este empleado en particular
		// caso contrario estaria agregando recibos repetidos
		ArrayList<Recibo> ret = new ArrayList<Recibo>();
		for(Empleado unEmpleado: listaEmpleados) {
			if(yaRevise.contains(unEmpleado)) continue;
			for(Recibo unRecibo: listaRecibos) {
				if(unRecibo.getEmpleado() == unEmpleado) {
					ret.add(unRecibo);
				}
			}
		}
		return ret;
	}
}
