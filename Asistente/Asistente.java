/**
 * Asistente personal que recibe llamadas y noticias de Twitter
 * Se pueden agregar tareas por hacer y avisa cuando faltan 5 minutos
 * 
 * Se utiliza JFrame, JPanel y diversos elementos de JavaSwing
 * 
 * Para obtener las noticias de Twitter se utiliza twitter5j
 * 
 * Las clases TwitterTest y Lamina, no se utilizan, fueron creadas para
 * realizar pruebas y configurar elementos
 * 
 */

package Asistente;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.util.Calendar;
//import java.util.Scanner;

import twitter4j.TwitterException;

import java.awt.event.*;
import java.io.IOException;

public class Asistente extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	boolean ocupado;
	
	List <Llamada> llamadas;
	//List <Tarea> tareas;

	//private Scanner in;
	
	Marco miMarco;
	
	TwitterStreamTest twStream;
	
	JButton busy;
	
	Calendar calendario = Calendar.getInstance();
	int hora, minuto;
	
	public Asistente() throws TwitterException, IOException {
		miMarco = new Marco();
		
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//miMarco.addKeyListener(this);
		
		busy = new JButton("ON/OFF Busy Mode");
		busy.addActionListener(this);
		miMarco.lamina.add(busy);
		
		twStream = new TwitterStreamTest();
		twStream.start(miMarco);
			      
		this.ocupado = false;
		
		this.llamadas = new ArrayList<>();
		//this.tareas = new ArrayList<>();
		
		Random random = new Random();
		int numero;
		
		while(true) {
			//System.out.println(this.ocupado);
			this.calendario = Calendar.getInstance();
			
			this.hora = calendario.get(Calendar.HOUR_OF_DAY);
			this.minuto = calendario.get(Calendar.MINUTE);
			
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
	
	/*public void generaNoticia(String numero) {
		if(this.ocupado) {
			this.noticias.add(new Noticia(numero));
		}else {
			Noticia noticiaEntrante = new Noticia(numero);
			noticiaEntrante.mostrar(this.ocupado, miMarco);
		}
	}*/
	
	public void mostrarTareas() {
		if(miMarco.lamina2.tareas.size() > 0) {
			for(int i = 0; i < miMarco.lamina2.tareas.size(); i++) {
				Tarea entrante = (Tarea) miMarco.lamina2.tareas.get(i);
				entrante.mostrar(this.hora, this.minuto, miMarco);
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
	
	public static void main(String[] args) throws TwitterException, IOException {
		new Asistente();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.ocupado) {
			this.ocupado = false;
			twStream.ocupado = false;
			//System.out.println("Modo ocupado desactivado");
			miMarco.lamina.agregarPalabra("Modo ocupado desactivado");
			miMarco.recargarLamina();
			if(this.llamadas.size() > 0) {
				for(int i = 0; i < this.llamadas.size(); i++) {
					Llamada entrante = (Llamada) this.llamadas.get(i);
					entrante.mostrar(!this.ocupado, miMarco);
				}
				this.llamadas.clear();
			}
			if(twStream.noticias.size() > 0) {
				for(int i = 0; i < twStream.noticias.size(); i++) {
					Noticia entrante = (Noticia) twStream.noticias.get(i);
					entrante.mostrar(!this.ocupado, miMarco);
				}
				twStream.noticias.clear();
			}
		}
		else {
			this.ocupado = true;
			twStream.ocupado = true;
			//System.out.println("Modo ocupado activado");
			miMarco.lamina.agregarPalabra("Modo ocupado activado");
			miMarco.recargarLamina();
		}
	}

	/*public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_1 == e.getKeyCode())
			if(this.ocupado) {
				this.ocupado = false;
				twStream.ocupado = false;
				System.out.println("Modo ocupado desactivado");
				miMarco.lamina.agregarPalabra("Modo ocupado desactivado");
				miMarco.recargarLamina();
				if(this.llamadas.size() > 0) {
					for(int i = 0; i < this.llamadas.size(); i++) {
						Llamada entrante = (Llamada) this.llamadas.get(i);
						entrante.mostrar(!this.ocupado, miMarco);
					}
				}
				if(twStream.noticias.size() > 0) {
					for(int i = 0; i < twStream.noticias.size(); i++) {
						Noticia entrante = (Noticia) twStream.noticias.get(i);
						entrante.mostrar(!this.ocupado, miMarco);
					}
				}
			}
			else {
				this.ocupado = true;
				twStream.ocupado = true;
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
	}*/
}

// CUANDO LOS MINUTOS SON MENORES A 10, HAY UN PEQUEÑO "ERROR" EN EL FORMATO