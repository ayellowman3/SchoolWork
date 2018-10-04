package Fall2017_Module1;

public class Heater extends Appliance{
	private String brand; 
	
	public Heater() { super(); }
	public Heater(String brand) {
		this(); 
		this.brand = brand; 
	}
	
	public String functionality() {
		return "water heating"; 
	}
	
	public String getBrand() { return brand; }
}
