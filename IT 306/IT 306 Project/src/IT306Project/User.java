
public class User {

    private static int count;
    private static int lastUserID = 1000;

    private String userID;
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String email;
    private String address;
    private String resource;

    public User(){
        this.email = "";
        this.password = "";
        count++;
    }

    public User(String userID, String fName, String lName, String username, String password, String email, String address, String resource){
        this();
        this.userID = userID;
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.resource = resource;
        if(Integer.parseInt(userID) > lastUserID){
            lastUserID = Integer.parseInt(userID);
        }
    }



	/**
	* Returns value of count
	* @return
	*/
	public static int getCount() {
		return count;
	}

	/**
	* Returns value of userID
	* @return
	*/
	public String getUserID() {
		return this.userID;
	}

	/**
	* Returns value of fName
	* @return
	*/
	public String getFName() {
		return this.fName;
	}

	/**
	* Returns value of lName
	* @return
	*/
	public String getLName() {
		return this.lName;
	}

	/**
	* Returns value of username
	* @return
	*/
	public String getUsername() {
		return this.username;
	}

	/**
	* Returns value of password
	* @return
	*/
	public String getPassword() {
		return this.password;
	}

	/**
	* Returns value of email
	* @return
	*/
	public String getEmail() {
		return this.email;
	}

	/**
	* Returns value of address
	* @return
	*/
	public String getAddress() {
		return this.address;
	}

	/**
	* Returns value of resource
	* @return
	*/
	public String getResource() {
		return this.resource;
	}

	/**
	* Returns value of r
	* @return
	*/


	/**
	* Sets new value of count
	* @param
	*/
	public static void setCount(int count) {
		User.count = count;
	}

	/**
	* Sets new value of userID
	* @param
	*/
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	* Sets new value of fName
	* @param
	*/
	public void setFName(String fName) {
		this.fName = fName;
	}

	/**
	* Sets new value of lName
	* @param
	*/
	public void setLName(String lName) {
		this.lName = lName;
	}

	/**
	* Sets new value of username
	* @param
	*/
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	* Sets new value of password
	* @param
	*/
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	* Sets new value of email
	* @param
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	* Sets new value of address
	* @param
	*/
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	* Sets new value of resource
	* @param
	*/
	public void setResource(String resource) {
		this.resource = resource;
	}

    public static int getLastUserID(){
        return lastUserID;
    }
}
