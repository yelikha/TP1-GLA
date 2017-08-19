package com.tp1_java;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;
import java.io.File;
import java.io.*;

public class Gestionnaire_taches {
	// LA DECLARATION DES LISTES OU TABLEAU DE LISTES CHAINEE

	static ArrayList<Assignes> ListAssigne = new ArrayList<Assignes>();
	static ArrayList<Membres> ListMembre = new ArrayList<Membres>();
	static ArrayList<Taches> Listache = new ArrayList<Taches>();
	static Scanner sc = new Scanner(System.in);
	
	// LA FONCTION MENU PRINCIPAL 

	public static void menuPrincipal() {
    	System.out.println("\t"+"\t"+"|*********************************************************************************************************|");
		System.out.println("\t"+"\t"+"|**                                      MENU DE LA GESTION DES MEMBRES                                 **|");
		System.out.println("\t"+"\t"+"|*********************************************************************************************************|");
		System.out.println("\t"+"\t"+"|**                                                                                                     **|");
		System.out.println("\t"+"\t"+"|**                 CHOISISSEZ UNE OPERATION  OU 0 POUR QUITTER ET ENREGISTRER                          **|");
		System.out.println("\t"+"\t"+"|**                                                                                                     **|");
		System.out.println("\t"+"\t"+"|*********************************************************************************************************|");
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|**        1 - CREER UNE MEMBRE      |                                                                  **|");
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|**        2 - MODIFIER UN MEMBRE    |                                                                  **|");
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|**        3 - AFFICHER LES MEMBRES  |   9 - CREER UNE ASSIGNATION                                      **|");
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|**        4 - SUPPRIMER UN MEMBRE   |   10 - AFFICHER LES ASSIGNATIONS                                 **|"); 
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|*************************************   11 - RECHERCHE DES TACHES ASSIGNEES PAR ID DU MEMBRE           **|");
		System.out.println("\t"+"\t"+"|**        5 - CREER UNE TACHE       |                                                                  **|");
		System.out.println("\t"+"\t"+"|**                                  |   12 - RECHERCHE DES TACHES PAR LEURS STATUS ET NOM DE L'ASSIGNE **|");
		System.out.println("\t"+"\t"+"|**        6 - MODIFIER UNE TACHE    |                                                                  **|");
		System.out.println("\t"+"\t"+"|**                                  |   0 - QUITTER ET SAUVEGARDER LES LISTES                          **|");
		System.out.println("\t"+"\t"+"|**        7 - AFFICHER LES TACHES   |                                                                  **|");
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|**        8 - SUPPRIMER UNE TACHE   |                                                                  **|");
		System.out.println("\t"+"\t"+"|**                                  |                                                                  **|");
		System.out.println("\t"+"\t"+"|*********************************************************************************************************|");
		System.out.println("  ");
		System.out.print("\t"+" DANS LE MENU DES MEMBRES FAITES VOTRE CHOIX :     ");

	}

	// LA PARTIE DES FONCTIONS DE LA CLASSE MEMBRE

	// LA FONCTION DE RECHERCHE DES MEMBRES

	public static Membres recherche(String Nom) {
		Membres resultats = null;
		for (Membres mbre : ListMembre) {
			if (mbre.getNom_membre().equalsIgnoreCase(Nom)) {
				resultats = mbre;
				break;
			}
		}
		return resultats;
	}
	
	
	// RECHERCHE ID MEMBRES 
	
	public static Membres rechercheIDMembre(int ID) {
		Membres resultats = null;
		for (Membres mbre : ListMembre) {
			if (mbre.getID_membre()== ID) {
				resultats = mbre;
				break;
			}
		}
		return resultats;
	}

	// RECHERCHE ID TACHES 
	
	public static Taches rechercheIDTache(int ID) {
		Taches resultats = null;
		for (Taches mbre : Listache) {
			if (mbre.getID_tache()== ID) {
				resultats = mbre;
				break;
			}
		}
		return resultats;
	}
	
