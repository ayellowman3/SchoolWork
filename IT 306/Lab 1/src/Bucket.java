public class Bucket {
	private Voter[] elements; 
	private int key;
	private int num; 
	
	public Bucket(int n , int k){
		elements = new Voter[n];
		key = k;
	}
	public void add(Voter v){
		if(num<elements.length)
			elements[num++] = v;
		else
			System.out.println("This is not the right bucket.");
	}
	
	public Voter[] getElement(){
		return elements;
	}
	
	public int getKey(){
		return key;
	}
	
	
	public int getSize(){
		return num;
	}

}
