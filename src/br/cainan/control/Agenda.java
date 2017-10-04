package br.cainan.control;

import java.util.ArrayList; 
import java.util.List;

import br.cainan.exception.EmailInException;
import br.cainan.model.Contato;
import br.cainan.view.View;

public class Agenda {
	// lista onde são armazenados os contatos
	List<Contato> agenda = new ArrayList<Contato>();
	
	public void adicionarContato() throws EmailInException{
		//método para adicionar um contato na lista
		View view = new View();
		Contato contato = new Contato(view.recebeString("Nome: "), view.recebeString("E-mail: "));
		validaEmail(contato);
		agenda.add(contato);
		
	}
	
	public Contato buscarContato(String nomeBusca){
		//método para encontrar um contato de acordo com o nome que o usuário digitar
		Contato buscaContato = null;
		
		for (int i = 0; i < agenda.size(); i++) {
			String nomeContato = agenda.get(i).getNome();
			if (nomeBusca.equalsIgnoreCase(nomeContato))
				buscaContato = agenda.get(i);
		}
		
		return buscaContato;
		
	}
	
	public void removerContato(String nome){
		//método para remover um contato. Ele utiliza o método de busca para chegar ao contato e removê-lo
		View view = new View();
		if (buscarContato(nome)==null)
			view.exibeMsg("Nenhum contato com este nome!!");
		else{
			Object[] options = {"Sim", "Não"};
			Integer escolha = view.opcoes("Tem certeza que deseja excluir o contato " + nome + "?", options);
			if (escolha == 0)
				agenda.remove(buscarContato(nome));
			else
				view.exibeMsg("O contato " + nome + " não foi removido.");
		}
		
	}
	
	public void verDados(){
		//método para exibir todos os contatos da lista
		View view = new View();
		
		if (agenda.isEmpty()){
			view.exibeMsg("Não há nenhum contato registrado!!");
		}
		
		else{
			for (int i = 0; i < agenda.size(); i++) {
				//if (agenda.get(i) != null)
				view.exibeMsg(agenda.get(i).toString());
			}
		}
			
		
		
	}
	
	public Contato validaEmail (Contato contato) throws EmailInException{
		
		char[] teste = contato.getEmail().toCharArray();
		char stringTest = '!';
		char stringTest1 = '!';
		
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste.length; j++) {
				if (teste[i] == '@')
					stringTest = teste[i];
				else if (teste[j] == '.')
					stringTest1 = teste[j];
			}
			
		}
		
		if(stringTest != '!' && stringTest1 != '!'){
			String[] separaEmail = contato.getEmail().split("@");
			String dominio = separaEmail[1];
			String[] separaDom = dominio.split("\\.");
			
			if (separaDom[0].equalsIgnoreCase("gmail") || separaDom[0].equalsIgnoreCase("hotmail") || separaDom[0].equalsIgnoreCase("yahoo")){
				return contato;
			}
			else
				throw new EmailInException(contato);
		}
		
		else
			throw new EmailInException(contato);		
			
	}
	
	
}
