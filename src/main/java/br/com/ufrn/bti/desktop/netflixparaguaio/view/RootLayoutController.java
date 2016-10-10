package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class RootLayoutController {

	// Referência à aplicação principal
	private Main main;

	/**
	 * É chamado pela aplicação principal para referenciar a si mesma.
	 * 
	 * @param main
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	/**
	 * Cria uma agenda vazia.
	 */
	@FXML
	private void handleNewUsuario() {
	}

	@FXML
	private void handleListarUsuarios() {
	}

	@FXML
	private void handleListarFilmesUser() {
	}
	@FXML
	private void handleListarSeriadosUser() {
	}
	@FXML
	private void handlePesquisar() {
	}
	/**
	 * Abre uma janela Sobre.
	 */
	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("NetFlixParaguaio");
		alert.setHeaderText("Sobre");
		alert.setContentText("Autor: Ramon Malaquias\n IMDXXXX - BTI - 2016.2");
		alert.showAndWait();
	}
	/**
	 * Fecha a aplicação.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}
}