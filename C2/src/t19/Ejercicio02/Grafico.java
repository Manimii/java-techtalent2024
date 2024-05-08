package t19.Ejercicio02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Grafico extends JFrame {

	private JPanel cp;

	public Grafico() {
		setTitle("Películas");
		setSize(470, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Panel
		cp = new JPanel();
		cp.setLayout(null);
		setContentPane(cp);

		// Label
		JLabel label1 = new JLabel("Escribe el título de una película");
		label1.setBounds(20, 30, 178, 20);
		cp.add(label1);

		// TextField
		JTextField tf1 = new JTextField();
		tf1.setBounds(30, 80, 150, 20);
		cp.add(tf1);

		// Label
		JLabel label2 = new JLabel("Películas");
		label2.setBounds(300, 30, 65, 20);
		cp.add(label2);

		// ComboBox
		JComboBox<String> cb = new JComboBox<>();
		cb.setBounds(250, 80, 150, 20);
		cp.add(cb);

		// ActionListener
		ActionListener al1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pelicula = tf1.getText();
				cb.addItem(pelicula);

			}

		};

		// Button
		JButton bt1 = new JButton("Añadir");
		bt1.setBounds(40, 130, 84, 20);
		bt1.addActionListener(al1);
		cp.add(bt1);

	}

}
