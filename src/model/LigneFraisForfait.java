package model;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;


public class LigneFraisForfait{
	private Visiteur idVisiteur;
	private StringProperty mois;
	private FraisForfait idFraisForfait;
	private IntegerProperty quantite;
	private FloatProperty montant;
	
public LigneFraisForfait(Visiteur idVisiteur,FraisForfait idFraisForfait){
	this.idVisiteur=idVisiteur;
	this.mois=new SimpleStringProperty();
	this.idFraisForfait=idFraisForfait;
	this.quantite=new SimpleIntegerProperty();
	this.montant= new SimpleFloatProperty();
}

//----------------------------------------------------------------------
public Visiteur getIdVisiteur(){
	return idVisiteur;
}

public void setIdVisiteur(Visiteur idVisiteur){
	this.idVisiteur=idVisiteur;
}

public StringProperty getMoisPro(){
	return mois;
}

public void setMoisPro(StringProperty mois){
	this.mois=mois;
}

public FraisForfait getIdFraisForfaitPro (){
	return idFraisForfait;
}

public IntegerProperty getQuantitePro() {
	return quantite;
}

public void setQuantitePro(IntegerProperty quantite) {
	this.quantite = quantite;
}
public FloatProperty getMontantPro() {
	return montant;
}

public void setMontantPro(FloatProperty montant) {
	this.montant = montant;
}
//-------------------------------------------------------------------------

public void setMois(String mois) {
	this.mois.set(mois);
}
public String getMois() {
	return mois.get();
}
public void setQuantite(int quantite) {
	// TODO Auto-generated method stub
	this.quantite.set(quantite);
}
public int getQuantite() {
	return quantite.get();
}
public void setMontant(float montant) {
	this.montant.set(montant);
}


public Float getMontant(){
	return montant.get();
}
public FraisForfait getIdFraisforfait() {
	return idFraisForfait;
}
public void setIdFraisForfait(FraisForfait idFraisForfait) {
	this.idFraisForfait=idFraisForfait;
	
}

@Override
public String toString() {
	return "LigneFraisForfait [idVisiteur=" + idVisiteur + ", mois=" + mois + ", idFraisForfait=" + idFraisForfait
			+ ", quantite=" + quantite + ", montant=" + montant + "]";
}





}