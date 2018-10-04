/*
George Huang
11/15/16
IT 206-001
Assignment 8

Employee Vacation is a program that allows Monica to track the vacation
Vacations for Her employee and their families. This Program will allow
her to track who's going on vacation, where the vacation is, the number
of people going, total cost, and insurance of ski lessons depending on
where they are going. The program also allows the deletion of vacations
and display a summary of beach vacations, ski vacations, and overall
total cost summary.

input
Menu choice
1: Add Vacation
2: Delete Vacation
3: Print Beach House Vacation Summary
4: Print Ski Vacation Summary
5: Print Vacation Summary
6: Quit

Variable: Name
type: String
description: Employee name

Variable: Location
type: String
description: Vacation location 

Variable: Zipcode
type: String
description: zipcode

Variable: Number of family Members
type: int
description: number of family members going on vacation

Variable: Hurricane Insurance
type: boolean
description: if hurricane insurance is being purchased

Variable: num stars
type:
description:

Variable: SkiResortPeople
type:
description:

Variable: Lessons
type:
description:

output:
vacation information
cost of each vacation
total cost of vacation
*/
import javax.swing.JOptionPane;

public class EmployeeVacation{
   public static void main(String[] args){
      Vacation[] vaca = new Vacation[Vacation.MAX_NUM_VACATION];
      int menuOption;
   	//Prompt for menu selection until the user enters 6 to quit
      do{
         menuOption = getInt("Select Menu Option\n\n[1]Add Vacation\n[2]Remove Vacation\n[3]Print All Beach House Vacation Bills\n[4]Print All Ski Resort Vacation Bills\n[5]Print Vacation Summary\n[6]Quit\n", "Error! Selected Menu Option is Invalid!", 1, 6);
         switch(menuOption){
            case 1:
               addVacation(vaca, Vacation.getVacationCount());
               break;
            case 2:
               removeVacation(vaca, Vacation.getVacationCount());
               break;
            case 3:
               printBeachVacationBills(vaca, Vacation.getVacationCount());
               break;
            case 4:
               printSkiResortBills(vaca, Vacation.getVacationCount());
               break;
            case 5:
               printVacationSummary(vaca, Vacation.getVacationCount());
               break;
            case 6:
               break;
            default:
               JOptionPane.showMessageDialog(null, "this should not appear");
               break;
         }
      }while(menuOption!=6);
   }
	//adds vacation
   public static void addVacation(Vacation[] vaca, int count){
      Object[] options = {"Beach House Vacation", "Ski Resort Vacation"};
      if(count < Vacation.MAX_NUM_VACATION){
      	//prompts for vacation type
         int vacationType = JOptionPane.showOptionDialog(null, "What type of Vacation would you like to go on?", "Create Vacation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      	//prompts for employee name
         String name = getName("Enter employee's name", "Error! Invalid name entered!", vaca, count);
      	//prompts for vacation location
         String location = getLocation("Enter vacation Location", "Error! Invalid location entered!", vaca, count);
      	//prompts for zip code
         String zipcode = getZipcode("Enter zipcode\nFormat: yyyyy-yyyy (y are digits)", "Error! Invalid zipcode entered!");
      	//prompts for number of family members
         int numFamilyMembers = getInt("Enter number of family members", "Error! Invalid number of family members entered!", 1, 10);
      	//if beach vacation
         if(vacationType == 0){
            boolean hurricanInsurance= JOptionPane.showConfirmDialog(null, "Would you like to purchase hurrican insurance?") == JOptionPane.YES_OPTION;
            vaca[count] = new BeachHouseVacation(name, location, zipcode, numFamilyMembers, hurricanInsurance);
         }
         //if ski vacation
         else{
         	//prompt for number of stars
            int numStars = getInt("Enter number of stars!", "Error! Invalid number of stars entered!", SkiResortVacation.MIN_STARS, SkiResortVacation.MAX_STARS);
            SkiResortPeople[] people = new SkiResortPeople[numFamilyMembers];
         	//get people going on vacation info
            boolean lessons = JOptionPane.showConfirmDialog(null, "Is " + name + " taking ski lessons?") == JOptionPane.YES_OPTION;
            people[0] = new SkiResortPeople(name, lessons);
            getPeople(people, numFamilyMembers);
            vaca[count] = new SkiResortVacation(name, location, zipcode, numFamilyMembers, numStars, people);
         }
      }
      else{
         JOptionPane.showMessageDialog(null, "Max number of vacation has been entered!\nNo more vacations can be entered!");
      }
   }
	//prints summary of beach vacation
   public static void printBeachVacationBills(Vacation[] vaca, int count){
      int listCount = 0;
      String message = "Beach Vacation Bills\n";
      for(int i = 0; i<count; i++){
         if(vaca[i] instanceof BeachHouseVacation){
            message += vaca[i].toString();
            listCount++;
         }
      }
      if(listCount>0){
         JOptionPane.showMessageDialog(null, message);
      }
      else{
         JOptionPane.showMessageDialog(null, "No Beach Vacations has been entered!");
      }
   }
	//prints summary of ski vacation
   public static void printSkiResortBills(Vacation[] vaca, int count){
      int listCount = 0;
      String message = "Ski Resort Bills\n";
      for(int i = 0; i<count; i++){
         if(vaca[i] instanceof SkiResortVacation){
            message += vaca[i].toString();
            listCount++;
         }
      }
      if(listCount>0){
         JOptionPane.showMessageDialog(null, message);
      }
      else{
         JOptionPane.showMessageDialog(null, "No Ski Vacations has been entered!");	
      }
   }

	//promp for zipcode
   public static String getZipcode(String message, String errorMessage){
      String input;
      boolean valid;
      do{
         input = getString(message, errorMessage);
         valid = Vacation.validateZipcode(input);
         if(!valid){
            JOptionPane.showMessageDialog(null, errorMessage);
         }
      }while(!valid);
      return input;
   
   }

	//prompts for name
   public static String getName(String message, String errorMessage, Vacation[] vaca, int count){
      String input;
      boolean valid;
      do{
         input=getString(message, errorMessage);
         valid = checkRepeatName(input, vaca, count);
         if(!valid){JOptionPane.showMessageDialog(null, "Error! Name has already been entered!");}
      }while(!valid);
      return input;
   }
	//prompts for location
   public static String getLocation(String message, String errorMessage, Vacation[] vaca, int count){
      String input;
      boolean valid;
      do{
         input=getString(message, errorMessage);
         valid = checkRepeatLocation(input, vaca, count);
         if(!valid){JOptionPane.showMessageDialog(null, "Error! Location has already been entered!");}
      }while(!valid);
      return input;
   }
	//get people going on ski vacation
   public static void getPeople(SkiResortPeople[] people, int count){
      int currentCount = 1;
      for(int i = 1; i<count; i++){
         String name = getFamilyMemberName("Enter Family Member's Name", "Error! Invalid Name Entered!", people, count, currentCount);
         boolean lessons = JOptionPane.showConfirmDialog(null, "Is " + name + " taking ski lessons?") == JOptionPane.YES_OPTION;
         people[i] = new SkiResortPeople(name, lessons);
         currentCount++;
      }
   }

	//get peoples name going on ski vacation
   public static String getFamilyMemberName(String message, String errorMessage, SkiResortPeople[] people, int count, int currentCount){
      String input;
      boolean valid;
      do{
         input=getString(message, errorMessage);
         valid=checkRepeatFamilyMemberName(input, people, currentCount);
         if(!valid){JOptionPane.showMessageDialog(null, "Error! Family member's name has already been entered!");}	
      }while(!valid);
      return input;
   }

	//prompt user for a string
   public static String getString(String message, String errorMessage){
      String input;
      boolean valid;
      do{
         input = JOptionPane.showInputDialog(message);
         valid = Vacation.validateString(input);
         if(!valid){JOptionPane.showMessageDialog(null,errorMessage);}
      }while(!valid);
      return input;
   }
	//prompt user for an int within a range
   public static int getInt(String message, String errorMessage, int min, int max){
      int input;
      boolean valid;
      do{
         try{
            input = Integer.parseInt(JOptionPane.showInputDialog(message));
         }
         catch(NumberFormatException e){
            input = -1;
         }
         valid = Vacation.validateInt(input, min, max);
         if(!valid){JOptionPane.showMessageDialog(null, errorMessage);}
      }while(!valid);
      return input;
   }
	//prompt user for an int
   public static int getInt(String message){
      int input;
      try{
         input = Integer.parseInt(JOptionPane.showInputDialog(message));
      }
      catch(NumberFormatException e){
         input = -1;
      }
      return input;
   }
	//check if name entered is used
   public static boolean checkRepeatName(String name, Vacation[] vaca, int count){
      for(int i = 0; i<count; i++){
         if(name.equalsIgnoreCase(vaca[i].getName())){
            return false;
         }
      }
      return true;
   }

	//check if location entered is used
   public static boolean checkRepeatLocation(String location, Vacation[] vaca, int count){
      for(int i = 0; i<count; i++){
         if(location.equalsIgnoreCase(vaca[i].getLocation())){
            return false;
         }
      }
      return true;
   }
	//check if family name is repeated
   public static boolean checkRepeatFamilyMemberName(String name, SkiResortPeople[] people, int count){
      for(int i = 0; i<count; i++){
         if(name.equalsIgnoreCase(people[i].getName())){
            return false;
         }
      }
      return true;
   }

	//remove vacation
   public static void removeVacation(Vacation[] vaca, int count){
      if(checkEmpty(count, "No Vacations has been entered!")){
         int remove;
         String message = "Which vacation would you like to remove?\n\n";
         for(int i = 0; i < count; i++){
            message+="[" + (i+1) + "]" + vaca[i].getName() + "\n";
         }
         remove = getInt(message);
         if(remove<1||remove>count){
            JOptionPane.showMessageDialog(null, "Error! Remove Vacation entered is invalid!");
         }
         else{
            for(int i = remove-1; i<count-1; i++){
               vaca[i] = vaca[i+1];
            }
            vaca[count-1]=null;
            Vacation.decreaseCount();
         }
      }
   }

	//print vacation summary
   public static void printVacationSummary(Vacation[] vaca, int count){
      if(checkEmpty(count, "No Vacations has been entered!")){
         String message = "Vacation Summary\n\nTotal Number of Vacations: " + count;
         double cost = 0;
         for(int i = 0; i<count;i++){
            cost+=vaca[i].calculateCost();
         }
         message += "\nTotal Cost: " + String.format("$%.2f", cost) + "\n";
         JOptionPane.showMessageDialog(null, message);
      }
   }
	//check if value entered is empty
   public static boolean checkEmpty(int count, String message){
      if(count == 0){
         JOptionPane.showMessageDialog(null, message);
         return false;
      }
      return true;
   }
}