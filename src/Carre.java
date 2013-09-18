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

public class Carre extends Rectangle {
	

	public Carre(int noSeq, int x, int y, int longueurCote) {
		super(noSeq, x,  y,  longueurCote, longueurCote);
		couleur = Color.CYAN;
		
	}
}
