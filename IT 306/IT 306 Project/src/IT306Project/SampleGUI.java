import javax.swing.JOptionPane;

public class SampleGUI{
   public static void main(String[] args) {
      String[] gui = new String[100];
      //login with empty users
      gui[0] = "Welcome!\n\n" +
             "No users currently exist!";
      gui[1] = "Enter admin's first name: ";
      gui[2] = "Enter admin's last name: ";
      gui[3] = "Enter admin's username: ";
      gui[4] = "Enter admin's password: ";
      gui[5] = "Enter admin's email: ";
      gui[6] = "Enter admin's address: ";

      //login with users
      gui[7] = "Welcome!\n\n" +
             "[1] Login\n" +
             "[2] Create new user\n" +
             "[0] Exit\n";

      //login
      gui[8] = "Enter username";
      gui[9] = "Enter password";

      //login with invalid password
      gui[10] = "Error! Invalid username or password entered!";

      //login as an user
      gui[11] = "[1] Search for Resource\n" +
                 "[0] Exit";

      //search for resource
      gui[12] = "[1] Sort\n" +
                 "[2] Filter\n" +
                 "[0] Exit\n\n" +
                 "Book 1\nBook2\nVideo 1";

      //set a sort by
      gui[13] = "Sort by:\n" +
                 "[1] ResourceID\n" +
                 "[2] Author\n" +
                 "[3] Category\n" +
                 "[0] Cancel";
      //set a filter
      gui[14] = "Filter by:\n" +
                 "[1] ResourceID\n" +
                 "[2] Author\n" +
                 "[3] Category\n" +
                 "[0] Cancel";;

      //login as an employee
      gui[15] = "[1] Search for Resource\n"+
                 "[2] Checkout\n"+
                 "[3] Return\n"+
                 "[4] Update Resource\n"+
                 "[5] Add Resource\n"+
                 "[0] Exit";

      //checkout
      gui[16] = "Checkout\n\n" +
                 "Enter User ID:";
      gui[17] = "Checkout\n\n" +
                 "Enter Resource ID:";
      gui[18] = "Checkout Successful!";
      gui[19] = "Error user already as material checked out";

      //return
      gui[20] = "Return:\n" +
                 "Enter Resource ID:";
      gui[21] = "Return Successful!";

      //update resource
      gui[22] = "Which resource would you like to update\n\n" +
                 "[1] Book1\n" +
                 "[2] Book2\n" +
                 "[3] Book3\n" +
                 "[0] Exit";

      gui[23] = "What would you like to update?\n\n" +
                 "[1] Book Title\n" +
                 "[2] Book Author\n" +
                 "[3] Book Genre\n" +
                 "[0] Exit";

      //Add resource

      gui[24] = "What type of resource is it?\n\n"+
                 "[1] Book\n" +
                 "[2] VHS";
      gui[25] = "What is the name of the resource? ";
      gui[26] = "What genre is the resource?";
      gui[27] = "Who is the author?";
      gui[28] = "What year was it published?";
      //login as an admin
      gui[29] = "[1] Search for Resource\n"+
                 "[2] Checkout\n"+
                 "[3] Return\n"+
                 "[4] Update Resource\n"+
                 "[5] Add Resource\n"+
                 "[6] Add Employee\n"+
                 "[7] Modify Employee\n"+
                 "[8] Delete Employee\n"+
                 "[0] Exit";

      //add an employee
      gui[30] = "Enter Employee's first name: ";
      gui[31] = "Enter Employee's last name: ";
      gui[32] = "Enter Employee's username: ";
      gui[33] = "Enter Employee's password: ";
      gui[34] = "Enter Employee's email: ";
      gui[35] = "Enter Employee's address: ";

      //modify employee
      gui[36] = "Which Employee would you like to modify?\n\n" +
                 "[1] Employee1\n"+
                 "[2] Employee2\n"+
                 "[3] Employee3\n"+
                 "[0] Exit";
      gui[37] = "What would you like to modify?\n\n" +
                 "[1] first name\n" +
                 "[2] last name\n" +
                 "[3] username\n" +
                 "[4] password\n" +
                 "[5] email\n" +
                 "[6] address\n" +
                 "[0] Exit\n";

      //delete employee
      gui[38] = "Which Employee would you like to delete?\n\n" +
                 "[1] Employee1\n"+
                 "[2] Employee2\n"+
                 "[3] Employee3\n"+
                 "[0] Exit";
      gui[39] = "Employee Deleted!";
      gui[40] = "Employee can not be deleted!\nThey have material checked out!";

      //create new user
      gui[41] = "Enter user's first name: ";
      gui[42] = "Enter user's last name: ";
      gui[43] = "Enter user's username: ";
      gui[44] = "Enter user's password: ";
      gui[45] = "Enter user's email: ";
      gui[46] = "Enter user's address: ";

      int size = 47;
      printer(gui, size);
   }

   public static void printer(String[] gui, int num){
      for(int i = 0; i < num; i++){
         JOptionPane.showMessageDialog(null, gui[i]);
      }
   }
}
