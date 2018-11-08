package TDALista;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ElementIterator<E> implements Iterator<E> {

	//atributos
	
			protected PositionList<E> list;
			protected Position<E> cursor;
			
	//constructor
			
			public ElementIterator(PositionList<E> L) {
				try {
					list=L;
					if (list.isEmpty())
						cursor=null;
					else
						cursor=list.first();
				}
				catch(EmptyListException e) {
					e.printStackTrace();
				}
			}
			
	//metodos
			
			public boolean hasNext() {
				return cursor!=null;
			}
			
			public E next() throws NoSuchElementException{
				E ret = null;
				try {
					if (cursor==null)
						throw new NoSuchElementException("no tiene siguiente");
					ret = cursor.element();
					cursor= (cursor==list.last()) ? null : list.next(cursor);
				}
				catch (InvalidPositionException | EmptyListException | BoundaryViolationException e) {
					e.printStackTrace();
				}
				return ret; 
			}
}
