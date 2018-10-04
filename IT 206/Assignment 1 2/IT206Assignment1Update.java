import javax.swing.JOptionPane;

public class IT206Assignment1Update
{
   public static void main(String[] args)
   {
      IT206Assignment1ClassUpdate c = new IT206Assignment1ClassUpdate();
      int count = 0;
      double money = 0.0;
      do
      {
         c.getUserInput();
         count++;
         money += c.getPaycheckAmount();
      }while(c.moreInput());
      JOptionPane.showMessageDialog(null,
         "----------Payroll Summery----------"
         +"\n---------------------------------------------"
         +"\nNumber of Employees: " + count
         + "\nTotal Paycheck Amount: " + String.format("%.2f",money));
      JOptionPane.showMessageDialog(null, "Thank You for using Payroll Deluxe!\nHave a nice Day!");
   }
   
}