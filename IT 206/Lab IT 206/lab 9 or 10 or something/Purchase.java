/*
 * In this file, complete tasks as identified below, only inside of the commented areas
 */

import javax.swing.JOptionPane;
public class Purchase {
   public static void main(String[] args) {
      final int MAX_ITEMS = 3;
      
      // BEGIN: Create an array of type Sellable, called items
      Sellable[] items = new Sellable[MAX_ITEMS];
      // END

      populateItems(items);
      displayReceipt(items);
   }
   
   private static void populateItems(Sellable[] items) {
   
      // BEGIN: In the items array, hardcode the creation of one book, one DVD, and one consulting service
      items[0] = new Book("Under the Dome", 9.95);
      items[1] = new DVD("Casablanca", 14.99, "Drama");
      items[2] = new ConsultingService("DVD Repair", 100.00, 2);
      // END
   }
   
   private static void displayReceipt(Sellable[] items) {
      String receipt = "***Bob's Retail Store***\n\n";
      double total = 0.0;
   
      // BEGIN: Loop through all of the items in the array of type Sellable to calculate the total, and print out the item's cost
      //        and a String representation of the item for each item
      for(int i = 0; i<3; i++){
         receipt+=items[i].toString() + "\nCost: " + items[i].getCost() + "\n";
         total+=items[i].getCost();
      }

      // END
      
      // BEGIN: Create one line that will calculate the sales tax based on the total (Hint: Remember SALES_TAX is stored in the interface)
      double salesTax = total*Sellable.SALES_TAX;
      // END
      
      receipt += "Total: " + String.format("$%.2f", total) + "\n";
      receipt += "Sales Tax: " + String.format("$%.2f", salesTax) + "\n";
      receipt += "Grand Total: " + String.format("$%.2f", total + salesTax) + "\n";      
      JOptionPane.showMessageDialog(null, receipt);
   }
}