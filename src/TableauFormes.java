/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: TableauFormes.java
Date créé: 2013-09-17
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Nicolas Jiménez-Dumont
2013-09-17 Version initiale
 *******************************************************/

import java.util.NoSuchElementException;

public class TableauFormes {

	/**
	 * Tableau contenants les formes
	 * */
	private Forme[] tabFormes;

	/**
	 * Itterateur indiquant é quelle position du tableau les formes doivent étre
	 * ajouté
	 * */
	private int itterateurFin;

	/**
	 * Itterateur indiquant é quelle position du tableau les formes doivent étre
	 * enlevé
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
	 * varables sont initialisé é 0
	 */
	public TableauFormes() {
		tabFormes = new Forme[10];
		itterateurFin = 0;
		itterateurDebut = 0;
		nbElements = 0;
	}

	/**
	 * Ajoute au tableau une nouvelle forme, le nombre de forme mémorisé
	 * n'excédera pas 10
	 * 
	 * @param valForme Forme à ajouter
	 */
	public void ajouter(Forme valForme) {
		tabFormes[itterateurFin] = valForme;

		// ajuste les variable local aux changements apporté au tableau
		incrementeNbElements();
		incrementeItterateurFin();
	}

	/**
	 * Obtient la forme la plus ancienne ajouté au tableau de formes
	 * 
	 * @return objet de type Forme
	 */
	public Forme retirer() {

		if (nbElements > 0) {
			// ajuste les variable local aux changements apporté au tableau
			decrementeNbElements();
			incrementeItterateurDebut();

			return tabFormes[itterateurDebut];
		} else {
			// exception lancé si il n'y a aucune forme é retourner
			throw new NoSuchElementException();
		}

	}

	/**
	 * Incremente l'ittérateur en boucle pour qu'il ne dépasse pas 9
	 */
	private void incrementeItterateurFin() {
		itterateurFin++;
		itterateurFin = (itterateurFin == 10) ? 0 : itterateurFin;
	}

	/**
	 * Incremente l'ittérateur en boucle pour qu'il ne dépasse pas 9
	 */
	private void incrementeItterateurDebut() {
		itterateurDebut++;
		itterateurDebut = (itterateurDebut == 10) ? 0 : itterateurDebut;
	}

	/**
	 * Incremente le nombre d'éléments en boucle pour qu'il ne dépasse pas 10
	 */
	private void incrementeNbElements() {
		nbElements++;
		nbElements = (nbElements > 10) ? 10 : nbElements;
	}

	/**
	 * Incremente le nombre d'éléments en boucle pour qu'il ne soit pas sous 0
	 */
	private void decrementeNbElements() {
		nbElements--;
		nbElements = (nbElements < 0) ? 0 : nbElements;

	}
}
