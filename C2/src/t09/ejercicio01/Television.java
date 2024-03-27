package t09.ejercicio01;

public class Television extends Electrodomestico {

	private int resolucion;
	private boolean sintonizadorTDT;

	public Television() {
		super();
		this.resolucion = 20;
		this.sintonizadorTDT = false;
	}

	public Television(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = 20;
		this.sintonizadorTDT = false;
	}

	public Television(double precioBase, String color, char consumoEnergetico, double peso, int resolucion,
			boolean sintonizadorTDT) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
	}
	
	public double precioFinal() {
		double precio = super.precioFinal();
		if (this.resolucion > 40) {
			precio += precio*0.3;
		}
		if (this.sintonizadorTDT) {
			precio += 50;
		}
		return precio;
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	public void setSintonizadorTDT(boolean sintonizadorTDT) {
		this.sintonizadorTDT = sintonizadorTDT;
	}
	
	

}
