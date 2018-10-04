import javax.swing.JOptionPane;

public class IT206Assignment1ClassUpdate
{
   private String name;
   private String employeeID;
   private String hourlyPayRateStr;
   private double hourlyPayRate;
   final private double standardPayRate = 12.63;
   private double hoursWorked;
   private boolean seniorEmployee;
   private double paycheckAmount;
   
   public void getUserInput()
   {
      this.getEmployeeSummery();
      this.getName();
      this.getEmployeeID();
      this.getHourlyPayRate();
      this.getHoursWorked();
      this.getSeniorEmployeeStatus();
      this.calcPaycheckAmount();
      this.getEmployeeSummery();
   }
   private void getName()
   {
      do
      {
         name = JOptionPane.showInputDialog("Enter Employee's Name:");
         if(name.equals(""))JOptionPane.showMessageDialog(null, "Error! You must enter a name");
      }while(name.equals(""));
   }
   private void getEmployeeID()
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
   private void getHourlyPayRate()
   {
      boolean error;
      do
      {
         error = false;
         hourlyPayRateStr = JOptionPane.showInputDialog("Enter " + name + "'s Pay Rate: ");
         if(hourlyPayRateStr.equals(""))hourlyPayRate = standardPayRate;
         else
         {
            try
            {
               hourlyPayRate = Double.parseDouble(hourlyPayRateStr);
            }
            catch(NumberFormatException e)
            {
               error = true;
            }
         }
         if(hourlyPayRate < 0) error = true;
         if(error == true) JOptionPane.showMessageDialog(null, "Error! Pay rate entered is invalid!");
      }while(error);
   }
   private void getHoursWorked()
   {
      boolean error;
      do
      {
         error = false;
         try
         {
            hoursWorked = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of hours " + name + " worked"));
         }
         catch(NumberFormatException e)
         {
            error = true;
         }
         if(hoursWorked < 0) error = true;
         if(error == true) JOptionPane.showMessageDialog(null, "Error! Hours worked entered is invalid!");
      }while(error);
   }
   private void getSeniorEmployeeStatus()
   {
      boolean error;
      do
      {
         error = false;
         String userinput = JOptionPane.showInputDialog("Does " + name + " have senior status?\n(yes or no)");
         if(userinput.equalsIgnoreCase("yes"))seniorEmployee = true;
         else if(userinput.equalsIgnoreCase("no"))seniorEmployee = false;
         else
         {
            error = true;
            JOptionPane.showMessageDialog(null, "Error! Invalid entry! Please enter yes or no");
         }
      }while(error);
   
   }
   private void calcPaycheckAmount()
   {
      paycheckAmount = hourlyPayRate * hoursWorked;
      if(seniorEmployee)paycheckAmount += 206.26;
   }
   private String getSeniorEmployeeStatus(boolean s)
   {
      String message;
      if(s == true)message = "Yes";
      else message = "No";
      return message;
   }
   private void getEmployeeSummery()
   {
      String message = "--------Employee Summery--------\n--------------------------------------------\n"
         
         + "Employee Name: " + name
         + "\nEmployee's ID number: " + employeeID
         + "\nHourly Pay Rate: " + hourlyPayRate
         + "\nNumber of Hours Worked: " + hoursWorked
         + "\nSenior Employee Status: " + getSeniorEmployeeStatus(seniorEmployee)
         + "\nPaycheck Amount: " + String.format("%.2f",paycheckAmount);
      JOptionPane.showMessageDialog(null, message);
   }
   public double getPaycheckAmount()
   {
      return paycheckAmount;
   }
   
   public boolean moreInput()
   {
      boolean ans = false;
      boolean error = false;
      do{
         error = false;
         String input = JOptionPane.showInputDialog("Would you like to enter any more employees?\n(yes or no)");
         if(input.equalsIgnoreCase("yes")) ans = true;
         else if(input.equalsIgnoreCase("no")) ans = false;
         else
         {
            JOptionPane.showMessageDialog(null, "Error! Invalid entry! Please enter yes or no");
            error = true;
         }
      }while(error);
      return ans;
   }
}