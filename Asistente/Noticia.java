package Asistente;

import java.util.Calendar;
//import java.util.Random;

public class Noticia {
	
	int m, h, numero;
	
	Calendar calendario = Calendar.getInstance();
	
	public Noticia(int numero) {
		
		this.numero = numero;
		this.m = calendario.get(Calendar.MINUTE);
		this.h = calendario.get(Calendar.HOUR_OF_DAY);
	}
	
	public void mostrar(boolean ocupado, Marco marco) {
		if(!ocupado) {
			System.out.println("nueva noticia!: noticia " + numero);
			System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("nueva noticia!: noticia " + numero + " a las : " + h + ":" + m);
			marco.recargarLamina();
		}else{
			System.out.println("noticia perdida: noticia " + numero);
			System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("noticia perdida: noticia " + numero + " a las : " + h + ":" + m);
			marco.recargarLamina();
		}
	}

	public static void main(String[] args) {

	}
}