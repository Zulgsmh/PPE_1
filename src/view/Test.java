package view;

import java.sql.Date;
import java.sql.SQLException;


import DAO.ComptableDAO;
import DAO.DocumentDAO;
import DAO.FicheFraisDAO;
import DAO.VisiteurDAO;
import javafx.collections.ObservableList;
import model.Document;
import model.FicheFrais;
import model.Visiteur;

public class Test {
	public static void main(String[] args) throws SQLException { 
		
		
		//ComptableDAO v1 = new ComptableDAO();
		//ObservableList<Visiteur> liste1 = v1.findAll();
		//ObservableList<>
	
//ObservableList<FicheFrais> liste =	(new FicheFraisDAO()).findAll();
ObservableList<FicheFrais> list = (new FicheFraisDAO()).findByMois("10");
	
		System.out.println(list.get(0));
		
DocumentDAO ddao = new DocumentDAO();
ObservableList<Document> listeDocument = ( new DocumentDAO()).findAll();
System.out.println(listeDocument.get(0));
		
	}
	

}
