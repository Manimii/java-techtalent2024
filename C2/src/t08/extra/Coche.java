package t08.extra;

/*
 * Problema: Crea una clase llamada Coche que tenga como atributos marca, modelo y año de fabricación.
 * Implementa métodos para obtener y establecer estos atributos.
 * */

public class Coche {

	private String marca;
	private String modelo;
	private int fabricacion;

	public Coche(String marca, String modelo, int fabricacion) {
		this.marca = marca;
		this.modelo = modelo;
		this.fabricacion = fabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(int fabricacion) {
		this.fabricacion = fabricacion;
	}

}
