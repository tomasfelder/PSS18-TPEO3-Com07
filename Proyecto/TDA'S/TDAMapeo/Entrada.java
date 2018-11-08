package TDAMapeo;

public class Entrada<K,V> implements Entry<K,V> {
	
    //atributos
		private K clave;
		private V valor;
	
	//constructor
		
		public Entrada(K k, V v) { 
			clave = k; valor = v; 
		}
	
	//metodos
		
		public K getKey() { 
			return clave; 
		}
	
		public V getValue() { 
			return valor;
		}
		
		public void setKey( K k ) {
			clave = k;
		}
	
		public void setValue(V v) { 
			valor = v;
		}
		
}