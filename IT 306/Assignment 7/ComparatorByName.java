import java.util.Comparator;

public class ComparatorByName implements Comparator<User>{
	public int compare(User u1, User u2){
		return (u1.getUsername().compareToIgnoreCase(u2.getUsername()));
	}
}
