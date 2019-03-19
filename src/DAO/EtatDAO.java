package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import model.Etat;

public class EtatDAO implements DAO<Etat>{

	public Etat findById(String id) throws SQLException {
		
		String RequeteSQL ="Select * from etat where id = ?";
		Connection cx =  Connect.getInstance().getConnection() ;
		PreparedStatement pst = cx.prepareStatement(RequeteSQL);
		pst.setString(1, id);
		ResultSet jeu = pst.executeQuery();
		 Etat Etat1 =new Etat();
		
		 while (jeu.next()) {
			Etat1.setId(jeu.getString("id"));
			Etat1.setLibelle(jeu.getString("libelle"));
			 }
	return Etat1;
	}
	@Override
	public ObservableList<Etat> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
