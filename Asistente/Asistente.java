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
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Asistente extends JFrame implements KeyListener {
	
	boolean ocupado;
	boolean candadito;
	
	List <Llamada> llamadas;
	List <Noticia> noticias;
	List <Tarea> tareas;
	
	
	public Asistente() {
		addKeyListener(this);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      
		this.ocupado = false;
		this.candadito = false;
		
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
				
				if(this.ocupado) {
					this.noticias.add(new Noticia(numero));
				}else {
					Noticia noticiaEntrante = new Noticia(numero);
					noticiaEntrante.mostrar(this.ocupado);
					//ELIMINAR
				}
			}
			
			if(random.nextInt(100) <= 10) {
				numero = random.nextInt(60000000) + 40000000; //numero de telefono aleatorio
				
				if(this.ocupado) {
					this.llamadas.add(new Llamada(numero));
				}else {
					Llamada llamadaEntrante = new Llamada(numero);
					llamadaEntrante.mostrar(this.ocupado);
					//ELIMINAR
				}
			}
			
			/*if(random.nextInt(100) <= 10 && !this.candadito) {				
				String nuevaTarea;
				int horaTarea, minutoTarea;
				
				Scanner in = new Scanner(System.in);
				System.out.print("Ingrese nueva tarea: ");
				nuevaTarea = in.nextLine();
				System.out.print("Hora de la tarea: ");
				horaTarea = in.nextInt();
				System.out.print("Minutos de la tarea: ");
				minutoTarea = in.nextInt();
				
				this.tareas.add(new Tarea(nuevaTarea, horaTarea, minutoTarea));
				this.candadito = true;
				
			}
			
			if(random.nextInt(100) <= 5) {
				if(this.ocupado) {
					this.ocupado = false;
					System.out.println("Modo ocupado desactivado");
					if(this.llamadas.size() > 0) {
						for(int i = 0; i < this.llamadas.size(); i++) {
							Llamada entrante = (Llamada) this.llamadas.get(i);
							entrante.mostrar(!this.ocupado);
						}
					}
					if(this.noticias.size() > 0) {
						for(int i = 0; i < this.noticias.size(); i++) {
							Noticia entrante = (Noticia) this.noticias.get(i);
							entrante.mostrar(!this.ocupado);
						}
					}
				}else {
					this.ocupado = true;
					System.out.println("Modo ocupado activado");
				}
			}*/
			
			if(this.tareas.size() > 0) {
				for(int i = 0; i < this.tareas.size(); i++) {
					Tarea entrante = (Tarea) this.tareas.get(i);
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
	
	/*class DrawCanvas extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);
		}
	}*/
	
	public static void main(String[] args) {
		/*try {
            Asistente window = new Asistente();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
		new Asistente();
	}

	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_1 == e.getKeyCode())
			if(this.ocupado) {
				this.ocupado = false;
				System.out.println("Modo ocupado desactivado");
				if(this.llamadas.size() > 0) {
					for(int i = 0; i < this.llamadas.size(); i++) {
						Llamada entrante = (Llamada) this.llamadas.get(i);
						entrante.mostrar(!this.ocupado);
					}
				}
				if(this.noticias.size() > 0) {
					for(int i = 0; i < this.noticias.size(); i++) {
						Noticia entrante = (Noticia) this.noticias.get(i);
						entrante.mostrar(!this.ocupado);
					}
				}
			}
			else {
				this.ocupado = true;
				System.out.println("Modo ocupado activado");
			}
		else if(KeyEvent.VK_2 == e.getKeyCode()) {
			String nuevaTarea;
			int horaTarea, minutoTarea;
			
			Scanner in = new Scanner(System.in);
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

//PROBLEMA CON IF DE TAREA, NO SE ACTUALIZAN LOS VALORES DE HORA
// FALTA ELIMINAR LLAMADAS Y NOTICIAS ENTRANTES Y LAS QUE SE ELIMINAN DE LA LISTA
// ARREGLAR FORMATO DE LOS MINUTOS (FALTA UN 0)