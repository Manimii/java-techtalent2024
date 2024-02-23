package t06.extra;

public class Ejercicio04App {

	public static void main(String[] args) {
		int[] numeros = {1,2,3,4,5,6,1,2,1,10,11};
		
	}
	
	public static void eliminaDuplicados() {
		
	}
	
	public static void muestraArray(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				System.out.print(a[i] + ",");
			} else if (i != a.length - 1) {
				System.out.print(" " + a[i] + ",");
			} else {
				System.out.print(" " + a[i]);
			}
		}
		System.out.println("]");
	}

}
