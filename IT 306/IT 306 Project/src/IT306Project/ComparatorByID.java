import java.util.Comparator;

public class ComparatorByID implements Comparator<Resource> {
	public int compare(Resource o1, Resource o2) {
        	return o1.getID().compareTo(o2.getID());
	}
}
