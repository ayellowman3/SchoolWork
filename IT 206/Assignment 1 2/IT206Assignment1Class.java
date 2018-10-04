import javax.swing.JOptionPane;

public class IT206Assignment1Class
{
   String name;
   String employeeID;
   String hourlyPayRateStr;
   double hourlyPayRate;
   double hoursWorked;
   boolean seniorEmployee;
   double paycheckAmount;
   public void askName()
   {
      do
      {
         name = JOptionPane.showInputDialog("Enter Employee's Name:");
         if(name.equals(""))JOptionPane.showMessageDialog(null, "Error! You must enter a name");
      }while(name.equals(""));
   }
   public void askEmployeeID()
   {
      do
      {
         employeeID = JOptionPane.showInputDialog("Enter " + name+"'s employee ID");
         if(employeeID.equals(""))
         {
            JOptionPane.showMessageDialog(null, "Error! You must enter an employee ID");
         }
      }while(employeeID.equals(""));
   }
   public void askHourlyPayRate()
   {
      boolean error;
      do
      {
         error = false;
         hourlyPayRateStr = JOptionPane.showInputDialog("Enter Pay Rate: ");
         if(hourlyPayRateStr.equals(""))hourlyPayRate = 12.63;
         else
         {
            try
            {
               hourlyPayRate = Double.parseDouble(hourlyPayRateStr);
            }
            catch(NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null, "Error! Pay rate entered is invalid");
               error = true;
            }
         }
      }while(error);
   }
   public void askHoursWorked()
   {
      boolean error;
      do
      {
         error = false;
         try
         {
            hoursWorked = Double.parseDouble(JOptionPane.showInputDialog("Enter hours worked"));
         }
         catch(NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Error! Hours worked entered is invalid!");
            error = true;
         }
      }while(error);
   }
   public void askSeniorEmployee()
   {
      boolean error;
      do
      {
         error = false;
         String userinput = JOptionPane.showInputDialog("Does the employee have senior status?");
         if(userinput.equalsIgnoreCase("yes"))seniorEmployee = true;
         else if(userinput.equalsIgnoreCase("no"))seniorEmployee = false;
         else
         {
            error = true;
            JOptionPane.showMessageDialog(null, "Error! Invalid entry! Please enter yes or no");
         }
      }while(error);
   }
   public void calcPaycheckAmount()
   {
      paycheckAmount = hourlyPayRate * hoursWorked;
      if(seniorEmployee)paycheckAmount += 206.26;
   }
   public double getPaycheckAmount()
   {
      return paycheckAmount;
   }
   public String getSeniorEmployeeStatus(boolean s)
   {
      String message;
      if(s == true)message = "Yes";
      else message = "No";
      return message;
   }
   public void getMessage()
   {
      String message = "Employee Name: " + name
      + "\nEmployee's ID number: " + employeeID
      + "\nHourly Pay Rate: " + hourlyPayRate
      + "\nNumber of Hours Worked: " + hoursWorked
      + "\nSenior Employee Status: " + getSeniorEmployeeStatus(seniorEmployee)
      + "\nPaycheck Amount: " + paycheckAmount;
      JOptionPane.showMessageDialog(null, message);
   }
   public boolean askMoreEmployees()
   {
      String userInput;
      boolean isFinished = false;
      boolean error;
      do
      {
         error = false;
         userInput = JOptionPane.showInputDialog("Would you like to enter anymore employees?");
         if(userInput.equalsIgnoreCase("yes"))isFinished = false;
         else if(userInput.equalsIgnoreCase("no"))isFinished = true;
         else
         {
            error = true;
            JOptionPane.showMessageDialog(null, "Error! Please enter yes or no");
         }
      }while(error);   
      return isFinished;
   }
}