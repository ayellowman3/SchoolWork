

import java.util.Iterator;
import java.util.LinkedList;
import java.util.EmptyStackException;

import javax.management.RuntimeErrorException;


public class LinkedListStack implements Iterable{
	//JAVA-LinkedList implementation of Stack.
	private LinkedList data;
	private Object top;
	public LinkedListStack() {
		data= new LinkedList();
		top=null;
	}

	public void push(Object x) {
		data.add(x);
		top = data.getLast();
	}

	public Object pop() {
		if(data.isEmpty()) {
			throw new RuntimeException("StackUnderflow!");
		}
		else {		Object out = top;
					data.removeLast();
					if(!data.isEmpty()) top = data.getLast();
					else top = null;
					return out;
		}

	}


	public boolean isEmpty() {
		return ( top==null ? true : false);
	}

	public Iterator iterator() {
		return data.iterator();
	}

	public Object peek(){
		if(data.isEmpty())
			throw new EmptyStackException();
		else{
			return top;
		}
	}

	public int search(Object o){
		if(data.isEmpty()){
			throw new RuntimeException("StackUnderflow!");
		}
		int counter = 1;
		/*Iterator n = iterator();
		System.out.println(n.next());
		while(n.hasNext()){
			//System.out.println(n.next());
			if(n.next().equals(o)){
				return counter;
			}
			counter++;
		}*/
		return (data.size() - data.indexOf(o));
	}
}
