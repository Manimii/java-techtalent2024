package t05.extra2;

import javax.swing.JOptionPane;

public class Ejercicio04App {

	public static void main(String[] args) {
		String texto = JOptionPane.showInputDialog("Introduce un texto de tres o más caracteres");
		int index = Integer.parseInt(JOptionPane.showInputDialog("Introduce un índice"));
		String resultado = "Los caracteres anterior y posterior al índice son distintos";
		
		if (index < texto.length() - 1 && index > 0 && (texto.charAt(index - 1) == texto.charAt(index + 1))) {
			resultado = "Los caracteres anterior y posterior al índice son iguales";
		}

		System.out.println(resultado);
	}

}
