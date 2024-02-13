package t05.extra2;

import javax.swing.JOptionPane;

public class Ejercicio01App {

	public static void main(String[] args) {

		String texto = JOptionPane.showInputDialog("Introduce un texto de dos o más caracteres");
		String resultado = "Los dos primeros caracteres son distintos";

		if (texto.charAt(0) == texto.charAt(1)) {
			resultado = "Los dos primeros caracteres son iguales";
		}

		JOptionPane.showMessageDialog(null, resultado);
	}

}
