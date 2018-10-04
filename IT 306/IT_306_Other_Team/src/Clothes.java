public class Clothes extends Item{
	String brand;
	String color;
	int s;
	int m;
	int l;
	int xl;
	
	public Clothes(){

	}

	public Clothes(double price, int quantity, int sold, String brand, String color, int s, int m, int l, int xl){
		super(price, quantity, sold);
		this.brand = brand;
		this.color = color;
		this.s = s;
		this.m = m;
		this.l = l;
		this.xl = xl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getXl() {
		return xl;
	}

	public void setXl(int xl) {
		this.xl = xl;
	}

	@Override
	public String toString() {
		return "Clothes [brand=" + brand + ", color=" + color + ", s=" + s + ", m=" + m + ", l=" + l + ", xl=" + xl
				+ super.toString() + "]";
	}
	
	
}