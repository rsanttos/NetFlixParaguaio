package br.com.ufrn.bti.desktop.netflixparaguaio.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {
	
	public static void alertaErro(String textoHeader, String textoMensagem) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Ops...");
		alert.setHeaderText(textoHeader);
		alert.setContentText(textoMensagem);
		alert.showAndWait();
	}
	public static void alertaSucesso(String textoHeader, String textoMensagem) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Show! :)");
		alert.setHeaderText(textoHeader);
		alert.setContentText(textoMensagem);
		alert.showAndWait();
	}
}
