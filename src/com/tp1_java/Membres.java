package com.tp1_java;

import java.io.Serializable;

//LES ATTRIBUTS

public class Membres implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int ID_membre;
	private String Nom_membre;

	// LES CONSTRUCTEURS

	public Membres() {

	}

	public String toString() {
		return this.getID_membre() + "\n" + this.getNom_membre();
	}

	public Membres(int ID_membre, String Nom_membre) {

		this.ID_membre = ID_membre;
		this.Nom_membre = Nom_membre;
	}

	// LES GETHERS ET LES SETHERS

	public int getID_membre() {
		return ID_membre;
	}

	public void setID_membre(int ID_membre) {
		this.ID_membre = ID_membre;
	}

	public String getNom_membre() {
		return Nom_membre;
	}

	public void setNom_membre(String Nom_membre) {
		this.Nom_membre = Nom_membre;
	}

}
