package Asistente;

import java.util.Calendar;

public class Tarea {
	boolean candado;
	
	int hora, minuto;
	
	int m, h;
	String tarea;
	
	Calendar calendario = Calendar.getInstance();
	
	public Tarea(String tarea, int h, int m){
		this.candado = false;
		
		this.tarea = tarea;
		this.m = m;
		this.h = h;
	}
	
	public void mostrar() {
		this.hora = calendario.get(Calendar.HOUR_OF_DAY); //Estos valores no se actualizan!!
		this.minuto = calendario.get(Calendar.MINUTE);
		
		System.out.println(this.hora + ":" + this.minuto);
		
		if((this.m == this.minuto) && (this.h == this.hora) && !this.candado) {
			System.out.println("Recordatorio tarea: " + tarea);
			System.out.println("a las : " + h + ":" + m);
			this.candado = true;
		}
	}

	public static void main(String[] args) {
		
	}
}
