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
		
		//g.setColor(Color.RED);
		g.drawString("In busy mode, you will only", this.posX - 180, 10);
		g.drawString("get notifications from tasks", this.posX - 180, 30);
		
		for(int i = 0; i < this.palabras.size(); i++) {
			g.drawString(this.palabras.get(i), 10, this.posY - (palabras.size() - i - 1) * 20);
		}
	}

}