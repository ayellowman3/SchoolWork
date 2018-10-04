import javax.swing.JOptionPane;

public class Final{
	public static void main(String args[]){
		Final3 fin3 = new Final3();
		Final2 fin2 = fin3;
		JOptionPane.showMessageDialog(null, fin2.getAns());
		Final2 fin = new Final2();
		Final3 fix = (Final3)fin2;
      
		if(fin2 instanceof Final3){
			Final3 fin4 = (Final3)fin2;
			JOptionPane.showMessageDialog(null, fin4.study());
		}
		Final2[] f = new Final2[3];
		f[0] = new Final2();
		f[1] = new Final3();
		f[2] = new Final2();
		for(int i = 0; i < f.length; i++){
			JOptionPane.showMessageDialog(null, f[i].getAns());
			if(f[i] instanceof Final3){
				Final3 x = (Final3)f[i];
				JOptionPane.showMessageDialog(null, x.study());
			}
		}
 	}
}