/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: Carre.java
Date créé: 2013-09-17
*******************************************************
Historique des modifications
*******************************************************
*@author Nicolas Jiménez-Dumont
2013-09-17 Version initiale
*******************************************************/  
import java.awt.Color;

/**
 * Cette classe représente un carré
 */
public class Carre extends Rectangle {

    /**
     * Constructeur de la classe carré
     * @param noSeq Numéro séquentiel obtenu lors de la connexion au serveur
     * @param x position en X du carré
     * @param y position en Y du carré
     * @param longueurCote longueur des côtés d'un carré
     */
	public Carre(int noSeq, int x, int y, int longueurCote) {
		super(noSeq, x,  y,  longueurCote, longueurCote);
		setCouleur(Color.CYAN);
	}
}
