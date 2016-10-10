package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="filme", schema="public")
public class Filme {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FILME")
	@SequenceGenerator(name="SEQ_FILME", schema = "public", sequenceName="id_filme", allocationSize=1)
	private int id;
	
	private String duracao;
	private String caminhoArquivo;

	public Filme(int id, String duracao) {
		super();
		this.id = id;
		this.duracao = duracao;
	}
	
	public Filme(){
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
}
