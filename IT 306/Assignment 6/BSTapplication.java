

import javax.swing.JOptionPane;

public class BSTapplication {
	//TODO  Try inserting 5,2,-4,3,12,9,21,19
	//TODO search for -4
	//TODO delete 12, 19,-4
	//TODO traverse from the very root

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String menu= "1- Insert \n2- Delete \n3- Search \n4- Traverse \n5- Exit.";
		int choice=0;
		BinarySearchTree bst = new BinarySearchTree();
		do{
			try{
				choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Enter an Integer between 1-5");
			}
			switch(choice){
			case 1:
				try{
					TreeNode p = new TreeNode(Double.parseDouble(JOptionPane.showInputDialog("Enter a numeric double value to insert into the tree")));
					bst.add(p);
					break;
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "wrong format! Please try again.");
					break;
				}

			case 2:
				double num = Double.parseDouble(JOptionPane.showInputDialog("Enter a numeric double value to delete from the tree"));
				bst.delete(num, bst.root());
				break;
			case 3:
				double q = Double.parseDouble(JOptionPane.showInputDialog("Enter a numeric double value to search in the tree"));
				TreeNode found = bst.search(q, bst.root());
				JOptionPane.showMessageDialog(null, found!=null );
				break;
			case 4:
				int t = Integer.parseInt(JOptionPane.showInputDialog("Indicate the traversal method by inserting the corresponding number: "+
			BinarySearchTree.TRAVERSAL[0] + ", " + BinarySearchTree.TRAVERSAL[1] + ", "+ BinarySearchTree.TRAVERSAL[2] ));
				JOptionPane.showMessageDialog(null, bst.traverse(t, bst.root()));
				break;
			case 5:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, menu);
			}


		}while(choice!=5);

	}

}
