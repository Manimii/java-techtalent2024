package t09.ejercicio06;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Pelicula p = new Pelicula("Titánic", 120, 12, "Director");
		Cine c = new Cine(p, 20, 8, 8);

		int capacidad = c.getColumnas() * c.getFilas();
		Asiento[][] asientos = new Asiento[c.getFilas()][c.getColumnas()];

		rellenarAsientos(asientos);
		dibujarCine(asientos);

		System.out.println("Introduce el número de espectadores que van al cine:");
		int n = sc.nextInt();
		Espectador[] espectadores = new Espectador[n];
		
		generarEspectadores(n, espectadores);
		sentarEspectadores(espectadores, capacidad, c, asientos, p);
		dibujarCine(asientos);
		
		sc.close();
	}

	public static void sentarEspectadores(Espectador[] espectadores, int capacidad, Cine c, Asiento[][] asientos, Pelicula p) {
		int count = 0;
		//Mientras queden espectadores por asignarle un asiento y quede espacio en la sala	
		while (count < espectadores.length && hayEspacio(asientos)) {
			int fila = generarAsiento(c.getFilas());
			int columna = generarAsiento(c.getColumnas());
			//Genera un nuevoasiento si el asiento que ha generado está ocupado 
			while (asientos[fila][columna].isOcupado()) {
				fila = generarAsiento(c.getFilas());
				columna = generarAsiento(c.getColumnas());
			}
			if (puedeSentarse(espectadores[count], c, p, asientos)) {
				asientos[fila][columna].ocuparAsiento();	
			} else {
				System.out.println(espectadores[count].getNombre() + " No puede ver la película.");
			}
			count++;
		}
	}

	public static int generarAsiento(int n) {
		return (int) (Math.random() * n);
	}

	public static void generarEspectadores(int n, Espectador[] espectadores) {
		for (int i = 0; i < n; i++) {
			espectadores[i] = new Espectador();
			//System.out.println(espectadores[i].toString());
		}
	}

	public static void dibujarCine(Asiento[][] asientos) {
		for (int i = asientos.length - 1; i >= 0; i--) {
			for (int j = 0; j < asientos[i].length; j++) {
				Asiento asientoActual = asientos[i][j];
				System.out.print(Integer.toString(asientoActual.getfila()) + asientoActual.getcolumna() + "(");
				if (asientoActual.isOcupado()) {
					System.out.print("X) ");
				} else {
					System.out.print("o) ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rellenarAsientos(Asiento[][] asientos) {
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = new Asiento();
				asientos[i][j].setfila(i + 1);;
				asientos[i][j].setcolumna((char) (65 + j));
			}
		}
	}

	public static boolean puedeSentarse(Espectador e, Cine c, Pelicula p, Asiento[][] a) {
		return ((tieneDinero(e, c)) && (tieneEdad(p, e)));
	}

	public static boolean tieneDinero(Espectador e, Cine c) {
		return (e.getDinero() >= c.getPrecio());
	}

	public static boolean hayEspacio(Asiento[][] asientos) {
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (!asientos[i][j].isOcupado()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean tieneEdad(Pelicula p, Espectador e) {
		return (e.getEdad() >= p.getEdadMinima());
	}

}
