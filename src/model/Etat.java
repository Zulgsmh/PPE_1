package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.util.StringConverter;

public class Etat {
	private StringProperty id;
	private StringProperty libelle;

public Etat () {
	this.id=new SimpleStringProperty();
	this.libelle=new SimpleStringProperty();
}

public StringProperty getIdPro() {
	return id;
}

public void setIdPro(StringProperty id) {
	this.id = id;
}

public StringProperty getLibellePro() {
	return libelle;
}

public void setLibellePro(StringProperty libelle) {
	this.libelle = libelle;
}
public String getId() {
	return id.get();
}

public void setId(String string) {
   this.id.set(string);
	
}

public void setLibelle(String libelle) {
	this.libelle.set(libelle);
}
public String getLibelle() {
	 return this.libelle.get();
}
}
