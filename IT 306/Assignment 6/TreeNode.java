

public class TreeNode {
	private double element; //this is data
	private TreeNode parent; //represents the link to the parent node

	private TreeNode left;
	private TreeNode right;

	private int numChild;

	public TreeNode(){ numChild=0; }

	public TreeNode(double element){
		numChild=0;
		this.element = element;
	}

	public void setElement(double element){
		this.element = element;
	}


	public void setLeft(TreeNode l){
		if(left==null){
			numChild++;
		}
		left = l;
	}

	public void setRight(TreeNode r){
		if(right==null){
			numChild++;
		}
		right = r;
	}

	public TreeNode getRight() {return right; }
	public TreeNode getLeft() {return left; }

	public double getElement() { return element; }

	public void setParent(TreeNode parent){
		this.parent = parent;
	}

	public TreeNode getParent(){ return parent; }

	public int getNumChildren() { return numChild; }

	public String toString() {
		return String.valueOf(this.getElement());
	}

}
