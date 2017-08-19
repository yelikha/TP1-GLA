package com.tp1_java;

import java.io.Serializable;

public class Assignes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id_assigne;
	int ID_Membre;
	int ID_Tache;

	// LES CONSTRUCTEURS

	public Assignes() {
		super();
	}

	public Assignes(int id_assigne, int ID_Membre, int ID_Tache) {
		super();
		this.id_assigne = id_assigne;
		this.ID_Membre = ID_Membre;
		this.ID_Tache = ID_Tache;
	}
	
	public String toString(){
		return this.getId_assigne() + "\t" + this.getID_Tache()+
				"\t"+this.getID_Membre();
		
	} 

	public int getId_assigne() {
		return id_assigne;
	}

	public void setId_assigne(int id_assigne) {
		this.id_assigne = id_assigne;
	}

	public int getID_Membre() {
		return ID_Membre;
	}

	public void setID_Membre(int ID_Membre) {
		this.ID_Membre = ID_Membre;
	}

	public int getID_Tache() {
		return ID_Tache;
	}

	public void setID_Tache(int ID_Tache) {
		this.ID_Tache = ID_Tache;
	}

}
