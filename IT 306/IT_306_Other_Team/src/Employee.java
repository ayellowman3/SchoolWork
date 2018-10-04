public class Employee{
	
	private static int count = 0;

	private String fName;
	private String lName;
	private String email;
	private String password;



	public Employee(){
		count++;
	}

	public Employee(String fName, String lName,	String email, String password){
		this();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public static int getCount(){
		return count;
	}

	@Override
	public String toString() {
		return "Employee [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password + "]";
	}
	
	
}