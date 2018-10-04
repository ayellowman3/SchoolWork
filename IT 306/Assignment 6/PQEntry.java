public class PQEntry {
	private long key;
	private Flight val;
	public static final long DEFAULT_KEY = 1000000; //Indicates a very low priority --used for non-connective flights.

	public PQEntry() {}

	public void setValue(Flight p){
		val = p;
		calcKey();
	}

	private void calcKey(){
		if (val.isConnectingFlight()) {
			this.key = val.getConnectionPeriod();
		}else{
			this.key = PQEntry.DEFAULT_KEY;
		}
	}

	public Flight getValue() {return val; }

	public long getKey(){
		return key;
	}

	public String toString() {
		return "Value: "+ val.toString() + ", key: "+ key;
	}
}
