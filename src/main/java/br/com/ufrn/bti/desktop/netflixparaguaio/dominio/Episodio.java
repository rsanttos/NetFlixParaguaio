package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	public String caminhoArquivo;
	public int numeroEpisodio;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_temporada")
	private Temporada temporada;
	
	public Episodio(){
		
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
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

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	
}
