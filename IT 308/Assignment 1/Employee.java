public abstract class Employee{
	private String fName;
	private String lName;
	private String jobTitle;
	private String empID;
	private Address address;

	public Employee(){

	}

	public Employee(String empID, String fName, String lName, String jobTitle){ 
		this.fName = fName;
		this.lName = lName;
		this.jobTitle = jobTitle;
		this.empID = empID;
	}

	public Employee(String empID, String fName, String lName, String jobTitle, Address address){ 
		this.fName = fName;
		this.lName = lName;
		this.jobTitle = jobTitle;
		this.empID = empID;
		this.address = address;
	}

	public void setfName(String fName){
		this.fName = fName;
	}
	public void setlName(String lName){
		this.lName = lName;
	}
	public void setjobTitle(String jobTitle){
		this.jobTitle = jobTitle;
	}
	public void setempID(String empID){
		this.empID = empID;
	}
	public void setaddress(Address address){
		this.address = address;
	}
	
	public String fName(){
		return fName;
	}
	public String lName(){
		return lName;
	}
	public String jobTitle(){
		return jobTitle;
	}
	public String empID(){
		return empID;
	}
	public Address address(){
		return  address;
	}	

	public abstract String computeMonthlySalary();

	public String toString(){
		String s = "";
		s += 	empID + "," +
				fName + "," +
				lName + "," +
				jobTitle + ",";
		return s;
	}
}