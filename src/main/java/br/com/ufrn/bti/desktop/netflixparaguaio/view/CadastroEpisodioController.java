package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.EpisodioService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroEpisodioController {
	@FXML
	private TextField imgField;
	@FXML
	private TextField nomeEpField;
	@FXML
	private TextField numeroEpField;
	@FXML
	private TextField duracaoEpField;

	private Stage stage;
	private boolean entrarClicked = false;
	private Main main;
	
	private Episodio episodio;
	private EpisodioService episodioService = new EpisodioService();

	@FXML
	private void initialize() {
	}

	@FXML
	public void handleCadastrarEpisodio(){
		if(validaCamposEpisodio()){
			episodio.setDuracao(duracaoEpField.getText());
			episodio.setNome(nomeEpField.getText());
			episodio.setNumeroEpisodio(Integer.parseInt(numeroEpField.getText()));
			//episodio.setCaminhoArquivo(imgField.getText());
			episodioService.salvarOuAtualizar(episodio);
			Alerta.alertaSucesso("Aê!!!", "Episódio salvo com sucesso.");
		}
	}
	
	public boolean validaCamposEpisodio(){
		return true;
	}
	
    @FXML
    private void handleCancelar() {
        stage.close();
    }

	public TextField getImgField() {
		return imgField;
	}

	public void setImgField(TextField imgField) {
		this.imgField = imgField;
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

	public TextField getDuracaoEpField() {
		return duracaoEpField;
	}

	public void setDuracaoEpField(TextField duracaoEpField) {
		this.duracaoEpField = duracaoEpField;
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

	public Episodio getEpisodio() {
		return episodio;
	}

	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}
    
}
