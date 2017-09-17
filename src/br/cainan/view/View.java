package br.cainan.view;

import javax.swing.JOptionPane;

public class View {
	
	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public String recebeString(String texto){
		String resposta = JOptionPane.showInputDialog(null, texto);
		return resposta;
		
	}
	
	public  static Integer opcoes(String texto){
		Object[] options = {"Adcionar", "Buscar", "Remover", "Ver contatos", "Sair"};
		Integer resposta = JOptionPane.showOptionDialog(null, texto, "MENU", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		
		return resposta;
		
	}

}
