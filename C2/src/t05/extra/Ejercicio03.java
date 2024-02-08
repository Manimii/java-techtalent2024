package t05.extra;

import javax.swing.JOptionPane;

public class Ejercicio03 {

	public static void main(String[] args) {
		int suma = 0;
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		
		while (num > 0) {
			suma += num;
			num--;
		}
		
		System.out.println(suma);
	}

}
