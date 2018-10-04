import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class TreeSetApplication{
	public static void main(String[] args){

		Set<User> user = new TreeSet<User>(new ComparatorByName());
		user.add(new User("ab","5555555555"));
		user.add(new User("bc","5555555553"));
		user.add(new User("zx","5555555551"));
		user.add(new User("ds","5555555559"));
		user.add(new User("cf","5555555557"));
		user.add(new User("fc","5555555558"));
		user.add(new User("sd","5555555554"));
		user.add(new User("qw","5555555552"));
		user.add(new User("we","5555555556"));
		user.add(new User("er","5555555550"));

		String message = "Sorted By Name\n\n"  + displayAll(user);
		JOptionPane.showMessageDialog(null, message);

		user = new TreeSet<User>(new ComparatorByPhone());
		user.add(new User("qw","5555555559"));
		user.add(new User("we","5555555557"));
		user.add(new User("er","5555555555"));
		user.add(new User("rt","5555555553"));
		user.add(new User("ty","5555555551"));
		user.add(new User("yu","5555555550"));
		user.add(new User("ui","5555555558"));
		user.add(new User("io","5555555556"));
		user.add(new User("op","5555555554"));
		user.add(new User("gg","5555555552"));

		message = "\nSorted By Phone\n\n" + displayAll(user);
		JOptionPane.showMessageDialog(null, message);


	}

	public static String displayAll(Set<User> user){
		Iterator<User> it = user.iterator();
		String message = "";
		if(!user.isEmpty()){
			while(it.hasNext()){
				message = message + ((User) it.next()).toString() + "\n";
			}
			return message;
		}else{
			return "The Tree Set is Empty.";
		}
	}
}
