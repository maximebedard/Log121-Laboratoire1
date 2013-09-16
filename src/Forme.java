import java.awt.Graphics;


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
	 * @TODO description
	 * 
	 * @param noSeq Num�ro s�quentielle unique obtenu lors des �changes avec 
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
