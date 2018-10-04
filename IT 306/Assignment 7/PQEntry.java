
public class PQEntry<K,V> {
	private K key;
	private V val;
	public static final long DEFAULT_KEY = 1000000; //Indicates a very low priority --used for non-connective flights.

	public PQEntry() {}

	public void setValue(V v){
		val = v;
		calcKey();
	}

	private void calcKey(){
		//TODO part
	}

	public V getValue() {return val; }

	public K getKey(){
		return key;
	}

	public String toString() {
		return "Value: "+ val.toString() + ", key: "+ key;
	}
}
