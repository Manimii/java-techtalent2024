package t09.ejercicio06;

public class Espectador extends Pelicula {

	private String nombre;
	private int edad;
	private double dinero;

	public Espectador() {
		super();
		this.nombre = "";
		this.edad = 18;
		this.dinero = 50;
	}

	public Espectador(Pelicula pelicula, double precio, int filas, int columnas, String titulo, int duracion,
			int edadMinima, String director, String nombre, int edad, double dinero) {
		super(pelicula, precio, filas, columnas, titulo, duracion, edadMinima, director);
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
	}

//	public boolean tieneDinero() {
//	return (this.dinero >= super.get)
//}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + "]";
	}

}
