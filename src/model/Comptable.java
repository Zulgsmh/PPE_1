package model;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;


public class Comptable {
	private StringProperty id;
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty login;
	private StringProperty mdp;
	private StringProperty adresse;
	private StringProperty cp;
	private StringProperty ville;
	private ObjectProperty<LocalDate> dateEmbauche;

public Comptable() {
	
	this.id= new SimpleStringProperty();
	this.nom=new SimpleStringProperty();
	this.prenom=new SimpleStringProperty();
	this.login=new SimpleStringProperty();
	this.mdp=new SimpleStringProperty();
	this.adresse=new SimpleStringProperty();
	this.cp=new SimpleStringProperty();
	this.ville=new SimpleStringProperty();
	this.dateEmbauche= new SimpleObjectProperty<LocalDate> ();
}
//-------------------------------------------------------------------------
public StringProperty getId(){
	return id;
} 

public void setID(StringProperty id){
	this.id=id;
}

public StringProperty getNom(){
	return nom;
}

public void setNom(StringProperty nom){
	this.nom=nom;
}

public StringProperty getPrenom (){
	return prenom;
}

public void setPrenom(StringProperty prenom){
	this.prenom=prenom;
}

public StringProperty getLogin(){
	return login;
}

public void setLogin(StringProperty login){
	this.login=login;
}

public StringProperty getMdp(){
	return mdp;
}

public void setMdp(StringProperty mdp){
	this.mdp=mdp;
}

public StringProperty getAdresse(){
	return adresse;
}

public void setAdresse(StringProperty adresse){
	this.adresse=adresse;
}

public StringProperty getCp(){
	return cp;
}

public void setCp(StringProperty cp){
	this.cp=cp;
}

public StringProperty getVille(){
	return ville;
}

public void setVille(StringProperty ville){
	this.ville=ville;
}

public ObjectProperty<LocalDate> getDateEmbauche(){
	return dateEmbauche;
}

public void setDateEmbauche(ObjectProperty<LocalDate> dateEmbauche){
	this.dateEmbauche=dateEmbauche;
}
//--------------------------------------------------------------------------






}