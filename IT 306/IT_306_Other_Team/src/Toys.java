public class Toys extends Item{
	String name;
	int min_age;
	int max_age;

	public Toys(){

	}

	public Toys(double cost, int quantity, int sold, String name, int min_age, int max_age){
		super(cost, quantity, sold);
		this.name = name;
		this.min_age = min_age;
		this.max_age = max_age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMin_age() {
		return min_age;
	}

	public void setMin_age(int min_age) {
		this.min_age = min_age;
	}

	public int getMax_age() {
		return max_age;
	}

	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}

	@Override
	public String toString() {
		return "Toys [name=" + name + ", min_age=" + min_age + ", max_age=" + max_age + super.toString() + "]";
	}
	
	
}