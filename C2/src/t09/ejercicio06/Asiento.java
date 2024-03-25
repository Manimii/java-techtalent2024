package t09.ejercicio06;

public class Asiento extends Espectador {

	private int fila;
	private char columna;
	private boolean ocupado;

	public Asiento() {
		this.fila = 1;
		this.columna = 'A';
		this.ocupado = false;
	}

	public Asiento(Pelicula pelicula, double precio, int filas, int columnas, String titulo, int duracion,
			int edadMinima, String director, String nombre, int edad, double dinero, int fila, char columna,
			boolean ocupado) {
		super(pelicula, precio, filas, columnas, titulo, duracion, edadMinima, director, nombre, edad, dinero);
		this.fila = fila;
		this.columna = columna;
		this.ocupado = ocupado;
	}

	public void sentarEspectadores() {

	}

//	public boolean puedeSentarse() {
//		
//	}

	public int getfila() {
		return fila;
	}

	public void setfila(int fila) {
		this.fila = fila;
	}

	public char getcolumna() {
		return columna;
	}

	public void setcolumna(char columna) {
		this.columna = columna;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "Asiento [fila=" + fila + ", columna=" + columna + ", ocupado=" + ocupado + "]";
	}

}
