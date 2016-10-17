package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroSeriadoController {
	
	@FXML
	private TextField qtdTemporadas;

	private Stage stage;
	private boolean entrarClicked = false;
	private Main main;
	
	private Seriado seriado;
	

	public TextField getQtdTemporadas() {
		return qtdTemporadas;
	}

	public void setQtdTemporadas(TextField qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
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

	public Seriado getSeriado() {
		return seriado;
	}

	public void setSeriado(Seriado seriado) {
		this.seriado = seriado;
	}

	@FXML
	private void initialize() {
	}

	@FXML
	public void handleCadastrar(){
		
	}
	
    @FXML
    private void handleCancelar() {
        stage.close();
    }
}
