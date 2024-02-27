package t07;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ejercicio01App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Número de alumnos del curso:");
		int nAlumnos = sc.nextInt();
		System.out.println("Número de asignaturas del curso:");
		int nAsignaturas = sc.nextInt();
		sc.nextLine();

		ArrayList<Double> notas = new ArrayList<Double>();
		HashMap<String, Double> notasAlumnos = new HashMap<>();

		introduceNotas(notas, notasAlumnos, nAlumnos, nAsignaturas);
		System.out.println("Notas medias de los alumnos:\n" + notasAlumnos.toString());
		sc.close();
	}

	public static double calcularMedia(ArrayList<Double> a) {
		double suma = 0;

		Iterator<Double> i = a.iterator();
		while (i.hasNext()) {
			suma += i.next();
		}

		return suma / (double) a.size();
	}

	public static void introduceNotas(ArrayList<Double> a, HashMap<String, Double> h, int n, int m) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < n; i++) {
			System.out.println("Nombre del alumno " + i);
			String alumno = sc.nextLine();

			for (int j = 0; j < m; j++) {
				System.out.println("Introduce la nota de " + alumno + " de la asignatura " + j);
				a.add(sc.nextDouble());
			}
			sc.nextLine();

			double media = calcularMedia(a);
			a.clear();

			h.put(alumno, media);
		}
		sc.close();
	}

}
