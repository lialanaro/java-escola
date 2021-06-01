package model;

/**
 * Classe respons�vel por armazenar os atributos e m�todos do objeto aluno
 * 
 * @author Nathalia Lanaro
 * @since 23/02/2021
 *
 */
public class Aluno {
	// declarando os atributos de aluno
	private int codigo;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private Contato contado;
	
	
	//m�todos para acessar os atributos
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContado() {
		return contado;
	}

	public void setContado(Contato contado) {
		this.contado = contado;
	}


}
