
public class TestQueue {

			public static void main(String[] args) {
				ArrayQueue q1 = new ArrayQueue();
				q1.add("a");
				q1.add("b");
				q1.add("c");
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				System.out.println(q1.offer(new Double(3.1)));
				while(!q1.isEmpty()){
					System.out.println(q1.remove());
				}
				//________________________________
				System.out.println("\n\n");

				Queue q2 = new Queue();
				q2.add('(');
				q2.add('*');
				q2.add(')');

				while(!q2.isEmpty()){
					System.out.println(q2.remove());
				}
				//________________________________
				System.out.println("\n\n");

				LinkedListQueue q3 = new LinkedListQueue();
				q3.add(new Double(4.0));
				q3.add(new Double(3.8));
				q3.add(new Double(3.2));


				while(!q3.isEmpty()){
					System.out.println(q3.remove());
				}
	}
}
