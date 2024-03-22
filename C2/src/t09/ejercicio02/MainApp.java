package t09.ejercicio02;

public class MainApp {

	public static void main(String[] args) {

		Serie[] series = new Serie[5];
		Videojuego[] videojuegos = new Videojuego[5];

		rellenarSeries(series);
		rellenarVideojuegos(videojuegos);

		entregarArray(series, videojuegos);

		System.out.println("Series entregadas: " + contarSeriesEntregadas(series));
		System.out.println("Videojuegos entregados: " + contarVideojuegosEntregadas(videojuegos));
		
		System.out.println("El videojuego con más horas estimadas es: " + masHoras(videojuegos));
		System.out.println("La serie con más temporadas es: " + masTemporadas(series));
	}

	public static void rellenarSeries(Serie[] s) {
		s[0] = new Serie();
		s[1] = new Serie("t1", "c1");
		s[2] = new Serie("t2", 11, "g2", "c2");
		s[3] = new Serie("t3", 7, "g3", "c3");
		s[4] = new Serie("t4", 18, "g4", "c4");
	}

	public static void rellenarVideojuegos(Videojuego[] v) {
		v[0] = new Videojuego();
		v[1] = new Videojuego("v1", 15);
		v[2] = new Videojuego("v2", 5, "g7", "co2");
		v[3] = new Videojuego("v3", 19, "g8", "co3");
		v[4] = new Videojuego("v4", 10, "g9", "co4");
	}

	public static void entregarArray(Serie[] s, Videojuego[] v) {
		s[0].entregar();
		s[3].entregar();
		v[1].entregar();
		v[2].entregar();
		v[4].entregar();
	}

	public static int contarSeriesEntregadas(Serie[] s) {
		int count = 0;

		for (int i = 0; i < s.length; i++) {
			if (s[i].isEntregado()) {
				count++;
			}
		}

		return count;
	}
	
	public static int contarVideojuegosEntregadas(Videojuego[] v) {
		int count = 0;

		for (int i = 0; i < v.length; i++) {
			if (v[i].isEntregado()) {
				count++;
			}
		}
		return count;
	}

	public static String masTemporadas(Serie[] s) {
		Serie serieMasTemporadas = new Serie();
		
		for (int i = 0; i < s.length; i++) {
			serieMasTemporadas = (Serie) serieMasTemporadas.compareTo(s[i]);
		}
		
		return serieMasTemporadas.toString();
	}
	
	public static String masHoras(Videojuego[] v) {
		Videojuego videojuegoMasHoras = new Videojuego();
		
		for (int i = 0; i < v.length; i++) {
			videojuegoMasHoras = (Videojuego) videojuegoMasHoras.compareTo(v[i]);
		}
		
		return videojuegoMasHoras.toString();
	}
}
