package t19.Ejercicio01;

import java.awt.event.*;

import javax.swing.*;

public class Grafico extends JFrame{

	private JPanel cp;

	public Grafico() {
		setTitle("Saludador");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//Panel
		cp = new JPanel();
		cp.setLayout(null);
		setContentPane(cp);
		
		//Label
		JLabel label1 = new JLabel("Escribe un nombre para saludar");
		label1.setBounds(55,50,300,20);
		cp.add(label1);
		
		//TextField
		JTextField tf1 = new JTextField();
		tf1.setBounds(30,100,230,20);
		cp.add(tf1);
		
		//ActionListener
		ActionListener al1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = tf1.getText();
				JOptionPane.showMessageDialog(null, "¡Hola " + s + "!");
				
			}
			
		};
		
		//Button
		JButton bt1 = new JButton("¡Saludar!");
		bt1.setBounds(100,150,84,20);
		bt1.addActionListener(al1);
		cp.add(bt1);
	
	}
}
