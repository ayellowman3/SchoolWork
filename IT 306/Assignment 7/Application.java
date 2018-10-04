/*1- (40 points) For this exercise, use the User.java DDC provided in the lecture slides. Create an Application class. Inside the main method, create user objects on demand, and store them in an expandable data structure that supports the following functionalities. Note that phone number is a unique field for each user object.
a. Search in O(1).
b. Not allowing duplicates.
c. Iterator functionality.
Then, implement the following static methods in the Application class:
Ø Create the static method “Search” to perform searching a user in O(1) based on their phonenumber, on the data structure in O(1) time.
Ø Create a static method to print all the users’ information using an iterator.
Ø Create a static method to remove a user object if only it exists in the data structure.
Ø Submit your Application.java file.
  */
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import javax.swing.JOptionPane;
public class Application{
    public static void main(String[] args){
        Map<String,User> accounts = new Hashtable<String,User>();
        menu(accounts);
	}

    public static void menu(Map<String,User> accounts){
        int option = 0;
        do{
            option = getMenuOption();
            switch(option){
                case 1:
                    addUser(accounts);
                    break;
                case 2:
                    searchUser(accounts);
                    break;
                case 3:
                    removeUser(accounts);
                    break;
                case 4:
                    printAllUsers(accounts);
                    break;
                case 5:
                    break;

            }
        }while(option != 5);
    }

    public static int getMenuOption(){
        int option;
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(null,"Select option below"
                + "\n1. Add a User"
                + "\n2. Search a User"
                + "\n3. Remove a User"
                + "\n4. Display All users"
                + "\n5. Quit"));
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Error! invalid input");
            option = getMenuOption();
            return option;
        }
        if(option > 5 || option < 1){
            JOptionPane.showMessageDialog(null,"Error! invalid input");
            option = getMenuOption();
            return option;
        }
        return option;

    }

	public static void addUser(Map<String,User> accounts){
		User newUser = new User(JOptionPane.showInputDialog("Enter name:"));
		boolean validPhone = false;
		while(!newUser.setPhoneNumber(JOptionPane.showInputDialog("Enter 10 digit phone number."))){
            JOptionPane.showMessageDialog(null, "Error! Invalid phone number");
		}
        if(accounts.containsKey(newUser.getPhoneNumber())){
            JOptionPane.showMessageDialog(null, "Entry Exist, try again");
        }
        else{
            accounts.put(newUser.getPhoneNumber(), newUser);
        }
	}

	public static void searchUser(Map<String, User> accounts){
        String phoneNumber;
        if(accounts.containsKey(phoneNumber = JOptionPane.showInputDialog(null,"Search by phone number: "))){
			JOptionPane.showMessageDialog(null,accounts.get(phoneNumber));
		}else{
			JOptionPane.showMessageDialog(null, "User does not exist.");
		}
	}

	public static void printAllUsers(Map<String,User> accounts){
		Iterator<Entry<String, User>> it = accounts.entrySet().iterator();
		String message = "user list\n";
		while(it.hasNext()){
			message += "\n" + ((Entry<String,User>)it.next()).getValue().toString();
		}
		JOptionPane.showMessageDialog(null, message);
	}

	public static void removeUser(Map<String, User> accounts){
        String phoneNumber;
        if(accounts.containsKey(phoneNumber = JOptionPane.showInputDialog("Remove by Phone number: ")))
			accounts.remove(phoneNumber);
		else{
			JOptionPane.showMessageDialog(null,"Phone number does not exist");
        }
    }
}
