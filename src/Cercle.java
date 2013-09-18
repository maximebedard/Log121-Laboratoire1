import java.awt.Color;


public class Cercle extends Ovale
{

	public Cercle(int noSeq, int x, int y, int rayon) {
		super(noSeq, x, y, rayon, rayon);
		setCouleur(Color.ORANGE);
	}

}
