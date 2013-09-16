import java.awt.Graphics;


public class Ovale extends Forme {
	
	private int largeur;
	
	private int longueur;

	public Ovale(int noSeq, int x, int y, int largeur, int longueur) {
		super(noSeq, x, y);
		this.largeur = largeur;
		this.longueur = longueur;
	}

	@Override
	public void dessiner(Graphics g) {
		g.drawOval(getX(), getY(), largeur, longueur);
	}

}
