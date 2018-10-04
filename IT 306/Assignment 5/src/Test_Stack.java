

public class Test_Stack {

	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push(new Double(4.0));
		s1.push(new Double(3.8));
		s1.push(new Double(3.2));

		while(!s1.isEmpty()){
			System.out.println(s1.pop());
		}
		//________________________________
		System.out.println("\n\n");

		LinkedListStack s2 = new LinkedListStack();
		s2.push(new String ("Sam"));
		s2.push(new String("Tom"));
		s2.push(new String("Ben"));

		while(!s2.isEmpty()){
			System.out.println(s2.pop());
		}

		//________________________________
		System.out.println("\n\n");

		ArrayStack s3 = new ArrayStack();
		s3.push(new Character ('('));
		s3.push(new Character('*'));
		s3.push(new Character(')'));

		while(!s3.isEmpty()){
			System.out.println(s3.pop());
		}

		//________________________________
	}
}
