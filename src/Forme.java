/******************************************************
Cours:  LOG121
Projet: laboratoire #1
Nom du fichier: Forme.java
Date cr��: 2013-09-12
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-09-12 Version initiale

*@author Nicolas Jim�nez-Dumont
2013-09-17 Ajout de la variable couleur
*******************************************************/  

import java.awt.Graphics;
import java.awt.Color;

/**
 * Classe abstraite qui d�finit les attributs et les m�thodes partag�s entre
 * les diff�rentes formes
 * 
 * @author Maxime B�dard
 */
public abstract class Forme {
	
	/**
	 * Num�ro s�quentiel unique obtenu lors de la cr�ation de la forme
	 */
	private int noSeq;
	private int x;
	private int y;
	private Color couleur;
	
	/**
	 * Retourne le num�ro s�quentiel obtenu lors de la cr�ation 
	 * de la forme.
	 * @return le num�ro s�quentiel unique
	 */
	public int getNoSeq()
	{
		return noSeq;
	}
	
	/**
	 * Retourne la position en X de la forme
	 * @return position en x
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Assigne la position en X de la forme
	 * @param x Position en X de la forme sur le canevas
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Retourne la position en Y de la forme
	 * @return position en y
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Assigne la position en Y de la forme
	 * @param y Position en Y de la forme sur le canevas
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * Retourne la couleur de la forme
	 * @return couleur de la forme
	 */
	public Color getCouleur()
	{
		return couleur;
	}
	
	/**
	 * Assigne la couleur utilis� lorsque la forme est dessin�
	 * @param couleur Couleur de la forme
	 */
	public void setCouleur(Color couleur)
	{
		this.couleur = couleur;
	}
	
	
	/**
	 * Construit une nouvelle forme a partir d'un num�ro s�quentiel ainsi
	 * ainsi que ses coordonn�es (x,y)		
	 * 
	 * @param noSeq Num�ro s�quentielle unique obtenu lors des �changes avec 
	 * 			    le serveur.
	 * @param x Position initiale de la forme en X sur le canevas
	 * @param y Position initiale de la forme en Y sur le canevas
	 */
	public Forme(int noSeq, int x, int y, Color couleur)
	{
		this.noSeq = noSeq;
		this.x = x;
		this.y = y;
		this.couleur = couleur;
	}
	
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		dessinerForme(g);
	}
	
	/**
	 * Dessine la forme sur le canevas
	 */
	protected abstract void dessinerForme(Graphics g);
	
}
