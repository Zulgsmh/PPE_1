package model;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;

public class LigneFraisHorsForfait {
	private StringProperty id;
	private Visiteur idVisiteur;
	private StringProperty mois;
	private StringProperty libelle;
	private ObjectProperty<LocalDate> date;
	private FloatProperty montant;
	
public LigneFraisHorsForfait() {
	this.id=new SimpleStringProperty();
	this.idVisiteur=new Visiteur();
	this.mois=new SimpleStringProperty();
	this.libelle=new SimpleStringProperty();
	this.date=new SimpleObjectProperty<LocalDate>();
	this.montant=new SimpleFloatProperty();
}

public StringProperty getIdPro() {
	return id;
}

public void setIdPro(StringProperty id) {
	this.id = id;
}

public Visiteur getIdVisiteur() {
	return idVisiteur;
}

public void setIdVisiteur(Visiteur idVisiteur) {
	this.idVisiteur = idVisiteur;
}

public StringProperty getLibellePro() {
	return libelle;
}

public void setLibellePro(StringProperty libelle) {
	this.libelle = libelle;
}

public StringProperty getMoisPro() {
	return mois;
}

public void setMoisPro(StringProperty mois) {
	this.mois = mois;
}

public ObjectProperty<LocalDate> getDatePro() {
	return date;
}

public void setDatePro(ObjectProperty<LocalDate> date) {
	this.date = date;
}

public FloatProperty getMontantPro() {
	return montant;
}

public void setMontantPro(FloatProperty montant) {
	this.montant = montant;
}

public void setId(int id) {
	// TODO Auto-generated method stub
	
}

public void setIdVisiteur(String idVisiteur) {
	// TODO Auto-generated method stub
	
}

public void setMois(String mois) {
	// TODO Auto-generated method stub
	
}

public void setLibelle(String libelle) {
	// TODO Auto-generated method stub
	
}

public void setDate(Date date) {
	// TODO Auto-generated method stub
	
}

public void setMontant(Float montant) {
	// TODO Auto-generated method stub
	
}
}