	// LA FONCTION D'AJOUT ET DE CREATION DES MEMBRES

	public static void addMembres(Membres m) {

		Membres membreNom = recherche(m.getNom_membre());
		Membres membreID = rechercheIDMembre(m.getID_membre());
		if (membreNom != null || membreID!=null) {
			System.out.println("\t"+ "\t" +"Desole ID ou Nom saisi existe deja"+ "\t");
		} else {

			ListMembre.add(m);
		}
	}

	// LA FONCTION DE SUPPRESSION DES MEMBRES DANS LA LISTE

	public static void delMembres(String Nom) {
		Membres membre2 = recherche(Nom);

		if (membre2 != null) {
			int index = ListMembre.indexOf(membre2);
			ListMembre.remove(index);
			
		} else {
			System.out.println("\t" + " Desole l'element saisie n'existe pas dans la liste");
		}
	}

	// LA FONCTION DE MODIFICATION DES MEMBRES

	public static void editMembre(String Anom, String Nnom) {
		Membres membre3 = recherche(Anom);
	
		if (membre3 != null) {
			int index = ListMembre.indexOf(membre3);
			
			ListMembre.remove(index);
			Membres creeMembre = new Membres(index, Nnom);
			ListMembre.add(creeMembre);
			
		} else {
			System.out.println("\t" + "Desole Ce nom N'existe pas");
			
		}
		
	}

	// LA FONCTION AFFICHAGE DES MEMBRES

	public static void affichageMembres() {
		if (!ListMembre.isEmpty()) {
			for (Membres tache : ListMembre) {
				System.out.println("\t"+"|"+tache.getID_membre() + "\t" + "|" +tache.getNom_membre());
				System.out.println("\n");
			}
		} else {
			System.out.println("\t" +"Desole La liste des taches est vide");
		}
		
	}

	// LA PARTIE DES FONCTIONS DE LA CLASSE TACHE

	// LA FONCTION DE RECHERCHE DES TACHES
	public static Taches rechercheTache(String Nom) {
		Taches resultatache = null;
		for (Taches tach : Listache) {
			if (tach.getNom_tache().equalsIgnoreCase(Nom)) {
				resultatache = tach;
				break;
			}
		} 
		return resultatache;
	}

	// LA FONCTION D'AJOUT ET DE CREATION DES TACHES
	 public static void addTaches(Taches t) {

		Taches tache1 = rechercheTache(t.getNom_tache());
		Taches tacheID = rechercheIDTache(t.getID_tache());
		if (tache1 != null || tacheID!=null) {
			System.out.println("\t"+ "\t" +"Desole ID ou Nom saisi existe deja"+ "\t");

		} else {

			Listache.add(t);
		}
	}

	// LA FONCTION DE SUPPRESSION DES TACHES DANS LA LISTE
	public static void delTaches(String Nom) {
		Taches tache2 = rechercheTache(Nom);

		if (tache2 != null) {
			int index = Listache.indexOf(tache2);
			Listache.remove(index);
			
		} else {
			System.out.println("\t" +"Desolé l'element saisie n'existe pas dans la liste");
		}
	}

	// LA FONCTION DE MODIFICATION DES TACHES
	public static void editTache(String AnomTache,String NnomTache, String NDesc, String NStatus) {
		Taches tache3 = rechercheTache(AnomTache);
		if (tache3 != null) {
			int index1 = Listache.indexOf(tache3);
			Listache.remove(index1);
			Taches creeTache = new Taches(index1, NnomTache,NDesc,NStatus);
			Listache.add(creeTache);			
			
		} else {
			System.out.println("\t" +"Desolé Ce nom existe deja");
		}
	}

	// LA FONCTION AFFICHAGE DES TACHES
	public static void affichageTaches() {

		if (!Listache.isEmpty()) {
			for (Taches tache : Listache) {
				System.out.println("\t"+"|"+tache.getID_tache() + "\t"+"|" + tache.getNom_tache() + "\t"+"|" + tache.getDesc() + "\t"+"|"
						+ tache.getStatus());
				System.out.println("\n");
			}
		} else {
			System.out.println("Desolé La liste des taches est vide");
		}

	}

