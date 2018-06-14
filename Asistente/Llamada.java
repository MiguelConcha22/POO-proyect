package Asistente;

import java.util.Calendar;
//import java.util.Random;

public class Llamada {
	
	int m, h, numero;
	
	Calendar calendario = Calendar.getInstance();
	//Calendar calendario = new GregorianCalendar();
	
	public Llamada(int numero){
		//Random random = new Random();
		
		this.numero = numero;
		this.m = calendario.get(Calendar.MINUTE);
		this.h = calendario.get(Calendar.HOUR_OF_DAY);
		//this.m = random.nextInt(60);
		//this.h = random.nextInt(24);
		//static int separador;
	}
	
	
	public void mostrar(boolean ocupado, Marco marco) {
		if(!ocupado) {
			System.out.println("llamada entrante de: +569" + numero);
			System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("llamada entrante de: +569" + numero + " a las : " + h + ":" + m);
			marco.recargarLamina();
		}else{
			System.out.println("llamada perdida de: +569" + numero);
			System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("llamada perdida de: +569" + numero + " a las : " + h + ":" + m);
			marco.recargarLamina();
		}
	}

	public static void main(String[] args) {
		//separador = 1;
	}

}