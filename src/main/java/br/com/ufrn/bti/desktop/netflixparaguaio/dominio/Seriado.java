package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="seriado", schema="public")
public class Seriado {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SERIADO")
	@SequenceGenerator(name="SEQ_SERIADO", schema = "public", sequenceName="id_seriado", allocationSize=1)
	private int id;
	public int qtdTemporadas;
	
	public Seriado(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdTemporadas() {
		return qtdTemporadas;
	}

	public void setQtdTemporadas(int qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}
}
