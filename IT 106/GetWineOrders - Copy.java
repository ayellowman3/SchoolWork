import javax.swing.JOptionPane;

public class GetWineOrders
{
   public static void main(String[] args)
   {  
      int[][] wineOrderCount = new int[4][3];
      
      String[][] wineList = new String[][] {
      {"Dry", "Off Dry", "Sweet"},
      {"Apple", "Lemon", "Vanilla"},
      {"Lime", "Lemongrass", "Coconut"},
      {"Plum", "Black Cherry", "Chocolate"}
      };
      
      double[][] winePrice = new double[][] {
      {4.50, 4.00, 5.00},
      {6.00, 5.50, 6.00},
      {4.50, 6.50, 7.00},
      {5.00, 7.50, 6.00}
      };
      double totalCost = 0.0;
      String[] wineType = new String[] {"Riesling", "Chardonnay", "Sauvignon Blanc", "Merlot", "Sparkling Water"};
      int[] wineTypeCount = new int[5];
      
      boolean isFinishedOrders = false;
      int customerCount = 0;
      
      while(!isFinishedOrders && customerCount < 16)
      {
         boolean isFinishedCustomerOrders = false;
         int drinkCount = 0;
         int wineTypeOrder = 0;
         int wineTypeFlavor = 0;
         do
         {
            wineTypeOrder = getWineTypeOrder();
            if(wineTypeOrder == 5)
            {
               totalCost += 1.0;
            }
            else
            {
               wineTypeFlavor = getWineTypeFlavor(wineTypeOrder);
            }
            drinkCount ++;
            if(drinkCount < 3)
            {
               isFinishedCustomerOrders = getMoreWine();
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Customer has reached maxed number of drinks! Next Customer!");
            }
         }while(drinkCount < 3 && !isFinishedCustomerOrders);
         isFinishedOrders = getMoreOrders();
         
      
      }
   }
   public static int getWineTypeOrder()
   {  
      int ans;
      do
      {
         ans = Integer.parseInt(JOptionPane.showInputDialog("Please Select A Wine Type:\n[1] Riesling\n[2] Chardonnay\n[3] Sauvignon Blanc\n[4] Merlot\n[5] Sparkling Water"));
      }while(ans != 1 && ans != 2 && ans != 3 && ans != 4 && ans != 5);
      return ans;
   }
   public static boolean getMoreWine()
   {
      String ans = "";
      do
      {
         ans = JOptionPane.showInputDialog("Would you like to order more wine?\n(Y = yes or N = no)");
      }while(ans == "Y" || ans == "N");
      if(ans.equals("N"))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public static boolean getMoreOrders()
   {
      String ans = "";
      do
      {
         ans = JOptionPane.showInputDialog("Would you like to add another customer's order?\n(Y = yes or N = no)");
      }while(ans == "Y" || ans == "N");
      if(ans.equals("N"))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public static int getWineTypeFlavor(int type)
   {  
      String message = "Please Select A Wine Flavor:";
      if(type == 1)
      {
      message += "\n[1]Dry\n[2]Off Dry\n[3]Sweet";
      }
      if(type == 2)
      {
      message += "\n[1]Apple\n[2]Lemon\n[3]Vanilla";
      }
      if(type == 3)
      {
      message += "\n[1]Lime\n[2]Lemongrass\n[3]Coconut";
      }
      if(type == 4)
      {
      message += "\n[1]Plum\n[2]Black Cherry\n[3]Chocolate";
      }
      int ans = 0;
      do
      {
         ans = Integer.parseInt(JOptionPane.showInputDialog(message));
      }while(ans != 1 || ans != 2 || ans != 3);
      return ans;
   }
   
   
}