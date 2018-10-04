public abstract class Item{
	private static int count = 0;

	private double cost;
	private int quantity;
	private int numItemSold;

	public Item(){
		count++;
	}

	public Item(double cost, int quantity, int numItemSold){
		this();
		this.cost = cost;
		this.quantity = quantity;
		this.numItemSold = numItemSold;
	}

	public static int getCount(){
		return count;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumItemSold() {
		return numItemSold;
	}

	public void setNumItemSold(int numItemSold) {
		this.numItemSold = numItemSold;
	}

	@Override
	public String toString() {
		return "Item [cost=" + cost + ", quantity=" + quantity + ", numItemSold=" + numItemSold + "]";
	}
	
}