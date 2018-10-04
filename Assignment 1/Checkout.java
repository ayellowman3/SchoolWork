public class Checkout extends java.lang.Object{
	private DessertItem[] dessertList; //array to store dessert items
	private int count = 0; //count for number of dessert

	//@ghuang defalut contructor
	public Checkout(){
		dessertList = new DessertItem[50];
	}

	public Checkout(int i){
		dessertList = new DessertItem[i];
	}

	//@ghuang clear dessertList
	public void clear(){
		dessertList = new DessertItem[50];
		count = 0;
	}

	//@ghuang Entering Dessert items
	public void enterItem(DessertItem item){
		dessertList[count] = item;
		count++;
	}

	//@ghuang returns number of items ordered
	public int numberOfItems(){
		return count;
	}

	/*@ghuang create itemized receipt
	store name
	each item description, price
	tax
	total cost
	*/
	public String toString(){
		String s = "\n";
		//@ghuang addes store name to receipt
		s += "     " + DessertShoppe.STORE_NAME
		  + "\n     --------------------\n\n";
		//@ghuang loops through DessertItem array and get each item
		for(int i = 0; i < count; i++){
			s += getItemString(dessertList[i]);
		}
		//@ghuang addes tax
		s += "\nTax";
		//ghuang3 
		String tax = DessertShoppe.cents2dollarsAndCents(totalTax());
		s += getBlankSpace("Tax", tax);
		s += tax;
		s += "\nTotal Cost";
		String totalCost = DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax());
		s += getBlankSpace("Total Cost", totalCost);
		s += totalCost;

		return s;
	}

	/*@ghuang calculate final cost
	loops through each item to get total cost
	*/
	public int totalCost(){
		int cost = 0;
		for(int i = 0; i < count; i++){
			cost+=dessertList[i].getCost();
		}
		return cost;
	}
	
	//@ghuang calculates tax
	public int totalTax(){
		int cost = totalCost();
		double rawTax = cost * DessertShoppe.TAX_RATE / 100;
		int tax = (int)rawTax / 1;
		if(rawTax % 1 >= .5){
			tax += 1;
		}
		return tax;
	}

	/*@ghuang properly formate each item in receipt
	prints proper information for type of dessert
	for all, name and cost for each item
	*/
	public String getItemString(DessertItem d){
		String s = "";
		if(d instanceof Candy){
			double weight = ((Candy) d).getWeight();
			double digit = weight * 100;
			s += weight;
			if(digit % 10 == 0){
				s += "0";
			}
			s += " lbs. @ "
				+ DessertShoppe.cents2dollarsAndCents(((Candy) d).getPrice())
				+ " /lb.\n";
		}
		else if(d instanceof Cookie){
			s += ((Cookie) d).getNumOfCookies()
				+ " @ "
				+ DessertShoppe.cents2dollarsAndCents(((Cookie) d).getPrice())
				+ " /dz.\n";
		}
		else if(d instanceof Sundae){
			s += ((Sundae) d).getTopping() + " Sundae with\n";
		}
		else{
			//should never reach here.
		}

		s += d.getName();
			double price = d.getCost();
			String stringPrice = "" + price / 100;
			if(price % 10 == 0){
				stringPrice += "0";
			}
			s += getBlankSpace(d.getName(), stringPrice);
			s += stringPrice + "\n";
		return s;
	}

	//@ghuang format blankspace in receipt for price to allign on right side

	public String getBlankSpace(String name, String price){
		int width = 31;
		width = width - name.length();
		width = width - price.length();
		String blank = "";
		for(int i = 0; i < width; i++){
			blank += " ";
		}
		return blank;
	}
}