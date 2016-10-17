package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.ConteudoService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ObservableList<String> opcoesClassificacaoComboBox = FXCollections.observableArrayList("Livre", "10 anos",
			"12 anos", "14 anos", "16 anos", "18 anos");
	@FXML
	private ComboBox<String> classificacaoEtariaComboBox = new ComboBox<String>();
	private ObservableList<String> opcoesTipoComboBox = FXCollections.observableArrayList("Filme", "Seriado");
	@FXML
	private ComboBox<String> tipoComboBox = new ComboBox<String>();

	private Stage stage;
	private boolean entrarClicked = false;
	private Main main;

	private Conteudo conteudo;

	private ConteudoService conteudoService = new ConteudoService();
	
	public CadastroConteudoController() {
		initialize();
	}

	@FXML
	private void initialize() {
		classificacaoEtariaComboBox.getItems().addAll(opcoesClassificacaoComboBox);
		tipoComboBox.getItems().addAll(opcoesTipoComboBox);
	}

	public TextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(TextField nomeField) {
		this.nomeField = nomeField;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
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

	@FXML
	public void handleCadastrar() {
		if(validaCampos()){
			conteudo = new Conteudo();
			conteudo.setNome(nomeField.getText());
			conteudo.setClassificacaoEtaria(classificacaoEtariaComboBox.getValue());
			conteudo.setDescricao(descricaoField.getText());
			conteudo.setAnoLancamento(Integer.parseInt(anoLancamentoField.getText()));
			conteudo.setAtorPrincipal(atorPrincipalField.getText());
			conteudo.setTipo(tipoComboBox.getValue());
			conteudoService.salvarOuAtualizar(conteudo);
			if (conteudo.getTipo().equals("Filme")){
				Filme filmeAux = new Filme();
				filmeAux.setConteudo(conteudo);
				main.showCadastroFilme(filmeAux);
			} else if (conteudo.getTipo().equals("Seriado")){
				Seriado seriadoAux = new Seriado();
				seriadoAux.setConteudo(conteudo);
				main.showCadastroSeriado(seriadoAux);
			}
		}
	}

	public boolean validaCampos() {
		if (nomeField.getText() == null || classificacaoEtariaComboBox.getValue() == null
				|| descricaoField.getText() == null || anoLancamentoField.getText() == null
				|| atorPrincipalField.getText() == null || tipoComboBox.getValue() == null) {
			Alerta.alertaErro("Eita!", "É necessário preencher todos os campos.");
			return false;
		}

		if (anoLancamentoField.getText().length() != 4) {
			Alerta.alertaErro("Algo de errado no campo do ano de lançamento.", "O ano deve conter 4 dígitos.");
			return false;
		}
		
		return true;
	}

	@FXML
	private void handleCancelar() {
		this.stage.close();
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

	public ObservableList<String> getOpcoesClassificacaoComboBox() {
		return opcoesClassificacaoComboBox;
	}

	public void setOpcoesClassificacaoComboBox(ObservableList<String> opcoesClassificacaoComboBox) {
		this.opcoesClassificacaoComboBox = opcoesClassificacaoComboBox;
	}

	public ComboBox<String> getClassificacaoEtariaComboBox() {
		return classificacaoEtariaComboBox;
	}

	public void setClassificacaoEtariaComboBox(ComboBox<String> classificacaoEtariaComboBox) {
		this.classificacaoEtariaComboBox = classificacaoEtariaComboBox;
	}

	public ObservableList<String> getOpcoesTipoComboBox() {
		return opcoesTipoComboBox;
	}

	public void setOpcoesTipoComboBox(ObservableList<String> opcoesTipoComboBox) {
		this.opcoesTipoComboBox = opcoesTipoComboBox;
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
