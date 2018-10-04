import javax.swing.JOptionPane;

public class FinancialAid 
{
   public static void main(String[] args) 
   {
      final int NUM_MIN_DEPENDENTS = 0;
      final int NUM_MAX_DEPENDENTS = 9;
      
      /* #1: Create code that will call the method you created in #3 below to get the number of dependents,
       *     factoring in the minimum and maximum number of dependents allowed
       */  
      int num_Dependents = getNumDep(NUM_MIN_DEPENDENTS, NUM_MAX_DEPENDENTS);
      
      
      /* #2: Create code that will call the method you created in #4 below to calculate the amount of aid
       *     that will be earned based on the number of dependents gathered.
       */
      int aid = getFinancialAid(num_Dependents);

      printFinancialAid(aid);
   }
   
   /* #3: Create a method to get and return the number of dependents, factoring in
    *     the minimum and maximum number of dependents allowed
    */
   public static int getNumDep(int min, int max)
      {
         int num_Dep;
         do
         {
            num_Dep = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Dependents:"));
            if (num_Dep < min || num_Dep > max)
            {
               JOptionPane.showMessageDialog(null, "Invalid amount of dependents entered");
            }
         }while(num_Dep < min || num_Dep > max);
         return num_Dep;
      }
      
   /* #4: Create a method to calculate and return the amount of financial aid that will be earned
    *      based on the number of dependents gathered
    */
      public static int getFinancialAid(int num_Dep)
      {
         switch (num_Dep)
         {
            case 2: return 1500*2;
            case 3: return 2500*3;
            case 4: return 3000*4;
            default: return 0;
         }
      }
   
   public static void printFinancialAid(double aid) {
      JOptionPane.showMessageDialog(null, "The amount of financial aid your family is eligible for is: $" + String.format("%.2f", aid));
   }
}