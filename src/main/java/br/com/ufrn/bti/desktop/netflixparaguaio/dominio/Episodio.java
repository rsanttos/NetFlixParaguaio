package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="episodio", schema="public")
public class Episodio {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EPISODIO")
	@SequenceGenerator(name="SEQ_EPISODIO", schema = "public", sequenceName="id_episodio", allocationSize=1)
	private int id;
	public String nome;
	public String duracao;
	public int numeroEpisodio;
	
	public Episodio(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
