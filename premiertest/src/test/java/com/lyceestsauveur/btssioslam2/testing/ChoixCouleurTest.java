package com.lyceestsauveur.btssioslam2.testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class ChoixCouleurTest {

	@Test
	void testAddTwoPositiveNumbers() {
		double a =  0.80;


		ChoixCouleur calculator = new ChoixCouleur();
		// Act
		String letest = calculator.ContructeurChoixCouleur(a);

		// Assert
		assertEquals("orange", letest);
		a = 1;
		letest = calculator.ContructeurChoixCouleur(a);
		assertEquals("rouge", letest );
		a =0.60;
		letest = calculator.ContructeurChoixCouleur(a);
		assertEquals("vert", letest);
	
	}
	
}

