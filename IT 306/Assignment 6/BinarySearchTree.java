

import java.util.*;

public class BinarySearchTree implements Iterable {

	private class PositionIterator implements Iterator{
		private int current;
		private List<TreeNode> array;

		public PositionIterator(List<TreeNode> array) {
			this.array = array;
			current = 0;
		}

		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current <  array.size()) return true;
			else return false;
		}

		public TreeNode next() {
			return array.get(current++);
		}

		public void remove() {
			System.err.println("This method is currently disfunctinal.");
		}

	}

	private List<TreeNode> positions;
	private TreeNode root;
	private int size;
	public static final String[] TRAVERSAL = {"LrR-1" , "rLR-2" , "LRr-3"};





	public BinarySearchTree(){
		size =0;
		positions = new LinkedList<TreeNode>();
	}

	public boolean isEmpty() { return (root==null) ?true:false; }

	public TreeNode root() { return root; }


	/**
	 * returns the parent of p, or null if p is the root
	 * @param node
	 * @return
	 */
	public TreeNode parent(TreeNode p){
		if (p==root) return null;
		else return p.getParent();
	}


	/**
	 * returns true if p has at least one child
	 * @param p
	 * @return
	 */
	public static boolean isInternal(TreeNode p){
		if(p.getNumChildren()==0) return false;
		else return true;
	}


	/**
	 *  returns true if p does not have any children
	 * @param p
	 * @return
	 */
	public static boolean isExternal(TreeNode p){
		if (p.getNumChildren()==0) return true;
		else return false;
	}


	public boolean isRoot(TreeNode p) {
		if (p==root) return true;
		else return false;
	}


	public static TreeNode getLeftChild(TreeNode p) throws IllegalArgumentException{
		return p.getLeft();
	}


	public static TreeNode getRightChild (TreeNode p) throws IllegalArgumentException {
		return p.getRight();
	}


	/**
	 * Inserts a node into a BST according to the insertion rule
	 * @param p
	 * @throws IllegalArgumentException
	 */
	public void add(TreeNode p) throws IllegalArgumentException{
		size++;
		positions.add(p);
		insert(p, root());
	}

	public int getSize() { return size; }

	private void insert(TreeNode p , TreeNode root )throws IllegalArgumentException{
		if(this.root==null) {
			this.root =p;
			return;
		}
		else if(p.getElement() <= root.getElement()){
			if(root.getLeft()==null) {
				root.setLeft(p);
				p.setParent(root);
				return;
			}
			else insert(p, root.getLeft());
		}
		else if(p.getElement() > root.getElement()){
			if(root.getRight()==null){
				root.setRight(p);
				p.setParent(root);
				return;
			}
			else insert (p, root.getRight());
		}
	}


	/**
	 *
	 * @param p : The node to be deleted from the BST subtree
	 * @param root : The root of the subtree
	 * @return
	 */
	public boolean delete(double p, TreeNode root){
		if(isEmpty()) return false;
		TreeNode found = search(p , root());
		if(found!=null) {
			size--;
			if(isExternal(found)){
				//leaf node
				TreeNode parent = found.getParent();
				if(parent!=null){
					if(parent.getLeft().getElement()== found.getElement()){
						//it is the left child
						parent.setLeft(null);
						found = null;
						return true;
					}
					else{
						//it is the right child
						parent.setRight(null);
						found = null;
						return true;
					}
				}
				else{
					found = null;
					return true;
				}
			}
			else {
				if(found.getNumChildren()==1){
					TreeNode parent = found.getParent();
					if(parent!=null){
						if(parent.getLeft()==found){
							//found is the left child of parent
							if(found.getLeft()==null){
								//found has one right child
								parent.setLeft(found.getRight());
								found.getRight().setParent(parent);
								found = null;
								return true;
							}
							else{
								//found has one right child
								parent.setLeft(found.getLeft());
								found.getLeft().setParent(parent);
								found = null;
								return true;
							}
						}
						else if(parent.getRight()==found){
							//found is the right child of parent
							if(found.getRight()==null){
								//found has one right child
								parent.setRight(found.getLeft());
								found.getLeft().setParent(parent);
								found = null;
								return true;
							}
							else{
								//found has one right child
								parent.setRight(found.getRight());
								found.getRight().setParent(parent);
								found = null;
								return true;
							}
						}

					}
				}
				else if(found.getNumChildren()==2){
					//1-Find the minimum node in the right sub-tree of the node that must be removed.
					TreeNode min = findMin(found.getRight());
					//2-Replace that minimum node with the node to be removed.
					found.setElement(min.getElement());
					//3-Remove the node duplicate from its prior location.
					TreeNode parent = min.getParent();
					if(parent.getLeft()==min) parent.setLeft(null);
					else parent.setRight(null);
					min = null;
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Returns the node with the minimum value in a given sub-tree
	 * @param root
	 * @return
	 */
	private TreeNode findMin(TreeNode root){
		if(root ==null) return null;
		TreeNode min = root;
		if(root.getNumChildren()==0) return min;
		else{
			if(root.getLeft()!=null){
				TreeNode temp = findMin(root.getLeft());
				if(temp.getElement()<min.getElement()) min = temp;
			}

			if(root.getRight()!=null){
				TreeNode temp = findMin(root.getRight());
				if(temp.getElement()<min.getElement()) min = temp;
			}

			return min;
		}
	}

	/**
	 * Searches for node p in subtree determined by the root variable
	 * @param p
	 * @param root
	 * @return
	 */
	public TreeNode search(double p, TreeNode root){
		if(root==null) 	return null;
		if(root.getElement()== p )
			return root;
		else if(p <= root.getElement()){
			return search(p, root.getLeft());
		}
		else if(p > root.getElement()){
			return search (p, root.getRight());
		}
		return null;
	}


	public String traverse(int ix , TreeNode p) {
		String traversal = TRAVERSAL[ix-1];
		System.out.println(traversal + " taversal starts....");
		if(ix-1 == 0) return inorder(p);
		else if (ix-1 == 1) return preorder(p);
		else if (ix-1 == 2) return postorder(p);
		else throw new IllegalArgumentException();

	}

	/**
	 * traverses and prints the subtree in the order of left -root-right
	 * @param p
	 */
	public String inorder(TreeNode p){
		if(p==null) return "Empty!";
		String left_subtree="";
		String right_subtree="";
		if(p.getLeft()!=null) left_subtree= inorder(p.getLeft());
		String middle = p.getElement() + ", ";
		if(p.getRight()!=null) right_subtree = inorder(p.getRight());
		return left_subtree+middle + right_subtree;
	}


	/**
	 * traverses and prints the subtree in the order of root -left-right
	 * @param p
	 */
	public String preorder(TreeNode p){
		if(p==null) return "Empty!";
		String left_subtree="";
		String right_subtree="";
		String middle = p.getElement() + ", ";
		if(p.getLeft()!=null) left_subtree = preorder(p.getLeft());
		if(p.getRight()!=null) right_subtree = preorder(p.getRight());
		return middle+left_subtree + right_subtree;
	}


	public String postorder(TreeNode p){
		//TODO: recursively traverse the tree postorder and print the node by calling "task(...)" method
		if(p==null) return "Empty!";
		String left_subtree="";
		String right_subtree="";
		//gets the left element, then right before middle
		if(p.getLeft()!=null) left_subtree = preorder(p.getLeft());
		if(p.getRight()!=null) right_subtree = preorder(p.getRight());
		String middle = p.getElement() + ", ";
		return left_subtree + right_subtree + middle;
	}


	public void task(TreeNode p){
		System.out.println(p);
	}

	/**
	 * returns the depth of a BST
	 * @param p
	 * @return
	 */
	public int depth(TreeNode p){
		if (p==root) return 0;
		else return 1+ depth(p.getParent());
	}


	/**
	 * Returns the height of a BST
	 * @return
	 */
	public int getHeight(){
		int h=0;
		for(TreeNode p:positions){
			if(isExternal(p)){
				h = Math.max(h, depth(p));
			}
		}
		return h;
	}

	public Iterator iterator() {
		PositionIterator it = new PositionIterator(positions);
		return it;
	}



}
