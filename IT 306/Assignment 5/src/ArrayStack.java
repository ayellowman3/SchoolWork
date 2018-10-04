

import java.util.EmptyStackException;

//Array implementation of Stack

public class ArrayStack {
	private Object [] data;
	private int manyItems;

	public ArrayStack(){
		final int INITIAL_CAPACITY = 10;
		manyItems=0;
		data = new Object[INITIAL_CAPACITY];
	}

	public ArrayStack(int initialCapacity){
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

	public Object peek(){ //returns the top element in the stack, but does not remove that element.
		if(manyItems ==0)
			throw new  EmptyStackException();
		return data[manyItems-1];
	}

	public Object pop(){
		if(manyItems==0)
			throw new EmptyStackException();
		return data[--manyItems];
	}

	public void push(Object item){
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

	public int search(Object o){
		for(int i = manyItems - 1; i > -1; i--){
			if(data[i].equals(o)){
				return manyItems - i;
			}
		}
		return -1;
	}
}
