package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FraisForfait;

public class FraisForfaitDAO {

	    public FraisForfait findById(String id) throws SQLException {

	        String requeteSQL = "SELECT * FROM fraisforfait WHERE id = ? ";
	        Connection co = Connect.getInstance().getConnection();
	        PreparedStatement pst = co.prepareStatement(requeteSQL);
	        pst.setString(1, id);
	        FraisForfait ff = new FraisForfait();
	        ResultSet jeu =pst.executeQuery();
	        //  id libelle montant
	        while(jeu.next()) {
	        ff.setId(jeu.getString("id"));

	        ff.setLibelle(jeu.getString("libelle"));
	        ff.setMontant(jeu.getFloat("montant"));
	        System.out.print(ff);
	        }
	        return ff;
	    }
}
