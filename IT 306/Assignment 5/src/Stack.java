

//linkedlist implementation of Stack developed from scratch.
import java.util.EmptyStackException;

public class Stack {

	private Node top;

	public Stack(){
		top = null;
	}

	public boolean isEmpty() {  return (top==null)? true : false; }

	public void push(Object x){
		Node node = new Node(x,null);
		if(this.isEmpty()){
			top = node;
			top.setNext(null);
		}
		else{
			node.setNext(top);
			top = node;
		}
	}


	public Object pop(){
		if(this.isEmpty()) return -1;
		else{
			Object out = top.getData();
			Node oldTop = top;
			top = top.getNext();
			oldTop.setNext(null);
			oldTop=null;
			return out;
		}
	}

	public Object peek(){
		if(this.isEmpty())
			throw new EmptyStackException();
		else{
			Object out = top.getData();
			return out;
		}
	}

	public int search(Object o){
		int tracker = 1;
		if(this.isEmpty()) return -1;
		Node n = top;
		while(n != null){
			if(n.getData().equals(o)){
				return tracker;
			}
			n = n.getNext();
			tracker++;
		}
		return -1;
	}
}
