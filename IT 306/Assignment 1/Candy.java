//inherit dessert item
public class Candy extends DessertItem{
	private double weight; //weight of candy
	private int price; //price of candy

	//@ghuang defualt constructor
	public Candy(){
		super();
	}

	public Candy(String name, double weight, int price){
		this();
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	
	//@ghuang3 returns price of candy
	public int getPrice(){
		return price;
	}

	//@ghuang3 returns weight of candy
	public double getWeight(){
		return weight;
	}

	//@ghuang returns total cost of candy, weight times price
	public double getCost(){
		double rawCost = price * weight;
		double rawCostRound = rawCost % 1;
		if(rawCostRound >= 0.5){
			rawCost += 1;
		}
		double cost = rawCost - rawCostRound;
		return cost;
	}
}