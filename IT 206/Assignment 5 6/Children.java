//Children data definition class

public class Children{
	//constants
   public static final int MAX_NUM_FOOD_ALLERGIES = 7;
   public static final double COST_PER_DAY = 106.26;
   public static final double EXTENDED_COST = 16.96;
   public static final int MIN_AGE = 3;
   public static final int MAX_AGE = 11;
   public static final int MIN_DAY = 1;
   public static final int MAX_DAY = 5;
   private static int maxNumChildren = 8;
   private static int childrenCount = 0;
   private String name;
   private int age;
   private String streetAddress;
   private String phoneNumber;
   private String email;
   private String[] foodAllergies = new String[7];
   private int foodAllergiesCount;
   private int daysPerWeek;
   private boolean extendedHours;
   private double cost;
   private boolean tutored;

	//constructor
   public Children(String name, int age, String streetAddress, String phoneNumber, String email, String[] foodAllergies, int foodAllergiesCount, int daysPerWeek, boolean extendedHours, double cost, boolean tutored){
      this.name = name;
      this.age = age;
      this.streetAddress = streetAddress;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.foodAllergies = foodAllergies;
      this.foodAllergiesCount = foodAllergiesCount;
      this.daysPerWeek = daysPerWeek;
      this.extendedHours = extendedHours;
      this.cost = cost;
      this.tutored = tutored;
      childrenCount++;
   }

	//accessor
   public static int getChildrenCount(){
      return childrenCount;}
   public static int getMaxNumChildren(){
      return maxNumChildren;}

   public String getName(){
      return name;}
   public int getAge(){
      return age;}
   public String getStreetAddress(){
      return streetAddress;}
   public String getPhoneNumber(){
      return phoneNumber;}
   public String getEmail(){
      return email;}
   public String[] getFoodAllergies(){
      return foodAllergies;}
   public int getFoodAllergiesCount(){
      return foodAllergiesCount;}
   public int getDaysPerWeek(){
      return daysPerWeek;}
   public boolean getExtendedHours(){
      return extendedHours;}
   public double getCost(){
      return cost;}
   public boolean getTutored(){
      return tutored;}
	//mutator
	
   public boolean setName(String name){
      if(!validateNonEmptyString(name)){
         this.name = name;
         return false;
      }
      return true;
   }
   public boolean setAge(int age){
      if(!validateInt(age)){
         this.age = age;
         return false;
      }
      return true;
   }	
   public boolean setStreetAddress(String address){
      if(!validateNonEmptyString(address)){
         this.streetAddress = address;
         return false;
      }
      return true;
   }	
   public boolean setPhoneNumber(String phoneNumber){
      if(!validatePhoneNumber(phoneNumber)){
         this.phoneNumber = phoneNumber;
         return false;
      }
      return true;
   }	
   public boolean setEmail(String email){
      if(!validateEmail(email)){
         this.email = email;
         return false;
      }
      return true;
   }	
   public boolean setDaysPerWeek(int daysPerWeek){
      if(!validateDaysPerWeek(daysPerWeek)){
         this.daysPerWeek = daysPerWeek;
         return false;
      }
      return true;
   }	
   public void setExtendedHours(boolean extendedHours){
      this.extendedHours = extendedHours;
   }
   public void setTutored(boolean tutored){
      this.tutored = tutored;
   }
   public static boolean setMaxNumChildren(int num){
      if(validateIncreaseMaxNumChildren(num)){
         maxNumChildren = num;
         return false;
      }
      return true;
   }

	//validator
	
   public static boolean validateNonEmptyString(String str){
      return(str.equals(""));
   }
   public static boolean validateInt(int num){
      return(num<0);
   }
   public static boolean validateDaysPerWeek(int num){
      return(num<MIN_DAY || num>MAX_DAY);
   }
   public static boolean validatePhoneNumber(String str){
      int[] numPosition = new int[] {1,2,3,6,7,8,10,11,12,13};
      if(str.length()!= 14){
         return true;}
      if(str.charAt(0) != '('){
         return true;}
      if(str.charAt(4) != ')'){
         return true;}
      if(str.charAt(5) != ' '){
         return true;}
      if(str.charAt(9) != '-'){
         return true;}
      for(int i = 0; i < 10; i++){
         if(!Character.isDigit(str.charAt(numPosition[i]))){
            return true;}
      }
      return false;
   }

   public static boolean validateEmail(String email){
      if(email.length()<6){
         return true;}
      int atCount = 0;
      int atLocation = 0;
      for(int i = 0; i < email.length(); i++){
         if(email.charAt(i) == '@'){
            atCount++;
            atLocation = i;
         }
      }
   
      if(atCount != 1){
         return true;}
      if(atLocation == 0 || atLocation == email.length()-1){
         return true;}
      if(email.charAt(atLocation+1) == '.' || email.charAt(atLocation-1)== '.' || email.charAt(0)== '.'){
         return true;}
      String part1 = email.substring(0, atLocation);
      String part2 = email.substring(atLocation + 1);
      for(int i = 0; i < part1.length(); i++){
         if(part1.charAt(i) == ' '){
            return true;}
      }
      int periodCount = 0;
      int lastPeriod = 0;
      for(int i = 0; i < part2.length(); i++){
         if(part2.charAt(i) == ' '){
            return true;}
         if(part2.charAt(i) == '.'){
            periodCount++;
            lastPeriod = i;
         }
      }
      if(periodCount == 0){
         return true;}
      if(part2.charAt(0) == '.'){
         return true;}
      int charAfterPeriod = part2.length() - lastPeriod - 1;
      if(charAfterPeriod < 2 || charAfterPeriod > 4){
         return true;}
      return false;
   }


	//special purpose method

   public static boolean validateEligibility(int age, int foodAllergiesCount){
      return(eligibleAge(age) && eligibleAllergyCount(foodAllergiesCount));
   }
   public static boolean validateIncreaseMaxNumChildren(int num){
      return (num > maxNumChildren);
   }

   public static boolean eligibleAge(int age){
      return (age>=MIN_AGE && age <= MAX_AGE);
   }
   public static boolean eligibleAllergyCount(int num){
      return (num<=MAX_NUM_FOOD_ALLERGIES);
   }

   public static String inEligible(int age, int foodAllergiesCount){
      String message = "Error!";
      if(!eligibleAge(age)){
         message += "\n\nChild's age does not qualify!";
      }
      if(!eligibleAllergyCount(foodAllergiesCount)){
         message += "\n\nChild's allergy count does not qualify!";
      }
      return message;
   }
   public String toString(){
      String message = "\n\nName: " + name
         + "\nAge: " + age
         + "\nStreet Address: " + streetAddress
         + "\nPhone Number: " + phoneNumber
         + "\nE mail: " + email;
      message +="\nFood Allergies:"+ toString(foodAllergies, foodAllergiesCount);
      message +="\nDays Per Week: " + daysPerWeek;
      if(extendedHours){
         message += "\nExtended hours: Yes";
      }
      else{
         message+= "\nExtended hours: No";
      }
      return message;
   }
   public String toString(String[] foodAllergies, int count){
      String message = "";
      for(int i = 0; i <count; i++){
         message += "\n   " + foodAllergies[i];
      }
      if(count == 0){
         return " None";}
      return message;
   }
   public String costString(){
      String message = "\nCost: " + String.format("$%.2f", cost);
      return message;
   }
}