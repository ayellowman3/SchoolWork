public class Candidate {
	
	private String name;
	private int code;
	private static int total; 
	
	public Candidate(String name , int code){
		this.name = name;
		this.code = code;
		total++;
	}
	
	public int getCode(){
		return code;
	}
	
	public static int getTotalCandidates(){
		return total;
	}
	
	public String toString(){
		return String.format("Name:%s Code:%d", name,code);
	}

}
