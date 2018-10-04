import java.util.Comparator;

public class ComparatorByPhone implements Comparator<User>{
	public int compare(User u1, User u2){
		return (u1.getPhoneNumber().compareToIgnoreCase(u2.getPhoneNumber()));
	}
}
