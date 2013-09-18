import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;


public class TableauFormesTest {
	
	private void remplirTableau(TableauFormes tabl)
	{
		assertEquals(0, tabl.getNbElements());
		for(int i = 0; i < 10; i++)
		{
			tabl.ajouter(new Rectangle(i, i * 10, i * 10, i * 10, i * 10));
		}
		assertEquals(10, tabl.getNbElements());
	}
	
	
	@Test
	public void testAjouter() {
		TableauFormes tabl = new TableauFormes();
		remplirTableau(tabl);

		tabl.ajouter(new Rectangle(11, 110, 110, 110, 110));
		assertEquals(10, tabl.getNbElements());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRetirerVide() {
		TableauFormes tabl = new TableauFormes();
		assertEquals(0, tabl.getNbElements());
	
		tabl.retirer();
	}
	
	@Test
	public void testRetirerUnique()
	{
		TableauFormes tabl = new TableauFormes();
		
		tabl.ajouter(new Rectangle(0,10,10,10,10));
		
		tabl.retirer();
		assertEquals(0, tabl.getNbElements());
	}

	@Test
	public void testRetirerPleine()
	{
		TableauFormes tabl = new TableauFormes();
		
		remplirTableau(tabl);
		tabl.retirer();
		assertEquals(9, tabl.getNbElements());
	}
	
	

}
