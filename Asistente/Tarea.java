package Asistente;

//import java.util.Calendar;

public class Tarea {
	boolean candado;
	
	int m, h;
	String tarea;
	
	public Tarea(String tarea, int h, int m){
		this.candado = false;
		
		this.tarea = tarea;
		this.m = m;
		this.h = h;
	}
	
	public void mostrar(int h, int m, Marco marco) {		
		//System.out.println(this.hora + ":" + this.minuto);
		
		if((this.m <= m + 5) && (this.h == h) && !this.candado) {
			//System.out.println("Recordatorio tarea: " + tarea);
			//System.out.println("a las : " + h + ":" + m);
			marco.lamina.agregarPalabra("Watch out!, don't forget this task: " + this.tarea + " at : " + this.h + ":" + this.m);
			marco.recargarLamina();
			this.candado = true;
		}
	}
}