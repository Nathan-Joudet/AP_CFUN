package com.lyceestsauveur.btssioslam2.testing;

public class ChoixMontant {

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

}