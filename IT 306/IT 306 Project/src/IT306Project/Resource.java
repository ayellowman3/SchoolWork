
public class Resource {

    private static int count = 0;
    private static int lastID = 1000;
    private String id;
    private String type;
    private String name;
    private String genre;
    private String author;
    private String year;
    private String userID;
    private boolean checkedOut;

    public Resource(){
        count++;
    }

    public Resource(String id,String type,String name,String genre,String author,String year, String userID, boolean checkedOut){
        this();
        this.id = id;
        this.type = type;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.userID = userID;
        this.checkedOut = checkedOut;
        if(Integer.parseInt(id) > lastID){
            lastID = Integer.parseInt(id);
        }
    }

    public static int getCount(){
        return count;
    }

    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }

    public boolean getCheckedOut(){
        return checkedOut;
    }

    public String toString(){
        String message = "Type : " + type + " Name: " + name + " checkedOut: " + checkedOut;
        return message;
    }

	/**
	* Returns value of count
	* @return
	*/


	/**
	* Returns value of id
	* @return
	*/
	public String getID() {
		return this.id;
	}

	/**
	* Returns value of type
	* @return
	*/
    public String getAuthor(){
        return this.author;
    }

	/**
	* Returns value of genre
	* @return
	*/
	public String getGenre() {
		return this.genre;
	}

	/**
	* Returns value of authorID
	* @return
	*/


	/**
	* Returns value of year
	* @return
	*/
	public String getYear() {
		return this.year;
	}

	/**
	* Returns value of userID
	* @return
	*/
	public String getUserID() {
		return this.userID;
	}

	/**
	* Returns value of checkedOut
	* @return
	*/
	public boolean isCheckedOut() {
		return this.checkedOut;
	}

	/**
	* Returns value of e
	* @return
	*/


	/**
	* Returns value of e
	* @return
	*/


	/**
	* Returns value of getCount
	* @return
	*/


	/**
	* Returns value of getType
	* @return
	*/


	/**
	* Returns value of getName
	* @return
	*/


	/**
	* Returns value of getCheckedOut
	* @return
	*/


	/**
	* Returns value of toString
	* @return
	*/


	/**
	* Sets new value of count
	* @param
	*/
	public static void setCount(int count) {
		Resource.count = count;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	* Sets new value of type
	* @param
	*/
	public void setType(String type) {
		this.type = type;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Sets new value of genre
	* @param
	*/
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	* Sets new value of authorID
	* @param
	*/
	public void setAuthor(String author) {
		this.author = author;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}



    public static int getLastID(){
        return lastID;
    }
}
