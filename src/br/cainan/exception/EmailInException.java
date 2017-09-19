package br.cainan.exception;

import br.cainan.model.Contato;

public class EmailInException extends Exception{
	
	private Contato c;
	
	public EmailInException(Contato c) {
		super();
		this.c = c;
	}
	
	@Override
	public String getMessage() {
		return "O e-mail do usuário " + c.getEmail() + " é inválido.";
	}	
	

}
