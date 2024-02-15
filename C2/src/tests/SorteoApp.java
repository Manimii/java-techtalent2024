package tests;

import javax.swing.JOptionPane;

public class SorteoApp {

	public static void main(String[] args) {

		int nParticipantes = 3;
		String participantes[] = new String[nParticipantes];

		for (int i = 0; i < nParticipantes; i++) {
			String participante = JOptionPane.showInputDialog("Nombre del participante");
			participantes[i] = participante;
		}

		for (int i = 0; i < nParticipantes; i++) {
			System.out.println(participantes[i]);
		}

		int sorteo = (int) (Math.random() * nParticipantes);
		JOptionPane.showMessageDialog(null, "El ganador del sorteo es: " + participantes[sorteo]);

	}

}
