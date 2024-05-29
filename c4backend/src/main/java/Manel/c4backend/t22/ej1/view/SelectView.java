package Manel.c4backend.t22.ej1.view;

import javax.swing.*;

public class SelectView extends JFrame{

	private JPanel jp;

	public SelectView() {
		setTitle("Select");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);
	}
}
