package tests;

public class ProbarRandoms {

	public static void main(String[] args) {
		int i = 0;
		while (i < 100) {
			int random = (int) (Math.random()*5);
			System.out.println((int) (Math.random()*5));
			i++;
		}
		
	}

}
