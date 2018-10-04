package Lecture_4.LinkedList;


public class Test_DoublyLinkedList {

	public static void main(String[] args){
		Scientist s1 = new Scientist("Tom");
		Scientist s2 = new Scientist("Tim");
		Scientist s3 = new Scientist("Mary");
		Scientist s4 = new Scientist("Jack");
		DoublyLinkedList dlist = new DoublyLinkedList(); 
		dlist.addToHead(new DoublyLNode(s1, null, null));
		dlist.addToHead(new DoublyLNode(s2, null, null));
		dlist.addToHead(new DoublyLNode(s3, null, null));
		dlist.addToHead(new DoublyLNode(s4, null, null));
		
		System.out.println(dlist.display());
		System.out.println(dlist.indexOfElements(s3));
		System.out.println(dlist.display());
	}
}