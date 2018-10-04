//inherit dessert item
public class Cookie extends DessertItem{
	private int price; //cost per dozen cookies
	private int numOfCookies; // number of cookies

	//default constructor
	public Cookie(){
		super();
	}

	public Cookie(String name, int numOfCookies, int price){
		this();
		this.name = name;
		this.price = price;
		this.numOfCookies = numOfCookies;
	}

	//@ghuang gets price of cookies
	public int getPrice(){
		return price;
	}

	//@ghuang gets number of cookies
	public int getNumOfCookies(){
		return numOfCookies;
	}

	//@ghuang gets total cost of cookies, price per dozen
	public double getCost() {
		double rawCost = price * numOfCookies;
		rawCost = rawCost / 12;
		double cost = rawCost;
		return cost;
	}	
}