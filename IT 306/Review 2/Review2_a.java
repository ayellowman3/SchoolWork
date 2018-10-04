package Fall2017_Module1;

import javax.swing.JOptionPane;

public class Review2_a {
	/*
	 * Inheritance
	 * Create class Appliance as a super class (inheritance and polymorphism--abstract class and abstract method)
	 * Create the subclasses Oven,fridge,heater with the type of functionality(e.g., heat, cold) 
	 * Create class House (association)
	 * Create an application class to manage the record of multiple house objects.
	 * constructors
	 */
	
	public static void main(String[] args){ 
		//Instantiating a House object
		House h = new House(3); 
		
		//creating appliances, instantiating as Oven
		Appliance app1 = new Oven(500); 
		h.addAppliance(app1); 
		
		//creating appliances, instantiating as Heater
		Appliance app2 = new Heater("GE"); 
		h.addAppliance(app2); 
		
		//creating appliances, instantiating as Fridge
		Appliance app3 = new Fridge(10, 11, 12); 		
		h.addAppliance(app3); 
		String f="";
		for(int i=0; i<Appliance.getTotal(); i++) {
			//indicate the functionality
			Appliance temp = h.getAll()[i]; 
			f += temp.functionality(); 
			
			if (temp instanceof Oven) {
				Oven o = (Oven) temp; 
				f+= ","+ o.getMaxTemperatur()+ "\n";
			}
			else if (temp instanceof Heater) {
				Heater he = (Heater) temp;
				f+= ", " + he.getBrand()+ "\n";
			}
			else if (temp instanceof Fridge) {
				Fridge fr = (Fridge) temp;
				f+= "," + fr.getCapacity() + "\n";
			}
		}
		
		JOptionPane.showMessageDialog(null,f);
	}

}
