package tests;

import java.text.SimpleDateFormat;
import java.util.Date;
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

		Date fecha = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat("h");
		int horadia = Integer.parseInt(formatoHora.format(fecha));
		
		switch (horadia) {
		case 9:
			System.out.println("Buenos días");
			break;
		case 10:
			System.out.println("Buenas tardes");
			break;
		}
	}

}
