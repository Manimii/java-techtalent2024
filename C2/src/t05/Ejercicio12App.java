package t05;

import javax.swing.JOptionPane;

public class Ejercicio12App {

	public static void main(String[] args) {
		String password = "abc123";
		String intento = "";
		int nIntentos = 3;

		while (!intento.equals(password) && nIntentos > 0) {
			intento = JOptionPane.showInputDialog("Introduce la contraseña (" + nIntentos + " intentos)");
			nIntentos--;
		}

		if (intento.equals(password)) {
			JOptionPane.showMessageDialog(null, "Enhorabuena! =)");
		} else {
			JOptionPane.showMessageDialog(null, "Contraseñas incorrectas :(");
		}

	}

}
