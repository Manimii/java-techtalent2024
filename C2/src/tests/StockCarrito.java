package tests;

import java.util.HashMap;
import java.util.Scanner;

public class StockCarrito {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Crear la base de datos utilizando HashMap
		HashMap<String, HashMap<String, Object>> baseDeDatos = crearBaseDeDatos();

		// Crear un carrito de la compra
		HashMap<String, Integer> carrito = new HashMap<>();

		boolean terminar = false;
		while (!terminar) {
			System.out.println("\n1. Añadir artículo al carrito");
			System.out.println("2. Calcular precio total");
			System.out.println("3. Consultar stock de un artículo");
			System.out.println("4. Añadir nuevo artículo");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el nombre del artículo: ");
				String nombreArticulo = scanner.nextLine();
				System.out.print("Ingrese la cantidad: ");
				int cantidad = scanner.nextInt();
				añadirAlCarrito(carrito, nombreArticulo, cantidad);
				break;
			case 2:
				double precioTotal = calcularPrecioTotal(carrito, baseDeDatos);
				System.out.println("Precio total a pagar: $" + precioTotal);
				actualizarBaseDeDatosDespuesDeCompra(carrito, baseDeDatos);
				carrito.clear(); // Limpiar el carrito después de la compra
				break;
			case 3:
				System.out.print("Ingrese el nombre del artículo para consultar el stock: ");
				String articuloConsulta = scanner.nextLine();
				consultarStock(baseDeDatos, articuloConsulta);
				break;
			case 4:
				agregarNuevoArticulo(baseDeDatos, scanner);
				break;
			case 5:
				terminar = true;
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}

		scanner.close();
	}

	// Método para crear la base de datos inicial
	public static HashMap<String, HashMap<String, Object>> crearBaseDeDatos() {
		HashMap<String, HashMap<String, Object>> baseDeDatos = new HashMap<>();
		// Se añaden algunos artículos iniciales
		baseDeDatos.put("Articulo1", crearArticulo("Articulo1", 5, 10.50, "Normal"));
		baseDeDatos.put("Articulo2", crearArticulo("Articulo2", 10, 25.75, "Reducido"));
		return baseDeDatos;
	}

	// Método para crear un HashMap con la información de un artículo
	public static HashMap<String, Object> crearArticulo(String nombre, int cantidad, double precio, String tipoIVA) {
		HashMap<String, Object> articulo = new HashMap<>();
		articulo.put("nombre", nombre);
		articulo.put("cantidad", cantidad);
		articulo.put("precio", precio);
		articulo.put("tipoIVA", tipoIVA);
		return articulo;
	}

	// Método para añadir artículos al carrito
	public static void añadirAlCarrito(HashMap<String, Integer> carrito, String nombreArticulo, int cantidad) {
		if (carrito.containsKey(nombreArticulo)) {
			int cantidadActual = carrito.get(nombreArticulo);
			carrito.put(nombreArticulo, cantidadActual + cantidad);
		} else {
			carrito.put(nombreArticulo, cantidad);
		}
		System.out.println(cantidad + " unidades de " + nombreArticulo + " añadidas al carrito.");
	}

	// Método para calcular el precio total del carrito
	public static double calcularPrecioTotal(HashMap<String, Integer> carrito,
			HashMap<String, HashMap<String, Object>> baseDeDatos) {
		double precioTotal = 0.0;
		for (String nombreArticulo : carrito.keySet()) {
			int cantidad = carrito.get(nombreArticulo);
			double precioUnitario = (double) baseDeDatos.get(nombreArticulo).get("precio");
			precioTotal += precioUnitario * cantidad;
		}
		return precioTotal;
	}

	// Método para consultar el stock de un artículo en la base de datos
	public static void consultarStock(HashMap<String, HashMap<String, Object>> baseDeDatos, String nombreArticulo) {
		if (baseDeDatos.containsKey(nombreArticulo)) {
			int stock = (int) baseDeDatos.get(nombreArticulo).get("cantidad");
			System.out.println("Stock disponible de " + nombreArticulo + ": " + stock);
		} else {
			System.out.println("El artículo no se encuentra en la base de datos.");
		}
	}

	// Método para agregar un nuevo artículo a la base de datos
	public static void agregarNuevoArticulo(HashMap<String, HashMap<String, Object>> baseDeDatos, Scanner scanner) {
		System.out.print("Ingrese el nombre del nuevo artículo: ");
		String nombreArticulo = scanner.nextLine();
		System.out.print("Ingrese la cantidad del nuevo artículo: ");
		int cantidad = scanner.nextInt();
		System.out.print("Ingrese el precio del nuevo artículo: ");
		double precio = scanner.nextDouble();
		scanner.nextLine(); // Consumir el salto de línea
		System.out.print("Ingrese el tipo de IVA del nuevo artículo: ");
		String tipoIVA = scanner.nextLine();

		baseDeDatos.put(nombreArticulo, crearArticulo(nombreArticulo, cantidad, precio, tipoIVA));
		System.out.println("Nuevo artículo agregado a la base de datos.");
	}

	// Método para actualizar la cantidad en stock de la base de datos después de
	// realizar una compra
	public static void actualizarBaseDeDatosDespuesDeCompra(HashMap<String, Integer> carrito,
			HashMap<String, HashMap<String, Object>> baseDeDatos) {
		for (String nombreArticulo : carrito.keySet()) {
			int cantidadComprada = carrito.get(nombreArticulo);
			int cantidadActual = (int) baseDeDatos.get(nombreArticulo).get("cantidad");
			baseDeDatos.get(nombreArticulo).put("cantidad", cantidadActual - cantidadComprada);
		}
		System.out.println("Base de datos actualizada después de la compra.");
	}
}
