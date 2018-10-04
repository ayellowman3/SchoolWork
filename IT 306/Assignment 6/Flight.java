
public class Flight {

    private String flightNumber;
    private boolean connectingFlight;
    private long connectionPeriod; 
    
    public Flight(String flightNumber, boolean connectingFlight){
        this.flightNumber = flightNumber;
        this.connectingFlight = connectingFlight;
        connectionPeriod = PQEntry.DEFAULT_KEY;
    }
    public Flight(String flightNumber, boolean connectingFlight, long connectionPeriod){
        this.flightNumber = flightNumber;
        this.connectingFlight = connectingFlight;
        this.connectionPeriod = connectionPeriod;
    }
    public boolean setConnectionPeriod(long p){
    	if (p < PQEntry.DEFAULT_KEY) {
    		connectionPeriod = p;
    		return true;
    	}
    	else return false;
    }
    public long getConnectionPeriod() { return connectionPeriod; }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public boolean isConnectingFlight() {
        return connectingFlight;
    }
    public void setConnectingFlight(boolean connectingFlight) {
        this.connectingFlight = connectingFlight;
    }
    public String toString (){

        return "F#"+flightNumber;
    }



}
