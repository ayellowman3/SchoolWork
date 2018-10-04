/*
 * George Huang
 * G00775631
 * ghuang3@masonlive.gmu.edu
 */

import javax.swing.JOptionPane;
public class Assignment3{
	public static void main(String[] args){
		String ans;

		ans = test1();
		dis(ans);
		
		ans = test2();
		dis(ans);

		ans = test3();
		dis(ans);
		
		gui();

	}

	//user interface for testing
	public static void gui(){
		int input = -1; 
		
		while(input != 0){
			input = Integer.parseInt(JOptionPane.showInputDialog("Which would you like to test? \nPlease enter 1, 2, 3, 0. No error checking included\n\n[1] reverse string\n[2] difficult problem\n[3] binary conversion\n[0] exit"));
			switch(input){
				case 1:selftest1();
				break;
				case 2:selftest2();
				break;
				case 3:selftest3();
				break;
				default: input = 0;
			}
		}
	}

	//gets input for testing for problem 1
	public static void selftest1(){
		String s;
		s = JOptionPane.showInputDialog("enter String");
		String ans = problem1(s);
		dis(ans);
	}
	
	//gets input for testing for problem 2
	public static void selftest2(){
		int n = Integer.parseInt(JOptionPane.showInputDialog("enter n"));
		int r = Integer.parseInt(JOptionPane.showInputDialog("enter r"));

		String ans = "" + problem2(n,r);
		dis(ans);
	}

	//gets input for testing for problem 3
	public static void selftest3(){
		int n = Integer.parseInt(JOptionPane.showInputDialog("enter number"));
		String ans = problem3(n);
		dis(ans);
	}

	//displays string
	public static void dis(String s){
		JOptionPane.showMessageDialog(null, s);
	}

	//test solution for problem 1
	public static String test1(){
		String s = "Problem 1\n\n";
		s += problem1("a") + "\n";
		s += problem1("ab") + "\n";
		s += problem1("abc") + "\n";
		s += problem1("abcd") + "\n";
		s += problem1("abcde") + "\n";
		s += problem1("abcdef") + "\n";
		s += problem1("abcdefg") + "\n";
		s += problem1("abcdefgh") + "\n";
		s += problem1("abcdefghi") + "\n";
		s += problem1("abcdefghij") + "\n";
		s += problem1("abcdefghijk") + "\n";
		s += problem1("abcdefghijkl") + "\n";
		s += problem1("abcdefghijklm") + "\n";
		s += problem1("abcdefghijklmn") + "\n";
		s += problem1("abcdefghijklmno") + "\n";
		s += problem1("abcdefghijklmnop") + "\n";
		s += problem1("abcdefghijklmnopq") + "\n";
		s += problem1("abcdefghijklmnopqr") + "\n";
		s += problem1("abcdefghijklmnopqrs") + "\n";
		s += problem1("abcdefghijklmnopqrst") + "\n";
		s += problem1("abcdefghijklmnopqrstu") + "\n";
		s += problem1("abcdefghijklmnopqrstuv") + "\n";
		s += problem1("abcdefghijklmnopqrstuvw") + "\n";
		s += problem1("abcdefghijklmnopqrstuvwx") + "\n";
		s += problem1("abcdefghijklmnopqrstuvwxy") + "\n";
		s += problem1("abcdefghijklmnopqrstuvwxyz") + "\n";
		
		return s;
	}

	//test solution for problem 2
	public static String test2(){
		String s = "Problem 2\n\n";
		s += "C(2,1): " + problem2(2,1) + "\n";
		s += "C(3,1): " + problem2(3,1) + "\n";
		s += "C(3,2): " + problem2(3,2) + "\n";
		s += "C(4,1): " + problem2(4,1) + "\n";
		s += "C(4,2): " + problem2(4,2) + "\n";
		s += "C(4,3): " + problem2(4,3) + "\n";
		s += "C(5,1): " + problem2(5,1) + "\n";
		s += "C(5,2): " + problem2(5,2) + "\n";
		s += "C(5,3): " + problem2(5,3) + "\n";
		s += "C(5,4): " + problem2(5,4) + "\n";
		s += "C(6,1): " + problem2(6,1) + "\n";
		s += "C(6,2): " + problem2(6,2) + "\n";
		s += "C(6,3): " + problem2(6,3) + "\n";
		s += "C(6,4): " + problem2(6,4) + "\n";
		s += "C(6,5): " + problem2(6,5) + "\n";
		s += "C(7,1): " + problem2(7,1) + "\n";
		s += "C(7,2): " + problem2(7,2) + "\n";
		s += "C(7,3): " + problem2(7,3) + "\n";
		s += "C(7,4): " + problem2(7,4) + "\n";
		s += "C(7,5): " + problem2(7,5) + "\n";
		s += "C(7,6): " + problem2(7,6) + "\n";

		return s;

	}
	
	//test solution for problem 3
	public static String test3(){
		String s = "Problem 3\n\n";

		s += "1: " + problem3(1) + "\n";
		s += "2: " + problem3(2) + "\n";
		s += "3: " + problem3(3) + "\n";
		s += "4: " + problem3(4) + "\n";
		s += "7: " + problem3(7) + "\n";
		s += "8: " + problem3(8) + "\n";
		s += "15: " + problem3(15) + "\n";
		s += "16: " + problem3(16) + "\n";
		s += "31: " + problem3(31) + "\n";
		s += "32: " + problem3(32) + "\n";
		s += "63: " + problem3(63) + "\n";
		s += "64: " + problem3(64) + "\n";
		s += "127: " + problem3(127) + "\n";
		s += "128: " + problem3(128) + "\n";
		s += "255: " + problem3(255) + "\n";
		s += "256: " + problem3(256) + "\n";
		s += "511: " + problem3(511) + "\n";
		s += "512: " + problem3(512) + "\n";
		s += "1023: " + problem3(1023) + "\n";
		s += "1024: " + problem3(1024) + "\n";
		s += "2047: " + problem3(2047) + "\n";
		s += "2048: " + problem3(2048) + "\n";
		s += "4095: " + problem3(4095) + "\n";
		s += "4096: " + problem3(4096) + "\n";
		s += "8191: " + problem3(8191) + "\n";
		s += "8192: " + problem3(8192) + "\n";
		s += "155: " + problem3(155) + "\n";
		
		return s;
	}
	
	//reverses string
	public static String problem1(String word){
		String s = "";
		s += word.charAt(word.length() - 1);
		if(word.length() > 1){
			s += problem1(word.substring(0,word.length()-1));
		}
		return s;
	}
	
	//solves that math problem
	public static int problem2(int n, int r){
		int num = n;
		if(r > 1){
			num = (num * problem2(n - 1, n - r)) / r;
		}
		return num;
	}

	//converts int to binary
	public static String problem3(int num){
		String s;
		if(num % 2 == 1){
			s = "1";
		}
		else{
			s = "0";
		}
		if(num > 1){
			s = problem3(num / 2) + s;
		}
		return s;
	}
}