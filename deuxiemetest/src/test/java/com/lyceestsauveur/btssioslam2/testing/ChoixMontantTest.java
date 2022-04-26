package com.lyceestsauveur.btssioslam2.testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ChoixMontantTest {

	@Test
	void testAddTwoPositiveNumbers() {
		double a = 0.15;

		ChoixMontant calculator = new ChoixMontant();
		// Act
		String letest = calculator.ContructeurChoixMontant(a);

		// Assert
		assertEquals("gratuit", letest);
		a = 0.40;
		letest = calculator.ContructeurChoixMontant(a);
		assertEquals("zerocinq", letest);
		a = 0.60;
		letest = calculator.ContructeurChoixMontant(a);
		assertEquals("un", letest);

	}

}
