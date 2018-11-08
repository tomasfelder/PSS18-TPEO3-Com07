package TDALista;
import java.util.Iterator;

public class ListaDE<E> implements PositionList<E> , java.io.Serializable{
	
	//atributos
	
		protected Dnodo<E> head , tail;
		protected int tamaño;
		
	//constructor
		
		public ListaDE() {
			head=new Dnodo<E>(null) ; 
			tail = new Dnodo<E>(null);
			tamaño=0;
			head.setNext(tail);
			tail.setPrev(head);
		}
		
	//metodos
		
		public int size() {
			return tamaño;
		}
		
		public boolean isEmpty() {
			return tamaño==0;
		}
		
		public Position<E> first() throws EmptyListException{
			if(tamaño==0)
				throw new EmptyListException("lista vacia");
			return head.getNext();
		}
		
		public Position<E> last() throws EmptyListException{
			if(tamaño==0)
				throw new EmptyListException("lista vacia");
			return tail.getPrev();
		}
		
		private Dnodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
			try {
				Dnodo<E> n = (Dnodo<E>) p;
				if(p==null || p==head || p==tail || tamaño==0)
					throw new InvalidPositionException("posicion nula o invalida");
				return n;
			}
			catch(ClassCastException e) {
				throw new InvalidPositionException("el parametro no era de tipo nodo");
			}
		}
		
		public Position<E> next(Position<E> p) throws InvalidPositionException , BoundaryViolationException{
			Dnodo<E> n = checkPosition(p);
			if(n.getNext() == tail)
				throw new BoundaryViolationException("error al usar next en la ult pos");
			return n.getNext();
		}
		
		public Position<E> prev (Position<E> p) throws InvalidPositionException , BoundaryViolationException{
			Dnodo<E> n = checkPosition(p);
			if (n.getPrev() == head)
				throw new BoundaryViolationException("error al usar prev en la primer pos");
			return n.getPrev();
		}
		
		public void addFirst(E e) {
			Dnodo<E> n = new Dnodo<E>(head,head.getNext(),e);
			head.setNext(n);
			n.getNext().setPrev(n);
			tamaño++;
		}
		
		public void addLast(E e) {
			Dnodo<E> n = new Dnodo<E>(tail.getPrev(),tail,e);
			tail.setPrev(n);
			n.getPrev().setNext(n);
			tamaño++;
		}
		
		public void addAfter(Position<E> p , E e) throws InvalidPositionException{
			Dnodo<E> n = checkPosition(p);
			Dnodo<E> ad = new Dnodo<E> (n,n.getNext(), e);
			n.setNext(ad);
			ad.getNext().setPrev(ad);
			tamaño++;
		}
		
		public void addBefore(Position<E> p , E e) throws InvalidPositionException{
			Dnodo<E> n = checkPosition(p);
			Dnodo<E> ad = new Dnodo<E> (n.getPrev(),n, e);
			n.setPrev(ad);
			ad.getPrev().setNext(ad);
			tamaño++;
		}
		
		public E remove ( Position<E> p) throws InvalidPositionException{
			Dnodo<E> n = checkPosition(p);
			E aux= p.element();
			n.getPrev().setNext(n.getNext());
			n.getNext().setPrev(n.getPrev());
			n.setNext(null);
			n.setPrev(null);
			n.setElemento(null);
			tamaño--;
			return aux;
		}
		
		public E set (Position<E> p ,E e) throws InvalidPositionException{
			Dnodo<E> n = checkPosition(p);
			E aux = n.getElemento();
			n.setElemento(e);
			return aux;
		}

		//--------------------------------------
		
		public Iterator<E> iterator(){
			return new ElementIterator<E>(this);
		}
		
		public Iterable<Position<E>> positions(){
			PositionList<Position<E>> LP = new ListaDE<Position<E>>();
			Dnodo<E> pri;
			if (!this.isEmpty()) {
				pri = head.getNext();
				while (pri!=tail) {
					LP.addLast(pri);
					pri = pri.getNext();
				}
			}
			return LP;
		}
		
		public void deleteExtra(ListaDE <E> B) {
			Dnodo<E> n = head.getNext();
			int a=0 , b=0;
			while(n!=tail) {
				E e= n.getElemento();
				Dnodo<E> aux=head.getNext();
				while(aux!=tail) {
					if(aux.getElemento()==e)
						a++;
					aux=aux.getNext();
				}
				Iterator<E> it=B.iterator();
				while(it.hasNext())
					if(it.next()==e)
						b++;
				if(b>a) {
					n.getPrev().setNext(n.getNext());
					n.getNext().setPrev(n.getPrev());
					aux=n.getNext();
					n.setNext(null);
					n.setPrev(null);
					n=aux;
				}
				else
					n=n.getNext();
				a=0; b=0;
			} 
		}
}
