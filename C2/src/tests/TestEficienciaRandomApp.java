package tests;

public class TestEficienciaRandomApp {

	public static void main(String[] args) {
		int sorteo = (int) (Math.random() * 3);
		int count1 = 0, count2 = 0, count3 = 0;
		
		for (int i = 0; i < 10000; i++) {
			int s = (int) (Math.random() * 3);
			
			switch(s) {
			case 0:
				count1++;
				break;
			case 1:
				count2++;
				break;
			case 2:
				count3++;
				break;
			}
		}
		
		System.out.println(count1 + " " + count2 + " " + count3);
	}

}
