package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.DocumentDAO;
import DAO.FicheFraisDAO;
import DAO.LigneFraisForfaitDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Document;
import model.FicheFrais;
import model.LigneFraisForfait;
import view.FenetreConnexion;

public class LigneFraisForfaitController {
	  @FXML
	    private Label labelId;
	  @FXML
	    private Label labelNom;
	  @FXML
	    private Label labelPrenom;

	  //------------------------------------------------
	
	@FXML
    private TableView<LigneFraisForfait> tableauFicheFraisVisiteur;
    @FXML
    private TableColumn<LigneFraisForfait, String> idVisiteur;
    @FXML
    private TableColumn<LigneFraisForfait, String> mois ;
    @FXML
    private TableColumn<LigneFraisForfait, String> idFraisForfait;
    @FXML
    private TableColumn<LigneFraisForfait, String> quantite;
    @FXML
    private TableColumn<LigneFraisForfait, String> montant;

    ObservableList<LigneFraisForfait> listeFicheFrais ;
    FicheFrais fiche ;
    
    //--------------------------------------------------------
    
    @FXML
    private TableView<Document> tableauJustificatif;
    @FXML 
    private TableColumn<Document, String> descriptionJustificatif;
    @FXML
    private TableColumn<Document, Float> montantJustificatif;
    @FXML
    private TableColumn<Document, String> path;
    @FXML
    private TableColumn<Document, String> idJustificatif;

    
    ObservableList<Document> listeDocument ;
    //------------------------------------------------------------
    @FXML
    private Button validerFicheDeFrais;
    
    @FXML
    private Button Dcx; //bouton deconnexion
    
    @FXML
    private TableColumn afficherJustificatif ;
    
    @FXML
    private void initialize () {

    		//recuperation des données
    		try {
    			listeFicheFrais =  (new LigneFraisForfaitDAO()).findAll();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
    	System.out.println(listeFicheFrais.get(0));
	tableauFicheFraisVisiteur.setItems(listeFicheFrais);
		
    	 idVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getIdPro() );
         mois.setCellValueFactory(cellData -> cellData.getValue().getMoisPro());
         idFraisForfait.setCellValueFactory(cellData -> cellData.getValue().getIdFraisForfaitPro().getIdPro());
         montant.setCellValueFactory(cellData -> cellData.getValue().getMontantPro().asString());
         quantite.setCellValueFactory(cellData -> cellData.getValue().getQuantitePro().asString());
    

    		//recuperation des données
    		try {
    			listeDocument =  (new DocumentDAO()).findAll();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
    	System.out.println(listeDocument.get(0));
    	tableauJustificatif.setItems(listeDocument);
		
		 Callback<TableColumn<Document, String>, TableCell<Document, String>> cellFactory1
         = //
         new Callback<TableColumn<Document, String>, TableCell<Document, String>>() {
     @Override
     public TableCell call(final TableColumn<Document, String> param) {
         final TableCell<Document, String> cell = new TableCell<Document, String>() {

             final Button btn = new Button("Afficher");

             @Override
             public void updateItem(String item, boolean empty) {
                 super.updateItem(item, empty);
                 if (empty) {
                     setGraphic(null);
                     setText(null); 
                 } else {
                     btn.setOnAction(event -> {
                    	 Document   doc = getTableView().getItems().get(getIndex());
                    System.out.println(doc.getIdJustificatif());
                       
                       FXMLLoader loader = new FXMLLoader();
         			    loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("view/afficherPagePDF.fxml"));
         			   AnchorPane userFrame;
					try {
						  userFrame = (AnchorPane) loader.load();
						
                        Scene sc = btn.getScene();
                        
                        PdfController pdfcontrol = loader.getController(); 
                        
                  pdfcontrol.setDocument(doc);
                        
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
	
 afficherJustificatif.setCellFactory(cellFactory1);
if ( idJustificatif == null) {
	System.out.print("ID JUSTIFICATIF NULL");
}else {
    	 idJustificatif.setCellValueFactory(cellData -> cellData.getValue().getIdJustificatifPro().asString());
    	 path.setCellValueFactory(cellData -> cellData.getValue().getPathPro());
}
    }
    
    
    
    
    
public void actionValiderLaFiche(ActionEvent evt) throws SQLException, IOException {
	System.out.println(fiche);
	FicheFraisDAO.updateFiche(fiche.getIdVisiteur().getId(),fiche.getMois());

	
	 try {
         // Load person overview.
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("view/afficherFicheFrais.fxml"));
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




	

	


	public FicheFrais getFiche() {
		return fiche;
	}
	public void setFiche(FicheFrais fiche) {
		this.fiche = fiche;
		labelId.setText(fiche.getIdVisiteur().getId());
		labelNom.setText(fiche.getIdVisiteur().getNom());
		labelPrenom.setText(fiche.getIdVisiteur().getPrenom());
	}
	@FXML
    public void Deconnexion(ActionEvent actEv)  throws SQLException, IOException {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("view/connexion.fxml"));
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
	@FXML
    public void Retour(ActionEvent actEv)  throws SQLException, IOException {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FenetreConnexion.class.getClassLoader().getResource("view/afficherFicheFrais.fxml"));
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
