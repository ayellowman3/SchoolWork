package Lecture_4.LinkedList;


import javax.swing.JOptionPane;

public class Test_Circular_LinkedList {
	
	public static void main(String args[]){
		CircularLinkedList clist = new CircularLinkedList(); 
		String menu = "1- Add to head\n2-Add to tail\n3- Display values\n4- Exit."; 
		int choice; 
		do{
			choice =Integer.parseInt(JOptionPane.showInputDialog(menu)); 
			switch(choice){
			case 1:
				clist.addToHead(new LNode(Integer.parseInt(JOptionPane.showInputDialog("Enter an integer value")), null)); 
				break;
			case 2:
				clist.addToTail(new LNode(Integer.parseInt(JOptionPane.showInputDialog("Enter an integer value")), null)); 
				break;
			case 3:
				JOptionPane.showMessageDialog(null, clist.display()); 
				break;
			case 4:
				System.exit(0); 
			}
		}while(choice!=4);
	}

}