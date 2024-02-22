package tests;

public class TestEficienciaRandomApp {

	public static void main(String[] args) {
//		int sorteo = (int) (Math.random() * 3);
//		int random = (int) (10 + (Math.random() * (20 + 1 - 10)));
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0,
				count10 = 0, count11 = 0;

		for (int i = 0; i < 10000; i++) {
			int s = (int) (10 + (Math.random() * (20 + 1 - 10)));

			switch (s) {
			case 10:
				count1++;
				break;
			case 11:
				count2++;
				break;
			case 12:
				count3++;
				break;
			case 13:
				count4++;
				break;
			case 14:
				count5++;
				break;
			case 15:
				count6++;
				break;
			case 16:
				count7++;
				break;
			case 17:
				count8++;
				break;
			case 18:
				count9++;
				break;
			case 19:
				count10++;
				break;
			case 20:
				count11++;
				break;
			}
		}

		System.out.println(count1 + " " + count2 + " " + count3 + " " + count4 + " " + count5 + " " + count6 + " "
				+ count7 + " " + count8 + " " + count9 + " " + count10 + " " + count11);
	}

}
