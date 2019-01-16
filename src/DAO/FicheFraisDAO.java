package DAO;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.ObservableList;
import model.Etat;
import model.FicheFrais;
import model.LigneFraisHorsForfait;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Visiteur;

public class FicheFraisDAO implements DAO<FicheFrais> {

	 @Override
	//public ObservableList<FicheFrais> findAll() throws SQLException {
		// TODO Auto-generated method stub

			public ObservableList<FicheFrais>  findAll() throws SQLException {
				// TODO Auto-generated method stub
				ObservableList<FicheFrais> listeFicheFrais = FXCollections.observableArrayList();
				
			String sqlRequete = "SELECT * FROM FicheFrais";
			Connection cx =  Connect.getInstance().getConnection() ;
			PreparedStatement pst = cx.prepareStatement(sqlRequete);
			ResultSet table = pst.executeQuery();
			
			 String idVisiteur;
			 String mois;
			 int nbJustificatifs;
			 float montantValide;
			 Date dateModif;
			 String idEtat;
			
			
			while(table.next())
			{
				idVisiteur = table.getString("idVisiteur");
			 	mois = table.getString("mois");
			 	nbJustificatifs = table.getInt("nbJustificatifs");
			 	montantValide = table.getFloat("montantValide");
			 	dateModif = table.getDate("dateModif");
			 	idEtat = table.getString("idEtat");
			 //	VisiteurDAO vd = new VisiteurDAO();
		 VisiteurDAO vd = new VisiteurDAO();
		 Visiteur v = vd.findById(idVisiteur);
		 EtatDAO ed = new EtatDAO();
		 Etat  e = ed.findById(idEtat);
		 
		 
			 	FicheFrais ficheFrais = new FicheFrais();
			 	ficheFrais.setIdVisiteur(v);
			 	ficheFrais.setMois(mois);
			 	ficheFrais.setNbJustificatifs(nbJustificatifs);
			 	ficheFrais.setMontantValide(montantValide);
			 	ficheFrais.setDateModif(dateModif);
			 	ficheFrais.setIdEtat(e);
			
			 
				System.out.println(v);
				listeFicheFrais.add(ficheFrais);
			}

				return listeFicheFrais;
			}

		public ObservableList<FicheFrais>  findByMois(String mois) throws SQLException {
			// TODO Auto-generated method stub
			ObservableList<FicheFrais> listeFicheFrais = FXCollections.observableArrayList();
			
		String sqlRequete = "SELECT * FROM FicheFrais WHERE mois = ? ";
		Connection cx =  Connect.getInstance().getConnection() ;
		PreparedStatement pst = cx.prepareStatement(sqlRequete);
		pst.setString(1, mois);
		ResultSet table = pst.executeQuery();
		
		 String idVisiteur;
		 int nbJustificatifs;
		 float montantValide;
		 Date dateModif;
		 String idEtat;
		
		
		while(table.next())
		{
			idVisiteur = table.getString("idVisiteur");
		 	mois = table.getString("mois");
		 	nbJustificatifs = table.getInt("nbJustificatifs");
		 	montantValide = table.getFloat("montantValide");
		 	dateModif = table.getDate("dateModif");
		 	idEtat = table.getString("idEtat");
		 //	VisiteurDAO vd = new VisiteurDAO();
	 VisiteurDAO vd = new VisiteurDAO();
	 Visiteur v = vd.findById(idVisiteur);
	 EtatDAO ed = new EtatDAO();
	 Etat  e = ed.findById(idEtat);
	 
	 
		 	FicheFrais ficheFrais = new FicheFrais();
		 	ficheFrais.setIdVisiteur(v);
		 	ficheFrais.setMois(mois);
		 	ficheFrais.setNbJustificatifs(nbJustificatifs);
		 	ficheFrais.setMontantValide(montantValide);
		 	ficheFrais.setDateModif(dateModif);
		 	ficheFrais.setIdEtat(e);
		
		 
		
			listeFicheFrais.add(ficheFrais);
			}

			return listeFicheFrais;
		}
	@Override
	public FicheFrais findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean updateFiche(String idVisiteur, String mois) throws SQLException{ 
		
		String reqUpdate = "UPDATE `fichefrais` SET `dateModif`=?,`idEtat`= ? WHERE idVisiteur = ? AND mois=?";
		Connection cxUpdate =  Connect.getInstance().getConnection() ;
		PreparedStatement pstUpdate = cxUpdate.prepareStatement(reqUpdate);
		String dateModif = String.valueOf( LocalDate.now());
		pstUpdate.setString(1,dateModif);
		pstUpdate.setString(2, "VA");
		pstUpdate.setString(3, idVisiteur);
		pstUpdate.setString(4, mois);
		boolean i = pstUpdate.execute();
		
		
		
	return i;
	
	
	
	
		}
}
