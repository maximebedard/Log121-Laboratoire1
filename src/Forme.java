import java.awt.Graphics;


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
	private int x;
	private int y;
	
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
	 * @TODO description
	 * 
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
	}
	
	/**
	 * Dessine la forme sur le canevas
	 */
	public abstract void dessiner(Graphics g);
	
}
