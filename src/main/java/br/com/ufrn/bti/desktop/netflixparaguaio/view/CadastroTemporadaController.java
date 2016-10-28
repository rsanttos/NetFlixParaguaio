//package br.com.ufrn.bti.desktop.netflixparaguaio.view;
//
//import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
//import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Temporada;
//import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
//import br.com.ufrn.bti.desktop.netflixparaguaio.service.TemporadaService;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//public class CadastroTemporadaController {
//	@FXML
//	private TextField numeroTemporadaField;
//	@FXML
//	private TextField qtdEpisodiosField;
//
//	private Stage stage;
//	private boolean entrarClicked = false;
//	private Main main;
//	
//	private Temporada temporada;
//	private TemporadaService temporadaService = new TemporadaService();
//
//	@FXML
//	private void initialize() {
//	}
//
//	@FXML
//	public void handleCadastrarTemporada(){
//		if(true){
//			temporada.setNumeroTemporada(Integer.parseInt(numeroTemporadaField.getText()));
//			temporada.setQtdEpisodios(Integer.parseInt(qtdEpisodiosField.getText()));
//			temporadaService.salvarOuAtualizar(temporada);
//			Episodio episodio = new Episodio();
//			//episodio.setTemporada(temporada);
//			main.showCadastroEpisodio(episodio);
//		}
//	}
//	
//    @FXML
//    private void handleCancelar() {
//        stage.close();
//    }
//
//	public TextField getNumeroTemporadaField() {
//		return numeroTemporadaField;
//	}
//
//	public void setNumeroTemporadaField(TextField numeroTemporadaField) {
//		this.numeroTemporadaField = numeroTemporadaField;
//	}
//
//	public TextField getQtdEpisodiosField() {
//		return qtdEpisodiosField;
//	}
//
//	public void setQtdEpisodiosField(TextField qtdEpisodiosField) {
//		this.qtdEpisodiosField = qtdEpisodiosField;
//	}
//
//	public Stage getStage() {
//		return stage;
//	}
//
//	public void setStage(Stage stage) {
//		this.stage = stage;
//	}
//
//	public boolean isEntrarClicked() {
//		return entrarClicked;
//	}
//
//	public void setEntrarClicked(boolean entrarClicked) {
//		this.entrarClicked = entrarClicked;
//	}
//
//	public Main getMain() {
//		return main;
//	}
//
//	public void setMain(Main main) {
//		this.main = main;
//	}
//
//	public Temporada getTemporada() {
//		return temporada;
//	}
//
//	public void setTemporada(Temporada temporada) {
//		this.temporada = temporada;
//	}
//
//	public TemporadaService getTemporadaService() {
//		return temporadaService;
//	}
//
//	public void setTemporadaService(TemporadaService temporadaService) {
//		this.temporadaService = temporadaService;
//	}
//    
//}
