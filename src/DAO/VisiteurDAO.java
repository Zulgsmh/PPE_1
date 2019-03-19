package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Visiteur;

public class VisiteurDAO implements DAO<Visiteur>{
@Override
	public Visiteur findById(String id) throws SQLException {
	
		 String sqlRequest = " select * from visiteur where id = ?";
		 Connection cx =  Connect.getInstance().getConnection() ;
		 PreparedStatement pst = cx.prepareStatement(sqlRequest);
		 pst.setString(1, id);
		 
		 ResultSet jeu = pst.executeQuery();
		 Visiteur visiteur1=new Visiteur();
		 while (jeu.next()) {
			
			 visiteur1.setId(jeu.getString("id"));
			 visiteur1.setNom(jeu.getString("nom"));
			 visiteur1.setPrenom(jeu.getString("prenom"));
			 visiteur1.setLogin(jeu.getString("login"));
			 visiteur1.setMdp(jeu.getString("mdp"));
			 visiteur1.setAdresse(jeu.getString("adresse"));
			 visiteur1.setCp(jeu.getString("cp"));
			 visiteur1.setVille(jeu.getString("ville"));
			 visiteur1.setDateEmbauche(jeu.getDate("dateEmbauche"));
			 }
return visiteur1;
	}

	@Override
	public ObservableList<Visiteur>  findAll() throws SQLException {
		// TODO Auto-generated method stub
		ObservableList<Visiteur> listeVisiteur = FXCollections.observableArrayList();
		
	String sqlRequete = "SELECT * FROM Visiteur";
	Connection cx =  Connect.getInstance().getConnection() ;
	PreparedStatement pst = cx.prepareStatement(sqlRequete);
	ResultSet table = pst.executeQuery();
	
	 String id;
	 String nom;
	 String prenom;
	 String login;
	 String mdp;
	 String adresse;
	 String cp;
	 String ville;
	 Date dateEmbauche;
	
	while(table.next())
	{
		id = table.getString("id");
	 	nom = table.getString("nom");
	 	prenom = table.getString("prenom");
	 	login = table.getString("login");
	 	mdp = table.getString("mdp");
	 	adresse = table.getString("adresse");
	 	cp = table.getString("cp");
	 	ville = table.getString("Ville");
	 	dateEmbauche = table.getDate("dateEmbauche");
 
	 	Visiteur visiteur = new Visiteur();
	 	visiteur.setId(id);
	 	visiteur.setNom(nom);
	 	visiteur.setPrenom(prenom);
	 	visiteur.setLogin(login);
	 	visiteur.setMdp(mdp);
	 	visiteur.setAdresse(adresse);
	 	visiteur.setCp(cp);
	 	visiteur.setVille(ville);
	 	visiteur.setDateEmbauche(dateEmbauche);
	 	
	
 
	 	listeVisiteur.add(visiteur);
		System.out.println(visiteur);
	}

		return listeVisiteur;
	}

	
	
	}


