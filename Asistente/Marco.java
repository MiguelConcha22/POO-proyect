package Asistente;

import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame{
	private static final long serialVersionUID = 1L;
	
	LaminaString lamina;
	
	public Marco() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/4, alturaPantalla/2);
		
		setTitle("Navi");
		
		Image navi = miPantalla.getImage("src/graficos/Navi.png");
		setIconImage(navi);
		
		lamina = new LaminaString(10, alturaPantalla/2 -50);
		/*lamina.agregarPalabra("hola");
		lamina.agregarPalabra("chao");
		lamina.agregarPalabra("jaja");*/
		add(lamina);
	}
	
	public void recargarLamina() {
		lamina.repaint();
	}
}
