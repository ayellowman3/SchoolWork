package Lecture_4.LinkedList;


public class DoublyLinkedList {

	private DoublyLNode head;
	private DoublyLNode tail; 
	private int size; 
	
	public DoublyLinkedList(){
		head= null;
		tail = null;
		size=0;
	}
	
	public boolean isEmpty(){ return (head==null) ? true : false; }
	
	public void addToHead(DoublyLNode newNode){
		if(head==null) {
			head = newNode; 
			tail= head;
			size++;
		}
		else{
			newNode.setPrevious(null);
			newNode.setNext(head);
			head.setPrevious(newNode);
			head= newNode;
			size++;
		}
	}
	
	
	public void addToTail(DoublyLNode newNode){
		if(tail==null) {
			tail = newNode;
			head=tail; 
			size++;
		}
		else{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			size++;
		}
	}
	
	
	public boolean remove(String query){
		boolean flag=false; 
		if(size==0) return flag; 
		DoublyLNode current = head;
		do{
			if(current.getData().equals(query)){
				//remove current
				DoublyLNode prev = current.getPrevious(); 
				DoublyLNode next =current.getNext(); 
				prev.setNext(next);
				next.setPrevious(prev);
				current.setNext(null);
				current.setPrevious(null);
				current=null; 
				current = next;
				flag=true;
			}
			else{
				//go to the next element
				current = current.getNext(); 
			}
		}while(current!=null);
		return flag;
	}
	
	
	public String display(){
		String out="";
		DoublyLNode current =head;
		if (current ==null) return null;
		do{
			out+=current.getData()+","; 
			current=current.getNext(); 
		}while(current!=null);
		return out;
	}
	
	public DoublyLNode getHead(){
		return head;
	}

	public int indexOfElements(Scientist s){
		int counter = 0;
		DoublyLNode node = head;
		while(node != null){
			if(s.getName().equalsIgnoreCase(node.getName())){
				return counter;
			}
			counter++;
			node = node.getNext();
		}
		return -1;
	}
}