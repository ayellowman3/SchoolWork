public class EmployeeWithBonus extends Employee{
	
	private double yearlySalary;
	private double bonus;

	public EmployeeWithBonus(){
		super();
	}

	public EmployeeWithBonus(String fName, String lName, String jobTitle, String empID, Address address, double yearlySalary, double bonus){ 
		super(fName, lName, jobTitle, empID, address);
		this.yearlySalary = yearlySalary;
		this.bonus = bonus;
	}

	public void setYearlySalary(double yearlySalary){
		this.yearlySalary = yearlySalary;
	}

	public void setBonus(double bonus){
		this.bonus = bonus;
	}

	public double getYearlySalary(){
		return yearlySalary;
	}

	public double getBonus(){
		return bonus;
	}
	
	public String computeMonthlySalary(){
		double monthlySalary = yearlySalary/12;
		monthlySalary += monthlySalary * bonus;
		String salaryString = String.format("%1$,.2f", monthlySalary); 
		return salaryString;
	}

	public String toString(){
		String s = super.toString();
		s += computeMonthlySalary();
		return s;
	}
}