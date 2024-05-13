package t10.ejercicio05;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0, longitud = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.print("Tamaño de la array: ");
				n = sc.nextInt();
				System.out.print("Longitud de las contraseñas: ");
				longitud = sc.nextInt();
				Password[] passwords = new Password[n];
				boolean[] esfuerte = new boolean[n];

				for (int i = 0; i < passwords.length; i++) {
					passwords[i] = new Password(longitud);
					esfuerte[i] = passwords[i].esFuerte();
					System.out.println(passwords[i].getPass() + " " + esfuerte[i]);
				}
				error = false;
			} catch (Exception e) {
				System.out.println("Error de input. Debes introducir números.");
				sc.next();
			}
		}

		sc.close();
	}

}
