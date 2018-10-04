
//linkedlist implementation of Queue developed from scratch.
import java.util.NoSuchElementException;

public class Queue {

	private Node head;
	private Node tail;

	public Queue(){
		head = null;
		tail = null;
	}

	public boolean isEmpty() {  return (head==null)? true : false; }

	public void add (Object x){
		Node node = new Node(x,null);
		if(this.isEmpty()){
			tail = node;
			tail.setNext(null);
			head= tail;
		}
		else{
			tail.setNext(node);
			tail = node; //updating the tail
		}
	}


	public Object remove(){
		if(this.isEmpty()) return null;
		else{
			Object out = head.getData();
			Node oldHead = head;
			head = head.getNext();  //updating the head
			oldHead.setNext(null);
			oldHead=null;
			return out;
		}
	}

	public Object element(){
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		return head.getData();
	}
}
