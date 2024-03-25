package t09.ejercicio06;

public class MainApp {

	public static void main(String[] args) {
		Asiento a = new Asiento(5, 'B', false);
		Espectador e = new Espectador("Juan", 20, 50);
		Pelicula p = new Pelicula("Titánic", 120, 12, "Director");
		Cine c = new Cine(p, 20, 8, 8);
	}
	
	public static boolean tieneDinero(Espectador e, Cine c) {
		return (e.getDinero() >= c.getPrecio());
	}
	
	public static boolean hayEspacio(Cine c, int nEspectadores) {
		return (nEspectadores < (c.getColumnas()*c.getFilas()));
	}
	
	public static boolean tieneEdad(Pelicula p, Espectador e) {
		return (e.getEdad() >= p.getEdadMinima());
	}

}
