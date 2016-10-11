package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Temporada;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroTemporadaController {
	@FXML
	private TextField numeroTemporadaField;
	@FXML
	private TextField qtdEpisodiosField;

	private Stage dialogStage;
	private boolean entrarClicked = false;
	private Main main;
	
	private Temporada temporada;

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

	public TextField getNumeroTemporadaField() {
		return numeroTemporadaField;
	}

	public void setNumeroTemporadaField(TextField numeroTemporadaField) {
		this.numeroTemporadaField = numeroTemporadaField;
	}

	public TextField getQtdEpisodiosField() {
		return qtdEpisodiosField;
	}

	public void setQtdEpisodiosField(TextField qtdEpisodiosField) {
		this.qtdEpisodiosField = qtdEpisodiosField;
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

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
    
}
