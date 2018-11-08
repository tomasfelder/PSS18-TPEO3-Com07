package TDAMapeo;



import TDALista.*;
public class MapeoConLista<K,V> implements Map<K,V> {
	
	//atributos
	
		private PositionList<Entrada<K,V>> L;
		
	//constructor
		
		public MapeoConLista() {
			L = new ListaDE<Entrada<K,V>>();
		}
		
	//metodos
		
		public int size() {
			return L.size();
		}
		
		public boolean isEmpty() {
			return size()==0;
		}
		
		public V get(K k) throws InvalidKeyException {
			checkKey(k);
			for(Entrada<K,V> e : L)
				if(e.getKey().equals(k))
					return e.getValue();
			return null; 
		}
		
		private void checkKey(K k) throws InvalidKeyException {
			if(k==null)
				throw new InvalidKeyException("la clave es nula");
		}
		
		public V put(K key, V value)throws InvalidKeyException {
			checkKey(key);
			for( Position<Entrada<K,V>> p : L.positions() ) 
				if( p.element().getKey().equals(key) ) {
					V aux = p.element().getValue();
					p.element().setValue(value);
					return aux;
				}
			L.addLast(new Entrada<K,V>(key, value) );
			return null;
		}
		
		public V remove(K key) throws InvalidKeyException {
			checkKey(key);
			try {
				for(Position<Entrada<K,V>> p : L.positions()) {
					if(p.element().getKey().equals(key)) {
						V aux = p.element().getValue();
						L.remove(p);
						return aux;
					}
				}
			}
			catch(InvalidPositionException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Iterable<K> keys(){
			PositionList<K> Lk = new ListaDE<K>();
			for(Entrada<K,V> e : L)
				Lk.addLast(e.getKey());
			return Lk;
		}
		
		public Iterable<V> values(){
			PositionList<V> Lv = new ListaDE<V>();
			for(Entrada<K,V> e : L)
				Lv.addLast(e.getValue());
			return Lv;
		}
		
		public Iterable<Entry<K,V>> entries(){
			PositionList<Entry<K,V>> Le = new ListaDE<Entry<K,V>>();
			for(Entrada<K,V> e : L)
				Le.addLast(e);
			return Le;
		}
}
