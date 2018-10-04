

public class Node {

	Object data;
	Node link;


	public Node(Object data , Node link){
		this.data = data;
		this.link = link;
	}

	public Object getData() {
		return this.data;
	}

	public Node getNext(){
		return this.link;
	}

	public void setNext(Node link){
		this.link = link;
	}

	public void setData(Integer data){
		this.data = data;
	}


	public boolean hasNext(){
		if (link ==null ) return false;
		else return true;
	}


}
