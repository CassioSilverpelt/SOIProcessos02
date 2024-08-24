package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class KillMain {
	public static void main (String[] args) {
		KillController killCon = new KillController();
		String pid;
		String nome;
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"===============================\n"
					+ "===Insira a identificação da opção===\n"
					+ "1 - Lista Processos\n"
					+ "2 - Mata processo por PID\n"
					+ "3 - Mata processo por Nome\n"
					+ "9 - Fechar programa\n"
					+ "==============================="));
			switch(opc) {
				case 1:
					killCon.listaProcessos();
					break;
				case 2:
					pid = JOptionPane.showInputDialog("Insira o PID do processo: ");
					killCon.mataPid(pid);
					break;
				case 3:
					nome = JOptionPane.showInputDialog("Insira o Nome do processo: ");
					killCon.mataNome(nome);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Encerrando programa.");
					break;
			}
		}
		
		
	}
}
