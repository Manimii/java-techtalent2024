package t08;

public class MainApp {

	public static void main(String[] args) {		
		Password pass = new Password();
		System.out.println(pass.getPass());
		
		Password pass2 = new Password(10);
		System.out.println(pass2.getPass());

		Electrodomestico el = new Electrodomestico(10,10);
		System.out.println(el.toString());
		
		Serie s = new Serie("Un título", "Un creador");
		System.out.println(s.toString());
		
		Persona p = new Persona();
		System.out.println(p.toString());
	}

}
