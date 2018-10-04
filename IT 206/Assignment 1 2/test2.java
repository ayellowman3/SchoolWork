import javax.swing.JOptionPane;
import java.util.ArrayList;
public class test2{
   public static void main(String args[]){
      test1 t = new test1();
      
      double testy;
      t.askPayRate("enter something");
      testy = t.getPayRate();
      JOptionPane.showMessageDialog(null, testy);
   }
}