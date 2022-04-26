	package com.cfun.cfun;

	/**
	 * @author Dorian , Guillaume B et Nathan.
	 *
	 */
	public class ChoixMontant {

	/**
	 * @param a "Corresponds au temps passé par un client pour faire son sport"
	 * 		   
	 * @return "le prix que doit payer le client"
	 */
	public String ContructeurChoixMontant(double a) {
		
		if (a <= 0.25) {
			return "gratuit";
		} else if (a > 0.25 && a < 0.5) {
			return "zerocinq";
		} else if (a > 0.5 && a < 1) {
			return "un";
		}
		return null;
	}

	/**
	 * @return le montant
	 */ 
	public Object getMontant() {
		return null;
		}
	}
	
	


