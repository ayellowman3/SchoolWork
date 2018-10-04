package Lecture_4.LinkedList;


public class TLinkedList {
	private TNode head; 
	private int size; 
	
	public TLinkedList(){size = 0;}
	
	public boolean isEmpty() {if (head==null) return true; else return false; }
	
	
	public TNode getHead(){
		return head;
	}

	public void setHead(TNode newHead){
		head = newHead;
	}
	
	
	/**
	 *This method adds nodes to the list and keeps the list sorted.
	 * @param node
	 */

	
	
	
	
	public Scientist remove(){ //return and remove the last element inside the linkedlist
		if(isEmpty()) return null;
		TNode curr = head; 
		TNode previous = head; 
		//if there is only one element in the linkedlist:
		if(!curr.hasNext()) {
			Scientist data = curr.getData(); 
			head= null; 
			return data; 
		}
		else{ //multiple elemets inside the linkedlist
			while(curr.hasNext()){
				previous = curr; 
				curr = curr.getNext(); 
			}
			Scientist data = curr.getData(); 
			previous.setNext(null);
			curr = null; 
			return data; 
		}
	}
	public void addFirst(TNode node){
		size++;
		if(head==null) head = node; //if the linkedlist is empty
		else{
			TNode curr = head; 
			//if there is only one node in the linkedlist:
			if(!curr.hasNext()) {
				curr.setNext(node);
				//curr= node; 
			}
			
			//if there are multiple nodes inside the linkedlist
			else{
				//we need a loop
				while(curr.hasNext()){
					curr = curr.getNext(); 
				}
				curr.setNext(node);
			}
		}
		
	}
	
	public int getSize(){ return size; }
	
	
	public Scientist elementAt(int i) {
		if(isEmpty()) return null; 
		if(i>size) return null; 
		int counter = 1; 
		TNode current = head; 
		while(current!=null) {
			if (i==counter) return current.getData(); 
			else {current = current.getNext(); counter++; }
		}
		return null;	
	}


	//add to a linked list in alphabetical order
	public void add(TNode node){ //this method adds new nodes while keeping the list sorted.
		if (isEmpty()) { //when the list is empty
			addFirst(node);
			return;
		}
				
		TNode current = head; 
		TNode previous = current;
		
		if(getSize()==1) { //when the list has only one node
			if(node.getData().getName().compareTo(current.getData().getName()) <= 0 ){
				node.setNext(current);
				head = node;
				size++; 
			}
			else {
				current.setNext(node);
				size++; 
			}
			return;
		}
		
		while(current!=null){ //when list has two or more nodes
			if(node.getData().getName().compareTo(current.getData().getName()) <= 0 ){
					if(previous == head) {  node.setNext(head);  head = node; return; }
					else {
						previous.setNext(node);
						node.setNext(current);
						size++;
						return;
					}		
			}
			
			previous = current; 
			current = current.getNext();
			
		}
		previous.setNext(node);
		size++;
	}

	//1a searches for node and removes it and returns it.
	public Scientist searchName(String nameR){
		TNode curr = head;
		TNode prev = head;

		while(curr != null){
			if(nameR.equalsIgnoreCase(curr.getName())){
				if(nameR.equalsIgnoreCase(prev.getName())){
					head = curr.getNext();
				}
				else{
					prev.setNext(curr.getNext());
				}
				return curr.getData();
			}
			prev = curr;
			curr = curr.getNext();
		}
		return null;
	}

	public Scientist searchName(TNode node){
		TNode curr = head;
		TNode prev = head;

		while(curr != null){
			if(node.getName().equalsIgnoreCase(curr.getName())){
				if(node.getName().equalsIgnoreCase(prev.getName())){
					head = curr.getNext();
				}
				else{
					prev.setNext(curr.getNext());
				}
				return curr.getData();
			}
			prev = curr;
			curr = curr.getNext();
		}
		return null;
	}
}