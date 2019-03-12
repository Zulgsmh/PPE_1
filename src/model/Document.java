package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Document {
	
	private IntegerProperty idJustificatif;
	//private FraisForfait idFraisForfait;
	private StringProperty path;
	private Visiteur idVisiteur;
	//private StringProperty nomJustificatif;
	//private FloatProperty montantJustificatif;
	
	public Document(Visiteur idVisiteur) {
		this.idJustificatif= new SimpleIntegerProperty();
	//	this.idFraisForfait=idFraisForfait;
		this.path=new SimpleStringProperty();
		this.idVisiteur=idVisiteur;
		//this.nomJustificatif=new SimpleStringProperty();
		//this.montantJustificatif=new SimpleFloatProperty();
	}
	@Override
	public String toString() {
		return "Document [idJustificatif=" + idJustificatif + ", path=" + path + ", idVisiteur=" + idVisiteur + "]";
	}
	
	

	//-----------------------------------
	public int getIdJustificatif() {
		return idJustificatif.get();
	}
	public void setIdJustificatif(int idJustificatif) {
		this.idJustificatif.set(idJustificatif);;
	}
	/*
	public FraisForfait getIdFraisForfait() {
		return idFraisForfait;
	}
	public void setIdFraisForfait(FraisForfait idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}  */
	public String getPath() {
		return path.get();
	}
	public void setPath(String path) {
		this.path.set(path);
	}
	public Visiteur getIdVisiteur() {
		return idVisiteur;
	}
	public void setIdVisiteur(Visiteur idVisiteur) {
		this.idVisiteur=idVisiteur;
	}
	/*
	public void setNomJustificatif(String nomJustificatif) {
		this.nomJustificatif.set(nomJustificatif);
	}
	public String getNomJustificatif() {
		return nomJustificatif.get();
	}
	public void setMontantJustificatif(Float montantJustificatif) {
		this.montantJustificatif.set(montantJustificatif);
	}
	public Float getMontantJustificatif() {
		return montantJustificatif.get();
	} */
	//----------------------------------------
	public IntegerProperty getIdJustificatifPro() {
		return idJustificatif;
	}
	public void setIdJustificatif(IntegerProperty idJustificatif) {
		this.idJustificatif = idJustificatif;
	} 
	public StringProperty getPathPro() {
		return path;
	}
	public void setPath(StringProperty path) {
		this.path = path;
	}
	/*
	public StringProperty getNomJustificatifPro() {
		return nomJustificatif;
	}
	public void setNomJustificatifPro(StringProperty nomJustificatif) {
		this.nomJustificatif=nomJustificatif;
	}
	public void setMontantJustificatifPro(FloatProperty montantJustificatif ) {
		this.montantJustificatif=montantJustificatif;
	}
	public FloatProperty getMontantJustificatifPro() {
		return montantJustificatif;
	} */
}
