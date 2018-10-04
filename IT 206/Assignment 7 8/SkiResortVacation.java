//skiResort Vacation DDC

public class SkiResortVacation extends Vacation{
	//Constant
   public static final double BASE_PRICE = 308.0;
   public static final double LESSON_PRICE = 49.95;
   public static final int MIN_STARS = 2;
   public static final int MAX_STARS = 4;

	//variables
   private int numStars;
   private SkiResortPeople[] people;
	
	//Constructor
   public SkiResortVacation(String name, String location, String zipcode, int numFamilyMembers, int numStars, SkiResortPeople[] people){
      super(name, location, zipcode, numFamilyMembers);
      this.numStars = numStars;
      this.people = people;
   }

	//Accessors
   public int getNumStars(){
      return numStars;}
   public SkiResortPeople[] getSkiResortPeople(){
      return people;}

	//mutator
   public boolean setNumStars(int numStars){
      if(super.validateInt(numStars, MIN_STARS, MAX_STARS)){
         this.numStars = numStars;
         return true;
      }
      return false;
   }

   public void setSkiResortPeople(SkiResortPeople[] people){
      this.people = people;
   }
   
	//Special purpose method
   public double calculateCost(){
      double cost = numStars*BASE_PRICE;
      for(int i = 0; i < getNumFamilyMembers(); i++){
         if(people[i].getLessons()){
            cost+=LESSON_PRICE;
         }
      }
      return cost;
   }

   public String toString(){
      String message = super.toString();
      message += "\nNumber of Stars: " + numStars + "\nPeople attending:";
      for(int i = 0; i < getNumFamilyMembers(); i++){
         message += people[i].toString();
      }
      message += "\nCost: " + String.format("$%.2f", calculateCost()) + "\n";
      return message;
   }
}