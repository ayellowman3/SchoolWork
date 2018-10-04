/*
George Huang
11/6/2016
IT 206-001
Assignment 6

DayCare is a program that allows the user to enter children into the daycare program and increase the max
number of childrens allowed in the daycare. This program asks the user for the children's name, age, street
address, phone number, email, food allergies, days in day care per week, if extended hours is needed, tutoring
status, grade level, and tutored subjects. Once all the information is entered, if the child is eligible to
join in the day care, their information is stored. If the information entered is inelgible for the day care,
the information is discarded. 

eligible:
child between the age of 3 and 11 inclusive
number of food allergies is less than or equal to 7

input
menu choice
1: add children
2: increase max number of children
3: finished

Variable: name
type: String
description: child's name

Variable: age
type: int
description: child's age

Variable: streetAddress
type: String
description: Child's street address

Variable: phoneNumber
type: String
description: Child's phoneNumber

Variable: email
type: String
description: Child's email

Variable: foodAllergies
type: String array
description: array of food allergies

Variable: foodAllergiesCount
type: int
description: the number of food alleriges the child has

Variable: daysPerWeek
type: int
description: days per week of day care

Variable: extendedHours
type: boolean
description: extended hours status

Variable: cost
type: double
description: cost for the child

Variable: tutored
type: boolean
description: tutoring status

Variable: gradeLevel
type: String
description: child's grade level

Variable: numOfSubjects
type: int
description: number of subjects child is being tutored in

output:
child's information
number of tutored children
number of nontutored children
average cost of tutored children
average cost of nontutored children
*/
import javax.swing.JOptionPane;

