package t08;

public class Electrodomestico {

	protected final double precioBaseDefecto = 100;
	protected final String colorDefecto = "blanco";
	protected final char consumoEnergeticoDefecto = 'F';
	protected final double pesoDefecto = 5;

	protected double precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected double peso;

	public Electrodomestico() {
		this.precioBase = precioBaseDefecto;
		this.color = colorDefecto;
		this.consumoEnergetico = consumoEnergeticoDefecto;
		this.peso = pesoDefecto;
	}

	public Electrodomestico(double precioBase, double peso) {
		this();
		this.precioBase = precioBase;
		this.peso = peso;
	}

	public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
		this.precioBase = precioBase;
		if (!color.equalsIgnoreCase("blanco") && !color.equalsIgnoreCase("negro") && !color.equalsIgnoreCase("rojo")
				&& !color.equalsIgnoreCase("azul") && !color.equalsIgnoreCase("gris")) {
			this.color = colorDefecto;
		} else {
			this.color = color;
		}
		if (consumoEnergetico < 'A' || consumoEnergetico > 'F') {
			this.consumoEnergetico = consumoEnergeticoDefecto;
		} else {
			this.consumoEnergetico = consumoEnergetico;
		}
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Electrodomestico [" + ", precioBase=" + precioBase + ", color=" + color + ", consumoEnergetico="
				+ consumoEnergetico + ", peso=" + peso + "]";
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
