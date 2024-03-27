package t08.supermercado;

public class Producto {

	private double precio;
	private double iva;
	private int cantidad;
	private String nombre;

	public Producto(double precio, double iva, int cantidad, String nombre) {
		this.precio = precio;
		this.iva = iva;
		this.cantidad = cantidad;
		this.nombre = nombre;
	}

	public Producto() {
		this.precio = 1;
		this.iva = 0.21;
		this.cantidad = 10;
		this.nombre = "";
	}

}
