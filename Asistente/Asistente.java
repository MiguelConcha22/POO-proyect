/**
 * Asistente personal que recibe llamadas y noticias
 * Se pueden agregar tareas por hacer
 * 
 * Fue necesario utilizar JFrame para poder implementar KeyListener
 * 
 * Para entrar en modo ocupado: presionar "1"
 * Para agregar una tarea: presionar "2"
 */

package Asistente;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class Asistente extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;

	boolean ocupado;
	
	List <Llamada> llamadas;
	List <Noticia> noticias;
	List <Tarea> tareas;

	private Scanner in;
	
	Marco miMarco;
	
	public Asistente() {
		
		miMarco = new Marco();
		
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.addKeyListener(this);
			      
		this.ocupado = false;
		
		this.llamadas = new ArrayList<>();
		this.noticias = new ArrayList<>();
		this.tareas = new ArrayList<>();
		
		Random random = new Random();
		int numero;
		
		while(true) {
			//System.out.println(this.ocupado);
			
			if(random.nextInt(100) <= 10) {
				//se utiliza un numero random para darle un nombre aleatorio a la noticia
				numero = random.nextInt(400) + 100;
				
				generaNoticia(numero);
			}
			
			if(random.nextInt(100) <= 10) {
				//numero de telefono aleatorio
				numero = random.nextInt(60000000) + 40000000;
				
				generaLlamada(numero);
			}
			
			mostrarTareas();
			
			pausa(1000);
		}
	}
	
	public void generaLlamada(int numero) {
		if(this.ocupado) {
			this.llamadas.add(new Llamada(numero));
		}else {
			Llamada llamadaEntrante = new Llamada(numero);
			llamadaEntrante.mostrar(this.ocupado, miMarco);
			//ELIMINAR
		}
	}
	
	public void generaNoticia(int numero) {
		if(this.ocupado) {
			this.noticias.add(new Noticia(numero));
		}else {
			Noticia noticiaEntrante = new Noticia(numero);
			noticiaEntrante.mostrar(this.ocupado, miMarco);
			//ELIMINAR
		}
	}
	
	public void mostrarTareas() {
		if(this.tareas.size() > 0) {
			for(int i = 0; i < this.tareas.size(); i++) {
				Tarea entrante = (Tarea) this.tareas.get(i);
				entrante.mostrar();
			}
		}
	}
	
	public void pausa(int numero) {
		try {
			Thread.sleep(numero);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Asistente();
	}

	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_1 == e.getKeyCode())
			if(this.ocupado) {
				this.ocupado = false;
				System.out.println("Modo ocupado desactivado");
				miMarco.lamina.agregarPalabra("Modo ocupado desactivado");
				miMarco.recargarLamina();
				if(this.llamadas.size() > 0) {
					for(int i = 0; i < this.llamadas.size(); i++) {
						Llamada entrante = (Llamada) this.llamadas.get(i);
						entrante.mostrar(!this.ocupado, miMarco);
					}
				}
				if(this.noticias.size() > 0) {
					for(int i = 0; i < this.noticias.size(); i++) {
						Noticia entrante = (Noticia) this.noticias.get(i);
						entrante.mostrar(!this.ocupado, miMarco);
					}
				}
			}
			else {
				this.ocupado = true;
				System.out.println("Modo ocupado activado");
				miMarco.lamina.agregarPalabra("Modo ocupado activado");
				miMarco.recargarLamina();
			}
		else if(KeyEvent.VK_2 == e.getKeyCode()) {
			String nuevaTarea;
			int horaTarea, minutoTarea;
			
			in = new Scanner(System.in);
			System.out.print("Ingrese nueva tarea: ");
			nuevaTarea = in.nextLine();
			System.out.print("Hora de la tarea: "); //solo hora
			horaTarea = in.nextInt();
			System.out.print("Minutos de la hora: "); //minutos de la hora
			minutoTarea = in.nextInt();
			
			this.tareas.add(new Tarea(nuevaTarea, horaTarea, minutoTarea));
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}

// PREGUNTAR POR RRSS
// PREGUNTAR POR "NUMEROS REALES"

// CAMBIAR COLORES PALABRAS
// SEPARAR HORAS
// AGREGAR TAREA DESDE INTERFAZ GRAFICA
// PONER INSTRUCCIONES

// PROBLEMA CON IF DE TAREA, NO SE ACTUALIZAN LOS VALORES DE HORA
// FALTA ELIMINAR LLAMADAS Y NOTICIAS ENTRANTES Y LAS QUE SE ELIMINAN DE LA LISTA
// ARREGLAR FORMATO DE LOS MINUTOS (FALTA UN 0)