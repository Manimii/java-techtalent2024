package t09.ejercicio01;

public class Lavadora extends Electrodomestico {

	private final double CARGA = 5;

	private double carga;

	public Lavadora() {
		super();
		this.carga = CARGA;
	}

	public Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
		this.carga = CARGA;
	}

	public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
	}

	public double precioFinal() {
		double precio = super.precioFinal();
		if (this.carga > 30) {
			precio += 50;
		}
		return precio;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

}
