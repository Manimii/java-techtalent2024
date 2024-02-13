package t05.extra2;

import javax.swing.JOptionPane;

public class Ejercicio03App {

	public static void main(String[] args) {
		String texto = JOptionPane.showInputDialog("Introduce un texto");
		String resultado = "'abc' No se encuentra en el texto que has introducido";

		boolean found = false;

		for (int i = 1; i < texto.length() - 3 && !found; i++) {
			String substr = texto.substring(i, i + 3);
			if (substr.equals("abc")) {
				resultado = "'abc' se encuentra en el texto que has introducido en la posición " + i;
				found = true;
			}
		}

		JOptionPane.showMessageDialog(null, resultado);
	}

}
