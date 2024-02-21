package t06;

import javax.swing.JOptionPane;

public class Ejercicio05App {

	public static void main(String[] args) {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero decimal"));
		JOptionPane.showMessageDialog(null, numero + " en binario es " + toBinary(numero));
	}

	public static String toBinary(int n) {
		if (n == 0) {
			return "0";
		}
		
		String binario = "";

		while (n > 0) {
			binario += n % 2;
			n /= 2;

		}

		binario = reverseString(binario);

		return binario;
	}

	public static String reverseString(String s) {
		String aux = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			aux += s.charAt(i);
		}

		return aux;
	}
}
