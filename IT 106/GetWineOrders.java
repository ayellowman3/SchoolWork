/**
   Name: George Huang
   Date: 12/12/2015
   Course/Section: IT 106.002
   Assignment: Programming Assignment 10
   
   Description:
   
   This program is used to take a customer's order at a local wine tasting.
   The wine tasting is limited to 16 customer's and a maximum order amount
   or 3 drinks per customer. Each customer must order at least one drink.
   The customer is prompted to select one of 5 types or drinks(Riesling, 
   Chardonnay, Sauvignon Blanc, Merlot, Sparkling Water), and then prompted
   to select a flavor within each wine selection. After each selection is made
   the total calculated, and each selection is stored.

   There are 4 categories for wine and 3 flavors within each wine selection and
   a choice of sparkling water making a total of 13 options.
   
   After one of the following conditions are met, then the program will proceed
   to analyze the stored data to return the result.
   -no more customers
   -number of customers reaches 16
   
   After all customers are finished ordering
   
   The program will then calculate the total amount of money collected, the most
   ordered wine type, and the most ordered wine flavor.

**/

import javax.swing.JOptionPane;

public class GetWineOrders
{
   public static void main(String[] args)
   {  
      int[][] wineOrderCount = new int[4][3];
      //empty 2d array to store total amount of wine flavor combination
      String[][] wineList = createWineList();
      //array with the flavor of wines
      double[][] winePrice = createWinePriceList();
      //create a 2d array with wine prices
      double totalCost = 0.0;
      String[] wineType = createWineTypeList();
      //create an array with wine flavors
      int[] wineTypeCount = new int[5];
      //empty array to count total wine type ordered
      boolean isFinishedOrders = false;
      //conditional for while statement to get more orders
      int customerCount = 0;
      //conditional for wile statement to get more orders. max 16 customers
      isFinishedOrders = getMoreOrders("Would you like to place an order:\n(Y = yes or N = no)");
      //check if they would like to place an order in the first place
      while(!isFinishedOrders)
      {
         boolean isFinishedCustomerOrders = false;
         int drinkCount = 0;
         //count drinks ordered by customer. max 3
         int wineTypeOrder = 0;
         //stored wine type ordered
         int wineTypeFlavor = 0;
         //stored wine flavor ordered
         int wineTypeIndex = 0;
         //index of wine type ordered
         int wineFlavorIndex = 0;
         //index of wine flavor ordered
         
         do//takes a customers order
         {
            wineTypeOrder = getWineTypeOrder();
            wineTypeIndex = wineTypeOrder - 1;
            wineTypeCount[wineTypeIndex] += 1;
            if(wineTypeOrder == 5)
            //if customer orders water
            {
               totalCost += 1.0;
            }
            else
            //if customer orders wine
            {  
               wineTypeFlavor = getWineTypeFlavor(wineTypeOrder);
               //gets type selection from customer
               wineFlavorIndex = wineTypeFlavor - 1;
               //convers the type selection to index
               totalCost += winePrice[wineTypeIndex][wineFlavorIndex];
               //adds to total cost
               wineOrderCount[wineTypeIndex][wineFlavorIndex] += 1;
               //add to count for wine type/flavor
            }
            drinkCount ++;
            if(drinkCount < 3)
            //when customer hasn't ordered a third drink yet
            {
               isFinishedCustomerOrders = getMoreWine("Would you like to order more wine?\n(Y = yes or N = no)");
            }
            else
            //when customer ordered his/her third drink
            {
               JOptionPane.showMessageDialog(null, "Customer has reached maxed number of drinks! Next Customer!");
            }
         }while(drinkCount < 3 && !isFinishedCustomerOrders);
         customerCount++;
         if(customerCount < 16)
         {
            isFinishedOrders = getMoreOrders("Would you like to add another order?\n(Y = yes or N = no)");
            //check if there are any more customers
         }
         else
         //max customers reached
         {
            JOptionPane.showMessageDialog(null, "Can't take any more orders. Reached maximum number of customers");
            isFinishedOrders = true;
         }
      }
      int mostOrderedWineTypeIndex = getMostOrderedWineType(wineTypeCount);
      //gets the most ordered wine type
      int[] mostOrderedArray = getMost(wineOrderCount);
      //gets the most ordered wine flavor
      String answer = getResultMessage(totalCost, wineType[mostOrderedWineTypeIndex], wineType[mostOrderedArray[0]], wineList[mostOrderedArray[0]][mostOrderedArray[1]]);
      //Prints return message
      JOptionPane.showMessageDialog(null, answer);
   }
   
