package view;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenetreConnexion extends Application {
private Stage primaryStage ;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage ;
		
		try {
			FXMLLoader acc = new FXMLLoader() ;
			acc.setLocation(FenetreConnexion.class.getClassLoader().getResource("View/connexion.fxml"));
			Pane cnx = (Pane)acc.load();
			Scene scene = new Scene(cnx,700,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
