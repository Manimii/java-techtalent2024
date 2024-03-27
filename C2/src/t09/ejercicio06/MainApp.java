package t09.ejercicio06;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Pelicula p = new Pelicula("Titánic", 120, 12, "Director");
		Cine c = new Cine(p, 20, 8, 8);

		int capacidad = c.getColumnas() * c.getFilas();
		Asiento[][] asientos = new Asiento[c.getFilas()][c.getColumnas()];

		System.out.println("Introduce el número de espectadores que van al cine:");
		int n = sc.nextInt();
		Espectador[] espectadores = new Espectador[n];
		generarEspectadores(n, espectadores);
	}

	public static void sentarEspectadores(Espectador[] espectadores, int capacidad, Cine c, Asiento[][] asientos) {
		int count = 0;
		while (count < capacidad && count < espectadores.length) {
			int fila = generarAsiento(c.getFilas());
			int columna = generarAsiento(c.getColumnas());
			if (asientos[fila][columna].isOcupado()) {
				//ESTOY AQUÍ
			}
			count++;
		}
	}

	public static int generarAsiento(int n) {
		return (int) Math.random() * n;
	}

	public static void generarEspectadores(int n, Espectador[] espectadores) {
		for (int i = 0; i < n; i++) {
			espectadores[i] = new Espectador();
		}
	}

	public static boolean puedeSentarse(Espectador e, Cine c, Pelicula p, Asiento a, int nEspectadores) {
		return (tieneDinero(e, c) && hayEspacio(c, nEspectadores) && tieneEdad(p, e));
	}

	public static boolean tieneDinero(Espectador e, Cine c) {
		return (e.getDinero() >= c.getPrecio());
	}

	public static boolean hayEspacio(Cine c, int nEspectadores) {
		return (nEspectadores < (c.getColumnas() * c.getFilas()));
	}

	public static boolean tieneEdad(Pelicula p, Espectador e) {
		return (e.getEdad() >= p.getEdadMinima());
	}

}
