//inherit ice cream
//hi
public class Sundae extends IceCream{
	private int toppingCost; //topping cost
	private String topping; // topping name

	//@ghuang defualt constructor
	public Sundae(){
		super();
	}

	public Sundae(String name, int cost, String topping, int toppingCost){
		super(name, cost);
		this.toppingCost = toppingCost;
		this.topping = topping;
	}

	//@ghuang get topping cost
	public int getToppingCost(){
		return toppingCost;
	}

	//@ghuang get topping name
	public String getTopping(){
		return topping;
	}

	//@ghuang get ice cream + topping cost
	public double getCost(){
		return super.getCost() + toppingCost;
	}
}