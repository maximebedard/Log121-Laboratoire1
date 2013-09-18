import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.media.sound.InvalidFormatException;


public class DecodeurFormeTest {

	@Test(expected = IllegalArgumentException.class)
	public void formatInvalideTest()  {
		new DecodeurForme("<Carre>0 0 1</Carre>");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void formeInvalideTest() 
	{
		new DecodeurForme("1 <SPHERE>0 0 1 1</SPHERE>");
	}
	
	@Test
	public void decodeurFormeCarreTest() 
	{
		DecodeurForme d = new DecodeurForme("1 <CARRE>0 0 1 1</CARRE>");
		
		assertEquals(1, d.getNoSeq());
		assertEquals(TypeForme.CARRE, d.getType());
	}

	@Test
	public void decodeurFormeRectangleTest()
	{
		DecodeurForme d = new DecodeurForme("1 <RECTANGLE>0 0 1 1</RECTANGLE>");
		
		assertEquals(1, d.getNoSeq());
		assertEquals(TypeForme.RECTANGLE, d.getType());
	}
	
	@Test
	public void decodeurFormeCercleTest()
	{
		DecodeurForme d = new DecodeurForme("1 <CERCLE>0 0 1 1</CERCLE>");
		
		assertEquals(1, d.getNoSeq());
		assertEquals(TypeForme.CERCLE, d.getType());
	}
	
	@Test
	public void decodeurFormeOvaleTest() 
	{
		DecodeurForme d = new DecodeurForme("1 <OVALE>0 0 1 1</OVALE>");
		
		assertEquals(1, d.getNoSeq());
		assertEquals(TypeForme.OVALE, d.getType());
	}
	
	@Test
	public void decodeurFormeLigneTest() 
	{
		DecodeurForme d = new DecodeurForme("1 <LIGNE>0 0 1 1</LIGNE>");
		
		assertEquals(1, d.getNoSeq());
		assertEquals(TypeForme.LIGNE, d.getType());
	}
	
}
