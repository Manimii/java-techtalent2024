package Manel.c4backend.t22.ej1.view;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Manel.c4backend.t22.ej1.controller.Conexiones;
import Manel.c4backend.t22.ej1.controller.Listeners;
import Manel.c4backend.t22.ej1.model.Cientificos;
import Manel.c4backend.t22.ej1.model.Proyecto;

public class InsertAsignadoaView extends JFrame {

    private JPanel jp;
    private ArrayList<Cientificos> cientificos;
    private ArrayList<Proyecto> proyectos;

    public InsertAsignadoaView(final Conexiones c, final String tabla, final String db) {
        setTitle("Insert");
        setSize(400, 230);
        setLocationRelativeTo(null);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel titulo = new JLabel("Introduce los datos", SwingConstants.CENTER);
        titulo.setBounds(0, 10, 400, 20);
        jp.add(titulo);

        // Label
        JLabel lCientifico = new JLabel("Científico");
        lCientifico.setBounds(100, 40, 50, 20);
        jp.add(lCientifico);

        // Combo Box
        List<String> selectCientificos = new ArrayList<>();
        selectCientificos.add("dni");
        
        cientificos = c.selectCientificosData(db, selectCientificos, "cientificos", "", "", "", "");
        final JComboBox<String> cbCientifico = new JComboBox<String>();

        for (int i = 0; i < cientificos.size(); i++) {
            cbCientifico.addItem(cientificos.get(i).getDni());

        }
        cbCientifico.setBounds(170, 40, 100, 20);
        jp.add(cbCientifico);

        // Label
        JLabel lProyecto = new JLabel("Proyecto");
        lProyecto.setBounds(100, 70, 70, 20);
        jp.add(lProyecto);

        // Combo Box
        List<String> selectProyectos = new ArrayList<>();
        selectProyectos.add("id");

        proyectos = c.selectProyectoData(db, selectProyectos, "proyecto", "", "", "", "");
        final JComboBox<String> cbProyecto = new JComboBox<String>();

        for (int i = 0; i < proyectos.size(); i++) {
            cbProyecto.addItem(proyectos.get(i).getId());

        }
        cbProyecto.setBounds(170, 70, 100, 20);
        jp.add(cbProyecto);

        // Button
        JButton boton = new JButton("Añadir registro");
        boton.setBounds(140, 120, 120, 30);
        jp.add(boton);

        // ActionListener
        ActionListener alBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Listeners.addAsignadoARegistro(cbCientifico, cbProyecto, c);
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
