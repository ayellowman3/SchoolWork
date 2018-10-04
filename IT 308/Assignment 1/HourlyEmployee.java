public class HourlyEmployee extends Employee{
	public final double rate = 10.5;

	private int hoursWorked;

	public HourlyEmployee(){
		super();
	}

	public HourlyEmployee(String empID, String fName, String lName, String jobTitle, Address address, int hoursWorked){ 
		super(empID, fName, lName, jobTitle, address);
		this.hoursWorked = hoursWorked;
	}

	public void setHoursWorked(int hoursWorked){
		this.hoursWorked = hoursWorked;
	}
	
	public int getHoursWorked(){
		return hoursWorked;
	}

	public String computeMonthlySalary(){
		double monthlySalary = rate * hoursWorked;
		String salaryString = String.format("%1$,.2f", monthlySalary); 
		return salaryString;
	}

	public String toString(){
		String s = super.toString();
		s += computeMonthlySalary();
		return s;
	}
}