package Asistente;

//NO SE OCUPA

import javax.swing.*;
import java.awt.*;

public class Lamina extends JPanel{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawString("hola", 100, 100);
	}

}
