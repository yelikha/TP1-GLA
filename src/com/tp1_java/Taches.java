package com.tp1_java;

import java.io.Serializable;

////LES ATTRIBUTS

public class Taches implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private int ID_tache;
private String Nom_tache;
private String Desc;
private String Status;

// LES CONSTRUCTEURS

public Taches() {

}

public Taches(int ID_tache, String Nom_tache, String Desc, String Status) {
	
	this.ID_tache = ID_tache;
	this.Nom_tache = Nom_tache;
	this.Desc = Desc;
	this.Status = Status;
}

public String toString(){
	return this.getID_tache() +"\t"+this.getNom_tache()+"\t"+this.getDesc()+"\t"+this.getStatus();
}

// LES GETHERS ET LES SETHERS

public int getID_tache() {
	return ID_tache;
}

public void setID_tache(int ID_tache) {
	this.ID_tache = ID_tache;
}

public String getNom_tache() {
	return Nom_tache;
}

public void setNom_tache(String Nom_tache) {
	this.Nom_tache = Nom_tache;
}

public String getDesc() {
	return Desc;
}

public void setDesc(String Desc) {
	this.Desc = Desc;
}

public String getStatus() {
	return Status;
}

public void setStatus(String Status) {
	this.Status = Status;
}

}
