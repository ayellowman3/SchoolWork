/*
George Huang
10/6/2016
IT 206-001
Assignment 4

Position Tacker is a program that allows the user to track the positions at a company. This program
allows users to add positions, delete positions, display positions, and find the position/positions
with the highest salary. The user may not delete or display, or find the highest salary if there are
no positions added first. If non of the positions added have a salary, the user is given an error
message.

input
menu choice
1:addPosition
2:deletePosition
3:displayAllPosition
4:findHighestSalary
5:Exit Application

Variable: positionTitle
type: String
description: Title of the position

Variable: positionDepartment
type: String
description: Department the positon belongs to

Variable: positionStatus
type: String
description: The status of the position

Variable: numPeopleSupervise
type: int
description: the number of people the position supervises

Variable: startingSalary
type: double
description: The starting salary of the postition. Only required if the status
is Interviewing applicants or filled

Variable: deletePosition
type: String
description: The position to delete from the list. If the position entered isn't
in the list, the user is presented with an error message.


output:

displayAllPosition: Outputs all positionTitle, positionDepartment, Status, numPeople
to supervise. If the Status is interviewing applicants or filled, then salary is outputted.

findHighestSalary: outputs positionTitle, positionDepartment, and salary
*/
import javax.swing.JOptionPane;

public class PositionTracker {
   public static void main(String[] args) {
      final int MAX_POSITIONS = 17;
   	//creates an array of objects of Max size
      Position[] tracker = new Position[MAX_POSITIONS];
      int menuChoice = getMenuOption();
   	
   	//Based on userinput, perform a different function
      while (menuChoice != 5) {
         switch (menuChoice) {
            case 1:
            //adds more positions
               addPosition(tracker);
               break;
         
            case 2:
            //delete position
               deletePosition(tracker);
               break;
         
            case 3:
            //display all positions
               displayAllPosition(tracker);
               break;
         
            case 4:
            //find the highest salary
               findHighestSalary(tracker);
               break;
         
            default:
            //should never reach here
               JOptionPane.showMessageDialog(null, "you have a problem in your code");
               break;
         }
      	//repromt for menu choice
         menuChoice = getMenuOption();
      }
   }

