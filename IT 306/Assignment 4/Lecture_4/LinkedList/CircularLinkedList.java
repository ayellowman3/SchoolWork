package Lecture_4.LinkedList;


public class CircularLinkedList {
	private LNode head; 
	private LNode tail; 
	private int size; 
	
	
	public CircularLinkedList(){
		head= null; 
		tail = null; 
		size =0;
	}
	
	public void addToHead(LNode newNode){
		//adding to head:
		if(head==null){
			head = newNode; 
			tail = head;
		}
		else{
			//update head
			newNode.setNext(head); 
			tail.setNext(newNode); 
			head = newNode; 
		}
		size++; 
	}
	
	
	public void addToTail(LNode newNode){
		if(tail==null){
			tail = newNode; 
			head= tail; 
		}
		else{
			//update tail
			tail.setNext(newNode);
			newNode.setNext(head);
			tail = newNode;
		}
		size++;
	}
	
	
	public String display(){
		String out=""; 
		if (head==null) return null;
		LNode current = head; 
		do{
			out+=current.getData() +",";
			if (current==tail) break;
			current = current.getNext(); 
		}while(current!=null);
		return out;
	}
	
	public boolean isEmpty(){ return (head==null ? true : false); }
	public int getSize() { return size; }

	public void addToMiddle(LNode newNode){
		if(size == 0){
			addToHead(newNode);
		}
		else if(size == 1){
			if(head != null){
				addToHead(newNode);
			}
			else{
				addToTail(newNode);
			}
		}
		else{
			int counter = 0;
			int newIndex = size / 2;
			if(size % 2 == 0){
				newIndex--;
			}
			LNode node = head;
			while(counter < newIndex){
				node = node.getNext();
				counter++;
			}
			newNode.setNext(node.getNext());
			node.setNext(newNode);
		}
		size++;
	}
	
}