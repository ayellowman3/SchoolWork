

public class Tester{
    public static void main(String[] args){
        System.out.println("hi");
        Stack s1 = new Stack();
		s1.push(new Double(4.0));
		s1.push(new Double(3.9));
		s1.push(new Double(3.8));
        s1.push(new Double(3.7));
		s1.push(new Double(3.6));
		s1.push(new Double(3.5));
        s1.push(new Double(3.4));
		s1.push(new Double(3.3));
		s1.push(new Double(3.2));
        s1.push(new Double(3.1));
		s1.push(new Double(3.0));
		s1.push(new Double(2.9));

        System.out.println("peek");
        System.out.println(s1.peek());

        System.out.println("\nSearch");
        System.out.println(s1.search(2.9) + "//1");
        System.out.println(s1.search(3.0) + "//2");
        System.out.println(s1.search(3.1) + "//3");
        System.out.println(s1.search(3.2) + "//4");
        System.out.println(s1.search(3.3) + "//5");
        System.out.println(s1.search(3.4) + "//6");
        System.out.println(s1.search(3.5) + "//7");
        System.out.println(s1.search(3.6) + "//8");
        System.out.println(s1.search(3.7) + "//9");
        System.out.println(s1.search(3.8) + "//10");
        System.out.println(s1.search(3.9) + "//11");
        System.out.println(s1.search(4.0) + "//12");

		while(!s1.isEmpty()){
			System.out.println(s1.pop());
		}
		//________________________________
		System.out.println("\n\n");

		LinkedListStack s2 = new LinkedListStack();
		s2.push(new String("Sam"));
		s2.push(new String("Tom"));
		s2.push(new String("Ben"));
        s2.push(new String("Sam1"));
		s2.push(new String("Tom1"));
		s2.push(new String("Ben1"));
        s2.push(new String("Sam2"));
		s2.push(new String("Tom2"));
		s2.push(new String("Ben2"));
        s2.push(new String("Sam3"));
		s2.push(new String("Tom3"));
		s2.push(new String("Ben3"));

        System.out.println(s2.peek());

        System.out.println("Search");
        System.out.println(s2.search("Ben3") + "//1");
        System.out.println(s2.search("Tom3") + "//2");
        System.out.println(s2.search("Sam3") + "//3");
        System.out.println(s2.search("Ben2") + "//4");
        System.out.println(s2.search("Tom2") + "//5");
        System.out.println(s2.search("Sam2") + "//6");
        System.out.println(s2.search("Ben1") + "//7");
        System.out.println(s2.search("Tom1") + "//8");
        System.out.println(s2.search("Sam1") + "//9");
        System.out.println(s2.search("Ben") + "//10");
        System.out.println(s2.search("Tom") + "//11");
        System.out.println(s2.search("Sam") + "//12");

        while(!s2.isEmpty()){
			System.out.println(s2.pop());
		}



		//________________________________
		System.out.println("\n\n");

		ArrayStack s3 = new ArrayStack();
		s3.push(new Character('('));
		s3.push(new Character(')'));
        s3.push(new Character('!'));
		s3.push(new Character('@'));
        s3.push(new Character('#'));
		s3.push(new Character('$'));
		s3.push(new Character('%'));
        s3.push(new Character('^'));
		s3.push(new Character('&'));
		s3.push(new Character('*'));

        System.out.println(s3.search('*') + "//1");
        System.out.println(s3.search('&') + "//2");
        System.out.println(s3.search('^') + "//3");
        System.out.println(s3.search('%') + "//4");
        System.out.println(s3.search('$') + "//5");
        System.out.println(s3.search('#') + "//6");
        System.out.println(s3.search('@') + "//7");
        System.out.println(s3.search('!') + "//8");
        System.out.println(s3.search(')') + "//9");
        System.out.println(s3.search('(') + "//10");


		while(!s3.isEmpty()){
			System.out.println(s3.pop());
		}

        ArrayQueue q1 = new ArrayQueue();
        q1.add("a");
        q1.add("b");
        q1.add("c");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//true");
        System.out.println(q1.offer(new Double(3.1)) + "//false");

        while(!q1.isEmpty()){
            System.out.println(q1.remove());
        }
        //________________________________
        System.out.println("\n\n");

        Queue q2 = new Queue();

        q2.add('(');
        q2.add('*');
        q2.add(')');

        System.out.println(q2.element());

        while(!q2.isEmpty()){
            System.out.println(q2.remove());
        }
        //________________________________
        System.out.println("\n\n");

        LinkedListQueue q3 = new LinkedListQueue();
        q3.add(new Double(4.0));
        q3.add(new Double(3.8));
        q3.add(new Double(3.2));

        System.out.println(q3.element());

        while(!q3.isEmpty()){
            System.out.println(q3.remove());
        }
    }
}
