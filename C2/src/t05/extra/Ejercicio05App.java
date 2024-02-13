package t05.extra;

import java.util.Scanner;

public class Ejercicio05App {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String texto = sc.nextLine();
		boolean endLoop = false;
		
		for (int i = 0; i < texto.length()/2 && !endLoop; i++) {
			if (texto.charAt(i) != texto.charAt(texto.length()-1-i)) {
				endLoop = true;
			}
		}
		
		if (endLoop) {
			System.out.println("No es palíndromo");
		} else {
			System.out.println("Si es palíndromo");
		}
	}

}
