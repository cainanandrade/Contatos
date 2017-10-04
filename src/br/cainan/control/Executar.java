package br.cainan.control;

import br.cainan.exception.EmailInException;
import br.cainan.model.Contato;
import br.cainan.view.View;

public class Executar {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		View view = new View();
		
		Object[] options = {"Adcionar", "Buscar", "Remover", "Ver contatos", "Sair"};
		
		Integer opcao = view.opcoes("Escolha o que você deseja fazer: ", options);
		
		while(opcao != 4){
			switch (opcao){
			case 0:
				try {
					agenda.adicionarContato();
					break;
				} catch (EmailInException c) {
					view.exibeMsg(c.getMessage());
					break;
				}
				
				
			case 1:
				Contato buscaContato = agenda.buscarContato(view.recebeString("Digite o nome para buscar o contato: "));
				if (buscaContato != null)
					view.exibeMsg(buscaContato.toString());
				else
					view.exibeMsg("Nenhum contato possui o nome digitado!!");
				break;
			
			case 2:
				agenda.removerContato(view.recebeString("Digite o nome para buscar e remover o contato: "));
				break;
				
			case 3: 
				agenda.verDados();
				break;
			
			case 4: 
				System.exit(0);
			}
			
			opcao = view.opcoes("Escolha o que você deseja fazer: ", options);
		}			

	}

}
