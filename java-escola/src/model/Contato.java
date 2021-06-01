package model;

/**
 * Classe para armazenar atributos e m�todos do objeto contato
 * 
 * @author Nathalia Lanaro
 * @since 23/02/2021
 *
 */
public class Contato {
	//declarando atributos
	private String email;
	private String telefone;
	
	//m�todo para acessar os atributos
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
