

//Array implementation of Queue

public class ArrayQueue {
	private Object [] data;
	private int manyItems;

	public ArrayQueue(){
		final int INITIAL_CAPACITY = 10;
		manyItems=0;
		data = new Object[INITIAL_CAPACITY];
	}

	public ArrayQueue(int initialCapacity){
		if(initialCapacity < 0 )
			throw new IllegalArgumentException("initialCapacity too small "+initialCapacity);
		manyItems = 0;
		data = new Object[initialCapacity];
	}


	public void ensureCapacity(int minimumCapacity){
		Object[] biggerArray;

		if(data.length < minimumCapacity){
			biggerArray = new Object[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}

	public int getCapacity(){
		return data.length;
	}

	public boolean isEmpty(){
		return (manyItems==0);
	}

	public Object element(){ //returns the head element in the queue, but does not remove the head element.
		if(manyItems ==0)
			throw new RuntimeException("QueueUnderflow");
		return data[manyItems-1];
	}

	public Object remove(){
		if(manyItems==0) return null;
		Object out = data[0];
		data = shiftLeft(data);
		manyItems--;
		return out;
	}

	public Object[] shiftLeft(Object[] arr) {
		int i=0;
		for(i=0; i<manyItems-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[manyItems-1] = null;
		return arr;
	}

	public void add (Object item){
		if(manyItems == data.length){
			ensureCapacity(manyItems*2+1);
		}
		data[manyItems] = item;
		manyItems++;
	}

	public int size(){ return manyItems; }

	public void trimToSize(){
		Object[] trimmedArray;

		if(data.length != manyItems){
			trimmedArray =  new Object[manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;
		}
	}

	public boolean offer(Object e){
		if(this.size() < this.getCapacity()){
			this.add(e);
			return true;
		}
		return false;
	}
}
