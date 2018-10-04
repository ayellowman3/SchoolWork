package Fall2017_Module1;

public class Oven extends Appliance{
	private double maxTemperature; 
	
	public Oven(){
		super(); 
	}
	
	public Oven(double maxTemperature) {
		this(); 
		this.maxTemperature = maxTemperature; 
	}
	
	public String functionality() {
		return "heat"; 
	}
	
	public double getMaxTemperatur() { return maxTemperature; }
}
