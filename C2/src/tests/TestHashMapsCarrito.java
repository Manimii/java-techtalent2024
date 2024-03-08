package tests;

import java.util.HashMap;

import java.util.HashMap;

import java.util.HashMap;

public class TestHashMapsCarrito {
	public static void main(String[] args) {
		// Crear HashMap para almacenar el inventario
		HashMap<String, HashMap<String, Object>> inventario = new HashMap<>();

		// Agregar productos al inventario con un HashMap interno
		// Cada HashMap interno contiene las claves "Precio", "TipoIVA" y "Cantidad"
		inventario.put("Producto1", crearProducto(10.99, "IVA10", 100));
		inventario.put("Producto2", crearProducto(20.50, "IVA21", 50));
		inventario.put("Producto3", crearProducto(5.75, "IVA4", 75));
		inventario.put("Producto4", crearProducto(15.25, "IVA10", 30));
		inventario.put("Producto5", crearProducto(8.99, "IVA21", 60));
		inventario.put("Producto6", crearProducto(12.75, "IVA10", 80));
		inventario.put("Producto7", crearProducto(6.50, "IVA4", 20));
		inventario.put("Producto8", crearProducto(30.99, "IVA21", 45));
		inventario.put("Producto9", crearProducto(17.25, "IVA10", 55));
		inventario.put("Producto10", crearProducto(9.50, "IVA21", 70));

		// Imprimir el inventario
		System.out.println("Inventario:");
		imprimirInventario(inventario);

		// Crear carrito de la compra
		HashMap<String, HashMap<String, Object>> carrito = new HashMap<>();

		// Agregar productos al carrito con la misma información que en el inventario
		agregarAlCarrito(carrito, "Producto1", 3, (double) inventario.get("Producto1").get("Precio"),
				(String) inventario.get("Producto1").get("TipoIVA"));
		agregarAlCarrito(carrito, "Producto3", 2, (double) inventario.get("Producto3").get("Precio"),
				(String) inventario.get("Producto3").get("TipoIVA"));
		agregarAlCarrito(carrito, "Producto8", 1, (double) inventario.get("Producto8").get("Precio"),
				(String) inventario.get("Producto8").get("TipoIVA"));

		// Imprimir el carrito de la compra
		System.out.println("\nCarrito de la compra:");
		imprimirCarrito(carrito);

		// Imprimir el inventario nuevamente para confirmar que no se modificaron los
		// valores
		System.out.println("\nInventario después de agregar productos al carrito:");
		imprimirInventario(inventario);
	}

	// Método para crear un HashMap interno que representa la información de un
	// producto
	private static HashMap<String, Object> crearProducto(double precio, String tipoIVA, int cantidad) {
		HashMap<String, Object> producto = new HashMap<>();
		producto.put("Precio", precio);
		producto.put("TipoIVA", tipoIVA);
		producto.put("Cantidad", cantidad);
		return producto;
	}

	// Método para imprimir el inventario
	private static void imprimirInventario(HashMap<String, HashMap<String, Object>> inventario) {
		for (String nombreProducto : inventario.keySet()) {
			HashMap<String, Object> productoInfo = inventario.get(nombreProducto);
			double precio = (double) productoInfo.get("Precio");
			String tipoIVA = (String) productoInfo.get("TipoIVA");
			int cantidad = (int) productoInfo.get("Cantidad");

			System.out.println("Nombre: " + nombreProducto + ", Precio: " + precio + ", Tipo de IVA: " + tipoIVA
					+ ", Cantidad: " + cantidad);
		}
	}

	// Método para agregar productos al carrito
	private static void agregarAlCarrito(HashMap<String, HashMap<String, Object>> carrito, String nombreProducto,
			int cantidad, double precio, String tipoIVA) {
		HashMap<String, Object> productoCarrito = new HashMap<>();
		productoCarrito.put("Cantidad", cantidad);
		productoCarrito.put("Precio", precio);
		productoCarrito.put("TipoIVA", tipoIVA);
		carrito.put(nombreProducto, productoCarrito);
	}

	// Método para imprimir el carrito de la compra
	private static void imprimirCarrito(HashMap<String, HashMap<String, Object>> carrito) {
		for (String nombreProducto : carrito.keySet()) {
			HashMap<String, Object> productoCarrito = carrito.get(nombreProducto);
			int cantidad = (int) productoCarrito.get("Cantidad");
			double precio = (double) productoCarrito.get("Precio");
			String tipoIVA = (String) productoCarrito.get("TipoIVA");
			System.out.println("Nombre: " + nombreProducto + ", Cantidad: " + cantidad + ", Precio: " + precio
					+ ", Tipo de IVA: " + tipoIVA);
		}
	}
}
