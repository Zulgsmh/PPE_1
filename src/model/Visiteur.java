package model;
import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;


public class Visiteur {
	private StringProperty id;
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty login;
	private StringProperty mdp;
	private StringProperty adresse;
	private StringProperty cp;
	private StringProperty ville;
	private ObjectProperty<Date> dateEmbauche;

public Visiteur() {
	
	this.id = new SimpleStringProperty();
	this.nom = new SimpleStringProperty();
	this.prenom = new SimpleStringProperty();
	this.login = new SimpleStringProperty();
	this.mdp = new SimpleStringProperty();
	this.adresse = new SimpleStringProperty();
	this.cp = new SimpleStringProperty();
	this.ville = new SimpleStringProperty();
	this.dateEmbauche = new SimpleObjectProperty<Date>();
}
//-------------------------------------------------------------------

public StringProperty getIdPro(){
	return id;
} 

public void setIDPro(StringProperty id){
	this.id=id;
}

public StringProperty getNomPro(){
	return nom;
}

public void setNomPro(StringProperty nom){
	this.nom=nom;
}

public StringProperty getPrenomPro (){
	return prenom;
}

public void setPrenomPro(StringProperty prenom){
	this.prenom=prenom;
}

public StringProperty getLoginPro(){
	return login;
}

public void setLoginPro(StringProperty login){
	this.login=login;
}

public StringProperty getMdpPro(){
	return mdp;
}

public void setMdpPro(StringProperty mdp){
	this.mdp=mdp;
}

public StringProperty getAdressePro(){
	return adresse;
}

public void setAdressePro(StringProperty adresse){
	this.adresse=adresse;
}

public StringProperty getCpPro(){
	return cp;
}

public void setCpPro(StringProperty cp){
	this.cp=cp;
}

public StringProperty getVillePro(){
	return ville;
}

public void setVillePro(StringProperty ville){
	this.ville=ville;
}

public ObjectProperty<Date> getDateEmbauchePro(){
	return dateEmbauche;
}

public void setDateEmbauchePro(ObjectProperty<Date> dateEmbauche){
	this.dateEmbauche=dateEmbauche;
}
//--------------------------------------------------------------------------

public String getId(){
	return id.get();
} 

public void setId(String id){
	this.id.set(id);;
}

public String getNom(){
	return nom.get();
}

public void setNom(String nom){
	this.nom.set(nom);;
}

public String getPrenom (){
	return prenom.get();
}

public void setPrenom(String prenom){
	this.prenom.set(prenom);
}

public String getLogin(){
	return login.get();
}

public void setLogin(String login){
	this.login.set(login);
}

public String getMdp(){
	return mdp.get();
}

public void setMdp(String mdp){
	this.mdp.set(mdp);
}

public String getAdresse(){
	return adresse.get();
}

public void setAdresse(String adresse){
	this.adresse.set(adresse);
}

public String getCp(){
	return cp.get();
}

public void setCp(String cp){
	this.cp.set(cp);;
}

public String getVille(){
	return ville.get();
}

public void setVille(String ville){
	this.ville.set(ville);}

public Date getDateEmbauche(){
    return dateEmbauche.get();
}
public void setDateEmbauche(Date dateEmbauche){
    this.dateEmbauche.set(dateEmbauche);
}

@Override
public String toString() {
	return "Visiteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp
			+ ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + "]";
}



}
