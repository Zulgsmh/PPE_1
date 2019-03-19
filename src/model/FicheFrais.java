package model;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class FicheFrais {
	@Override
	public String toString() {
		return "FicheFrais [idVisiteur=" + idVisiteur + ", mois=" + mois + ", nbJustificatifs=" + nbJustificatifs
				+ ", montantValide=" + montantValide + ", dateModif=" + dateModif + ", idEtat=" + idEtat + "]";
	}

	private Visiteur idVisiteur;
	private StringProperty mois;
	private IntegerProperty nbJustificatifs;
	private FloatProperty montantValide;
	private ObjectProperty<Date> dateModif;
	private Etat idEtat;
	
public FicheFrais (Etat idEtat) {	
	this.idVisiteur= new Visiteur();
	this.mois=new SimpleStringProperty();
	this.nbJustificatifs=new SimpleIntegerProperty();
	this.montantValide=new SimpleFloatProperty();
	this.dateModif= new SimpleObjectProperty<Date>();
	this.idEtat=idEtat;
	
	//----------------------------------------------------
}

public Visiteur getIdVisiteur() {
	return idVisiteur;
}

public void setIdVisiteur(Visiteur idVisiteur) {
	this.idVisiteur = idVisiteur;
}

public StringProperty getMoisPro() {
	return mois;
}

public void setMois(StringProperty mois) {
	this.mois = mois;
}

public IntegerProperty getNbJustificatifsPro() {
	return nbJustificatifs;
}

public void setNbJustificatifs(IntegerProperty nbJustificatifs) {
	this.nbJustificatifs = nbJustificatifs;
}

public ObjectProperty<Date> getDateModifPro() {
	return dateModif;
}

public void setDateModifPro(ObjectProperty<Date> dateModif) {
	this.dateModif = dateModif;
}

public FloatProperty getMontantValidePro() {
	return montantValide;
}

public void setMontantValidePro(SimpleFloatProperty montantValide) {
	this.montantValide = montantValide;
}

public Etat getIdEtat() {
	return idEtat;
}

public void setIdEtat(Etat idEtat) {
	this.idEtat = idEtat;
}
//-------------------------------------------------------------------

public String getMois() {
	return mois.get();
}

public void setMois(String mois) {
	this.mois.set(mois);
}

public int getNbJustificatifs() {
	return nbJustificatifs.get();
}

public void setNbJustificatifs(int nbJustificatifs) {
	this.nbJustificatifs.set(nbJustificatifs);
}

public Date getDateModif() {
	return dateModif.get();
}

public void setDateModif(Date dateModif) {
	this.dateModif.set(dateModif);
}
public float getMontantValide() {
	return montantValide.get();
}

public void setMontantValide(float montantValide) {
	this.montantValide.set(montantValide);
}
}