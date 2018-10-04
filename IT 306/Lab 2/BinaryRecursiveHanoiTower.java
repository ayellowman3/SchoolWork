
import java.util.Stack;

public class BinaryRecursiveHanoiTower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> sourceCpy = new Stack<Integer>();

		for (int i=4; i>=1; i--){
			source.add(i);
		}

		sourceCpy = (Stack<Integer>) source.clone();

		System.out.println("Source:");
		while(!sourceCpy.isEmpty())
			System.out.println(sourceCpy.pop() );
		System.out.println("Destination:");
		if(!destination.isEmpty())
			while(!destination.isEmpty())
				System.out.println(destination.pop() );
		else System.out.println("destination is empty.");


		hanoi(4,source,temp, destination);

		System.out.println("\n\n");

		System.out.println("Source:");
		if(!sourceCpy.isEmpty())
			while(!sourceCpy.isEmpty())
				System.out.println(sourceCpy.pop() );
		else
			System.out.println("Source is empty.");

		System.out.println("Destination:");
		while(!destination.isEmpty())
			System.out.println(destination.pop() );
	}


	//Tansfers the content of source to dest preserving the order.
	//n is the number of elements in source.
	public static void hanoi(int n, Stack<Integer> source , Stack<Integer> temp
			, Stack<Integer> dest){

		if(n<=0) return; //illegal case

		hanoi((n-1), source, dest ,temp );
		dest.push(source.pop()); //base case
		hanoi((n-1) , temp , source, dest);
	}

}
