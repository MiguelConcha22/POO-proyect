package Asistente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LaminaTarea extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	List <Tarea> tareas;
	
	JLabel l1, l2, l3;
	JTextField tf1;
	JSpinner spinner1, spinner2;
	JButton b1;
	
	public LaminaTarea(int ancho, int alto) {
		
		this.tareas = new ArrayList<>();
		
		l1 = new JLabel("Ingresar Tarea:");
		
		tf1 = new JTextField();
		tf1.setPreferredSize(new Dimension(150, 20));
		
		l2 = new JLabel("Horas:");
		
		String[] hours = new String[24];
		for(int i = 0; i < 24; i++) {
			hours[i] = String.valueOf(i);
		}
		SpinnerListModel model1 = new SpinnerListModel(hours);
		spinner1 = new JSpinner(model1);
		spinner1.setPreferredSize(new Dimension(40, 20));
		
		l3 = new JLabel("Minutos:");
		
		String[] minutes = new String[61];
		for(int i = 0; i <= 60; i++) {
			minutes[i] = String.valueOf(i);
		}
		SpinnerListModel model2 = new SpinnerListModel(minutes);
		spinner2 = new JSpinner(model2);
		spinner2.setPreferredSize(new Dimension(40, 20));
        
		b1 = new JButton("Ingresar");
		b1.addActionListener(this);
		
		add(l1);
		add(tf1);
		add(l2);
		add(spinner1);
		add(l3);
		add(spinner2);
		add(b1);
	}
	
	public void actionPerformed(ActionEvent e) {
		String nuevaTarea = tf1.getText();
		int hour = Integer.parseInt((String) spinner1.getValue());
		int minute = Integer.parseInt((String) spinner2.getValue());
		
		this.tareas.add(new Tarea(nuevaTarea, hour, minute));
		//System.out.print(nuevaTarea + String.valueOf(hour) + String.valueOf(minute));
		
		tf1.setText("");
		spinner1.setValue("0");
		spinner2.setValue("0");
	}

}