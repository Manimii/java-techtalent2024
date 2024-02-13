package t05.extra2;

import javax.swing.JOptionPane;

public class Ejercicio02App {

	public static void main(String[] args) {
		String texto = JOptionPane.showInputDialog("Introduce un texto de cuatro o más caracteres");
		String resultado = "Los dos primeros caracteres son distintos a los dos últimos";

		String inicio = texto.substring(0, 2);
		String ultimo = texto.substring(texto.length() - 2);

		if (inicio.equals(ultimo)) {
			resultado = "Los dos primeros caracteres son iguales a los dos últimos";
		}

		JOptionPane.showInternalMessageDialog(null, resultado);
	}

}
