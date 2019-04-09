package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FraisForfait;
import model.LigneFraisForfait;
import model.Visiteur;

public class LigneFraisForfaitDAO implements DAO<LigneFraisForfait>{
	   @Override
	   public ObservableList<LigneFraisForfait>  findByIdListe(String id, String mois) throws SQLException {
		   try {
				ObservableList<LigneFraisForfait> listeLigneFraisForfait = FXCollections.observableArrayList();
				String sqlRequest = " select * from lignefraisforfait where idVisiteur like '%"+ id+"%' and mois like '%"+ mois +"%'" ;
				Connection cx =  Connect.getInstance().getConnection();
				PreparedStatement pst = cx.prepareStatement(sqlRequest);	 
				 
				 ResultSet jeu = pst.executeQuery();
			          
		       
				 
					 while (jeu.next()) {
						 VisiteurDAO vd = new VisiteurDAO()  ;	
						 Visiteur vr= vd.findById(jeu.getString("idVisiteur"));
						 FraisForfaitDAO ffd = new FraisForfaitDAO();
						 FraisForfait ff = ffd.findById(id);
						 LigneFraisForfait LigneFraisForfait1 =new LigneFraisForfait(vr,ff);
					
						 
						 LigneFraisForfait1.setIdVisiteur(vr);
						 LigneFraisForfait1.setMois(jeu.getString("mois"));
						 LigneFraisForfait1.setIdFraisForfait(ff);
						 LigneFraisForfait1.setQuantite(jeu.getInt("quantite"));
						 
						 
						 listeLigneFraisForfait.add(LigneFraisForfait1);
						 }
				 	
			return listeLigneFraisForfait;
		   }
		   catch(Exception ex) {
			   System.out.println(ex);
			   return null;
		   }
	   }
	


@Override
public ObservableList<LigneFraisForfait>  findAll() throws SQLException {
	// TODO Auto-generated method stub
	ObservableList<LigneFraisForfait> listeLigneFraisForfait = FXCollections.observableArrayList();
	
String sqlRequete = "SELECT * FROM lignefraisforfait";
Connection cx =  Connect.getInstance().getConnection() ;
PreparedStatement pst = cx.prepareStatement(sqlRequete);


 String idVisiteur ;
 String mois;
 String idFraisForfait ;
 int quantite;
 float montant;

ResultSet table = pst.executeQuery();
while(table.next())
{
	
	VisiteurDAO vd= new VisiteurDAO();
	idVisiteur = table.getString("idVisiteur");
	Visiteur v = vd.findById(idVisiteur);

 	mois = table.getString("mois");
 	FraisForfaitDAO ffd = new FraisForfaitDAO();
	idFraisForfait = table.getString("idFraisForfait");
	System.out.println(idFraisForfait);
 	FraisForfait ff= ffd.findById(idFraisForfait);
 
 	quantite = table.getInt("quantite");
 	montant = table.getFloat("montant");


 	LigneFraisForfait lff = new LigneFraisForfait(v,ff);
 	lff.setIdVisiteur(v);
 	lff.setMois(mois);
 	lff.setIdFraisForfait(ff);
 	lff.setQuantite(quantite);
 	lff.setMontant(montant);

 	


 	listeLigneFraisForfait.add(lff);
	System.out.println(lff);
}

	return listeLigneFraisForfait;
}
}