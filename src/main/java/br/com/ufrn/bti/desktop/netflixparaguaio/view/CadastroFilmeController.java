package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroFilmeController {

	@FXML
	private TextField duracaoField;

	private Stage stage;
	private boolean entrarClicked = false;
	private Main main;
	
	private Filme filme;

	@FXML
	private void initialize() {
	}

	public TextField getDuracaoField() {
		return duracaoField;
	}

	public void setDuracaoField(TextField duracaoField) {
		this.duracaoField = duracaoField;
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

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	

	@FXML
	public void handleCadastrar(){
		
	}
	
    @FXML
    private void handleCancelar() {
        stage.close();
    }
}
