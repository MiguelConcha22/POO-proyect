package Asistente;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.concurrent.TimeUnit;

public class Asistente implements KeyListener{
	static boolean ocupado;
	static boolean candadito = false;
	
	/*static List <Tarea> tareas;
	static List <Llamada> llamadas;
	static List <Noticia> noticias;
	
	public Asistente() {
		
		Asistente.tareas = new ArrayList<>();
		Asistente.llamadas = new ArrayList<>();
		Asistente.noticias = new ArrayList<>();
	}*/
	
	public static void main(String[] args) {
		ocupado = false;
		
		List <Llamada> llamadas;
		llamadas = new ArrayList<>();
		List <Noticia> noticias;
		noticias = new ArrayList<>();
		List <Tarea> tareas;
		tareas = new ArrayList<>();
		
		
		Random random = new Random();
		int numero;
		
		while(true) {
			//System.out.println(ocupado);
			
			if(random.nextInt(100) <= 10) {
				numero = random.nextInt(400) + 100;
				
				if(ocupado) {
					noticias.add(new Noticia(numero));
				}else {
					Noticia noticiaEntrante = new Noticia(numero);
					noticiaEntrante.mostrar(ocupado);
					//ELIMINAR
				}
			}
			
			if(random.nextInt(100) <= 10) {
				numero = random.nextInt(60000000) + 40000000;
				
				if(ocupado) {
					llamadas.add(new Llamada(numero));
				}else {
					Llamada llamadaEntrante = new Llamada(numero);
					llamadaEntrante.mostrar(ocupado);
					//ELIMINAR
				}
			}
			
			if(random.nextInt(100) <= 10 && !candadito) {				
				String nuevaTarea;
				int horaTarea, minutoTarea;
				
				Scanner in = new Scanner(System.in);
				System.out.print("Ingrese nueva tarea: ");
				nuevaTarea = in.nextLine();
				System.out.print("Hora de la tarea: ");
				horaTarea = in.nextInt();
				System.out.print("Minutos de la tarea: ");
				minutoTarea = in.nextInt();
				
				tareas.add(new Tarea(nuevaTarea, horaTarea, minutoTarea));
				candadito = true;
				
			}
			
			if(random.nextInt(100) <= 5) {
				if(ocupado) {
					ocupado = false;
					System.out.println("Modo ocupado desactivado");
					if(llamadas.size() > 0) {
						for(int i = 0; i < llamadas.size(); i++) {
							Llamada entrante = (Llamada) llamadas.get(i);
							entrante.mostrar(!ocupado);
						}
					}
					if(noticias.size() > 0) {
						for(int i = 0; i < noticias.size(); i++) {
							Noticia entrante = (Noticia) noticias.get(i);
							entrante.mostrar(!ocupado);
						}
					}
				}else {
					ocupado = true;
					System.out.println("Modo ocupado activado");
				}
			}
			
			if(tareas.size() > 0) {
				for(int i = 0; i < tareas.size(); i++) {
					Tarea entrante = (Tarea) tareas.get(i);
					entrante.mostrar();
				}
			}
			
			//pausa
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		/*if(KeyEvent.VK_1 == e.getKeyCode())
			if(ocupado) {
				ocupado = false;
				System.out.println("Modo ocupado desactivado");
				if(llamadas.size() > 0) {
					for(int i = 0; i < llamadas.size(); i++) {
						Llamada entrante = (Llamada) llamadas.get(i);
						entrante.mostrar(!ocupado);
					}
				}
				if(noticias.size() > 0) {
					for(int i = 0; i < noticias.size(); i++) {
						Noticia entrante = (Noticia) noticias.get(i);
						entrante.mostrar(!ocupado);
					}
				}
			}
			else {
				ocupado = true;
				System.out.println("Modo ocupado activado");
			}
		else if(KeyEvent.VK_2 == e.getKeyCode()) {
			String nuevaTarea;
			int horaTarea, minutoTarea;
			
			Scanner in = new Scanner(System.in);
			System.out.print("Ingrese nueva tarea: ");
			nuevaTarea = in.nextLine();
			System.out.print("Hora de la tarea: ");
			horaTarea = in.nextInt();
			System.out.print("Minutos de la tarea: ");
			minutoTarea = in.nextInt();
			
			tareas.add(new Tarea(nuevaTarea, horaTarea, minutoTarea));
		}*/
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}

//PROBLEMA CON IF DE TAREA, NO SE ACTUALIZAN LOS VALORES DE HORA
// FALTA ELIMINAR LLAMADAS Y NOTICIAS ENTRANTES Y LAS QUE SE ELIMINAN DE LA LISTA
// ARREGLAR FORMATO DE LOS MINUTOS (FALTA UN 0)
// CONFIGURAR MODO OCUPADO Y DESPLEGAR LISTA CUANDO SE SALGA DE ESTE MODO