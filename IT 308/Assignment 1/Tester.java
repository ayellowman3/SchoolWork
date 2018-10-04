import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Tester{
	public static void main(String[] args){

		Address address = new Address("123456", 1234, "ABC Street", "Fairfax" , "VA" , 20222 );
		
		SalariedEmployee salaried = new SalariedEmployee("123456" , "Susan", "Smith" , "Manager", address, 150000);

		HourlyEmployee hourly = new HourlyEmployee("123456" , "Susan", "Smith" , "Manager", address, 100);

		EmployeeWithBonus eWB = new EmployeeWithBonus("123456" , "Susan", "Smith" , "Manager", address, 150000, .1);

		String s = "";
		s += salaried.toString() + "\n";
		s += hourly.toString() + "\n";
		s += eWB.toString() + "\n";
		s += address.toString();
		JOptionPane.showMessageDialog(null, s);

		String outPath = "out.txt";
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(outPath);
			pw.write(salaried.toString() + "\n");
			pw.write(hourly.toString() + "\n");
			pw.write(eWB.toString() + "\n");
			pw.write(address.toString() + "\n");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}

	}
}