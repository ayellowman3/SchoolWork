//Tutored Children data definition class

public class TutoredChildren extends Children{
	//constants
   public static final String[] GRADE_LEVEL_LIST = {"pre-k", "k", "1st", "2ed", "3rd", "4th", "5th", "6th"};
   public static final double COST_PER_SUBJECT = 12.00;

   private static int numTutoredStudents = 0;
   private String gradeLevel;
   private int numOfSubjects;

	//constructors
   public TutoredChildren(String name, int age, String streetAddress, String phoneNumber, String email, String[] foodAllergies, int foodAllergiesCount, int daysPerWeek, boolean extendedHours, double cost, boolean tutored, String gradeLevel, int numOfSubjects){
      super(name, age, streetAddress, phoneNumber, email, foodAllergies, foodAllergiesCount, daysPerWeek, extendedHours, cost, tutored);
      this.gradeLevel = gradeLevel;
      this.numOfSubjects = numOfSubjects;
      numTutoredStudents++;
   }
	
	//accessors
   public static int getNumTutoredStudents(){
      return numTutoredStudents;}

   public String getGradeLevel(){
      return gradeLevel;}
   public int getNumOfSubjects(){
      return numOfSubjects;}
	
	//mutator
   public boolean setGradeLevel(String gradeLevel){
      if(!validateGradeLevel(gradeLevel)){
         this.gradeLevel = gradeLevel;
         return false;
      }
      return true;
   }
   public boolean setNumOfSubjects(int numOfSubjects){
      if(!Children.validateInt(numOfSubjects)){
         this.numOfSubjects = numOfSubjects;
         return false;
      }
      return true;
   }
	//validator
   public static boolean validateGradeLevel(String gradeLevel){
      boolean invalid = true;
      for(int i = 0; i < 8; i++){
         if(gradeLevel.equalsIgnoreCase(GRADE_LEVEL_LIST[i])){
            invalid = false;
         }
      }
      return invalid;
   }

	//special purpose method
	
   public String toString(){
      String message = super.toString();
      message += "\nGrade Level: " + gradeLevel + "\nNumber of Subjects: " + numOfSubjects;
      return message;
   }
}