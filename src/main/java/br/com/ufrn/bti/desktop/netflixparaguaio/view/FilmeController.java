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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FilmeController {

	@FXML
	private TableView<Filme> tabelaFilme;
	
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
				Label l = new Label(String.valueOf(c.getNome()));
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
				hbFilmes.getChildren().add(btnPlay);
				hbFilmes.getChildren().add(l);
			} else if(c.getTipo().equals("Seriado")){
				Label l = new Label(String.valueOf(c.getNome()));
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
				hbSeries.getChildren().add(l);				
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
		//Alerta.alertaSucesso(nome, "deu certo!");
		Filme filme = new Filme();
		filme = filmeService.buscarPeloIdConteudo(conteudo.getId());
		Alerta.alertaSucesso(filme.getCaminhoArquivo(), "deu certo!");
		//main.showMediaPlayerFilme();
	}
	
	public void abrirTemporadas(String nome){
		Alerta.alertaSucesso(nome, "deu certo!");
	}
}