public class DayCare{
   public static void main(String[] args){
   	//object array
      Children[] child = new Children[Children.getMaxNumChildren()];
      int menuOption;
   	//prompt for menu selection
      do{
         menuOption = getMenuOption();
         switch(menuOption){
            case 1:
               addChildren(child, Children.getChildrenCount());
               break;
            case 2:
               child = increaseMaxChildren(child, Children.getChildrenCount());
               break;
            case 3: 
               break;
            default:
               JOptionPane.showMessageDialog(null, "Error! Invalid menu section!");
         }
      }while(menuOption != 3);
      getSummery(child, Children.getChildrenCount());
   }
	//prompt for menu selection
   public static int getMenuOption(){
      int menuOption;
      try{
         menuOption = Integer.parseInt(JOptionPane.showInputDialog("Enter Child Care Option \n[1] Add Children \n[2] Increase Number of Children\n[3] Finish Entering Children"));
      }
      catch(NumberFormatException e){
         menuOption = 0;
      }
   
      return menuOption;
   }
	//method to add children
   public static void addChildren(Children[] child, int childrenCount){
      if(childrenCount<Children.getMaxNumChildren()){
         String name = getString("Enter child's name: ", "Error! Invalid name entered!");
         int age = getInt("Enter " + name + "'s age: " , "Error! Invalid age entered!");
         String streetAddress = getString("Enter " + name + "'s address", "Error! Invalid street address entered!");
         String phoneNumber = getPhoneNumber("Enter " + name + "'s phone number\nformat: (xxx) xxx-xxxx", "Error! Invalid phone number entered!");
         String email = getEmail("Enter " + name + "'s email\nformat: sample@email.com", "invalid email"); 
         String[] foodAllergies = getFoodAllergies("Enter " + name + "'s food allergies", "Error! Invalid allergies entered!");
         int foodAllergiesCount = getFoodAllergiesCount(foodAllergies);
         int daysPerWeek = getDaysPerWeek("How many days per week does " + name + " need child care?\n(1 through 5 days)", "Error! Invalid days per week entered!");
         boolean extendedHours = getBooleanConfirm("Does " + name + " need extended hours childcare?");
         double cost = getCost(daysPerWeek, extendedHours);
         boolean tutored = getBooleanConfirm("Does " + name + " need tutoring?");
         if(tutored){
            String gradeLevel = getGradeLevel(name,"Error! Invalid grade level entered");
            int numOfSubjects = getInt("How many subject is " + name + " tutored in?", "Error! Invalid number of subjects entered!");
            if(Children.validateEligibility(age, foodAllergiesCount)){
               cost += getTutoredCost(numOfSubjects);
               child[childrenCount] = new TutoredChildren(name, age, streetAddress, phoneNumber, email, foodAllergies, foodAllergiesCount, daysPerWeek, extendedHours, cost, tutored, gradeLevel, numOfSubjects);
            }
            else{
               JOptionPane.showMessageDialog(null, Children.inEligible(age, foodAllergiesCount));	
            }
         }
         else{
            if(Children.validateEligibility(age, foodAllergiesCount)){
               child[childrenCount] = new Children(name, age, streetAddress, phoneNumber, email, foodAllergies, foodAllergiesCount, daysPerWeek, extendedHours, cost, tutored);
            }
            else{
               JOptionPane.showMessageDialog(null, Children.inEligible(age, foodAllergiesCount));	
            }
         }
      }
      else{
         JOptionPane.showMessageDialog(null, "Error! No more children can be entered!");		
      }
   }	
	//method to ask for string
   public static String getString(String message, String invalidMessage){
      boolean error = false;
      String str;
      do{
         str = JOptionPane.showInputDialog(message);
         error = Children.validateNonEmptyString(str);
         if(error){JOptionPane.showMessageDialog(null, invalidMessage);}
      }while(error);
      return str;
   }
	//method to ask for interger
   public static int getInt(String message, String invalidMessage){
      boolean error = false;
      int num;
      do{
         try{
            num = Integer.parseInt(JOptionPane.showInputDialog(message));
         }
         catch(NumberFormatException e){
            num = -1;
         }
         error = Children.validateInt(num);
         if(error){JOptionPane.showMessageDialog(null, invalidMessage);}
      }while(error);
      return num;
   }
	//method to get phone number
   public static String getPhoneNumber(String message, String invalidMessage){
      boolean error = false;
      String phoneNumber;
      do{
         phoneNumber = getString(message, invalidMessage);
         error = Children.validatePhoneNumber(phoneNumber);
         if(error){errorMessage(invalidMessage);}
      }while(error);
      return phoneNumber;
   }
	//method to get email
   public static String getEmail(String message, String invalidMessage){
      boolean error = false;
      String email;
      do{
         email = getString(message, invalidMessage);
         error = Children.validateEmail(email);
         if(error){errorMessage(invalidMessage);}
      }while(error);
      return email;
   }
	//method to get a list of food allergies
   public static String[] getFoodAllergies(String message, String invalidMessage){
      String[] foodAllergies = new String[Children.MAX_NUM_FOOD_ALLERGIES + 1];
      int count = 0;
      if(getBooleanConfirm("Would you like to enter food allergies")){
         do{
            if(count<Children.MAX_NUM_FOOD_ALLERGIES + 1){
               foodAllergies[count] = getString(message, invalidMessage);
               count++;
            }
            else{
               foodAllergies[7] = getString(message, invalidMessage);
               count++;
            }
         }while(getBooleanConfirm("Would you like to enter another food allergy?"));
      }
      return foodAllergies;
   }
	//method to count the number of food allergies
   public static int getFoodAllergiesCount(String[] foodAllergies){
      int count = 0;
      for(int i = 0; i < foodAllergies.length; i++){
         if(foodAllergies[i] != null && foodAllergies[i].length() > 0){
            count++;
         }
      }
      return count;
   }
	//method to get number of days per week in the day care
   public static int getDaysPerWeek(String message, String invalidMessage){
      boolean error = false;
      int num;
      do{
         try{
            num = Integer.parseInt(JOptionPane.showInputDialog(message));
         }
         catch(NumberFormatException e){
            num = -1;
         }
         error = Children.validateDaysPerWeek(num);
         if(error){JOptionPane.showMessageDialog(null, invalidMessage);}
      }while(error);
      return num;
   }
	//method to get grade level
   public static String getGradeLevel(String name, String invalidMessage){
      boolean error = false;
      String gradeLevel;
      String message = "Enter " + name + "'s grade level\n";
      for(int i = 0; i < TutoredChildren.GRADE_LEVEL_LIST.length; i++){
         message += "\n" + TutoredChildren.GRADE_LEVEL_LIST[i];
      }
      do{
         gradeLevel = getString(message, invalidMessage);
         error = TutoredChildren.validateGradeLevel(gradeLevel);
         if(error){errorMessage(invalidMessage);}
      }while(error);
      return gradeLevel;
   }
	//method to calculate cost
   public static double getCost(int daysPerWeek, boolean extendedHours){
      double cost = 0.0;
      cost += daysPerWeek * Children.COST_PER_DAY;
      if(extendedHours){
         cost += daysPerWeek * Children.EXTENDED_COST;
      }
      return cost;
   }
	//method to caluculate tutoring
   public static double getTutoredCost(int num){
      return num * TutoredChildren.COST_PER_SUBJECT;
   }
	//method for confirm dialog
   public static boolean getBooleanConfirm(String input){
      int userInput;
      do{
         userInput = JOptionPane.showConfirmDialog(null, input);
      }while(userInput==JOptionPane.CANCEL_OPTION);
      return userInput == JOptionPane.YES_OPTION;
   }
	//method to print error message
   public static void errorMessage(String message){JOptionPane.showMessageDialog(null, message);}

