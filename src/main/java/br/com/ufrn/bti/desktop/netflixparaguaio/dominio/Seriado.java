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
@Table(name="seriado", schema="public")
public class Seriado {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SERIADO")
	@SequenceGenerator(name="SEQ_SERIADO", schema = "public", sequenceName="id_seriado", allocationSize=1)
	private int id;
	public int qtdTemporadas;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_conteudo")
	private Conteudo conteudo;
	
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

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
}
