/******************************************************
Cours:  LOG121
Projet: laboratoire #1
Nom du fichier: Rectangle.java
Date créé: 2013-09-12
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-09-12 Version initiale

*@author Nicolas Jiménez-Dumont
2013-09-17 Ajout de la variable couleur - modification dessiner()
*******************************************************/  

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Forme {
	
	private int largeur;
	
	private int longueur;
	
	public int getLargeur()
	{
		return largeur;
	}
	public int getLongueur()
	{
		return longueur;
	}

	public Rectangle(int noSeq, int x, int y, int largeur, int longueur) {
		super(noSeq, x, y);
		this.largeur = largeur;
		this.longueur = longueur;
		couleur = Color.MAGENTA;
	}

	@Override
	public void dessiner(Graphics g) {
		g.setColor(couleur);
		g.fillRect(getX(), getY(), largeur, longueur);
	}

}