	// LA FONCTION DE RECHERCHE DES ASSIGNATIONS
	public static Assignes recherchAssignation(int idmembres, int idtaches) {
		Assignes resultats = null;
		for (Assignes ass : ListAssigne) {
			if (ass.getID_Membre() == idmembres && ass.getID_Tache() == idtaches) {
				resultats = ass;
				break;
			}
		}
		return resultats;
	}

	// LA FONCTION DE CREATION D'UNE ASSIGNATION
	public static void addAssignes(Assignes ass1) {

		Assignes assigne1 = recherchAssignation(ass1.getID_Membre(), ass1.getID_Tache());

		if (assigne1 != null) {
			System.out.println("\t" +" Desolé Cette Assignation existe déja dans la liste Essayer une autre !!!!");

		} else {

			ListAssigne.add(ass1);
		}
	}

	// LA SUPPRESSION SUMULTANNEE DES TACHES ET MEMBRES DANS ASSIGNATION

	// SUPPRESION DE L'ID_TACHE APRES SA SUPPRESSION DANS LA LISTE TACHE
	public static void supprimerIDtacheDansAssignation(int ID_tache) {
		for (int i = 0; i < ListAssigne.size(); i++) {
			Assignes assignation = ListAssigne.get(i);
			if (assignation.getID_Tache() == ID_tache) {
				ListAssigne.remove(assignation);
			}
		}
	}

	// SUPPRESION DE L'ID_MEMBRE APRES SA SUPPRESSION DANS LA LISTE MEMBRE
	public static void supprimerIDMembreDansAssignation(int ID_membre) {

		for (int i = 0; i < ListAssigne.size(); i++) {
			Assignes assignation = ListAssigne.get(i);
			if (assignation.getID_Membre() == ID_membre) {
				ListAssigne.remove(assignation);
			}
		}

	}

	// AFFICHAGE DE TOUTES LES TACHES ASSIGNEES
	public static void affichageDesTachesAssignees() {

		for (Assignes a : ListAssigne) {
			System.out.println(a.toString() + "\n");

			System.out.print("Tache :\t");
		
			for (Taches tache : Listache) {
				if (a.getID_Tache() == tache.getID_tache()) {
					System.out.println(tache.getID_tache() + "\t" + tache.getNom_tache() + "\t" + tache.getDesc() + "\t"
							+ tache.getStatus());
					break;
				}
			}
			System.out.print("Membre :\t");
			// Recherche de l'element membre dans la liste des membres
			for (Membres membre : ListMembre) {
				if (a.getID_Membre() == membre.getID_membre()) {
					System.out.println(membre.getID_membre() + "\t" + membre.getNom_membre());
					break;
				}
			}
			System.out.println("------------------------------------------------");
		}
	}

	// AFFICHAGE DE TOUTES LES TACHES ASSIGNEES EN FONCTOIN DE ID_MEMBRE
	public static void afficherTachesAssigneesParIdMembre(int ID) {
		System.out.println("\t" + "\t" + " Les Taches assignees a ce membre ayant " +ID+ "sont : ");
		System.out.println("********************************************************");
		for (Assignes ass : ListAssigne) {
			System.out.println(ass.toString() + "\n");
			if (ass.getID_Membre() == ID) {
				for (Taches tach : Listache) {
					if (ass.getID_Tache() == tach.getID_tache()) {
						System.out.println(tach.getID_tache() + "\t" + tach.getNom_tache() + "\t" + tach.getDesc()
								+ "\t" + tach.getStatus());
						break;
					}
				}
			}
			System.out.println("****************************************************");
		}
	}

	// AFFICHAGE DE TOUTES LES TACHES ASSIGNEES AUX MEMBRES EN FONCTOIN DU
	// STATUT DE LA TACHE

