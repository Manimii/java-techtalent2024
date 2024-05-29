package Manel.c4backend.t22.ej1.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Manel.c4backend.t22.ej1.controller.Listeners;

public class Startmenu extends JFrame{
	
	private JPanel jp;
	
	public Startmenu() {
		JFrame frame = new JFrame();
		
		setTitle("Clientes");
		setSize(400, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);
		
		// Label
		JLabel titulo = new JLabel("Selecciona la función que quieres hacer en la tabla clientes", SwingConstants.CENTER);
		titulo.setBounds(0, 10, 400, 20);
		jp.add(titulo);
		
		// Combo Box
		final JComboBox<String> selectMenu = new JComboBox<String>();
		selectMenu.addItem("Insertar datos");
		selectMenu.addItem("Mostrar datos");
		selectMenu.addItem("Actualizar datos");
		selectMenu.addItem("Borrar datos");
		selectMenu.setBounds(140, 40, 120, 20);
		jp.add(selectMenu);
		
		// Button
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(150, 70, 100, 30);
		jp.add(confirmar);
		
		// Action Listener
		ActionListener alConfirmar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Listeners.selectMenu(selectMenu, );
			}
			
		};
		
		confirmar.addActionListener(alConfirmar);
		
		
		
		
		
	}

}
