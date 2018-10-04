package Lecture_4.LinkedList;

//import java.util.LinkedList;

public class TestTLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//LinkedList<Scientist> list1 = new LinkedList<Scientist>();
		
		TNode n1 = new TNode(new Scientist("Tom"), null);
		TNode n2 = new TNode(new Scientist("Tim"), null);
		TNode n3 = new TNode(new Scientist("Mary"), null);
		TNode n4 = new TNode(new Scientist("Jack"), null);
		TLinkedList list = new TLinkedList(); 
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		
		while(!list.isEmpty()){
			System.out.println(list.remove());
		}
	}

}