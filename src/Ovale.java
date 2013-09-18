/******************************************************
Cours:  LOG121
Projet: laboratoire #1
Nom du fichier: Ovale.java
Date créé: 2013-09-12
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-09-12 Version initiale

*@author Nicolas Jiménez-Dumont
2013-09-17 Ajout de la variable couleur - modification dessiner()
*******************************************************/  

import java.awt.Color;
import java.awt.Graphics;


public class Ovale extends Forme {
	
	private int largeur;
	
	private int longueur;

	public Ovale(int noSeq, int x, int y, int largeur, int longueur) {
		super(noSeq, x, y, Color.GREEN);
		this.largeur = largeur;
		this.longueur = longueur;
	}

	@Override
	protected void dessinerForme(Graphics g) {
		g.fillOval(getX(), getY(), largeur, longueur);
	}

}
