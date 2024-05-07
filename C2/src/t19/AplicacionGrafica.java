package t19;

import javax.swing.*;

public class AplicacionGrafica extends JFrame{
	
	private JPanel contentPane;

	public AplicacionGrafica() {
		setTitle("Título de la ventana");
		setBounds(400,200,640,375);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//Creación de la ventana
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//Etiqueta "Hola Mundo"
		JLabel etiqueta = new JLabel("¡Hola Mundo!");
		etiqueta.setBounds(30,20,100,20);
		contentPane.add(etiqueta);
		
		//Textfield de Hola Mundo
		JTextField textField = new JTextField();
		textField.setBounds(30,40,86,26);
		contentPane.add(textField);
		
		//Botón de Hola Mundo
		JButton boton = new JButton("Enviar");
		boton.setBounds(30,70,89,23);
		contentPane.add(boton);
		
		//RadioButtons
		JRadioButton radioButton1 = new JRadioButton("Opción 1", false);
		radioButton1.setBounds(30,130,109,23);
		contentPane.add(radioButton1);
		
		JRadioButton radioButton2 = new JRadioButton("Opción 2", false);
		radioButton2.setBounds(30,155,109,23);
		contentPane.add(radioButton2);
		
		JRadioButton radioButton3 = new JRadioButton("Opción 3", false);
		radioButton3.setBounds(30,180,109,23);
		contentPane.add(radioButton3);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(radioButton1);
		bgroup.add(radioButton2);
		bgroup.add(radioButton3);
		
		//CheckBoxs
		JCheckBox check1 = new JCheckBox("Opción 1", false);
		check1.setBounds(30,240,97,23);
		contentPane.add(check1);
		
		JCheckBox check2 = new JCheckBox("Opción 2", false);
		check2.setBounds(30,265,97,23);
		contentPane.add(check2);
		
		JCheckBox check3 = new JCheckBox("Opción 3", false);
		check3.setBounds(30,290,97,23);
		contentPane.add(check3);
		
		//TextArea
		JTextArea textarea = new JTextArea();
		textarea.setBounds(180,20,141,117);
		textarea.setWrapStyleWord(true);
		contentPane.add(textarea);
		
		JScrollPane scroll = new JScrollPane(textarea);
		scroll.setBounds(180,20,141,117);
		contentPane.add(scroll);
	}
}
