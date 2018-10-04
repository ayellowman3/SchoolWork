import java.util.*;

public class UnsortedPriorityQueue<K, V>  {

	private K queue;
	private V value;

	public UnsortedPriorityQueue(){
		this.queue = null;
	}

	public void add(K queue, V value){
		this.queue = queue;
		this. value = value;
	}
/*
	public PQEntry removeMin(){
		if(queue.isEmpty()){
			System.out.println("The queue is empty.");
			return null;
		}
		else{
			int min = 0;
			for(int i= 1; i<queue.size(); i++){
				if(queue.get(min).getKey() > queue.get(i).getKey())
					min =i;
				else if(queue.get(min).getKey() == queue.get(i).getKey()){
					if(min>i) min = i;
				}

			}

			PQEntry minEntry = queue.get(min);
			queue.remove(min);
			return minEntry;
		}

	}

	public boolean isEmpty(){
		return queue.isEmpty();
	}

	public int size(){
		return queue.size();
	}

*/
}
