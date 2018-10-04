
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListQueue implements Iterable{
	//JAVA-LinkedList implementation of Queue.
	private LinkedList data;
	private Object head;
	private Object tail;
	public LinkedListQueue() {
		data= new LinkedList();
		head=null; tail = null;
	}

	public void add(Object x) {
		if(isEmpty()) {
			data.add(x); //Appends the specified element to the end (tail) of this list.
			tail = data.getLast();
			head= tail;
		}
		else {
			data.add(x); //Appends the specified element to the end (tail) of this list.
			tail = data.getLast();
		}

	}

	public Object remove() {
		if(data.isEmpty()) {
			throw new RuntimeException("QueueUnderflow!");
		}
		else {		Object out = head;
					data.removeFirst();
					if(!data.isEmpty()) head = data.getFirst();
					else head = null;
					return out;
		}

	}


	public boolean isEmpty() {
		return ( head==null ? true : false);
	}

	public Iterator iterator() {
		return data.iterator();
	}

	public Object element(){
		return head;
	}

}
