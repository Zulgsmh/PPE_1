package DAO;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Document;
import model.Visiteur;

public class DocumentDAO implements DAO<Document> {

	public ObservableList<Document>  findAll() throws SQLException {
		// TODO Auto-generated method stub
		ObservableList<Document> listeDocument = FXCollections.observableArrayList();
		
	String sqlReq = "SELECT * FROM Document";
	Connection cx =  Connect.getInstance().getConnection() ;
	PreparedStatement pst = cx.prepareStatement(sqlReq);
	ResultSet table = pst.executeQuery();
	
	 int idJustificatif;
	// String idFraisForfait;
	 String path;
	 String idVisiteur;
	// String nomJustificatif;
	// Float montantJustificatif;
	
	
	while(table.next())
	{
		idVisiteur = table.getString("idVisiteur");
	 	idJustificatif = table.getInt("idJustificatif");
	 //	idFraisForfait = table.getString("idFraisForfait");
	 	path = table.getString("path");
	 //	nomJustificatif = table.getString("nomJustificatif");
	 //	montantJustificatif = table.getFloat("montantJustificatif");

	 //	VisiteurDAO vd = new VisiteurDAO();
 VisiteurDAO vd = new VisiteurDAO();
 Visiteur v = vd.findById(idVisiteur);
 //FraisForfaitDAO ffd = new FraisForfaitDAO();
 //FraisForfait ff = ffd.findById(idFraisForfait);

 
 
	 	Document doc = new Document(v);
	 	doc.setIdVisiteur(v);
	 	doc.setIdJustificatif(idJustificatif);
	 //	doc.setIdFraisForfait(ff);
	 	doc.setPath(path);
	 //	doc.setNomJustificatif(nomJustificatif);
	 //	doc.setMontantJustificatif(montantJustificatif);
	
	 
		System.out.println(doc);
		listeDocument.add(doc);
	}

		return listeDocument;
	}

	@Override
	public Document findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public  boolean afficherDocPDF() {
		InputStream pdfInJar = getClass().getClassLoader().getResourceAsStream("pdf/MonFichier.pdf");
		try {
		    File pdf = new File("MonFichier.pdf");
		    FileOutputStream fos = new java.io.FileOutputStream(pdf);
		    while (pdfInJar.available() > 0) {
		          fos.write(pdfInJar.read());
		    }
		    fos.close();
		    //ouverture pdf
		    Desktop.getDesktop().open(pdf);
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		return true;
		
	}
}
