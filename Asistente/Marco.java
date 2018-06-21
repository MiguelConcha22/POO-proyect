package Asistente;

import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame{
	private static final long serialVersionUID = 1L;
	
	LaminaString lamina;
	LaminaTarea lamina2;
	
	public Marco() {
		//setLayout(new BorderLayout());
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/2, alturaPantalla/2);
		
		setTitle("Navi");
		
		Image navi = miPantalla.getImage("src/graficos/Navi.png");
		setIconImage(navi);
		
		lamina = new LaminaString(anchoPantalla/2, alturaPantalla/2 -80);
		lamina2 = new LaminaTarea(anchoPantalla/2, alturaPantalla/2);
		
		lamina2.setLayout(new FlowLayout());
		
		lamina.setBackground(Color.CYAN);
		lamina2.setBackground(Color.GREEN);
		
		//lamina.setPreferredSize(new Dimension(anchoPantalla/4, alturaPantalla/4));
		//lamina2.setPreferredSize(new Dimension(anchoPantalla/4, alturaPantalla/4));
		
		build(lamina, lamina2);
		/*add(lamina, BorderLayout.WEST);
		add(lamina2, BorderLayout.EAST);*/
	}
	
	public void build(LaminaString lamina, LaminaTarea lamina2) {
		JTabbedPane tab = new JTabbedPane();       
	    tab.addTab("Notificaciones", null, lamina, "Notificaciones");
	    tab.addTab("Agregar Tarea", null, lamina2, "Agregar Tarea");
	    add(tab); 
	}
	
	public void recargarLamina() {
		lamina.repaint();
	}
	
	/*public void actionPerformed(ActionEvent e) {
		String s1=tf1.getText();
		System.out.print(s1);
	}*/
}