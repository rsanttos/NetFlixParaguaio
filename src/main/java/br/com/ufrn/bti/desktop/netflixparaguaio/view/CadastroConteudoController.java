package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import java.io.File;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Temporada;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.ConteudoService;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.FilmeService;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.SeriadoService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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
	@FXML
	private TextField duracaoFilmeField;
	@FXML
	private TextField qtdTemporadasField;
	@FXML
	private TextField imgPrincipalField;
	@FXML
	private Button btnEscolheArquivoFilme;
	@FXML
	private Button btnEscolheImgPrincipalSeriado;

	private Stage stage;
	private boolean entrarClicked = false;
	private Main main;

	private Conteudo conteudo;
	private Filme filme;
	private Seriado seriado;
	private Temporada temporada;
	private Episodio episodio;

	private ConteudoService conteudoService = new ConteudoService();
	private FilmeService filmeService = new FilmeService();
	private SeriadoService seriadoService = new SeriadoService();
	
	private String caminhoImgPrincipal;
	private String caminhoArquivoFilme;
	private File arquivo;
	
	public CadastroConteudoController() {
		initialize();
	}

	@FXML
	private void initialize() {
		conteudo = new Conteudo();
		filme = new Filme();
		seriado = new Seriado();
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

	public TextField getDuracaoFilmeField() {
		return duracaoFilmeField;
	}

	public void setDuracaoFilmeField(TextField duracaoFilmeField) {
		this.duracaoFilmeField = duracaoFilmeField;
	}

	public ConteudoService getConteudoService() {
		return conteudoService;
	}

	public void setConteudoService(ConteudoService conteudoService) {
		this.conteudoService = conteudoService;
	}
	
	public Button getBtnEscolheArquivoFilme() {
		return btnEscolheArquivoFilme;
	}

	public void setBtnEscolheArquivoFilme(Button btnEscolheArquivoFilme) {
		this.btnEscolheArquivoFilme = btnEscolheArquivoFilme;
	}

	public Button getBtnEscolheImgPrincipalSeriado() {
		return btnEscolheImgPrincipalSeriado;
	}

	public void setBtnEscolheImgPrincipalSeriado(Button btnEscolheImgPrincipalSeriado) {
		this.btnEscolheImgPrincipalSeriado = btnEscolheImgPrincipalSeriado;
	}

	@FXML
	public void handleEscolheImgPrincipal(){
		FileChooser fileChooser = new FileChooser();
		arquivo = fileChooser.showOpenDialog(stage);
		if(arquivo != null){
			String nome = arquivo.getName();
			File arquivoAux = new File("/Users/ramonsantos/bti/workspaces/programacao_desktop/arquivos/img/" + nome);
			arquivo.renameTo(arquivoAux);
			caminhoImgPrincipal = arquivoAux.getAbsolutePath();
		}
	}
	

	@FXML
	public void handleEscolheArquivoFilme(){
		FileChooser fileChooser = new FileChooser();
		arquivo = fileChooser.showOpenDialog(stage);
		if(arquivo != null){
			String nome = arquivo.getName();
			File arquivoAux = new File("/Users/ramonsantos/bti/workspaces/programacao_desktop/arquivos/filmes/" + nome);
			arquivo.renameTo(arquivoAux);
			caminhoArquivoFilme = arquivoAux.getAbsolutePath();
		}
	}

	@FXML
	public void handleCadastrar() {
		if(validaCamposConteudo()){
			conteudo = new Conteudo();
			conteudo.setNome(nomeField.getText());
			conteudo.setClassificacaoEtaria(classificacaoEtariaComboBox.getValue());
			conteudo.setDescricao(descricaoField.getText());
			conteudo.setAnoLancamento(Integer.parseInt(anoLancamentoField.getText()));
			conteudo.setAtorPrincipal(atorPrincipalField.getText());
			conteudo.setTipo(tipoComboBox.getValue());
			conteudoService.salvarOuAtualizar(conteudo);
			if (conteudo.getTipo().equals("Filme")){
				filme = new Filme();
				filme.setConteudo(conteudo);
				main.showCadastroFilme(filme);
			} else if (conteudo.getTipo().equals("Seriado")){
				seriado = new Seriado();
				seriado.setConteudo(conteudo);
				main.showCadastroSeriado(seriado);
			}
		}
	}

	public boolean validaCamposConteudo() {
		if (nomeField.getText() == null || classificacaoEtariaComboBox.getValue() == null
				|| descricaoField.getText() == null || anoLancamentoField.getText() == null
				|| atorPrincipalField.getText() == null || imgPrincipalField.getText() == null) {
			Alerta.alertaErro("Eita!", "É necessário preencher todos os campos.");
			return false;
		}

		if (anoLancamentoField.getText().length() != 4) {
			Alerta.alertaErro("Algo de errado no campo do ano de lançamento.", "O ano deve conter 4 dígitos.");
			return false;
		}
		
		return true;
	}

	private boolean validaCamposFilme(){
		if(duracaoFilmeField.getText() == null || caminhoArquivoFilme == null){
			Alerta.alertaErro("Eita.", "É necessário informar todos os campos.");
			return false;
		}
		
		return true;
	}
	
	@FXML
	private void handleCancelar() {
		this.stage.close();
	}

	@FXML
	private void handleCadastrarFilme() {
		if(validaCamposConteudo() && validaCamposFilme()){
			conteudo.setNome(nomeField.getText());
			conteudo.setClassificacaoEtaria(classificacaoEtariaComboBox.getValue());
			conteudo.setDescricao(descricaoField.getText());
			conteudo.setAnoLancamento(Integer.parseInt(anoLancamentoField.getText()));
			conteudo.setAtorPrincipal(atorPrincipalField.getText());
			conteudo.setCaminhoImgPrincipal(imgPrincipalField.getText());
			conteudo.setTipo("Filme");
			//conteudoService.salvarOuAtualizar(conteudo);
			filme.setConteudo(conteudo);
			filme.setDuracao(duracaoFilmeField.getText());
			filme.setCaminhoArquivo(caminhoArquivoFilme);
			filmeService.salvarOuAtualizar(filme);
			Alerta.alertaSucesso("Show!", "Filme cadastrado com sucesso. :)");
			filme = new Filme();
			stage.close();
			main.showListagemFilmesAdmin();
		}
	}

	@FXML
	private void handleCadastrarSeriado() {
		if(validaCamposConteudo() && validaCamposSeriado()){
			conteudo = new Conteudo();
			conteudo.setNome(nomeField.getText());
			conteudo.setClassificacaoEtaria(classificacaoEtariaComboBox.getValue());
			conteudo.setDescricao(descricaoField.getText());
			conteudo.setAnoLancamento(Integer.parseInt(anoLancamentoField.getText()));
			conteudo.setAtorPrincipal(atorPrincipalField.getText());
			conteudo.setCaminhoImgPrincipal(imgPrincipalField.getText());
			conteudo.setTipo("Seriado");
			seriado = new Seriado();
			seriado.setConteudo(conteudo);
			seriado.setQtdTemporadas(Integer.parseInt(qtdTemporadasField.getText()));
			seriadoService.salvarOuAtualizar(seriado);
			Episodio episodio = new Episodio();
			episodio.setSeriado(seriado);
			main.showCadastroEpisodio(episodio);
		}
	}	
	
	public boolean validaCamposSeriado(){
		if(qtdTemporadasField.getText() == null){
			Alerta.alertaErro("Rapaz...", "Você deve informar a quantidade de temporadas.");
			return false;
		}
		
		return true;
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

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public Episodio getEpisodio() {
		return episodio;
	}

	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}

	public FilmeService getFilmeService() {
		return filmeService;
	}

	public void setFilmeService(FilmeService filmeService) {
		this.filmeService = filmeService;
	}

	public TextField getQtdTemporadasField() {
		return qtdTemporadasField;
	}

	public void setQtdTemporadasField(TextField qtdTemporadasField) {
		this.qtdTemporadasField = qtdTemporadasField;
	}

	public SeriadoService getSeriadoService() {
		return seriadoService;
	}

	public void setSeriadoService(SeriadoService seriadoService) {
		this.seriadoService = seriadoService;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	public String getCaminhoImgPrincipal() {
		return caminhoImgPrincipal;
	}

	public void setCaminhoImgPrincipal(String caminhoImgPrincipal) {
		this.caminhoImgPrincipal = caminhoImgPrincipal;
	}

	public String getCaminhoArquivoFilme() {
		return caminhoArquivoFilme;
	}

	public void setCaminhoArquivoFilme(String caminhoArquivoFilme) {
		this.caminhoArquivoFilme = caminhoArquivoFilme;
	}

	public TextField getImgPrincipalField() {
		return imgPrincipalField;
	}

	public void setImgPrincipalField(TextField imgPrincipalField) {
		this.imgPrincipalField = imgPrincipalField;
	}	
	
}
