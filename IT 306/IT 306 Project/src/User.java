
public class User {

    private static int count;

    private String email;
    private String password;

    public User(){
        this.email = "";
        this.password = "";
        count++;
    }

    public User(String email, String password){
        this();
        this.email = email;
        this.password = password;
    }

    public static int getCount(){
        return count;
    }
}
