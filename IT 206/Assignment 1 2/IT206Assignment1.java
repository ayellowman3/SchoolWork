import javax.swing.JOptionPane;

public class IT206Assignment1
{
   public static void main(String[] args)
   {
      double[] countAndMoney = getUserInput();
      summeryMessage(countAndMoney);
   }
   public static double[] getUserInput()
   {
      boolean isFinished = false;
      double[] countAndMoney = {0,0};
      do
      {
         IT206Assignment1Class c = new IT206Assignment1Class();
         c.askName();
         c.askEmployeeID();
         c.askHourlyPayRate();
         c.askHoursWorked();
         c.askSeniorEmployee();
         c.calcPaycheckAmount();
         c.getMessage();
         countAndMoney[0]++;
         countAndMoney[1] += c.getPaycheckAmount();   
         isFinished = c.askMoreEmployees();
      }while(!isFinished);
      return countAndMoney;
   }
   public static void summeryMessage(double[] i)
   {
      String message =
      "Total amount of employees entered: " + i[0]
      + "\n Total amount of money: " + i[1];
      JOptionPane.showMessageDialog(null, message);
   }
}