public class Voter {
	
	private char gender; 
	private int voteNumber;
	private static int total; 
	
	public Voter(char ch){
		if(ch=='f' || ch=='m')  gender = ch;
		else ch='u'; //unknown
		total++;
	}
	
	public char getGender(){
		return gender;
	}
	
	public void setVote(int num){
		if(num>=1 && num<=Candidate.getTotalCandidates())
			voteNumber=num;
		else voteNumber=-1; //invalid vote
	}
	
	public int getVote(){
		return voteNumber;
	}
	
	public static int getTotal(){
		return total;
	}
	
	
	public String toString(){
		return String.format("gender:%s vote:%d", gender, voteNumber);
	}

}
