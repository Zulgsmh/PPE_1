package model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class FraisForfait {
	private StringProperty id;
	private StringProperty libelle;
	private FloatProperty montant;

public FraisForfait (){
	this.id= new SimpleStringProperty();
	this.libelle= new SimpleStringProperty();
	this.montant= new SimpleFloatProperty();
}
//---------------------------------------------
public StringProperty getIdPro(){
	return id;
}

public void setIdPro(StringProperty id){
	this.id=id;
}

public StringProperty getLibellePro(){
	return libelle;
}

public void setLibellePro(StringProperty libelle){
	this.libelle=libelle;
}

public FloatProperty getMontantPro(){
	return montant;
}

public void setMontantPro(FloatProperty montant){
	this.montant=montant;
}
//------------------------------------------------
public String getId(){
	return id.get();
}

public void setId(String id){
	this.id.set(id);
}

public String getLibelle(){
	return libelle.get();
}

public void setLibelle(String libelle){
	this.libelle.set(libelle);
}

public Float getMontant(){
	return montant.get();
}

public void setMontant(Float montant){
	this.montant.set(montant);
}
@Override
public String toString() {
	return "FraisForfait [id=" + id + ", libelle=" + libelle + ", montant=" + montant + "]";
}

}