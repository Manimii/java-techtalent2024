package t05;

import javax.swing.JOptionPane;

public class Ejercicio11App {

	public static void main(String[] args) {
		String dia = JOptionPane.showInputDialog("Introduce un día de la semana");

		switch (dia) {
		case "lunes", "martes", "miércoles", "jueves", "viernes":
			JOptionPane.showInternalMessageDialog(null, "Día laboral");
			break;

		case "sábado", "domingo":
			JOptionPane.showInternalMessageDialog(null, "Día no laboral");
			break;

		default:
			JOptionPane.showInternalMessageDialog(null, "Error");
			break;
		}
	}

}
