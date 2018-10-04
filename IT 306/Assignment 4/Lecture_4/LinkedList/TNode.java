package Lecture_4.LinkedList;

public class TNode {
	
	private Scientist data; 
	private TNode next; //link
	
	public TNode(Scientist data, TNode next){
		this.data = data; 
		this.next = next; 
	}
	
	public void setData(Scientist data) { this.data = data; }
	public void setNext(TNode next){ this.next = next; }
	public Scientist getData(){return data; }
	public TNode getNext() { return next; }
	public boolean hasNext() { 
		if (next!=null) return true; 
		else return false; 
	}

	public String getName(){
		return data.getName();
	}
	
}