public class BakeryProduct
{  
   //static variable
   public static final double maxCost = 5.00;
   public static final int maxQuantity = 50;
   
   //instance variable
   private String description;
   private double cost;
   private int quantity;
   
   //constructor
   public BakeryProduct()
   {
      this("cupcakes", 2.00, 50);
   }
   
   public BakeryProduct(String aDescription, double aCost, int aQuantity)
   {
      this.description = aDescription;
      this.cost = aCost;
      this.quantity = aQuantity;
   }
   
   //accessor
   public BakeryProduct(String description)
   {
      this(description, maxCost, maxQuantity);
   }
   
   public String getDescription()
   {
      return this.description;
   }
   public double getCost()
   {
      return this.cost;
   }
   public int getQuantity()
   {
      return this.quantity;
   }
   
   //mutator
   public void setDescription(String sDes)
   {
      this.description = sDes;
   }
   public boolean setCost(double sCost)
   {
      if(sCost >= 0 && sCost <= maxCost)
      {   
         this.cost = sCost;
         return true;
      }
      return false;
   }
   public boolean setQuantity(int sQuant)
   {
      if(sQuant >= 0 && sQuant <= maxQuantity)
      {
         this.quantity = sQuant;
         return true;
      }
      return false;
   }
   
   //special purpose
   public boolean sell(int sellQuant)
   {
      if(sellQuant > quantity || sellQuant <= 0)
      {
         return false;
      }
      quantity =- sellQuant;
      return true;
   }
}