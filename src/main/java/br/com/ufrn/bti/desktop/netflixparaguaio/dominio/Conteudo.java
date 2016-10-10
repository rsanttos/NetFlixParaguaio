package br.com.ufrn.bti.desktop.netflixparaguaio.dominio;

import java.io.File;

public class Conteudo {
	
	public int classificacaoEtaria;
	public String nome;
	public String descricao;
	public int anoLancamento;
	public String atorPrincipal;
	public File imgPrincipal;
	public String tipo;
	
	public Conteudo(){
		
	}

	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	public void setClassificacaoEtaria(int classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
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

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getAtorPrincipal() {
		return atorPrincipal;
	}

	public void setAtorPrincipal(String atorPrincipal) {
		this.atorPrincipal = atorPrincipal;
	}

	public File getImgPrincipal() {
		return imgPrincipal;
	}

	public void setImgPrincipal(File imgPrincipal) {
		this.imgPrincipal = imgPrincipal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