	public static void afficherTachesAssigneesAuxMembresParStatutTache(String Statut) {

		System.out.println("\t" + "\t" + " Les Taches assignees aux membre ayant le status"+Statut+" sont : ");
		for (Assignes ass : ListAssigne) {

			System.out.println(ass.toString() + "\n");
			
			System.out.println("****************************************************");
			for (Taches tache : Listache) {
				if (ass.getID_Tache() == tache.getID_tache() && tache.getStatus() == Statut) {
					System.out.print(tache.getID_tache() + "\t" + tache.getNom_tache() + "\t" + tache.getDesc());
					break;
				}
			}
			System.out.print("\t");
			for (Membres membre : ListMembre) {
				if (ass.getID_Membre() == membre.getID_membre()) {
					System.out.println(membre.getNom_membre());
					break;
				}
			}
			System.out.println("****************************************************");
		}
	}
	
	// LA GESTION DES CHEMINS ABSOLUS VERS LES FICHIERS
		public static String absolutePathMembre() {	   
		        File fill = new File("FichierMembres.txt");
		        String absolutePathMembre = fill.getAbsolutePath();
		        return absolutePathMembre;
		     }
		
		public static String absolutePathTache() {	   
	        File fille = new File("FichierTaches.txt");
	        String absolutePathTache = fille.getAbsolutePath();
	        return absolutePathTache;
	          
	}
		public static String absolutePathTacheAssignation() {	   
	        File fie = new File("FichierAssignations.txt");
	        String absolutePathTacheAssignation = fie.getAbsolutePath();
	        return absolutePathTacheAssignation;
	                  
	}	
	
	
	// STOCTAGE DES LISTES DANS DES FICHIERS

	// CHARGER LA LISTE DES MEMBRES DANS FICHIER
	
	public static void lireFichierMembre() throws Exception {

		FileInputStream fin = new FileInputStream("absolutePathMembre");
		ObjectInputStream objIn = new ObjectInputStream(fin);
		ListMembre = (ArrayList<Membres>) objIn.readObject();
		objIn.close();
	}

