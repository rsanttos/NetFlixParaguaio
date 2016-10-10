package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

public class Episodio {
	public String nome;
	public String duracao;
	public int numeroEpisodio;
	
	public Episodio(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getNumeroEpisodio() {
		return numeroEpisodio;
	}

	public void setNumeroEpisodio(int numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}
	
}
