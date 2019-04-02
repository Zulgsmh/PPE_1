package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.FicheFraisDAO;
import DAO.VisiteurDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import model.FicheFrais;
import view.FenetreConnexion;


public class FicheController {

	 @FXML
	    private TableView<FicheFrais> tableauVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String>  idVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String>  nomVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String> prenomVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String> adresseVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String> cpVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String> villeVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String> dateEmbaucheVisiteur;
	    @FXML
	    private TableColumn<FicheFrais, String> etatFiche;
	    //  tableColumn est de type button
	    @FXML
	    private TableColumn afficherFichesFraisVisiteur;
	    
	    @FXML
	    private TextField nbMois;
	    
	    ObservableList<FicheFrais> listeFicheFrais ;
	    
	    @FXML
	    private Button Dcx;
	    
	    @FXML
	    private void initialize () {

	    		//recuperation des données
	    		try {
	    			listeFicheFrais =  (new FicheFraisDAO()).findAll();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	
	    	System.out.println(listeFicheFrais.get(0));
			tableauVisiteur.setItems(listeFicheFrais);
			
			 Callback<TableColumn<FicheFrais, String>, TableCell<FicheFrais, String>> cellFactory
	         = //
	         new Callback<TableColumn<FicheFrais, String>, TableCell<FicheFrais, String>>() {
	     @Override
	     public TableCell call(final TableColumn<FicheFrais, String> param) {
	         final TableCell<FicheFrais, String> cell = new TableCell<FicheFrais, String>() {

	             final Button btn = new Button("Afficher");

	             @Override
	             public void updateItem(String item, boolean empty) {
	                 super.updateItem(item, empty);
	                 if (empty) {
	                     setGraphic(null);
	                     setText(null);
	                 } else {
	                     btn.setOnAction(event -> {
	                    	 FicheFrais      fiche = getTableView().getItems().get(getIndex());
	                    System.out.println(fiche.getIdVisiteur());
	                       
	                       FXMLLoader loader = new FXMLLoader();
	         			    loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("view/afficherLigneFicheForfait.fxml"));
	         			   AnchorPane userFrame;
						try {
							  userFrame = (AnchorPane) loader.load();
							
	                        Scene sc = btn.getScene();
	                        
	                        LigneFraisForfaitController ligneController = loader.getController(); 
	                        // faire passer les info a l'autre page 
	                    	
	                  ligneController.setFiche(fiche);
	                        
	                        sc.setRoot(userFrame);
	                     
	                     
	                       
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	         			    // Set person overview into the center of root layout.
	         			 
	                     });
	                     setGraphic(btn);
	                     setText(null);
	                 }
	             }
	         };
	         return cell;
	     }
	 };
			afficherFichesFraisVisiteur.setCellFactory(cellFactory);

	    	 idVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getIdPro() );
	         nomVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getNomPro());
	         prenomVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getPrenomPro());
	         adresseVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getAdressePro());
	         cpVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getCpPro());
	         villeVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getVillePro());
	        dateEmbaucheVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getDateEmbauchePro().asString());
	       etatFiche.setCellValueFactory(cellData -> cellData.getValue().getIdEtat().getLibellePro());





	    }
	    
	    
	    
	    @FXML
	    private void filtrerParMois(ActionEvent evt) {
	    	
	    	
	    String mois =	nbMois.getText();
	    
	 
		try {
			listeFicheFrais = (new FicheFraisDAO()).findByMois(mois);
			 tableauVisiteur.setItems(listeFicheFrais);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    	
	    } 
	    
	    @FXML
	    public void Deconnexion(ActionEvent actEv)  throws SQLException, IOException {

	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("view/Connexion.fxml"));
	           Pane Connexion  = (Pane) loader.load();
	                Stage stage =  (Stage) Dcx.getScene().getWindow();
	            // Set person overview into the center of root layout.

	                Scene scene = Dcx.getScene();
	                scene.setRoot(Connexion);
	                stage.setScene(scene);

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }
}