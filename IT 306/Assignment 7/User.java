

public class User implements Cloneable{
	private String username;
	private int userid;
	private String phoneNumber;
	private static int total;

	public User(String username){
		this.username= username;
		total++;
		userid=total;
	}

	public User(String username, String phoneNumber){
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.userid = total;
		total++;
	}

	public boolean setPhoneNumber(String phone){
		if(phone.length()!=10) return false;
		for(int i=0; i<phone.length(); i++){
			if(!Character.isDigit(phone.charAt(i))) return false;
		}
		this.phoneNumber=phone;
		return true;
	}
	public String getUsername(){ return username; }
	public int getUserid() { return userid; }
	public static int getTotal(){ return total; }
	public String getPhoneNumber() {return phoneNumber; }
	public String toString(){
		return "Username: " + this.username + "\nUserid: "+this.userid + "\nphone number: "+ this.phoneNumber;
	}

	public User clone() throws CloneNotSupportedException{
		User answer;
		try{
			answer = (User)super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Cloneable");
		}
		return answer;
	}
}
