package Asistente;

import javax.swing.*;
import java.awt.*;

public class Lamina extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawString("hola", 100, 100);
	}

}
