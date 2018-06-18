package Asistente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LaminaString extends JPanel{
	private static final long serialVersionUID = 1L;
	
	List <String> palabras;
	int posX, posY;
	
	public LaminaString(int posX, int posY) {
		this.palabras = new ArrayList<>();
		this.posX = posX;
		this.posY = posY;
	}
	
	public void agregarPalabra(String palabra) {
		this.palabras.add(palabra);
	}
	
	/*public void correrLista() {
		this.posY -= 20;
	}*/
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for(int i = 0; i < this.palabras.size(); i++) {
			g.drawString(this.palabras.get(i), this.posX, this.posY - (palabras.size() - i - 1) * 20);
		}
	}

}