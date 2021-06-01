package model;

import java.util.ArrayList;

/**
 * Classe para armazenar atributos e métodos do objeto professor
 * 
 * @author Nathalia Lanaro
 * @since 23/02/2021
 */
public class Professor extends Funcionarios {
	
	//declarando atributos do professor
	private ArrayList<Materia> listaMaterias;

	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}

	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	
	}
	
	
}
