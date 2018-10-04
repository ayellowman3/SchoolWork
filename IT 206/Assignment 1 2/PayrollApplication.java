/*
George Huang
9/25/2016
IT 206 001
Assignment 2

Payroll application is a program that generates the salary for each of its employees. 
The program asks the user for the employee's name, employee ID, pay rate, hours worked, 
senior employee status. The program then calculates the total amount of money on his/her
next paycheck. When the employees are entered, the program keeps count the number of 
employees entered and the total amount of all paychecks.

input

Variable: Name
type: String
description: Name of the employee. may not be an empty string.

Variable: empID
type: String
description: Employee's ID. May not be an empty string.

Variable: hrPayRate
type: Double
description: Employee's hourly pay rate. The user may use the default payrate or choose
to enter a different pay rate. If the user enters a payrate, it must be greater then
or equal to 0.

Variable: hrWorked
type: double
description: The amount of hours the employee has worked. This is required. double has
to be greater then or equal to 0.

Variable: seniorEmp
type: boolean
description: The user enters Y or N for employee's senior status. If Y is entered, it 
sets seniorEmp to true. If N, seniorEmp is set to false. Anything else would generate 
an error message.

output:

Variable: empCount
type: int
description: Everything an employee is created, the number increases.

Variable: totalPayout
type: double
description: keeps count of the total amount of all paychecks. 

Variable: toString()
type: String
description: Returns a summary of the emplyee information which includes, name,
employee ID, hourly pay rate, hours worked, senior employee status, and paycheck amount.



*/
import javax.swing.JOptionPane;
public class PayrollApplication
{
	//main method
	public static void main(String[] args)
	{
		
		do
		{
			//calles the addEmployee method
			Employee emp = addEmployee();
		//called the setMoreEmployees method to ask the user if they would like to enter
		//any more emplooyees
		}while(setMoreEmployees());
		//method to get the payroll application summery
		payrollSummery(Employee.getEmpCount(), Employee.getTotalPayout());
		//displays a thank you message for the user!
		JOptionPane.showMessageDialog(null, "Thank You for using Payroll Application! \n Have a great day!");
	}

	//This is the addEmployee method. It is used to create the employee object and get
	//the employee's information
	private static Employee addEmployee()
	{
		//create the new employee object.
		Employee emp = new Employee();
		//used to keep track if there are any user input errors as they are entering.
		//if there is an error, the user is reprompted.
		boolean error;
		
		//Used to get, set, and validate employee's name
		String name;
		do
		{
			name = getName();
			error = !emp.setName(name);
			if(error) JOptionPane.showMessageDialog(null, "Error! Invalid name entered!");
		}while(error);

		//used to get, set and validate employee ID
		String empID;
		do
		{
			empID = getEmpID();
			error = !emp.setEmpID(empID);
			if(error) JOptionPane.showMessageDialog(null, "Error! Invalid employee ID entered!");
		}while(error);

		//asks the user if they would like to use the standard payrate
		boolean useStandardPayRate = getUseStandardPayRate();
 
		//used to get, set, and validate hourly pay rate if they chose not to use the standard payrate
		double hrPayRate;
		if(!useStandardPayRate)
		{
			do
			{	
				hrPayRate = getHrPayRate();
				error = !emp.setHrPayRate(hrPayRate);
				if(error) JOptionPane.showMessageDialog(null, "Error! Invalid pay rate entered!");
			}while(error);
		}

		//Used to get, set, and validate amount of hours worked
		double hrWorked;
		do
		{
			hrWorked = getHrWorked();
			error = !emp.setHrWorked(hrWorked);
			if(error) JOptionPane.showMessageDialog(null, "Error! Invalid hours worked entered!");
		}while(error);

		//Used to get, set, and validate employoee's senior status.
		String seniorEmp;
		do
		{
			seniorEmp = getSeniorEmp();
			error = !emp.setSeniorEmp(seniorEmp);
			if(error) JOptionPane.showMessageDialog(null, "Error! Invalid senior employee status entered!");
		}while(error);

		//used to calculate employee's paycheck amount
		emp.setEmpPaycheck();

		//used to display a summery of the employee
		displayEmpSummery(emp);
		return emp;
	}

	//Methods for getting user inputs
	private static String getName()
	{
		String name;
		name = JOptionPane.showInputDialog(null, "Enter employee's name: ");
		return name;
	}

	private static String getEmpID()
	{
		String empID;
		empID = JOptionPane.showInputDialog(null, "Enter employee ID: ");
		return empID;
	}

	//method for asking user if they would like to use the standard payrate
	private static boolean getUseStandardPayRate()
	{
		boolean useStandardPayRate = false;
		boolean error = false;
		String userInput;
		do
		{
			userInput = JOptionPane.showInputDialog("Would you like to use the standard pay rate? 'Y' or 'N'");
			if(userInput.equalsIgnoreCase("Y"))
			{
				useStandardPayRate = true;
				error = false;
			}
			else if(userInput.equalsIgnoreCase("N"))
			{
				useStandardPayRate = false;
				error = false;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error! Invalid entry!");
				error = true;
			}
		}while(error);
		return useStandardPayRate;
	}

	private static double getHrPayRate()
	{
		Double hrPayRate;
		try
		{
			hrPayRate = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter employee's hourly pay rate: "));
		}
		catch(NumberFormatException e)
		{
			hrPayRate = -1.0;
		}
		return hrPayRate;
	}

	private static double getHrWorked()
	{
		double hrWorked;
		try
		{
			hrWorked = Double.parseDouble(JOptionPane.showInputDialog("Enter amount of hours worked: "));
		}
		catch(NumberFormatException e)
		{
			hrWorked = -1.0;
		}
		return hrWorked;
	}

	private static String getSeniorEmp()
	{
		String seniorEmp;
		seniorEmp = JOptionPane.showInputDialog("Is the employee a senior employee? \n(Y or N)");
		return seniorEmp;
	}

	//method to ask if the user would like to enter any more emplyees
	private static boolean setMoreEmployees()
	{
		boolean error;
		String moreEmployees;
		do
		{
			moreEmployees = JOptionPane.showInputDialog("Would you like to enter anymore employees?\n('Y' or 'N')");
			error = (!moreEmployees.equals("Y") && !moreEmployees.equals("N"));
			if(error) JOptionPane.showMessageDialog(null, "Error! Invalid entry! Enter 'Y' or 'N'.");
		}while(error);
		if(moreEmployees.equalsIgnoreCase("Y")) return true;
		return false;
	}

	//method to get the summery for the employees
	private static void displayEmpSummery(Employee emp)
	{
		JOptionPane.showMessageDialog(null, emp.toString());
	}

	//method to display the payroll summery
	private static void payrollSummery(int empCount, double totalPayout)
	{
		JOptionPane.showMessageDialog(null, "Payroll Summery\n\n"
		+"Employee Count: " + empCount
		+"\nTotal PayOut: " + String.format("$%.2f",totalPayout));
	}
}