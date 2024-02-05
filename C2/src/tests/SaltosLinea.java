package tests;

public class SaltosLinea {

	public static void main(String[] args) {
		int precioProducto = 300;
		final double IVA = 0.21;

		System.out.print("INFORMACIÓN DEL PRODUCTO\n" + "El precio del producto es: " + precioProducto + "\n"
				+ "El precio del producto, incluyendo el IVA es: " + (precioProducto + precioProducto * IVA));

	}

}
