package Fall2017_Module1;

public abstract class Appliance {
	private static int total = 0; 
	public Appliance() {
		total++;
	}
	public static int getTotal() {return total; }
	public abstract String functionality();
}
