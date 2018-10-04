public class SalariedEmployee extends Employee{

	private double yearlySalary;

	public SalariedEmployee(){
		super();
	}

	public SalariedEmployee(String empID, String fName, String lName, String jobTitle, Address address, double yearlySalary){ 
		super(empID, fName, lName, jobTitle, address);
		this.yearlySalary = yearlySalary;
	}

	public void setYearlySalary(double yearlySalary){
		this.yearlySalary = yearlySalary;
	}

	public double getYearlySalary(){
		return yearlySalary;
	}

	public String computeMonthlySalary(){
		double monthlySalary = yearlySalary/12;
		String salaryString = String.format("%1$,.2f", monthlySalary); 
		return salaryString;
	}

	public String toString(){
		String s = super.toString();
		s += computeMonthlySalary();
		return s;
	}
}