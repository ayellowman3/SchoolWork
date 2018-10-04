//inherit dessert item
public class IceCream extends DessertItem{
	private double cost; //cost of ice cream
	
	//@ghuang defautl contructor
	public IceCream(){
		super();
	}

	public IceCream(String name, int cost){
		super(name);
		this.cost = cost;
	}

	//@ghuang returns cost
	public double getCost() {
		return cost;
	}
}