package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
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
	private TextField duracaoField;

	private Stage dialogStage;
	private boolean entrarClicked = false;
	private Main main;
	
	private Episodio episodio;

	@FXML
	private void initialize() {
	}

	@FXML
	public void handleCadastrar(){
		
	}
	
    @FXML
    private void handleCancel() {
        dialogStage.close();
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

	public TextField getDuracaoField() {
		return duracaoField;
	}

	public void setDuracaoField(TextField duracaoField) {
		this.duracaoField = duracaoField;
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

	public Episodio getEpisodio() {
		return episodio;
	}

	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}
    
}
