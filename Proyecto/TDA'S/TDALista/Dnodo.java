package TDALista;

public class Dnodo<E> implements Position<E> {

	//atributos
		
		private Dnodo<E> prev,next;
		private E elem;
		
	//constructor
		
		public Dnodo(Dnodo<E> p , Dnodo<E> n ,E e) {
			prev = p ; next = n ; elem = e;
		}
		public Dnodo(E e) {
			this(null, null , e);
		}
		
	//metodos
		public E element() {
			return elem;
		}
		
		public E getElemento() {
			return elem;
		}
		
		public Dnodo<E> getPrev(){
			return prev;
		}
		
		public Dnodo<E> getNext(){
			return next;
		}
		
		public void setElemento(E e) {
			elem = e;
		}
		
		public void setNext(Dnodo<E> n) {
			next=n;
		}
		public void setPrev(Dnodo<E> p) {
			prev = p;
		}
}


