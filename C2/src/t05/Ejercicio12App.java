package t05;

import javax.swing.JOptionPane;

public class Ejercicio12App {

	public static void main(String[] args) {
		String password = "abc123";
		String intento = "";
		int nintentos = 3;

		while (!intento.equals(password) && nintentos > 0) {
			intento = JOptionPane.showInputDialog("Introduce la contraseña (" + nintentos + " intentos)");
			nintentos--;
		}

		if (intento.equals(password)) {
			JOptionPane.showMessageDialog(null, "Enhorabuena! =)");
		} else {
			JOptionPane.showMessageDialog(null, "Contraseñas incorrectas :(");
		}

	}

}
