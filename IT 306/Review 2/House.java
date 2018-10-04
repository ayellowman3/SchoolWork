package Fall2017_Module1;

public class House {
	private Appliance[] apps; 
	public House () {
		apps = new Appliance[5] ; 
	} 
	
	public House(int i){
		apps= new Appliance[i];
	}
	
	public void addAppliances(Appliance[] apps){
		this.apps = apps; 
	}
	
	public boolean addAppliance (Appliance app) {
		if (apps.length < Appliance.getTotal()) return false;
		apps[Appliance.getTotal()-1] = app; 
		return true;
	}
	
	public Appliance[] getAll() {return apps; }
	
}
