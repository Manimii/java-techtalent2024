package tests;

import java.util.Scanner;

public class HorasApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hora = sc.nextInt();

		if (hora > 0 && hora < 12) {
			System.out.println("Buenos días");
		} else if (hora >= 12 && hora < 20) {
			System.out.println("Buenas tardes");
		} else {
			System.out.println("Buenas noches");
		}
	}

}
