/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: TableauFormes.java
Date cr��: 2013-09-17
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Nicolas Jim�nez-Dumont
2013-09-17 Version initiale
 *******************************************************/

import java.util.NoSuchElementException;

public class TableauFormes {

	/**
	 * Tableau contenants les formes
	 * */
	private Forme[] tabFormes;

	/**
	 * Itterateur indiquant � quelle position du tableau les formes doivent �tre
	 * ajout�
	 * */
	private int itterateurFin;

	/**
	 * Itterateur indiquant � quelle position du tableau les formes doivent �tre
	 * enlev�
	 * */
	private int itterateurDebut;

	/**
	 * Nombre d'elements actuellement dans le tableau
	 */
	private int nbElements;

	/**
	 * Encapsulation du nombre d'elements
	 * 
	 * @return Nombre d'elements actuellement dans le tableau
	 */
	public int getNbElements() {
		return nbElements;
	}

	/**
	 * Constructeur: la taille du tableau est toujours = 10. Tous les autres
	 * varables sont initialis� � 0
	 */
	public TableauFormes() {
		tabFormes = new Forme[10];
		itterateurFin = 0;
		itterateurDebut = 0;
		nbElements = 0;
	}

	/**
	 * Ajoute au tableau une nouvelle forme, le nombre de forme m�moris�
	 * n'exc�dera pas 10
	 * 
	 * @param Objet
	 *            de type Forme
	 */
	public void ajouter(Forme valForme) {
		tabFormes[itterateurFin] = valForme;

		// ajuste les variable local aux changements apport� au tableau
		incrementeNbElements();
		incrementeItterateurFin();
	}

	/**
	 * Obtient la forme la plus ancienne ajout� au tableau de formes
	 * 
	 * @return objet de type Forme
	 */
	public Forme retirer() {

		if (nbElements > 0) {
			// ajuste les variable local aux changements apport� au tableau
			decrementeNbElements();
			incrementeItterateurDebut();

			return tabFormes[itterateurDebut];
		} else {
			// exception lanc� si il n'y a aucune forme � retourner
			throw new NoSuchElementException();
		}

	}

	/**
	 * Incremente l'itt�rateur en boucle pour qu'il ne d�passe pas 9
	 */
	private void incrementeItterateurFin() {
		itterateurFin++;
		itterateurFin = (itterateurFin == 10) ? 0 : itterateurFin;
	}

	/**
	 * Incremente l'itt�rateur en boucle pour qu'il ne d�passe pas 9
	 */
	private void incrementeItterateurDebut() {
		itterateurDebut++;
		itterateurDebut = (itterateurDebut == 10) ? 0 : itterateurDebut;
	}

	/**
	 * Incremente le nombre d'�l�ments en boucle pour qu'il ne d�passe pas 10
	 */
	private void incrementeNbElements() {
		nbElements++;
		nbElements = (nbElements > 10) ? 10 : nbElements;
	}

	/**
	 * Incremente le nombre d'�l�ments en boucle pour qu'il ne soit pas sous 0
	 */
	private void decrementeNbElements() {
		nbElements--;
		nbElements = (nbElements < 0) ? 0 : nbElements;

	}
}
