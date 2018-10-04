

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTests {

	@Test
	public void insert(){
		BinarySearchTree tester = new BinarySearchTree();
		tester.add(new TreeNode(5));
		tester.add(new TreeNode(2));
		tester.add(new TreeNode(-4));
		tester.add(new TreeNode(3));
		tester.add(new TreeNode(12));
		tester.add(new TreeNode(9));
		tester.add(new TreeNode(21));
		tester.add(new TreeNode(19));
		assertEquals("Testing add: size of BST must be 8", 8, tester.getSize());
		tester.delete(-4, tester.root());
		tester.delete(9, tester.root());
		tester.delete(12, tester.root());
		assertEquals("Testing delete: size of BST must be 5", 5, tester.getSize());

	}


}
