import java.awt.Graphics;


public class Rectangle extends Forme {
	
	private int largeur;
	
	private int longueur;

	public Rectangle(int noSeq, int x, int y, int largeur, int longueur) {
		super(noSeq, x, y);
		this.largeur = largeur;
		this.longueur = longueur;
	}

	@Override
	public void dessiner(Graphics g) {
		g.drawRect(getX(), getY(), largeur, longueur);
	}

}
