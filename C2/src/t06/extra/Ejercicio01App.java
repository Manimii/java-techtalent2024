package t06.extra;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio01App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el número de alumnos de la clase");
		int nAlumnos = sc.nextInt();

		int notas[] = new int[nAlumnos];
		rellenaNotas(notas);

		System.out.println("La nota media de los alumnos es " + calculaMedia(notas));
	}

	public static void rellenaNotas(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota del alumno " + i));
		}
	}
	
	public static double calculaMedia(int[] a) {
		double media = 0;
		double suma = 0;
		
		for (int i = 0; i < a.length; i++) {
			suma += a[i];
		}
		
		media = suma / a.length;
		return media;
	}
}
