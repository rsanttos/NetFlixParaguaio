package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroConteudoController {

	@FXML
	private TextField nomeField;
	@FXML
	private TextField descricaoField;
	@FXML
	private TextField anoLancamentoField;
	@FXML
	private TextField atorPrincipalField;
	@FXML
	private TextField imgField;
	@FXML
	private TextField nomeEpField;
	@FXML
	private TextField numeroEpField;
	@FXML
	private TextField duracaoField;
	@FXML
	private ComboBox<Integer> classificacaoEtariaComboBox;
	@FXML
	private ComboBox<String> tipoComboBox;

	private Stage dialogStage;
	private boolean entrarClicked = false;
	private Main main;
	
	private Conteudo conteudo;
	private Filme filme;
	private Seriado seriado;
	private Episodio episodio;

	@FXML
	private void initialize() {
	}

	public TextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(TextField nomeField) {
		this.nomeField = nomeField;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isEntrarClicked() {
		return entrarClicked;
	}

	public void setEntrarClicked(boolean entrarClicked) {
		this.entrarClicked = entrarClicked;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	public TextField getNomeEpField() {
		return nomeEpField;
	}

	public void setNomeEpField(TextField nomeEpField) {
		this.nomeEpField = nomeEpField;
	}

	public TextField getNumeroEpField() {
		return numeroEpField;
	}

	public void setNumeroEpField(TextField numeroEpField) {
		this.numeroEpField = numeroEpField;
	}

	public TextField getDuracaoField() {
		return duracaoField;
	}

	public void setDuracaoField(TextField duracaoField) {
		this.duracaoField = duracaoField;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Seriado getSeriado() {
		return seriado;
	}

	public void setSeriado(Seriado seriado) {
		this.seriado = seriado;
	}

	public Episodio getEpisodio() {
		return episodio;
	}

	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}

	@FXML
	public void handleCadastrar(){
		
	}
	
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
	public TextField getDescricaoField() {
		return descricaoField;
	}

	public void setDescricaoField(TextField descricaoField) {
		this.descricaoField = descricaoField;
	}

	public TextField getAnoLancamentoField() {
		return anoLancamentoField;
	}

	public void setAnoLancamentoField(TextField anoLancamentoField) {
		this.anoLancamentoField = anoLancamentoField;
	}

	public TextField getAtorPrincipalField() {
		return atorPrincipalField;
	}

	public void setAtorPrincipalField(TextField atorPrincipalField) {
		this.atorPrincipalField = atorPrincipalField;
	}

	public TextField getImgField() {
		return imgField;
	}

	public void setImgField(TextField imgField) {
		this.imgField = imgField;
	}

	public ComboBox<Integer> getClassificacaoEtariaComboBox() {
		return classificacaoEtariaComboBox;
	}

	public void setClassificacaoEtariaComboBox(ComboBox<Integer> classificacaoEtariaComboBox) {
		this.classificacaoEtariaComboBox = classificacaoEtariaComboBox;
	}

	public ComboBox<String> getTipoComboBox() {
		return tipoComboBox;
	}

	public void setTipoComboBox(ComboBox<String> tipoComboBox) {
		this.tipoComboBox = tipoComboBox;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
}
