	package com.cfun.cfun;

	/**
	 * @author Dorian , Guillaume B et Nathan.
	 *
	 */
	public class ChoixCouleur {
		private Couleur couleur;
		/**
		 * @param etat "Correspond à l'état de la salle ( son taux de remplissage )"
		 * 			  
		 */
		public String ConstructeurChoixCouleur(double etat) {
			if (etat < 0.70)
			{
				couleur = Couleur.vert;  /* Couleur verte => Taux d'occupation < 70% */
			}
			else
			{
				couleur = Couleur.orange; /* Couleur orange => Taux d'occupation > 70% */
			}
			if (etat==1) 
			{
				couleur = Couleur.rouge; /* Couleur rouge => Taux d'occupation = 100% */
			}
			return null;
		}

		/**
		 * @return "la couleur correspond au taux de remplissage"
		 */
		public Couleur getCouleur() {
			return couleur;
		}
	}



	