   //creates 2d array of Wine List
   public static String[][] createWineList()
      {
         String[][] ans = new String[][]
         {
         {"Dry", "Off Dry", "Sweet"},
         {"Apple", "Lemon", "Vanilla"},
         {"Lime", "Lemongrass", "Coconut"},
         {"Plum", "Black Cherry", "Chocolate"}
         };
         return ans;
      }
      
   //creates 2d array of Wine Prices
   public static double[][] createWinePriceList()
   {
      double[][] ans = new double[][]
      {
      {4.50, 4.00, 5.00},
      {6.00, 5.50, 6.00},
      {4.50, 6.50, 7.00},
      {5.00, 7.50, 6.00}
      };
      return ans;
   }
   
   //creates array of wine types
   public static String[] createWineTypeList()
   {
      String[] ans = new String[] {"Riesling", "Chardonnay", "Sauvignon Blanc", "Merlot", "Sparkling Water"};
      return ans;
   }
   
   //gets the wine type selection from customers
   public static int getWineTypeOrder()
   {  
      int ans;
      do
      {
         ans = Integer.parseInt(JOptionPane.showInputDialog("Please Select A Wine Type:\n(Use 1-5 to make selection)\n[1] Riesling\n[2] Chardonnay\n[3] Sauvignon Blanc\n[4] Merlot\n[5] Sparkling Water"));
      }while(ans != 1 && ans != 2 && ans != 3 && ans != 4 && ans != 5);
      return ans;
   }
   
   //asked if customer would like to order more wine
   public static boolean getMoreWine(String message)
   {
      String ans = "";
      do
      {
         ans = JOptionPane.showInputDialog(message);
      }while(!ans.equals("Y") && !ans.equals("N"));
      if(ans.equals("N"))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   //asks if there are any more customers
   public static boolean getMoreOrders(String message)
   {
      String ans = "";
      do
      {
         ans = JOptionPane.showInputDialog(message);
      }while(!ans.equals("Y") && !ans.equals("N"));
      if(ans.equals("N"))
      {
         return true;
      }
      else if(ans.equals("Y"));
      {
         return false;
      }
   }
   
   //get customer selection for wine flavor
   public static int getWineTypeFlavor(int type)
   {  
      String message = "Please Select A Wine Flavor:\n(Use 1-3 to make selection)";
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
      }while(ans != 1 && ans != 2 && ans != 3);
      return ans;
   }
   
   //gets the most ordered wine flavor
   public static int[] getMost(int[][] wineOrderCount)
   {  
      int[] ans = new int[2];
      int mostOrdered = 0;
      for(int i = 0; i < wineOrderCount.length; i++)
      {
         for(int j = 0; j < wineOrderCount[0].length; j++)
         {
            if(wineOrderCount[i][j] > mostOrdered)
            {
               mostOrdered = wineOrderCount[i][j];
               ans[0] = i;
               ans[1] = j;
            }
         }
      }
      return ans;
   }
   
   //gets the most ordered wine type
   public  static int getMostOrderedWineType(int[] wineTypeCount)
   {
      int ans = 0;
      int index = 0;
      for(int i = 0; i < (wineTypeCount.length - 1); i++)
      {
         if(wineTypeCount[i] > ans)
         {
            ans = wineTypeCount[i];
            index = i;
         }
      }
      return(index);
   }
   
   //gets the return message
   public static String getResultMessage(double cost, String wineType, String wineType2, String wineFlavor)
   {
      String answer = "Sales of the Night:\n\n";
      answer += "Total amount of Money Collected: $" + cost + "0";
      answer += "\n\nMost ordered wine type: " + wineType;
      answer += "\n\nMost ordered wine type/flavor combination: " + wineType2 + ", " + wineFlavor;
      return answer;
   }
}