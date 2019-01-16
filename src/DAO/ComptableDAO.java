package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import javafx.collections.ObservableList;
import model.Visiteur;

public class ComptableDAO implements DAO<Visiteur>{

	
	@Override
	public Visiteur findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public static boolean auth(String txtMdp, String txtLogin) throws SQLException {
		boolean loginOk  ;
	Connection cnx = Connect.getInstance().getConnection()  ;
		// TODO Auto-generated method stub
		PreparedStatement statement = cnx.prepareStatement("SELECT login,mdp FROM Comptable WHERE  login = ? and mdp = ?");
		
			statement.setString(1,txtLogin);
			statement.setString(2,txtMdp);
			ResultSet resultSet = statement.executeQuery();
			 
			while( resultSet.next()) {
				
				
				System.out.println("vghjvg");
				return true ;
			} 
	
	
		return false;
	}


	@Override
	public ObservableList<Visiteur> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}