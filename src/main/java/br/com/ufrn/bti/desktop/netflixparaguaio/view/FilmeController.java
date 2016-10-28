package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.ConteudoService;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.FilmeService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FilmeController {

	@FXML
	private TableView<Filme> tabelaFilme;
	
	@FXML
	private Label lblNome;
	@FXML
	private Label lblDescricao;
	@FXML
	private Label lblClassificacao;
	@FXML
	private Label lblAtorPrincipal;
	@FXML
	private Label lblDuracao;
	@FXML
	private Label lblAno;
	@FXML
	private ImageView imgViewDetalhes;
	
	@FXML
	private AnchorPane apImgView;
	
	@FXML
	private ScrollPane spFilmes;
	
	@FXML
	private ScrollPane spSeries;	

	@FXML
	private TableColumn<Filme, String> colunaImgPrincipal;
	
	@FXML
	private TableColumn<Filme, String> colunaNome;

	@FXML
	private TableColumn<Filme, String> colunaDescricao;

	@FXML
	private TableColumn<Filme, String> colunaCensura;

	@FXML
	private TableColumn<Filme, String> colunaPlay;
	
	private Main main;
	
	private FilmeService filmeService;
	
	private ConteudoService conteudoService;

	private Stage stage;
	
	private boolean entrarClicked = false;

	public FilmeController() {
//		this.tabelaFilme = new TableView<>();
//		this.colunaImgPrincipal = new TableColumn<Filme, String>();
//		this.colunaCensura = new TableColumn<Filme, String>();
//		this.colunaDescricao = new TableColumn<Filme, String>();
//		this.colunaNome = new TableColumn<Filme, String>();
//		this.colunaPlay = new TableColumn<Filme, String>();
		lblNome = new Label();
		lblDescricao = new Label();
		lblClassificacao = new Label();
		lblAtorPrincipal = new Label();
		lblDuracao = new Label();
		lblAno = new Label();
		imgViewDetalhes = new ImageView();
		apImgView = new AnchorPane();
		spFilmes = new ScrollPane();
		spSeries = new ScrollPane();
		filmeService = new FilmeService();
		conteudoService = new ConteudoService();
	}
	
	@FXML
	private void initialize() {
//		colunaImgPrincipal.setCellValueFactory(new PropertyValueFactory<Filme, String>("Imagem Principal"));
//		colunaCensura.setCellValueFactory(new PropertyValueFactory<Filme, String>("Censura"));
//		colunaDescricao.setCellValueFactory(new PropertyValueFactory<Filme, String>("Descrição"));
//		colunaNome.setCellValueFactory(new PropertyValueFactory<Filme, String>("Nome"));
//		colunaPlay.setCellValueFactory(new PropertyValueFactory<Filme, String>("Assistir"));
//		
//		tabelaFilme.getColumns().add(colunaImgPrincipal);
//		tabelaFilme.getColumns().add(colunaNome);
//		tabelaFilme.getColumns().add(colunaDescricao);
//		tabelaFilme.getColumns().add(colunaCensura);
//		tabelaFilme.getColumns().add(colunaPlay);
		
		List<Filme> filmes = new ArrayList<Filme>();
		List<Conteudo> conteudos = new ArrayList<Conteudo>();
		filmes = filmeService.listar();
		conteudos = conteudoService.listar();
		
		HBox hbFilmes = new HBox();
		HBox hbSeries = new HBox();
		
		for(Conteudo c : conteudos){
			if(c.getTipo().equals("Filme")){
				hbFilmes.setSpacing(30);
				hbFilmes.setAlignment(Pos.CENTER);
				Image image = new Image(c.getCaminhoImgPrincipal());
				ImageView imgView = new ImageView(image);
				imgView.setFitWidth(200);
				imgView.setFitHeight(200);
				Button btnPlay = new Button();
				btnPlay.setGraphic(imgView);
				btnPlay.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						executarVideo(c);
					}
				});
				Button btnDetalhes = new Button("Detalhes");
				btnDetalhes.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						verDetalhesFilme(c);
					}
				});
				hbFilmes.getChildren().add(btnPlay);
				hbFilmes.getChildren().add(btnDetalhes);
			} else if(c.getTipo().equals("Seriado")){
				hbSeries.setSpacing(30);
				hbSeries.setAlignment(Pos.CENTER);				
				Image image = new Image(c.getCaminhoImgPrincipal());
				ImageView imgView = new ImageView(image);
				imgView.setFitWidth(200);
				imgView.setFitHeight(200);
				Button btnAbrir= new Button();
				btnAbrir.setGraphic(imgView);
				btnAbrir.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						abrirTemporadas(c.getNome());
					}
				});
				hbSeries.getChildren().add(btnAbrir);			
			}
		}
		
		spFilmes.setContent(hbFilmes);
		spSeries.setContent(hbSeries);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
		//tabelaFilme.setItems(FXCollections.observableList(filmeService.listar()));
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
	
	public void executarVideo(Conteudo conteudo){
		Filme filme = new Filme();
		filme = filmeService.buscarPeloIdConteudo(conteudo.getId());
		//Alerta.alertaSucesso(filme.getCaminhoArquivo(), "deu certo!");
		main.showMediaPlayerFilme(filme);
	}
	
	public void verDetalhesFilme(Conteudo conteudo){
		Filme filme = new Filme();
		filme = filmeService.buscarPeloIdConteudo(conteudo.getId());
		filme.setConteudo(conteudo);
		main.showDetalhesFilme(filme);
	}
	
	public void carregaComponentes(Filme filme){
		lblNome.setText(filme.getConteudo().getNome());
		lblDescricao.setText(filme.getConteudo().getDescricao());
		lblClassificacao.setText(filme.getConteudo().getClassificacaoEtaria());
		lblAtorPrincipal.setText(filme.getConteudo().getAtorPrincipal());
		lblDuracao.setText(filme.getDuracao());
		lblAno.setText(String.valueOf(filme.getConteudo().getAnoLancamento()));
		Image image = new Image(filme.getConteudo().getCaminhoImgPrincipal());
		imgViewDetalhes = new ImageView(image);
		imgViewDetalhes.setVisible(true);
		imgViewDetalhes.setFitWidth(200);
		imgViewDetalhes.setFitHeight(200);
	}
	
	public void abrirTemporadas(String nome){
		Alerta.alertaSucesso(nome, "deu certo!");
	}

	public TableView<Filme> getTabelaFilme() {
		return tabelaFilme;
	}

	public void setTabelaFilme(TableView<Filme> tabelaFilme) {
		this.tabelaFilme = tabelaFilme;
	}

	public Label getLblNome() {
		return lblNome;
	}

	public void setLblNome(Label lblNome) {
		this.lblNome = lblNome;
	}

	public ScrollPane getSpFilmes() {
		return spFilmes;
	}

	public void setSpFilmes(ScrollPane spFilmes) {
		this.spFilmes = spFilmes;
	}

	public ScrollPane getSpSeries() {
		return spSeries;
	}

	public void setSpSeries(ScrollPane spSeries) {
		this.spSeries = spSeries;
	}

	public TableColumn<Filme, String> getColunaImgPrincipal() {
		return colunaImgPrincipal;
	}

	public void setColunaImgPrincipal(TableColumn<Filme, String> colunaImgPrincipal) {
		this.colunaImgPrincipal = colunaImgPrincipal;
	}

	public TableColumn<Filme, String> getColunaNome() {
		return colunaNome;
	}

	public void setColunaNome(TableColumn<Filme, String> colunaNome) {
		this.colunaNome = colunaNome;
	}

	public TableColumn<Filme, String> getColunaDescricao() {
		return colunaDescricao;
	}

	public void setColunaDescricao(TableColumn<Filme, String> colunaDescricao) {
		this.colunaDescricao = colunaDescricao;
	}

	public TableColumn<Filme, String> getColunaCensura() {
		return colunaCensura;
	}

	public void setColunaCensura(TableColumn<Filme, String> colunaCensura) {
		this.colunaCensura = colunaCensura;
	}

	public TableColumn<Filme, String> getColunaPlay() {
		return colunaPlay;
	}

	public void setColunaPlay(TableColumn<Filme, String> colunaPlay) {
		this.colunaPlay = colunaPlay;
	}

	public FilmeService getFilmeService() {
		return filmeService;
	}

	public void setFilmeService(FilmeService filmeService) {
		this.filmeService = filmeService;
	}

	public ConteudoService getConteudoService() {
		return conteudoService;
	}

	public void setConteudoService(ConteudoService conteudoService) {
		this.conteudoService = conteudoService;
	}

	public Label getLblDescricao() {
		return lblDescricao;
	}

	public void setLblDescricao(Label lblDescricao) {
		this.lblDescricao = lblDescricao;
	}

	public Label getLblClassificacao() {
		return lblClassificacao;
	}

	public void setLblClassificacao(Label lblClassificacao) {
		this.lblClassificacao = lblClassificacao;
	}

	public Label getLblAtorPrincipal() {
		return lblAtorPrincipal;
	}

	public void setLblAtorPrincipal(Label lblAtorPrincipal) {
		this.lblAtorPrincipal = lblAtorPrincipal;
	}

	public Label getLblDuracao() {
		return lblDuracao;
	}

	public void setLblDuracao(Label lblDuracao) {
		this.lblDuracao = lblDuracao;
	}
	
}
