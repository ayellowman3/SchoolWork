/*
 * In this file, do the following things:
 * 1) Modify the class so that it inherits from Product 
 * 2) Create a constructor that takes in a DVD title, DVD cost, and DVD genre
 * 3) Override the getCost() method by adding the DVD handling fee to the cost calculated for a Product
 */
 

public class DVD extends Product{
   public static final double HANDLING_FEE = 1.00;
   private String genre;

   public DVD(String title, double cost, String genre){
   	super(title, cost);
   	this.genre = genre;
   }

   public String getGenre() {
      return this.genre;
   }
   public double getCost(){
   	return super.getCost()+ 1.0;
   }

   public String toString() {
      return "\nGenre: " + getGenre();
   }    
}