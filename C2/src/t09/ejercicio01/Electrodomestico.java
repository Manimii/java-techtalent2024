package t09.ejercicio01;

public abstract class Electrodomestico {
	protected double precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected double peso;

	public Electrodomestico() {
		this.precioBase = 100;
		this.color = "Blanco";
		this.consumoEnergetico = 'F';
		this.peso = 5;
	}

	public Electrodomestico(double precioBase, double peso) {
		this();
		this.precioBase = precioBase;
		this.peso = peso;
	}

	public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
		this.precioBase = precioBase;
		if (comprobarColor(color)) {
			this.color = color;
		} else {
			this.color = "blanco";
		}
		this.color = color;
		if (comprobarConsumoEnergetico(consumoEnergetico)) {
			this.consumoEnergetico = consumoEnergetico;
		} else {
			this.consumoEnergetico = 'F';
		}
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
	}

	private boolean comprobarColor(String color) {
		return color.equalsIgnoreCase("blanco") || color.equalsIgnoreCase("negro") || color.equalsIgnoreCase("rojo")
				|| color.equalsIgnoreCase("azul") || color.equalsIgnoreCase("gris");
	}

	private boolean comprobarConsumoEnergetico(char letra) {
		return letra >= 'A' && letra <= 'F';
	}

	public double precioFinal() {
		double precio = this.precioBase;
		char letra = this.consumoEnergetico;
		double tamano = this.peso;
		switch (letra) {
		case 'A':
			precio += 100;
			break;
		case 'B':
			precio += 80;
			break;
		case 'C':
			precio += 60;
			break;
		case 'D':
			precio += 50;
			break;
		case 'E':
			precio += 30;
			break;
		case 'F':
			precio += 10;
			break;
		}
		if (tamano <= 19) {
			precio += 10;
		} else if (tamano <= 49) {
			precio += 50;
		} else if (tamano <= 79) {
			precio += 80;
		} else {
			precio += 100;
		}
		return precio;

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

	@Override
	public String toString() {
		return "Electrodomestico [precioBase=" + precioBase + ", color=" + color + ", consumoEnergetico="
				+ consumoEnergetico + ", peso=" + peso + "]";
	}

}
