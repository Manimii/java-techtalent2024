package t06;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ejercicio10App {

	public static void main(String[] args) {
		int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la array"));
		int array[] = new int[tamaño];
	}

	public static boolean esPrimo(int num) {
		boolean endLoop = false;

		for (int i = 2; i <= (num/2) && !endLoop; i++) {
			if (num % i == 0) {
				endLoop = true;
			}
		}
		
		return !endLoop;
		
	}
	
	public static int nrandom(int start, int end) {
		Random r = new Random();
		int num = r.nextInt(end - start + 1) + start;
		return num;
		
	}
}
