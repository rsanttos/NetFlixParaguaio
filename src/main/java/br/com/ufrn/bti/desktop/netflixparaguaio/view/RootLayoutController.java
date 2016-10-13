package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class RootLayoutController {

	// Referência à aplicação principal
	private Main main;
	private Stage stage;

	/**
	 * É chamado pela aplicação principal para referenciar a si mesma.
	 * 
	 * @param main
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Main getMain() {
		return main;
	}

	@FXML
	private void handleNewUsuario() {
		Usuario usuarioAux = new Usuario();
		main.showCadastroUsuario(usuarioAux);
	}

	@FXML
	private void handleNewConteudo() {
		Conteudo conteudoAux = new Conteudo();
		main.showCadastroConteudo(conteudoAux);
	}
	@FXML
	private void handleListarUsuarios() {
		main.showListagemUsuarios();
	}

	@FXML
	private void handleListarFilmes() {
		main.showListagemFilmes();
	}
	@FXML
	private void handleListarSeriados() {
		main.showListagemSeriados();
	}
	@FXML
	private void handleListarFilmesAdmin() {
		main.showListagemFilmesAdmin();
	}
	@FXML
	private void handleListarSeriadosAdmin() {
		main.showListagemSeriadosAdmin();
	}
	@FXML
	private void handlePesquisar() {
		main.showPesquisa();
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