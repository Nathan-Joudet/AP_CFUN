package com.cfun.cfun;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Nathan, Dorian, Guillaume B.
 *
 */
public class Complexe {
	private static int numeroActuel = 0;
	
	/**
	 * @return le Numéro actuel
	 */

	public static int getNumeroActuel() {
		return numeroActuel;
	}

	public static void setNumeroActuel() {
		Complexe.numeroActuel = Complexe.getNumeroActuel() + 1;
	}

	private String nomComplexe;

	/**
	 * @return le nom du complexe
	 */
	public String getNomComplexe() {
		return nomComplexe;
	}

	private int nbTotalPlacesFit;
	private int nbTotalPlacesMuscu;

	private int nbPlacesOccupeesFit;
	private int nbPlacesOccupeesMuscu;

	List<Arrivee> lesArrivees = new ArrayList<Arrivee>();
	
	/**
	 * @param uneArrivee
	 * 					correspond à l'arrivée d'un client dans le complexe
	 * @return l'acceptation d'un client
	 */

	public boolean entreeUsager(final Arrivee uneArrivee) {
		boolean ok;
		char choix;

		ok = false;
		choix = uneArrivee.getChoixSport();
		if (choix == 'F') {
			if (this.etatFit() != 1) {
				Complexe.setNumeroActuel();
				uneArrivee.setNumeroArrivee(Complexe.getNumeroActuel());
				lesArrivees.add(uneArrivee);
				this.nouvelUsagerFitness();
				ok = true;
			}
		} else {
			if (this.etatMuscu() != 1.0) {
				Complexe.setNumeroActuel();
				uneArrivee.setNumeroArrivee(Complexe.getNumeroActuel());
				lesArrivees.add(uneArrivee);
				this.nouvelUsagerMusculation();
				ok = true;
			}
		}
		return ok;
	}

	
	/**
	 * @param entree
	 * 				le numéro d'entrée d'un client
	 * @return le compte des usagés dans chaque sport après le départ d'un usager
	 */
	public Arrivee sortieUsager(final int entree) {
		Arrivee leDepart = recherche(entree);
		if (leDepart.getChoixSport() == 'F') {
			this.oterUsagerFitness();
		} else {
			this.oterUsagerMusculation();
		}
		return leDepart;
	}
	
	/**
	 * @param nbTotalPlacesMuscu
	 * 							Le nombre total de places en musculation dans le complexe 
	 * @param nbTotalPlacesFit
	 * 						  Le nombre total de places en fitness dans le complexe
	 * @param nomComplexe
	 * 					 Le nom du complexe
	 */

	public Complexe(final int nbTotalPlacesMuscu, final int nbTotalPlacesFit,
			final String nomComplexe) {
		this.nbTotalPlacesFit = nbTotalPlacesFit;
		this.nbTotalPlacesMuscu = nbTotalPlacesMuscu;
		this.nomComplexe = nomComplexe;
		this.nbPlacesOccupeesFit = 0;
		this.nbPlacesOccupeesMuscu = 0;
	}

	
	/**
	 * @return La couleur correspondant au taux d'occupation de la salle de musculation
	 */
	private String couleurMuscu() {
		ChoixCouleur choixCouleur = new ChoixCouleur();
		return choixCouleur.getCouleur().toString();
	}

	/**
	 * @return le taux de remplissage de la salle de fitness
	 */
	public double etatFit() {
		return (this.getNbPlacesOccupeesFit()) * 1.0 / this.nbTotalPlacesFit;
	}

