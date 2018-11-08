package TDAMapeo;

import TDALista.*;
public class MapeoHashAbierto<K,V> implements Map<K,V> {

	//atributos
		
		private PositionList<Entrada<K,V>>[] T;
		private int size;
		private int N;
		
	//constructor
		
		public MapeoHashAbierto() {
			size=0;
			N=7;
			T = (PositionList<Entrada<K,V>>[]) new ListaDE[N];
			for(int i=0 ; i<N ; i++) {
				T[i] = new ListaDE<Entrada<K,V>>();
			}
		}
		
	//metodos
		
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public V get (K key) throws InvalidKeyException{
			checkKey(key);
			int p = funcionHash(key);
			for(Entry<K,V> e : T[p])
				if(key.equals(e.getKey()))
					return e.getValue();
			return null;
			
		}
		
		private void checkKey(K k) throws InvalidKeyException {
			if(k==null)
				throw new InvalidKeyException("la clave es nula");
		}
		
		private int funcionHash(K k) {
			int i = Math.abs(k.hashCode());
			return (i % N);
		}
		
		private boolean factorCarga() {
			float i = size/N;
			return i<0.9;
		}
		
		public V put (K key, V value) throws InvalidKeyException{
			checkKey(key);
			
			if(!factorCarga())
				agrandarTabla();
			
			int p = funcionHash(key);

			for(Entrada<K,V> e : T[p])
				if(e.getKey().equals(key)) {
					V aux = e.getValue();
					e.setValue(value);
					return aux;
				}
			size++;
			T[p].addLast(new Entrada<K,V>(key,value));
			return null;
		}
		
		public V remove(K key) throws InvalidKeyException{
			checkKey(key);
			int p = funcionHash(key);
			try {
				for(Position<Entrada<K,V>> e : T[p].positions())
					if(e.element().getKey().equals(key)) {
						V aux = e.element().getValue();
						T[p].remove(e);
						size--;
						return aux;
					}
			}
			catch(InvalidPositionException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Iterable<K> keys(){
			PositionList<K> L = new ListaDE<K>();
			for(int i=0 ; i<N ; i++)
				for(Entrada<K,V> e : T[i])
					L.addLast(e.getKey());
			return L;
		}
		
		public Iterable<V> values(){
			PositionList<V> L = new ListaDE<V>();
			for(int i=0 ; i<N ; i++)
				for(Entrada<K,V> e : T[i])
					L.addLast(e.getValue());
			return L;
		}
		
		public Iterable<Entry<K,V>> entries(){
			PositionList<Entry<K,V>> L = new ListaDE<Entry<K,V>>();
			for(int i=0 ; i<N ; i++)
				for(Entrada<K,V> e : T[i])
					L.addLast(e);
			return L;
		}
		
		//---------------Ejercicios----------------
		
		public void agrandarTabla (){
			N= N*2 +1;
			PositionList<Entrada<K,V>> [] A = T;
			T =  (PositionList<Entrada<K,V>>[]) new ListaDE[N];
			for(int i=0; i<N ; i++)
				T[i]= new ListaDE<Entrada<K,V>>();
			
			for(int i=0 ; i<A.length ; i++)
				for(Entrada<K,V> e : A[i]) {
					int p = funcionHash(e.getKey());
					T[p].addLast(e);
				}
		}
		
		//---------13b--------------
		
		
		public boolean contenido(Map<K,V> M) {
			int f;
			boolean esta=false;
			for(Entry<K,V> e : M.entries()) {
				f=funcionHash(e.getKey());
				for(Entry<K,V> e2 : T[f]) 
					if(e==e2) {
						esta=true;
						break;
					}
				if(!esta)
					return false;
				esta=false;
			}
			
			return true;
					
		}
	
}
