package Manel.c4backend.t22.ej1.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Manel.c4backend.t22.ej1.controller.Conexiones;
import Manel.c4backend.t22.ej1.controller.Listeners;
import Manel.c4backend.t22.ej1.model.Cliente;


public class InsertVideosView extends JFrame{

    private JPanel jp;
    private ArrayList<Cliente> clientes;

    public InsertVideosView(final Conexiones c, final String tabla, final String db) {
        setTitle("Insert");
		setSize(400, 240);
		setLocationRelativeTo(null);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

        // Label
		JLabel lTexto = new JLabel("Introduce los datos", SwingConstants.CENTER);
		lTexto.setBounds(0, 10, 400, 20);
		jp.add(lTexto);

		// Label
		JLabel lTitulo = new JLabel("Título");
		lTitulo.setBounds(100, 40, 50, 20);
		jp.add(lTitulo);

		// Text Field
		final JTextField tfTitulo = new JTextField();
		tfTitulo.setBounds(170, 40, 100, 20);
		jp.add(tfTitulo);

        // Label
		JLabel lDirector = new JLabel("Director");
		lDirector.setBounds(100, 70, 50, 20);
		jp.add(lDirector);

		// Text Field
		final JTextField tfDirector = new JTextField();
		tfDirector.setBounds(170, 70, 100, 20);
		jp.add(tfDirector);

        // Label
		JLabel lClientId = new JLabel("ID Cliente");
		lClientId.setBounds(100, 100, 60, 20);
		jp.add(lClientId);

		// Combo Box
        List<String> select = new ArrayList<>();
		select.add("id");
        clientes = c.selectClienteData("clientes", select, "cliente", "", "", "", "");

		final JComboBox<Integer> cbClientId = new JComboBox<Integer>();
        for (int i = 1; i <= clientes.size(); i++) {
			cbClientId.addItem(i);

		}
		cbClientId.setBounds(170, 100, 100, 20);
		jp.add(cbClientId);

        // Button
		JButton boton = new JButton("Añadir registro");
		boton.setBounds(140, 150, 120, 30);
		jp.add(boton);

		// ActionListener
		ActionListener alBoton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                Listeners.addVideosRegistro(tfTitulo, tfDirector, cbClientId, c);
			}

		};
		
		boton.addActionListener(alBoton);

        // Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        Startmenu sm = new Startmenu(c, tabla, db);
		    }
		});
    }
}
