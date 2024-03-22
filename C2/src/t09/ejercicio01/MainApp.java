package t09.ejercicio01;

public class MainApp {

	public static void main(String[] args) {

		Electrodomestico[] electrodomesticos = new Electrodomestico[10];
		int nLavadoras = 0, nTelevisiones = 0;
		double precioLavadoras = 0, precioTelevisiones = 0, precioActual = 0, precioTotal = 0;

		rellenarArray(electrodomesticos);

		for (int i = 0; i < electrodomesticos.length; i++) {
			precioActual = electrodomesticos[i].precioFinal();
			System.out.println("Precio electrodoméstico " + i + ": " + precioActual);
			if (electrodomesticos[i] instanceof Lavadora) {
				nLavadoras++;
				precioLavadoras += precioActual;
			} else if (electrodomesticos[i] instanceof Television) {
				nTelevisiones++;
				precioTelevisiones += precioActual;
			}
			precioTotal += precioActual;
		}
		
		System.out.println("\nLavadoras totales: " + nLavadoras);
		System.out.println("Televisiones totales: " + nTelevisiones);
		System.out.println("Precio total de las televisiones: " + precioTelevisiones);
		System.out.println("Precio total de las lavadoras: " + precioLavadoras);
		System.out.println("Precio total de los electrodomésticos: " + precioTotal);
	}

	public static void rellenarArray(Electrodomestico[] electrodomesticos) {
		electrodomesticos[0] = new Lavadora();
		electrodomesticos[1] = new Lavadora(500, 90);
		electrodomesticos[2] = new Lavadora(200, "gris", 'B', 50, 40);
		electrodomesticos[3] = new Lavadora(300, "amarillo", 'C', 80, 20);
		electrodomesticos[4] = new Lavadora(150, "rojo", 'X', 30, 10);

		electrodomesticos[5] = new Television();
		electrodomesticos[6] = new Television(300, 15);
		electrodomesticos[7] = new Television(500, "azul", 'E', 30, 45, true);
		electrodomesticos[8] = new Television(450, "negro", 'D', 50, 50, false);
		electrodomesticos[9] = new Television(200, "verde", 'A', 10, 25, true);
	}

}
