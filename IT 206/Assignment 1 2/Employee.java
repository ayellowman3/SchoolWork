/*
George Huang
9/25/2016
IT 206-001
Assignment 2
This is the data definiton class called Employee
*/
public class Employee
{
	//constants
	private static int empCount = 0;
	private static double totalPayout = 0.00;
	final public static double standardPayRate = 12.63;
	final public static double seniorBonus = 206.26;

	//instance valiables
	private String name;
	private String empID;
	private double hrPayRate;
	private double hrWorked;
	private boolean seniorEmp;
	private double empPaycheck;

	//default constructor
	public Employee()
	{
		this(null, null, standardPayRate, 0.0, false, 0.0);
	}
	
	//constructor
	public Employee(String name, String empID, double hrPayRate, double hrWorked, boolean seniorEmp, double empPaycheck)
	{
		this.name = name;
		this.empID = empID; 
		this.hrPayRate = hrPayRate;
		this.hrWorked = hrWorked;
		this.seniorEmp =seniorEmp;
		this.empPaycheck =empPaycheck;
		++empCount;
	}

	//accessors
	public static int getEmpCount()
	{
		return empCount;
	}

	public static double getTotalPayout()
	{
		return totalPayout;
	}

	public String toString()
	{
		String summary = "Summary\n"
		+"\nName: " + this.name
		+"\nEmployee ID: " + this.empID
		+"\nHourly Pay Rate: " + String.format("$%.2f",this.hrPayRate)
		+"\nHours Worked: " + this.hrWorked
		+"\nSenior Employee Status: ";
		if(this.seniorEmp) summary += "Yes";
		else summary += "No";
		summary += "\nEmployee Paycheck Amount: " + String.format("$%.2f", this.empPaycheck);
		return summary;
	}

	//mutators
	public boolean setName(String name)
	{
		if(validateNonEmptyString(name))
		{
			this.name = name;
			return true;
		}
		return false;
	}

	public boolean setEmpID(String empID)
	{
		if(validateNonEmptyString(empID))
		{
			this.empID = empID;
			return true;
		}
		return false;
	}
	
	public boolean setHrPayRate(double hrPayRate)
	{
		if(validatePositiveDouble(hrPayRate))
		{
			this.hrPayRate = hrPayRate;
			return true;
		}
		return false;
	}
	
	public boolean setHrWorked(double hrWorked)
	{
		if(validatePositiveDouble(hrWorked))
		{
			this.hrWorked = hrWorked;
			return true;
		}
		return false;
	}
	
	public boolean setSeniorEmp(String seniorEmp)
	{
		if(validateYOrN(seniorEmp))
		{
			if(seniorEmp.equalsIgnoreCase("Y")) this.seniorEmp = true;
			else this.seniorEmp = false;
			return true;
		}
		return false;
	}

	//validation mutators
	private boolean validateNonEmptyString(String str)
	{
		return(!str.equals("")); 
	}

	private boolean validatePositiveDouble(double num)
	{
		return(num>=0);
	}
	private boolean validateYOrN(String str)
	{
		return(str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("N"));
	}

	//special purpse method
	public void setEmpPaycheck()
	{
		this.empPaycheck = hrPayRate*hrWorked;
		if(seniorEmp) this.empPaycheck += seniorBonus;
		totalPayout += this.empPaycheck;
	}
}