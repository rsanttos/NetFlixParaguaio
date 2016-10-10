package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

public class Usuario {
	private int id;
	private String login;
	private String senha;
	private String permissao;
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
}
