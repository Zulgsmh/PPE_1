package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import model.LigneFraisHorsForfait;
import model.Visiteur;

public class LigneFraisHorsForfaitDAO implements DAO<LigneFraisHorsForfait>{
@Override
	public LigneFraisHorsForfait findById(String id) throws SQLException {
	String sqlRequest = " select * from lignefraishorsfortfait where id = ?";
	 Connection cx =  Connect.getInstance().getConnection() ;
	 PreparedStatement pst = cx.prepareStatement(sqlRequest);
	 pst.setString(1, id);
	 
	 ResultSet jeu = pst.executeQuery();
	 LigneFraisHorsForfait LigneFraisHorsForfait1 =new LigneFraisHorsForfait();
	
	 while (jeu.next()) {
		
		 LigneFraisHorsForfait1.setId(jeu.getInt("id"));
		 
		 VisiteurDAO vd = new VisiteurDAO()  ;	
		 Visiteur vr= vd.findById(jeu.getString("idVisiteur"));
		 LigneFraisHorsForfait1.setIdVisiteur(vr);
		 
		 LigneFraisHorsForfait1.setMois(jeu.getString("mois"));
		 LigneFraisHorsForfait1.setLibelle(jeu.getString("libelle"));
		 LigneFraisHorsForfait1.setDate(jeu.getDate("date"));
		 LigneFraisHorsForfait1.setMontant(jeu.getFloat("montant"));
		 }
return LigneFraisHorsForfait1;
}

@Override
public ObservableList<LigneFraisHorsForfait> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}
