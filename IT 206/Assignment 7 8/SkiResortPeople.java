//Ski resort people - DDC

public class SkiResortPeople{
	//Variables
   private String name;
   private boolean lessons;

	//Constructor
   public SkiResortPeople(String name, boolean lessons){
      this.name = name;
      this.lessons = lessons;
   }

	//accessor
   public String getName(){
      return name;}
   public boolean getLessons(){
      return lessons;}

	//mutator
   public boolean setName(String name){
      if(validateString(name)){
         this.name = name;
         return true;
      }
      else{
         return false;
      }
   }
   public void setLessons(boolean lessons){
      this.lessons = lessons;
   }

	//validaton
   public boolean validateString(String name){
      return(!name.equals(""));
   }
	
	//special purpose method
   public String toString(){
      String message = "\n   name: " + name + "   Lessons: ";
      if(lessons){
         message+= "Yes";
      }
      else{
         message+="No";
      }
      return message;
   }
}