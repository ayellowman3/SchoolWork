import javax.swing.JOptionPane;
import java.util.ArrayList;

public class test1{
   private double payRate = -1;
   public void askPayRate(String input)
   {
      do
      {
         try
         {
            payRate = Double.parseDouble(JOptionPane.showInputDialog(input));
         }
         catch(NumberFormatException e)
         {
            payRate = -1;
         }
         if(payRate < 0)
         {
            JOptionPane.showMessageDialog(null, "Error! Please enter a valid number");
         }
         
      }while(payRate < 0);
   }
   public double getPayRate()
   {
      return payRate;
   }
}