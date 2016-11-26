package br.unirn.dominio;

import java.util.ArrayList;
import java.util.List;

public class Papel {

	private int codigo;
	
	private String nome;
	
	private String descricao;
	

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<String> validar() {
		List<String> erros = new ArrayList<>();
		if (nome.isEmpty())
			erros.add("Nome não informado.<br/>");
		if (codigo == 0)
			erros.add("Código não informado.<br/>");
		if (descricao == null || descricao.isEmpty())
			erros.add("Descrição não informado.<br/>");
		return erros;
	}

}