   private static int getMenuOption() {
      int menuChoice;
      do {
         try {
         	//ask for user input
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter your selection:"
               	+ "\n(1) Add a Position" 
               	+ "\n(2) Delete a Position" 
               	+ "\n(3) Display All Positions"
               	+ "\n(4) Find Highest Starting Salary" 
               	+ "\n(5) Exit Application"));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
      	//the input has to between 1 and 5 inclusive
         if (menuChoice < 1 || menuChoice > 5) {
            JOptionPane.showMessageDialog(null, "Invalid choice! Please enter a valid menu option!");
         }
      } while (menuChoice < 1 || menuChoice > 5);
      return menuChoice;
   }

   private static void addPosition(Position[] tracker){
   	//the number of positions 
      int positionCount = Position.getNumPosition();
      boolean error = false;
   	//only add position if the total number of positions added is under the maximum amount
      if(positionCount < tracker.length){
      	//creates a new position object
         tracker[positionCount] = new Position();
      	//prompt,set, and validate for position title
         String positionTitle;
         do{
            positionTitle = getPositionTitle();
            error = tracker[positionCount].validateInList(positionTitle, tracker, positionCount);
            if(error) JOptionPane.showMessageDialog(null, "Error! Position has already been entered!");
            else{
               error = !tracker[positionCount].setPositionTitle(positionTitle);
               if(error) JOptionPane.showMessageDialog(null, "Error! Position entered is invalid!");
            }
         }while(error);
      	
      	//prompts,set, and validate for position department
         String positionDepartment;
         do{
            positionDepartment = getPositionDepartment();
            error = !tracker[positionCount].setPositionDepartment(positionDepartment);
            if(error) JOptionPane.showMessageDialog(null, "Error! Department entered is invalid!");
         }while(error);
      	//prompts,set, and validate for position status
         String positionStatus;
         do{
            positionStatus = getPositionStatus();
            error = !tracker[positionCount].setPositionStatus(positionStatus);
            if(error) JOptionPane.showMessageDialog(null, "Error! Status entered is invalid!");
         }while(error);
      
      	//prompts,set, and validate for number of people supervise
         int numPeopleSupervise;
         do{
            numPeopleSupervise = getNumPeopleSupervise();
            error = !tracker[positionCount].setNumPeopleSupervise(numPeopleSupervise);
            if(error) JOptionPane.showMessageDialog(null, "Error! Number of people entered is invalid!");
         }while (error);
      	//prompt,set, and validate for starting salary
         double startingSalary;
         if(tracker[positionCount].requireSalary()){
            do{
               startingSalary = getStartingSalary();
               error = !tracker[positionCount].setStartingSalary(startingSalary);
               if(error) JOptionPane.showMessageDialog(null, "Error! Starting salary entered is invalid!");
            }while(error);
         }
      }
      
      else{ JOptionPane.showMessageDialog(null, "Error! Position tracker is full! No more positions can be added.");}
   }
	//prompts for position title
   private static String getPositionTitle() {
      String positionTitle;
      positionTitle = JOptionPane.showInputDialog("Enter position title: ");
      return positionTitle;
   }
	//prompt for position department
   private static String getPositionDepartment() {
      String department;
      department = JOptionPane.showInputDialog("Enter position department: ");
      return department;
   }

	//prompt for position status
   private static String getPositionStatus() {
      String status;
      status = JOptionPane.showInputDialog("Enter position status: "
         + "\nPosition posted"
         + "\nReceiving resumes"
         + "\nInterviewing applicants"
         + "\nPosition filled");
      return status;
   }
	//prompt for number of people supervise
   private static int getNumPeopleSupervise() {
      int numPeopleSupervise;
      try {
         numPeopleSupervise = Integer.parseInt(JOptionPane.showInputDialog("Enter number of people supervise: "));
      }
      catch (NumberFormatException e) {
         numPeopleSupervise = -1;
      }
      return numPeopleSupervise;
   }
	//prompt for starting salary
   private static double getStartingSalary(){
      double startingSalary;
      try{
         startingSalary = Double.parseDouble(JOptionPane.showInputDialog("Enter Starting Salary"));
      }
      catch (NumberFormatException e) {
         startingSalary = -1.0;
      }
      return startingSalary;
   }
	//prompt for delete position
   private static void deletePosition(Position[] tracker)
   {
      String removePosition;
      String removePositionList;
      int positionCount = Position.getNumPosition();
      if(positionCount == 0) {JOptionPane.showMessageDialog(null, "Error! No Position entered!");}
      else{
         removePositionList = getRemovePositionList(tracker, positionCount);
         removePosition = JOptionPane.showInputDialog(removePositionList);
         if(Position.validateInList(removePosition, tracker, positionCount)){
            reorderList(removePosition, tracker, positionCount);
            Position.decreasePositionCount();
            JOptionPane.showMessageDialog(null, "" + removePosition + " has been removed!");
         }
         else{
            JOptionPane.showMessageDialog(null, "Error! Entered invalid position to remove!");
         }
      }
   }
	//display a list of position to delete
   private static String getRemovePositionList(Position[] tracker, int positionCount){
      String removeMessage = "Which position would you like to remove?\n\n";
      for(int i = 0; i < positionCount; i++){
         removeMessage += tracker[i].getPositionTitle() + "\n";
      }
      return removeMessage;
   }
	//reorders list after deleting position
   private static void reorderList(String removePosition, Position[] tracker, int positionCount)
   {
      int removeIndex = 0;
      for(int i = 0; i < positionCount; i++){
         if(removePosition.equalsIgnoreCase(tracker[i].getPositionTitle())){
            removeIndex = i;
         }
      }
   
      for(int j = removeIndex; j < positionCount; j++){
         if(j < 16){
            tracker[j] = tracker[j+1];
         }
         else{
            tracker[j] = new Position();
         }
      }
   }
	//Display all position
   private static void displayAllPosition(Position[] tracker)
   {
      String displayAllPositionList;
      int positionCount = Position.getNumPosition();
      if(positionCount > 0){
         displayAllPositionList = getDisplayAllPositionList(tracker, positionCount);
         JOptionPane.showMessageDialog(null, displayAllPositionList);
      }
      else{ JOptionPane.showMessageDialog(null, "No position to display!");}
   }
	//creates a string of all position
   private static String getDisplayAllPositionList(Position[] tracker, int positionCount){
      String displayAllPositionList = "Position List\n";
      for(int i = 0; i < positionCount; i++){
         displayAllPositionList += tracker[i].toString();
      }
      return displayAllPositionList;
   }
	//find the position with highest salary
   private static void findHighestSalary(Position[] tracker)
   {	
      int positionCount = Position.getNumPosition();
      double highestSalary = -1;
      String highestSalaryList;
      if(positionCount == 0) JOptionPane.showMessageDialog(null, "Error! No Position entered!");
      else{
         highestSalary = getHighestSalary(tracker, positionCount, highestSalary);
         if(highestSalary == -1) JOptionPane.showMessageDialog(null, "Error! No Positon entered have a starting salary!");
         else{
            highestSalaryList = getHighestSalaryList(tracker, positionCount, highestSalary);
            JOptionPane.showMessageDialog(null, highestSalaryList);
         }
      }
   }
	//find the value of the highest salary
   private static double getHighestSalary(Position[] tracker, int positionCount, double highestSalary){
      double currentHighestSalary = highestSalary;
      for(int i = 0; i < positionCount; i++){
         if(tracker[i].requireSalary()){
            if(tracker[i].getStartingSalary() > currentHighestSalary){
               currentHighestSalary = tracker[i].getStartingSalary();
            }
         }
      }
      return currentHighestSalary;
   }
	//creates a string of the highest salary
   private static String getHighestSalaryList(Position[] tracker, int positionCount, double highestSalary)
   {
      String highestSalaryList = "Position with the highestSalary\n";
      for(int i = 0; i < positionCount; i++){
         if(tracker[i].requireSalary()){
            if(tracker[i].getStartingSalary() == highestSalary){
               highestSalaryList += tracker[i].toString(highestSalary);
            }
         }
      }
      return highestSalaryList;
   }
}