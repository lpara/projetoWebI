package br.unirn.dominio;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends AbstractEntity{

	private String login;
	
	private String nome;

	private String senha;
	
	private String confirmaSenha;
	
	private List<Papel> papeis;

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public List<String> validar() {
		List<String> erros = new ArrayList<>();
		if (nome.isEmpty())
			erros.add("Nome não informado.<br/>");
		if (login.isEmpty())
			erros.add("Login não informado.<br/>");
		if (senha == null || senha.isEmpty())
			erros.add("Senha não informado.<br/>");
		if (confirmaSenha == null || confirmaSenha.isEmpty())
			erros.add("Confirmação de senha não informado.<br/>");
		return erros;
	}
}