	//method to output summery
   public static void getSummery(Children[] child, int childrenCount){
      if(Children.getChildrenCount() > 0){
         String summery = "Summery";
         for(int i = 0; i < childrenCount; i++){
            summery += child[i].toString();
            summery += child[i].costString();
         }
         summery += getChildrenSummery(child, childrenCount);
         JOptionPane.showMessageDialog(null,  summery);
      }
      else{
         JOptionPane.showMessageDialog(null, "No Children information has been entered!");
      }
   }
	//method to get children summery
   public static String getChildrenSummery(Children[] child, int childrenCount){
      int tutoredChildrenCount = 0;
      int nonTutoredChildrenCount = 0;
      double totalCostTutored = 0.0;
      double totalCostNotTutored = 0.0;
      String averageTutoredCost;
      String averageNonTutoredCost;
      String summery;
      for(int i = 0; i < childrenCount; i++){
         if(child[i].getTutored()){
            tutoredChildrenCount ++;
            totalCostTutored += child[i].getCost();
         }
         else{
            nonTutoredChildrenCount ++;
            totalCostNotTutored += child[i].getCost();
         }
      }
      averageTutoredCost = String.format("$%.2f", getAverage(totalCostTutored, tutoredChildrenCount));
      averageNonTutoredCost = String.format("$%.2f", getAverage(totalCostNotTutored, nonTutoredChildrenCount));
   	
   
      summery = "\n\nnum of children tutored: " + tutoredChildrenCount
         + "\naverage tutored cost: " + averageTutoredCost
         + "\nnum of childrens not tutored: " + nonTutoredChildrenCount
         + "\naverage non tutored cost: " + averageNonTutoredCost;
      return summery; 
   }
	//method to caluculate average
   public static double getAverage(double total, int count){
      if(count != 0){
         return total/count;
      }
      return 0.0;
   }
	//method to increase max number of children
   public static Children[] increaseMaxChildren(Children[] child, int count){
      int newMaxChildren = getInt("enter new max child", "error, not valid");
      if(!Children.setMaxNumChildren(newMaxChildren)){
         Children[] tempt = new Children[Children.getMaxNumChildren()];
         for(int i = 0; i < count; i++){
            tempt[i] = child[i];
         }
         return tempt;
      }
      else{
         JOptionPane.showMessageDialog(null, "Error! New max is invalid!");
      }
      return child;
   }
}