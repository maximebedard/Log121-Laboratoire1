import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;


public class FileTest {
	
	private void remplirFile(File<Forme> file)
	{
		assertEquals(0, file.getSize());
		for(int i = 0; i < 10; i++)
		{
			file.ajouter(new Rectangle(i, i * 10, i * 10, i * 10, i * 10));
		}
		assertEquals(10, file.getSize());
	}
	
	
	@Test
	public void testAjouter() {
		File<Forme> file = new File<Forme>();
		remplirFile(file);

		file.ajouter(new Rectangle(11, 110, 110, 110, 110));
		assertEquals(10, file.getSize());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRetirerVide() {
		File<Forme> file = new File<Forme>();
		assertEquals(0, file.getSize());
	
		file.retirer();
	}
	
	@Test
	public void testRetirerUnique()
	{
		File<Forme> file = new File<Forme>();
		
		file.ajouter(new Rectangle(0,10,10,10,10));
		
		file.retirer();
		assertEquals(0, file.getSize());
	}

	@Test
	public void testRetirerPleine()
	{
		File<Forme> file = new File<Forme>();
		
		remplirFile(file);
		file.retirer();
		assertEquals(9, file.getSize());
	}
	
	@Test 
	public void testIterator()
	{
		File<Forme> file = new File<Forme>();
		remplirFile(file);
		int i = 0;
		for(Forme f : file)
		{
			assertEquals(i, f.getNoSeq());
			assertEquals(i * 10, f.getX());
			i++;
		}

	}
	
	@Test(expected = NoSuchElementException.class)
	public void testIteratorVide()
	{
		File<Forme> file = new File<Forme>();
		
		Iterator<Forme> iter = file.iterator();
		
		assertEquals(false, iter.hasNext());
		
		iter.next();
	}
	

}
