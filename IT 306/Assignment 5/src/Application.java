

import java.util.Stack;

public class Application {
	public class Bracket {
		public static final char LEFT_P = '(';
		public static final char RIGHT_P = ')';
		public static final char LEFT_B = '[';
		public static final char RIGHT_B = ']';
		public static final char LEFT_CURL_B = '{';
		public static final char RIGHT_CURL_B = '}';

	}


	public static void main(String[] args) {
		char[] input1 = "[(4+5+1) x (4 / 2)]".toCharArray();
		char[] input2 = "[(4+5+1) x (4 / 2]".toCharArray();
		System.out.println(isValid(input1));
		System.out.println(isValid(input2));
	}

	public static boolean isValid(char[] input) {
		Stack s = new Stack();
		//TODO
		for(int i = 0; i < input.length; i++){
			if(input[i] == Bracket.LEFT_P || input[i] == Bracket.LEFT_B || input[i] == Bracket.LEFT_CURL_B){
				s.push(input[i]);
			}
			if(input[i] == Bracket.RIGHT_P || input[i] == Bracket.RIGHT_B || input[i] == Bracket.RIGHT_CURL_B){
				if(getPair(input[i]) != (char) s.pop()){
					return false;
				}
			}
		}
		return true;
	}

	public static char getPair(char symbol) {
		if(symbol == Bracket.LEFT_B) return Bracket.RIGHT_B;
		if(symbol == Bracket.RIGHT_B) return Bracket.LEFT_B;

		if(symbol == Bracket.RIGHT_P) return Bracket.LEFT_P;
		if(symbol == Bracket.LEFT_P) return Bracket.RIGHT_P;

		if(symbol == Bracket.LEFT_CURL_B) return Bracket.RIGHT_CURL_B;
		if(symbol == Bracket.RIGHT_CURL_B) return Bracket.LEFT_CURL_B;

		else return '0';
	}



}
