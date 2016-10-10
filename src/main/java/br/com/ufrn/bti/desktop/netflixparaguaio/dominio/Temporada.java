package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="temporada", schema="public")
public class Temporada {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEMPORADA")
	@SequenceGenerator(name="SEQ_TEMPORADA", schema = "public", sequenceName="id_temporada", allocationSize=1)
	private int id;
	public int numeroTemporada;
	public int qtdEpisodios;
	
	public Temporada(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	public int getQtdEpisodios() {
		return qtdEpisodios;
	}

	public void setQtdEpisodios(int qtdEpisodios) {
		this.qtdEpisodios = qtdEpisodios;
	}
}
