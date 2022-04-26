package com.lyceestsauveur.btssioslam2.testing;

public class ChoixCouleur {

	public String ContructeurChoixCouleur(double a) {
		if (a < 0.70) {
			return "vert";
		} else if (a == 1) {
			return "rouge";
		} else {
			return "orange";
		}
		
		


	}

}