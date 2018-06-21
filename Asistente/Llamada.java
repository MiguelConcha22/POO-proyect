package Asistente;

import java.util.Calendar;

public class Llamada {
	
	int m, h, numero;
	
	Calendar calendario = Calendar.getInstance();
	
	public Llamada(int numero){
		this.numero = numero;
		this.m = calendario.get(Calendar.MINUTE);
		this.h = calendario.get(Calendar.HOUR_OF_DAY);
	}
	
	
	public void mostrar(boolean ocupado, Marco marco) {
		if(!ocupado) {
			//System.out.println("llamada entrante de: +569" + numero);
			//System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("Listen!, you have an incoming call from: +569" + numero + " at : " + h + ":" + m);
			marco.recargarLamina();
		}else{
			//System.out.println("llamada perdida de: +569" + numero);
			//System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("Look!, you missed a call from: +569" + numero + " at : " + h + ":" + m);
			marco.recargarLamina();
		}
	}
}