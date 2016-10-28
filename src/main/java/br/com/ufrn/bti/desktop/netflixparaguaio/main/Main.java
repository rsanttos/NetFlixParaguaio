package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import java.io.IOException;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.MediaControl;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.CadastroConteudoController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.CadastroEpisodioController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.CadastroUsuarioController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.FilmeController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.LoginController;
import br.com.ufrn.bti.desktop.netflixparaguaio.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
			loader.setLocation(Main.class.getResource("../view/cadastroUsuario.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Cadastro de Usuário");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			CadastroUsuarioController controller = loader.getController();
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
	
	public boolean showCadastroFilme(Filme filme) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/cadastroFilme.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Cadastro de Filme");
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
	
	public boolean showDetalhesFilme(Filme filme) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/detalhesFilme.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Detalhes de Filme");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			FilmeController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.carregaComponentesFilme(filme);
			controller.setMain(this);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showDetalhesSeriado(Usuario usuarioLogado, Seriado seriado) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/detalhesSeriado.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Detalhes de Seriado");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			FilmeController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setUsuarioLogado(usuarioLogado);
			controller.carregaComponentesSeriado(seriado);
			controller.setMain(this);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showMediaPlayer(String caminhoArquivo){
		
		Stage stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 540, 400);
		
		//Media media = new Media("file:/Users/ramonsantos/bti/workspaces/programacao_desktop/arquivos/filmes/video2.flv");
		Media media = new Media("file:" + caminhoArquivo);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		
		MediaControl mediaControl = new MediaControl(mediaPlayer);
		scene.setRoot(mediaControl);
		
		stage.setScene(scene);
		stage.show();
		
		return true;
	}

	public boolean showCadastroSeriado(Seriado seriado) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/cadastroSeriado.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Cadastro de Seriado");
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

	public boolean showCadastroEpisodio(Episodio episodio) {
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/cadastroEpisodio.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Cadastro de Episódio");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			CadastroEpisodioController controller = loader.getController();
			controller.setEpisodio(episodio);
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
	
	public boolean showListagemFilmesAdmin(Usuario usuarioLogado) {
		initRootLayoutAdmin();
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemConteudoAdmin.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Filmes");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			rootLayout.setCenter(page);
			
			FilmeController controller = loader.getController();
			controller.setUsuarioLogado(usuarioLogado);
			controller.setStage(dialogStage);
			controller.setMain(this);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showListagemFilmesUser(Usuario usuarioLogado) {
		initRootLayoutUser();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/listagemConteudoUser.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Listagem de Filmes");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			FilmeController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setUsuarioLogado(usuarioLogado);
			controller.setMain(this);
			
			rootLayout.setCenter(page);

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean showPesquisa(Usuario usuarioLogado) {
		initRootLayoutUser();
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/pesquisar.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("NetFlixParaguaio - Pesquisar conteúdo");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			FilmeController controller = loader.getController();
			controller.setUsuarioLogado(usuarioLogado);
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
