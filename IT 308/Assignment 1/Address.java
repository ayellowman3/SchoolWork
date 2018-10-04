public class Address{
	private String empID;
	private String streetName;
	private int aptNumber;
	private String city;
	private String state;
	private int zipCode;

	public Address(String empID, int aptNumber, String streetName, String city, String state, int zipCode){
		this.empID = empID;
		this.streetName = streetName;
		this.aptNumber = aptNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public void setEmpID(String empID){
		this.empID = empID;
	}
	
	public void setStreetName(String streetName){
		this.streetName = streetName;
	}
	
	public void setAptNumber(int aptNumber){
		this.aptNumber = aptNumber;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public void setZipCode(int zipCode){
		this.zipCode = zipCode;
	}
	
	
	public String getEmpID(){
		return empID;
	}
	
	public String getStreetName(){
		return streetName;
	}
	
	public int getAptNumber(){
		return aptNumber;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getState(){
		return state;
	}
	
	public int getZipCode(){
		return zipCode;
	}

	public String toString(){
		String s = "";
		s+=empID + ","
		+ streetName + ","
		+ aptNumber + ","
		+ city + ","
		+ state + ","
		+ zipCode;
		return s;
	}
}