import java.awt.Graphics;


public class Ligne extends Forme {
	
	private int x2;
	private int y2;
	
	public Ligne(int noSeq, int x, int y, int x2, int y2) {
		super(noSeq, x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void dessiner(Graphics g) {
		g.drawLine(getX(), getY(), x2, y2);
	}

}
