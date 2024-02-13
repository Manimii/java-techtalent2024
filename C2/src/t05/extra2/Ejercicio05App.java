package t05.extra2;

import javax.swing.JOptionPane;

public class Ejercicio05App {

	public static void main(String[] args) {
		String texto = JOptionPane.showInputDialog("Introduce un texto");
		int count = 0;

		for (int i = 0; i < texto.length() && count < 3; i++) {
			if (texto.charAt(i) == 'a') {
				count++;
				if (count == 2) {
					System.out.println("Índice de la segunda ocurrencia: " + i);
				} else if (count == 3) {
					System.out.println("Índice de la tercera ocurrencia: " + i);
				}
			}
		}
	}

}
