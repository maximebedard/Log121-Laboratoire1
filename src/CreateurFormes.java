import com.sun.media.sound.InvalidFormatException;


public final class CreateurFormes 
{

	/**
     * Cr�e une nouvelle forme. Cette m�thode re�oit la cha�ne de
     * caract�res provenant du serveur de formes, elle d�termine de quelle
     * forme il s'agit et applique l'op�rateur new sur le constructeur de
     * la forme d�sir�e.
     *
     * @param chaineForme un objet String contenant la cha�ne de caract�res
     *                    qui d�crit une forme et provenant du serveur de
     *                    formes.
     *
     * @return une instance d'une des sous-classes de la classe abstraite
     *         Forme avec les param�tres pass�s par la cha�ne d'entr�e.
     */
    public static Forme creerForme(String chaineForme) 
    {
			DecodeurForme df = new DecodeurForme(chaineForme);

			Forme f = null;
			int[] coords = df.getCoordonnes();
			switch(df.getType())
			{
			case CARRE:
				f = new Carre(df.getNoSeq(), coords[0], coords[1], coords[2]);
				break;
			case CERCLE:
				//f = new Cercle();
				break;
			case LIGNE:
				f = new Ligne(df.getNoSeq(), coords[0], coords[1], coords[2], coords[3]);
				break;
			case OVALE:
				f = new Ovale(df.getNoSeq(), coords[0], coords[1], coords[2], coords[3]);
				break;
			case RECTANGLE:
				f = new Rectangle(df.getNoSeq(), coords[0], coords[1], coords[2], coords[3]);
				break;
			default:
				break;
			
			}
    	
			return f;
    }
}
