//Beach House Vacation ddc
public class BeachHouseVacation extends Vacation{
	//constants
   public static final double LOW_BASE_COST = 196.0;
   public static final double MID_BASE_COST = 306.0;
   public static final double HIGH_BASE_COST = 524.0;
   public static final double HURRICAN_INSURANCE_1_5 = 9.5;
   public static final double HURRICAN_INSURANCE_6_10 = 4.75;
   public static final int INSURANCE_RATE_FAMILY_MEMBER_THRESHHOLD = 5;
   public static final int MID_MIN_FAMILY = 4;
   public static final int HIGH_MIN_FAMILY = 8;

	//variables
   private boolean insurance;
	
	//constructors
   public BeachHouseVacation(String name, String location, String zipcode, int numFamilyMembers, boolean hurricanInsurance){
      super(name, location, zipcode, numFamilyMembers);
      this.insurance = hurricanInsurance;
   }

	//accessors
   public boolean getInsurance(){
      return insurance;
   }
	
	//mutators
   public void setInsurance(boolean insurance){
      this.insurance = insurance;
   }

	//special purpose method
   public double calculateCost(){
      double cost = LOW_BASE_COST;
      if(super.getNumFamilyMembers() >= MID_MIN_FAMILY){
         cost = MID_BASE_COST;
         if(super.getNumFamilyMembers() >= HIGH_MIN_FAMILY){
            cost = HIGH_BASE_COST;
         }
      }
      if(insurance){
         for(int i = 0; i < super.getNumFamilyMembers(); i++){
            if(i < INSURANCE_RATE_FAMILY_MEMBER_THRESHHOLD){
               cost += HURRICAN_INSURANCE_1_5;
            }
            else{
               cost += HURRICAN_INSURANCE_6_10;
            }
         }
      }
      return cost;
   }

   public String toString(){
      String message = super.toString();
      if(insurance){
         message += "\nHurrican Insurance: Yes";
      }
      else{
         message += "\nHurrican Insurance: No";
      }
      message += "\nCost: " + String.format("$%.2f", calculateCost()) + "\n";
      return message;
   }
}