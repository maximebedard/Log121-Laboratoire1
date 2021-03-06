/******************************************************
Cours:  LOG121
Projet: laboratoire #1
Nom du fichier: Forme.java
Date créé: 2013-09-12
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-09-12 Version initiale

*@author Nicolas Jiménez-Dumont
2013-09-17 Ajout de la variable couleur

*@author Maxime Bédard
2013-09-18 Modification de l'application de la couleur
           Ajout de la JavaDoc
*******************************************************/  

import java.awt.Graphics;
import java.awt.Color;

/**
 * Classe abstraite qui définit les attributs et les méthodes partagés entre
 * les différentes formes
 * 
 * @author Maxime Bédard
 */
public abstract class Forme {
	
	/**
	 * Numéro séquentiel unique obtenu lors de la création de la forme
	 */
	private int noSeq;

    /**
     * Position en X
     */
	private int x;

    /**
     * Position en Y
     */
	private int y;

    /**
     * Couleur de la forme
     */
	private Color couleur;
	
	/**
	 * Retourne le numéro séquentiel obtenu lors de la création 
	 * de la forme.
	 * @return le numéro séquentiel unique
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
	 * Assigne la couleur utilisé lorsque la forme est dessiné
	 * @param couleur Couleur de la forme
	 */
	public void setCouleur(Color couleur)
	{
		this.couleur = couleur;
	}
	
	
	/**
	 * Construit une nouvelle forme a partir d'un numéro séquentiel ainsi
	 * ainsi que ses coordonnées (x,y). Lors de la création d'une forme, la
     * couleur Color.BLACK est initialisé par défaut.
	 * @param noSeq Numéro séquentielle unique obtenu lors des échanges avec 
	 * 			    le serveur.
	 * @param x Position initiale de la forme en X sur le canevas
	 * @param y Position initiale de la forme en Y sur le canevas
	 */
	public Forme(int noSeq, int x, int y)
	{
		this.noSeq = noSeq;
		this.x = x;
		this.y = y;
		this.couleur = Color.BLACK;
	}

    /**
     * Dessine la forme sur le canevas en appelant la fonction dessinerForme
     * des classes qui héritent de Forme. Cette fonction applique la couleur
     * avant de dessiner la forme.
     * @param g Context graphique sur lequel dessiner la forme
     */
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		dessinerForme(g);

	}
	
	/**
	 * Dessine la forme sur le canevas
     * @param g Context graphique sur lequel dessiner la forme
	 */
	protected abstract void dessinerForme(Graphics g);
	
}
