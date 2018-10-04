import javax.swing.JOptionPane;
public class Customer{
	public static void main(String[] args){
		String s = "(((())))";
		sub(s);
	}
	
	public static void sub(String s){
		JOptionPane.showMessageDialog(null, s);
		if(s.length() > 2){
			sub(s.substring(1, s.length() - 1));
		}
	}
}