package com.cfun.cfun;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Nathan, Dorian, Guillaume B.
 *
 */
public class Arrivee {
	private static int numeroSortie = 0;
	private int numeroArrivee;

	/**
	 * @return Le numéro d'arrivée du client
	 */
	public int getNumeroArrivee() {
		return numeroArrivee;
	}

	private char choixSport;

	/**
	 * @return Le sport choisi par le client 
	 */
	public char getChoixSport() {
		return choixSport;
	}

	private long horaireArrivee;
	private Calendar hDep;

	private Complexe complexe;

	/**
	 * @param complexe 
	 * 				  Le complexe où se trouve le client
	 * @param choixSport
	 * 					Le sport choisi par le client
	 */
	public Arrivee(final Complexe complexe, final char choixSport) {
		this.horaireArrivee = Calendar.getInstance().getTimeInMillis();
		this.choixSport = choixSport;
		this.complexe = complexe;
		this.hDep = null;
	}

	/**
	 * @return le billet d'entrée contenant toutes les informations liées à l'entrée d'un client
	 */
	public String afficheBillet() {
		final String MSGNOM = "Complexe ";
		final String MSGNUM = "Billet d'entrée n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";
		final String MSGCOUT = "Montant : ";

		String leBillet;
		leBillet = MSGNOM + this.getComplexe().getNomComplexe() + "\t";
		leBillet += MSGNUM + this.numeroArrivee + "\n";

		Calendar leCal = Calendar.getInstance();
		leCal.setTimeInMillis(this.horaireArrivee);
		Date laDate = leCal.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leBillet += MSGDATE + leJour.format(laDate) + "\n";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leBillet += MSGHEURE + lHeure.format(laDate) + "\n";
		leBillet += MSGCOUT + this.getMontant() + " €\n"; 

		return leBillet;
	}

	/**
	 * @return Le ticket contenant toutes les informations liées à la sortie d'un client
	 */
	public String afficheTicket() {
		final String MSGNOM = "Complexe ";
		final String MSGNUM = "Ticket de sortie n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";
		final String MSGCOUT = "Montant : ";

		String leTicket;

		leTicket = MSGNOM + this.getComplexe().getNomComplexe() + "\t";
		leTicket += MSGNUM + ++Arrivee.numeroSortie + "\n";

		this.hDep = Calendar.getInstance();
		
		//on simule ici une sortie 32 mn plus tard
		hDep.add(Calendar.MINUTE, +90);
		
		Date laDate = hDep.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leTicket += MSGDATE + leJour.format(laDate) + "\n";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leTicket += MSGHEURE + lHeure.format(laDate) + "\n";
		leTicket += MSGCOUT + this.getMontant() + "€\n";

		return leTicket;
	}

	/**
	 * @return le montant que le client doit payer
	 */
	public double getMontant() {
		double cout = 0;

		if (hDep != null) {
			// on passe des ms en mn
			long dep = hDep.getTimeInMillis() / (1000 * 60);
			long arr = this.horaireArrivee / (1000 * 60);
			long duree =  dep - arr;
			

			if (duree <= 30 && duree > 15) {
				cout = 0.5;
			} else {
				if (duree <= 15){
					cout = 0;
				}
				if (duree >30 && duree <= 60) {
					cout = 1;
				} else {
					// cout fixe d'une heure
					cout = 1;
					duree -= 60;
					// + tous les 1/4 h commencés
					long nbquarts, reste;
					nbquarts = duree / 15;
					reste = duree % 15;
					if (reste != 0)
						nbquarts++;
					cout += nbquarts * 0.5;
				}

			}
		}
		return cout;
	}

	/**
	 * @return le complexe où se trouve le client
	 */
	public Complexe getComplexe() {
		return this.complexe;
	}

	/**
	 * @param numero 
	 * 				Assigne un numéro à un client
	 */
	public void setNumeroArrivee(int numero) {
		numeroArrivee = numero;
	}
}
