package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import java.io.IOException;

import br.com.ufrn.bti.desktop.netflixparaguaio.view.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;


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
			controller.setDialogStage(dialogStage);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			return controller.isEntrarClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
