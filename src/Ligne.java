/******************************************************
Cours:  LOG121
Projet: laboratoire #1
Nom du fichier: Ligne.java
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


public class Ligne extends Forme {
	
	private int x2;
	private int y2;
	
	public Ligne(int noSeq, int x, int y, int x2, int y2) {
		super(noSeq, x, y);
		this.x2 = x2;
		this.y2 = y2;
		couleur = Color.YELLOW;
	}

	@Override
	public void dessiner(Graphics g) {
		g.setColor(couleur);
		g.drawLine(getX(), getY(), x2, y2);
		
	}

}