	public String lesInfos() {
		final String MSGNOM = "Etat du complexe : ";
		final String MSGDATE = "date : ";
		final String MSGHEURE = "heure : ";
		//final String MSGCOUT = "montant";
		final String MSGDISPMUSCU = "Places disponibles M : ";
		final String MSGDISPFIT = "Places disponibles F : ";
		final String MSGOCCMUSCU = "Places occupées M : ";
		final String MSGOCCFIT = "Places occup�es F : ";
		final String MSGTXMUSCU = "Taux occ. M : ";
		final String MSGTXFIT = "Taux occ. F : ";
		final String MSGCOULMUSCU = "Couleur M : ";
		final String MSGCOULFIT = "Couleur F : ";
		final String MSGBAS = "M : en musculation	F : en fitness";

		String leDoc;

		DecimalFormat df2 = new DecimalFormat("##0.00%");
		leDoc = MSGNOM + this.nomComplexe + "\t";

		Date laDate = Calendar.getInstance().getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leDoc += MSGDATE + leJour.format(laDate) + "\t";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leDoc += MSGHEURE + lHeure.format(laDate) + "\n";
	

		leDoc += MSGDISPMUSCU + this.getNbPlacesRestantesMuscu() + "\t";
		leDoc += MSGOCCMUSCU + this.nbPlacesOccupeesMuscu + "\t";
		leDoc += MSGTXMUSCU + df2.format(this.etatMuscu()) + "\t";
		leDoc += MSGCOULMUSCU + this.couleurMuscu() + "\n";

		leDoc += MSGDISPFIT + this.getNbPlacesRestantesFit() + "\t";
		leDoc += MSGOCCFIT + this.nbPlacesOccupeesFit + "\t";
		leDoc += MSGTXFIT + df2.format(this.etatFit()) + "\t";
		leDoc += MSGCOULFIT + this.couleurFit() + "\n\n";
		//leDoc += MSGCOUT + this.getMontant() + "€\n";

		leDoc += MSGBAS + "\n\n";
		return leDoc;
	}
	

	//private String getMontant() {
		//ChoixMontant choixCouleur = new ChoixMontant();
		//return choixCouleur.getMontant().toString();
	//}

	
	/**
	 * @return le nombre de places restantes en salle de fitness
	 */
	public int getNbPlacesRestantesFit() {
		return this.nbTotalPlacesFit - (this.nbPlacesOccupeesFit);
	}

	/**
	 * @return le nombre de places occupées en fitness
	 */
	public int getNbPlacesOccupeesFit() {
		return this.nbPlacesOccupeesFit;
	}


	/**
	 * ajoute 1 usager en fitness
	 */
	public void nouvelUsagerFitness() {
		nbPlacesOccupeesFit++;
	}

	/**
	 * retire 1 usager en fitness
	 */
	public void oterUsagerFitness() {
		nbPlacesOccupeesFit--;
	}

	/**
	 * @return le nombre de places restantes en salle de musculation
	 */
	public int getNbPlacesRestantesMuscu() {
		return this.nbTotalPlacesMuscu - (this.nbPlacesOccupeesMuscu);
	}

	/**
	 * @return le nombre de places occupées en musculation
	 */
	public int getNbPlacesOccupeesMuscu() {
		return this.nbPlacesOccupeesMuscu;
	}

	/**
	 * ajoute 1 usager en musculation
	 */
	public void nouvelUsagerMusculation() {
		nbPlacesOccupeesMuscu++;
	}

	/**
	 * retire 1 usager en musculation
	 */
	public void oterUsagerMusculation() {
		nbPlacesOccupeesMuscu--;
	}

	/**
	 * @return La couleur correspondant au taux d'occupation de la salle de fitness
	 */
	private String couleurFit() {
		ChoixCouleur choixCouleur = new ChoixCouleur();
		return choixCouleur.getCouleur().toString();
	}
	
	
	/**
	 * @return le taux de remplissage de la salle de musculation
	 */
	public double etatMuscu() {
		return (this.getNbPlacesOccupeesMuscu()) * 1.0
				/ this.nbTotalPlacesMuscu;
	}

	
	/**
	 * @param num
	 * 			 le numéro d'entrée d'un client
	 * @return le numéro du client recherché
	 */
	private Arrivee recherche(int num) {
		int i = 0;
		Arrivee courant = lesArrivees.get(i);
		while (courant.getNumeroArrivee() != num)
			courant = lesArrivees.get(++i);
		return courant;
	}
}
