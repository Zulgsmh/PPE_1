package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.ComptableDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.FenetreConnexion;

public class ConnexionController {
	
	@FXML
	TextField txtMdp ;
	@FXML
	TextField txtLogin ;
	@FXML
	TextField test ;
	@FXML
	Pane mainConnexion ;
	
	@FXML
	private void actionConnexion(ActionEvent evt) throws SQLException, IOException {
		
		try {
			if ( ComptableDAO.auth(txtMdp.getText(),txtLogin.getText())) {
				
				
				 // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("View/afficherFicheFrais.fxml"));
	           AnchorPane visiteurFrame = (AnchorPane) loader.load();

	            // Set person overview into the center of root layout.
	           Stage stage =  (Stage) txtMdp.getScene().getWindow();
	           // Set person overview into the center of root layout.
	               
	               Scene scene = txtMdp.getScene();
	               scene.setRoot(visiteurFrame);
	               stage.setScene(scene);
			}
			else {
				
				test.setText("faux");
			}
		}
		catch(Exception ec){
			System.out.println(ec);
		}
		
		
	}
	
	@FXML
	private void initialize() {
		
		txtMdp.setText("");
		
}

	
	
	
	
	
}