	// CHARGER LE FICHIER DES MEMBRES DANS LA LISTE
	public static void enregistrerMembresDansFichier() throws Exception {
		FileOutputStream fos = new FileOutputStream("absolutePathMembre");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ListMembre);
		oos.close();
	}

	// CHARGER LA LISTE DES TACHES DANS FICHIER ET RECIPROQUEMENT
	public static void lireFichierTaches() throws Exception {
		FileInputStream fin = new FileInputStream("absolutePathTache");
		ObjectInputStream objIn = new ObjectInputStream(fin);
		Listache = (ArrayList<Taches>) objIn.readObject();
		objIn.close();
	}

	// CHARGER LE FICHIER DES TACHES DANS LA LISTE
	public static void enregistrerTachesDansFichier() throws Exception {
		FileOutputStream fos = new FileOutputStream("absolutePathTache");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Listache);
		oos.close();
	}

	// ASSIGNATION
	public static void enregistrerAssignationsDansFichier() throws Exception {
		FileOutputStream fos = new FileOutputStream("absolutePathTacheAssignation");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ListAssigne);
		oos.close();
	}

	// CHARGER LA LISTE DES ASSIGNATION DANS UN FICHIER
	public static void lireFichierAssignations() throws Exception {
		FileInputStream fin = new FileInputStream("absolutePathTacheAssignation");
		ObjectInputStream objIn = new ObjectInputStream(fin);
		ListAssigne = (ArrayList<Assignes>) objIn.readObject();
		objIn.close();
	}

	// SAUVEGARDER
	public static void sauvegarderDansFichiers() {
		try {
			enregistrerTachesDansFichier();
			enregistrerMembresDansFichier();
			enregistrerAssignationsDansFichier();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//CHARGEMENT DES LISTES
	public static void chargement() {
		
		try {
			lireFichierTaches();
			lireFichierMembre();
			lireFichierAssignations();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Fonction de verification du type de la saisie de l'utilisateur

	public static void verifierType() {
		if (!sc.hasNextInt()) {
			System.out.print("Veuillez entrer un entier !!!\nChoix :");
			sc.nextLine();
			Gestionnaire_taches.verifierType();
		}
	}

	public static void verifierPlage(int choix, int borneInferieure, int borneSuperieure) {
		while (choix < borneInferieure || choix > borneSuperieure) {
			verifierType();
			System.out.println(
					"\n\nEntrez un entier entre " + borneInferieure + " et " + borneSuperieure + " compris\nChoix : ");
			choix = sc.nextInt();
		}
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   }  

/***********************************************************************************************************************************/
/***********************************************************************************************************************************/	

	// LA FONCTION PRINCIPALE
public static void main(String[] args) {
	absolutePathMembre();
	absolutePathTache();
	absolutePathTacheAssignation();
	int choix=0;
	int continu;
	chargement();//Initialisation des listes a partir des fichiers
	int sortieMenu = 1;
	while (sortieMenu == 1) {	
	menuPrincipal();
	verifierType();
	verifierPlage(choix, 0, 12);
	choix = sc.nextInt();
	//verifierPlage(choix, 0, 12);
			switch (choix) {
				case 1:
					int sortieMembreCreer = 1;
					while (sortieMembreCreer == 1) {
						int idMembre;
						String nomMembre;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------CREATION D'UN MEMBRE-----------");
						System.out.print("\t" + "Saisissez l'Identifiant : " + "\t");
						Scanner sc1 = new Scanner(System.in);
						idMembre = sc1.nextInt();
						System.out.print("\t" + "Saisissez le Nom : " + "\t");
						Scanner scc = new Scanner(System.in);
						nomMembre = scc.next();
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						Membres creeMembre = new Membres(idMembre, nomMembre);
						addMembres(creeMembre);
						affichageMembres();
						System.out.print("Voulez vous creer un autre membre si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc1.nextInt();
						if (continu == 1) {
							sortieMembreCreer = 1;
						} else
							sortieMembreCreer=0;				
						  	clearScreen();
					}
				break;
	
				case 2:
					int sortieMembreModifier = 1;
					Scanner scn = new Scanner(System.in);
					while (sortieMembreModifier == 1) {
						int idMembre;
						String NouveauNom;
						String AncienNom;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------MODIFICATION D'UN MEMBRE-----------");
						System.out.print("\t" + "Saisissez l'ancien : " + "\t");
						Scanner sccc1 = new Scanner(System.in);
						AncienNom = sc.next();
						System.out.print("\t" + "Saisissez le nouveau nom : " + "\t");
						Scanner scc1 = new Scanner(System.in);
						NouveauNom = sc.next();
						editMembre(AncienNom, NouveauNom);
						System.out.print("Voulez vous modifier un autre membre si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieMembreModifier = 1;
						} else
							sortieMembreModifier=0;				
						  	clearScreen();
					}
				break;
					
				case 3:
					int sortieAffichageMembnres = 1;
					while (sortieAffichageMembnres == 1) {
					System.out.println("\t"+"---------------------------------------------");
					affichageMembres();
					System.out.println("\t"+"---------------------------------------------");				
					System.out.print("Voulez vous reafficher a nouveau si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
					continu = sc.nextInt();
					if (continu == 1) {
						sortieAffichageMembnres = 1;
					} else
						sortieAffichageMembnres=0;				
					  	clearScreen();
					}				
					break;

				case 4:
					int sortieSuppMembre = 1;
					while (sortieSuppMembre == 1) {
						Membres m=null;
						String nomMembre;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------SUPPRESSION D'UN MEMBRE-----------");
						System.out.print("\t" + "Saisissez le nom du membre devant etre supprime : " + "\t");
						Scanner sc3 = new Scanner(System.in);
						nomMembre = sc3.next();
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
					    //Membres suppMembre = new Membres(m.getID_membre(), nomMembre);
					    delMembres(nomMembre);
					    //supprimerIDMembreDansAssignation(m.getID_membre());
					    affichageMembres();
						System.out.print("Voulez vous supprimer un autre membre si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieSuppMembre = 1;
						} else
							sortieSuppMembre=0;				
						  	clearScreen();
					}
				break;
					
				case 5:
					int sortieTachesCreer = 1;
					while (sortieTachesCreer == 1) {
						
						int idTache;
						String nomTache;
						String Description;
						String Status;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------CREATION D'UNE TACHE-----------");
						System.out.print("\t" + "Saisissez l'Identifiant : " + "\t");
						Scanner sc5 = new Scanner(System.in);
						idTache = sc5.nextInt();
						System.out.print("\t" + "Saisissez le Nom de la tache : " + "\t");
						Scanner sc6 = new Scanner(System.in);
						nomTache = sc6.next();
						System.out.print("\t" + "Saisissez le Description de la tache : " + "\t");
						Scanner sc7 = new Scanner(System.in);
						Description = sc7.next();
						System.out.print("\t" + "Saisissez le Status de la tache : " + "\t");
						Scanner sc8 = new Scanner(System.in);
						Status = sc8.next();
						Taches creeTache = new Taches(idTache, nomTache,Description, Status);
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						addTaches(creeTache);
						affichageTaches();
						System.out.print("Voulez vous creer une nouvelle tache si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieTachesCreer = 1;
						} else
							sortieTachesCreer=0;				
						  	clearScreen();
					}
					break;
	
				case 6:
					int sortieTacheModifier = 1;
					while (sortieTacheModifier == 1) {
						int idMembre;
						String AncienNom;
						String NouveauNom;
						String NDesc;
						String NStatus;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------MODIFICATION D'UNE TACHE-----------");
						System.out.print("\t" + "Saisissez l'ancien de la tache : " + "\t");
						Scanner sccc1 = new Scanner(System.in);
						AncienNom = sc.next();
						System.out.print("\t" + "Saisissez le nouveau nom de la tache : " + "\t");
						Scanner scc1 = new Scanner(System.in);
						NouveauNom = sc.next();
						System.out.print("\t" + "Saisissez la nouvelle Description : " + "\t");
						Scanner sc1 = new Scanner(System.in);
						NDesc = sc.next();
						System.out.print("\t" + "Saisissez le nouveau Status : " + "\t");
						Scanner s1 = new Scanner(System.in);
						NStatus = sc.next();
						editTache(AncienNom, NouveauNom, NDesc, NStatus);
						System.out.print("Voulez vous modifier une autre tache si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieTacheModifier = 1;
						} else
							sortieTacheModifier=0;				
						  	clearScreen();
					}
				break;
			
				case 7:
					int sortieAffichageTaches = 1;
					while (sortieAffichageTaches == 1) {
					System.out.println("\t"+"---------------------------------------------");
					affichageTaches();
					System.out.println("\t"+"---------------------------------------------");
					System.out.print("Voulez vous reafficher a nouveau les taches si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
					continu = sc.nextInt();
					if (continu == 1) {
						sortieAffichageTaches = 1;
					} else
						sortieAffichageTaches=0;				
					  	clearScreen();
				   }
				break;
					
				case 8:
					int sortieSuppTache = 1;
					while (sortieSuppTache == 1) {
						Taches m=null;
						String nomTache;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------SUPPRESSION D'UNE TACHE-----------");
						System.out.print("\t" + "Saisissez le nom du tache devant etre supprime : " + "\t");
						Scanner sc3 = new Scanner(System.in);
						nomTache = sc3.next();
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
					    //Taches suppTache = new Taches(m.getID_tache(),m.getNom_tache(),m.getDesc(),m.getStatus());
					    delTaches(nomTache);
					   // supprimerIDMembreDansAssignation(suppTache.getID_tache());
					    affichageTaches();
						System.out.print("Voulez vous supprimer une autre tache si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieSuppTache = 1;
						} else
							sortieSuppTache=0;				
						  	clearScreen();
					}
																	
				break;
					
					
				case 9:
					System.out.println("\t" + "Voici la liste des Membres");
					affichageMembres();
					System.out.println("\t" + "Voici la liste des Taches");
					affichageTaches();
					int sortieAssignationCreer = 1;
					while (sortieAssignationCreer == 1) {
						int idAssignes, idMembre,idTache;
						System.out.println("\n");
						System.out.println();
						System.out.println("\t" + "-------CREATION DES ASSIGNATIONS-----------");
						System.out.print("\t" + "Saisissez l'Identifiant de l'assignation : " + "\t");
						Scanner sc10 = new Scanner(System.in);
						idAssignes = sc10.nextInt();
						System.out.print("\t" + "Saisissez l'ID du membre devant etre affecte a une tache : " + "\t");
						Scanner sc11 = new Scanner(System.in);
						idMembre = sc11.nextInt();
						System.out.print("\t" + "Saisissez l'ID de la tache a assignee au membre : " + "\t");
						Scanner sc12 = new Scanner(System.in);
						idTache = sc12.nextInt();
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						Assignes creeAssignes = new Assignes(idAssignes,idMembre, idTache);
						addAssignes(creeAssignes);
						affichageDesTachesAssignees();
						System.out.print("Voulez vous creer une nouvelle assignation si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieAssignationCreer = 1;
						} else
							sortieAssignationCreer=0;				
						  	clearScreen();
					}
				break;
									
				case 10:
					int sortieAffichageTachesAssignees = 1;
					while (sortieAffichageTachesAssignees == 1) {
					affichageDesTachesAssignees();				
					System.out.print("Voulez vous reafficher la liste des assignations si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
					continu = sc.nextInt();
					if (continu == 1) {
						sortieAffichageTachesAssignees = 1;
					} else
						sortieAffichageTachesAssignees=0;				
					  	clearScreen();
				   }
				break;
									
				case 11:
					int sortieRechercheAssignesID = 1;
					while (sortieRechercheAssignesID == 1) {
						int ID;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------RECHERCHE ASSIGNATION PAR ID DES MEMBRES-----------");
						System.out.print("\t" + "Saisissez l'Identifiant : " + "\t");
						Scanner scc1 = new Scanner(System.in);
						ID = scc1.nextInt();
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						afficherTachesAssigneesParIdMembre(ID);
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						System.out.print("Voulez vous effectuer une autre recherher si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieRechercheAssignesID = 1;
						} else
							sortieRechercheAssignesID=0;				
						  	clearScreen();
					}
				break;
					
				case 12:
					int sortieRechercheAssignesStatus = 1;
					while (sortieRechercheAssignesStatus == 1) {
						String STATUS;
						System.out.println("\n");
						System.out.println("\t" + "--------------------------------------");
						System.out.println("\t" + "-------RECHERCHE ASSIGNATION PAR STATUS DES TACHES-----------");
						System.out.print("\t" + "Saisissez le status de la tache : " + "\t");
						Scanner sccc1 = new Scanner(System.in);
						STATUS = sccc1.next();
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						afficherTachesAssigneesAuxMembresParStatutTache(STATUS);
						System.out.println("\t"+"----------------------------------------------------------"+"\n");
						System.out.print("Voulez vous effectuer une autre recherher si oui 1 si non retourner sur le menu principal en tapant 0 : " + "\t");
						continu = sc.nextInt();
						if (continu == 1) {
							sortieRechercheAssignesStatus = 1;
						} else
							sortieRechercheAssignesStatus=0;				
						  	clearScreen();
					}
									
				break;
											
				case 0:
					sauvegarderDansFichiers();
					System.exit(0);
				break;
					
					default:
					break;
				}
			}
	choix = sc.nextInt();
	if (choix == 1) {
		sortieMenu = 1;
	} else
		sortieMenu=0;
	}
}