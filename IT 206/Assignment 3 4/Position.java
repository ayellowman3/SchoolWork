/*
George Huang
10/6/2016
IT206-001
Assignment 4
This is the data definiton class called Position
*/
public class Position {
	
	// contants
   public static final String[] STATUS = { "Position posted", "Receiving resumes", "Interviewing applicants",
   		"Position filled" };
	
   private static int numPosition = 0;


	// instance variables
   private String positionTitle;
   private String positionDepartment;
   private String positionStatus;
   private int numPeopleSupervise;
   private double startingSalary;


	// default constructor
   public Position() {
      this(null, null, null, 0, 0.0);
   }


	// constructor
   public Position(String positionTitle, String positionDepartment, String positionStatus, int numPeopleSupervise,	double startingSalary) {
      this.positionTitle = positionTitle;
      this.positionDepartment = positionDepartment;
      this.positionStatus = positionStatus;
      this.numPeopleSupervise = numPeopleSupervise;
      this.startingSalary = startingSalary;
      numPosition++;
   }

   public Position(String positionTitle, String positionDepartment, String positionStatus, int numPeopleSupervise) {
      this.positionTitle = positionTitle;
      this.positionDepartment = positionDepartment;
      this.positionStatus = positionStatus;
      this.numPeopleSupervise = numPeopleSupervise;
      numPosition++;
   }


	// accessors
   public static int getNumPosition() {
      return numPosition;
   }
   public String getPositionTitle(){
      return positionTitle;
   }
   public double getStartingSalary(){
      return startingSalary;
   }

		
	// mutators
   public boolean setPositionTitle(String positionTitle) {
      if (validateString(positionTitle)) {
         this.positionTitle = positionTitle;
         return true;
      }
      return false;
   }

   public boolean setPositionDepartment(String positionDepartment) {
      if (validateString(positionDepartment)) {
         this.positionDepartment = positionDepartment;
         return true;
      }
      return false;
   }

   public boolean setPositionStatus(String positionStatus) {
      if (validateStatus(positionStatus)) {
         for (int i = 0; i < STATUS.length; i++) {
            if (positionStatus.equalsIgnoreCase(STATUS[i])) {
               this.positionStatus = STATUS[i];
            }
         }
         return true;
      }
      return false;
   }

   public boolean setNumPeopleSupervise(int numPeopleSupervise){
      if(validatePosIntWZero(numPeopleSupervise)){
         this.numPeopleSupervise = numPeopleSupervise;
         return true;
      }
      return false;
   }

   public boolean setStartingSalary(double startingSalary){
      if(validatePosDouble(startingSalary)){
         this.startingSalary = startingSalary;
         return true;
      }
      return false;
   }


	// validation mutators
   public static boolean validateInList(String positionTitle, Position[] tracker, int positionCount) {
      for (int i = 0; i < positionCount; i++) {
         if (positionTitle.equalsIgnoreCase(tracker[i].positionTitle))
            return true;
      }
      return false;
   }

   private boolean validateString(String str) {
      return (!str.equals(""));
   }

   private boolean validateStatus(String positionStatus) {
      for (int i = 0; i < STATUS.length; i++) {
         if (positionStatus.equalsIgnoreCase(STATUS[i]))
            return true;
      }
      return false;
   }

   private boolean validatePosIntWZero(int numPeopleSupervise){
      return (numPeopleSupervise >=0);
   }

   private boolean validatePosDouble(double num){
      return(num >= 0.0);
   }


	// special purpose method
   public boolean requireSalary(){
      return(positionStatus.equals(STATUS[2]) || positionStatus.equals(STATUS[3]));
   }

   public String toString(){
      String info;
      info ="\nPosition Title: " + positionTitle
         + "\nDepartment: " + positionDepartment
         + "\nStatus: " + positionStatus
         + "\nNumber of People supervised: " + numPeopleSupervise + "\n";
      if(requireSalary()){
         info += "Starting Salary: " + String.format("$%.2f", startingSalary) +"\n";
      }
      return info;
   }
   public String toString(double highestSalary){
      String info;
      info = "\nPosition Title: " + positionTitle
         + "\nDepartment: " + positionDepartment
         + "\nStarting Salary: " + String.format("$%.2f",startingSalary) + "\n";
      return info;
   }
   public static void decreasePositionCount(){
      numPosition--;
   }
}