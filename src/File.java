import java.util.Iterator;
import java.util.NoSuchElementException;


public class File<T> implements Iterable<T>
{
	/**
	 * Capacite par défaut de la file = 10
	 * */
	private static final int CAPACITY_DEFAUT = 10;
	
	/**
	 * Capacite de la file
	 * */
	private int capacity;
	
	/**
	 * Nombre d'éléments dans la file
	 * */
	private int size;
	
	/**
	 * Noeud au début de la file
	 * */
	private Noeud<T> begin;
	
	/**
	 * Noeud à la fin de la file
	 * */
	private Noeud<T> end;
	
	/**
	 * Construit une file de forme vide
	 * */
	public File()
	{	
		this(CAPACITY_DEFAUT);
	}
	
	/**
	 * Construit une file de forme vide d'une certaine capacité 
	 * @param capacity Capacité de la file 
	 * */
	public File(int capacity)
	{
		begin = end = null;
		size = 0;	
		this.capacity = capacity;
	}
	
	/**
	 * Ajoute une forme à la fin de la file
	 * @param elem une forme
	 * @throws IllegalArguementExcepetion si la forme est nulle
	 * */
	public void ajouter(T elem)
	{
		if(elem == null)
		{
			throw new IllegalArgumentException("f");
		}
		
		// on retire le premier element si la pile est pleine 
		if(size == capacity)
		{
			retirer();
		}
			
		// on ajoute le noeud racine s'il n'existe pas
		if(begin == null)
		{
			begin = new Noeud<T>(elem);
			end = begin;
		}
		// on ajoute le noeud à la fin
		else
		{
			end.next = new Noeud<T>(elem);
			end = end.next;
		}
			
		size++;
	}
	
	/**
	 * Retire un element de la file
	 * @throws NoSuchElementException si la file est vide
	 * */
	public void retirer()
	{
		// la pile est vide
		if(begin == null)
		{
			throw new NoSuchElementException();
		}
		
		// on deplace le noeud du debut s'il y a plus d'un element
		if(begin.hasNext())
		{
			Noeud<T> temp = begin.next;
			begin = temp;
			size--;
			return;
		}
		
		// autrement il y a uniquement le noeud du debut, on le supprime
		begin = null;
		end = null;
		size--;
	}
	
	/**
	 * Retoune un iterateur pour parcourir les formes contenues dans la file
	 * */
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private Noeud<T> prev = null;
			private Noeud<T> current = begin;

			@Override
            public boolean hasNext() 
            {
            	return current != null;
            }

            @Override
            public T next() 
            {
            	if(current == null)
            	{
            		throw new NoSuchElementException();
            	}
            		
        		prev = current;
    			current = current.next;	
        		return prev.elem;
            }

            @Override
            public void remove() 
            {
            	// Supprime le premier element
                if(prev == null)
                {
                	begin = current.next;
                	return;
                }
                
                // On modifie le liens de l'élément qui précède l'item en cours d'utilisation
                prev.next = current.next;
            }
            
		};
	}
	
	/**
	 * Retourne le nombre de formes dans la file
	 * @return nombre de formes
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Retourne la capacité de la file (le nombre total d'éléments que celle-ci peut contenir)
	 * @return capacité de la file
	 * */
	public int getCapacity()
	{
		return capacity;
	}

	private class Noeud<U> 
	{
		public Noeud(U value)
		{
			this(value, null);
		}
		
		public Noeud(U value, Noeud<U> next) {
			this.elem = value;
			this.next = next;
		}
		
		public boolean hasNext()
		{
			return next != null;
		}
		
		public U elem;
		public Noeud<U> next;		
	}
		
}
