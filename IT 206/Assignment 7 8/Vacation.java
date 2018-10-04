//Abstract vacation ddc

public abstract class Vacation{
	//constants
   public static final int MAX_NUM_VACATION = 37;
   public static final int MAX_FAMILY_MEMBERS = 10;
   public static final int MIN_FAMILY_MEMBERS = 1;
	
	//variables
   private static int vacationCount = 0;
   private String name;
   private String location;
   private String zipcode;
   private int numFamilyMembers;

	//constructor
   public Vacation(String name, String location, String zipcode, int numFamilyMembers){
      this.name = name;
      this.location = location;
      this.zipcode = zipcode;
      this.numFamilyMembers = numFamilyMembers;
      vacationCount++;
   }
	//accessor 
   public static int getVacationCount(){
      return vacationCount;}
   public String getName(){
      return name;}
   public String getLocation(){
      return location;}
   public String getZipCode(){
      return zipcode;}
   public int getNumFamilyMembers(){
      return numFamilyMembers;}

	//Mutator
   public boolean setName(String name){
      if(validateString(name)){
         this.name = name;
         return true;
      }
      return false;
   }
   public boolean setLocation(String location){
      if(validateString(location)){
         this.location = location;
         return true;
      }
      return false;
   }
   public boolean setZipcode(String zipcode){
      if(validateZipcode(zipcode)){
         this.zipcode=zipcode;
         return true;
      }
      return false;
   }
   public boolean setNumFamilyMembers(int numFamilyMembers){
      if(validateInt(numFamilyMembers,MIN_FAMILY_MEMBERS, MAX_FAMILY_MEMBERS)){
         this.numFamilyMembers = numFamilyMembers;
         return true;
      }
      return false;
   }

	//Validator
   public static boolean validateString(String input){
      return(!input.equals(""));
   }
   public static boolean validateZipcode(String input){
      if(input.length()!=10){
         return false;
      }
      for(int i = 0; i<10; i++){
         if(i!=5){
            if(!Character.isDigit(input.charAt(i))){
               return false;
            }
         }
         if(input.charAt(5)!= '-'){
            return false;
         }
      }
      return true;
   }
   public static boolean validateInt(int input, int min, int max){
      return(input>=min && input<=max);
   }

	//special purpose Method
   public abstract double calculateCost();
	
   public static void decreaseCount(){
      vacationCount--;
   }
   public String toString(){
      String message;
      message = "\nname: " + name
         + "\nlocation: " + location
         + "\nzip code: " + zipcode
         + "\nNumber of Family Members: " + numFamilyMembers;
      return message;
   }
}