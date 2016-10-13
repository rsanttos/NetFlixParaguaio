package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import java.io.IOException;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.CadastroConteudoController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.CadastroUsuarioController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.LoginController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;

	private BorderPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("NetFlixParaguaio");
		showLogin();
	}
	
	public boolean showLogin() {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/telaLogin.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Login");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			LoginController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showCadastroUsuario(Usuario usuario) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/cadastroConteudo.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Cadastro de Conteúdo");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showCadastroConteudo(Conteudo conteudo) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/cadastroConteudo.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Cadastro de Conteúdo");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showListagemFilmesAdmin() {
		initRootLayoutAdmin();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemFilmesAdmin.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Filmes");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			rootLayout.setCenter(page);
			
			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showListagemFilmesUser() {
		initRootLayoutUser();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemFilmesUser.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Filmes");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);
			
			rootLayout.setCenter(page);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showPesquisa() {
		initRootLayoutUser();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemFilmes.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Pesquisar conteúdo");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);
			
			rootLayout.setCenter(page);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showListagemSeriadosAdmin() {
		initRootLayoutAdmin();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemSeriadosAdmin.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Seriados");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);
			
			rootLayout.setCenter(page);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showListagemSeriadosUser() {
		initRootLayoutUser();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemSeriadosUser.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Seriados");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			CadastroConteudoController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);
			
			rootLayout.setCenter(page);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showListagemUsuarios() {
		initRootLayoutAdmin();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemUsuarios.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Usuários");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			CadastroUsuarioController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);
			
			rootLayout.setCenter(page);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void initRootLayoutAdmin() {
		try {
			// Carrega o root layout do arquivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayoutAdmin.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostra a scene (cena) contendo o root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Dá ao controller o acesso ao main app.
			RootLayoutController controller = loader.getController();
			controller.setMain(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void initRootLayoutUser() {
		try {
			// Carrega o root layout do arquivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayoutUser.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostra a scene (cena) contendo o root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Dá ao controller o acesso ao main app.
			RootLayoutController controller = loader.getController();
			controller.setMain(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
