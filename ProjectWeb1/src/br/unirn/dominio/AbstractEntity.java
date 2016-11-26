package br.unirn.dominio;

import java.util.ArrayList;
import java.util.List;

public class AbstractEntity {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	public List<String> validar(){
		List<String> erros = new ArrayList<>();
		return erros;
	}
}
