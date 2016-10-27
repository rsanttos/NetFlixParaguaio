package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import br.com.ufrn.bti.desktop.netflixparaguaio.util.MediaControl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class TocadorJavaFx extends Application {

	private static final String MEDIA = "file:/Users/ramonsantos/bti/workspaces/programacao_desktop/arquivos/filmes/video2.flv";
	private static String arg1;

	public void start(Stage primaryStage) {
		primaryStage.setTitle("JavaLees MediaPlayer - JavaFX 2.0");
		Group root = new Group();
		Scene scene = new Scene(root, 540, 241);

		Media media = new Media((arg1 != null) ? arg1 : MEDIA);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);

		MediaControl mediaControl = new MediaControl(mediaPlayer);
		scene.setRoot(mediaControl);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}