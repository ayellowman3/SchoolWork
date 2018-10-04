/*
George Huang
G00775631
ghuang3@masonlive.gmu.edu
*/
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


public class Application{
	/*
	@ghuang3
	populates student array
	sort student array
	write into text file
	user interface for searching
	*/
	public static void main(String[] args){
		Student[] students = new Student[Student.MAX_NUM_STUDENTS]; //array of Students;
		Student[] studentsInsertion = new Student[Student.MAX_NUM_STUDENTS];
		Student[] studentsSelection = new Student[Student.MAX_NUM_STUDENTS];
		Student[] studentsRadix = new Student[Student.MAX_NUM_STUDENTS];
		String path = "./inputAssignment2.txt"; //read text path
		String insertionOutPath = "./insertionout.txt"; //write text path
		String selectionOutPath = "./selectionout.txt";
		String radixOutPath ="./radixout.txt";
		//reads file and populates student array
		populateStudents(students, path);

		//copy student arrays
		copy(students, studentsInsertion);
		copy(students, studentsSelection);
		copy(students, studentsRadix);

		//sorts students descending order by gpa
		sortStudents(studentsInsertion); //insertion sort
		sortStudents1(studentsSelection); //selection sort
		sortStudents2(studentsRadix); //radix sort

		//writes sorted students into different text file
		write(studentsInsertion, insertionOutPath); //insertion sort
		write(studentsSelection, selectionOutPath); //selection sort
		write(studentsRadix, radixOutPath); //radix sort

		int userOption;
		do{//@ghuang GUI for searching by GPA
			try{//prompt for user option
				userOption = Integer.parseInt(JOptionPane.showInputDialog("1: search by GPA\n0: exit"));
			}catch(NumberFormatException e){
				userOption = 2;
			}
			if(userOption == 1){
				search(studentsRadix);
			}
			else if(userOption == 0){

			}
			else{
				JOptionPane.showMessageDialog(null, "Error, Invalid input entered");
			}
		}while (userOption != 0);
	}

	//@ghuang populate student array with text file
	public static void populateStudents(Student[] s, String path){
		int counter = 0;
		File file= new File(path);

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String nextLine;
			String name;
			double gpa;

			while((nextLine=br.readLine()) != null){
				name = stringName(nextLine); //Strip String for name
				gpa = doubleGPA(nextLine); //String String for GPA
				if(validateGpa(gpa)){
					s[counter] = new Student(name, gpa);
					counter++;
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@ghuang takes a line of text and isolate just the name
	public static String stringName(String line){
		int dash = 0;
		int colon = 0;

		//@ghuang find dash
		for(int i = 0; i < 5; i++){
			if(line.charAt(i) == '-'){
				dash = i;
			}
		}

		//@ghuang find semi colon
		for(int i = 0; i < line.length(); i ++){
			if(line.charAt(i) == ':'){
				colon = i;
			}
		}

		//@ghuang return String of only the name
		return line.substring(dash + 2, colon - 1);
	}

	//@ghuang isolate GPA from line of text
	public static double doubleGPA(String line){
		int colon = 0;
		double gpa;

		for(int i = 0; i < line.length(); i ++){
			if(line.charAt(i) == ':'){
				colon = i;
			}
		}

		gpa = Double.parseDouble(line.substring(colon + 2, line.length()));
		return gpa;
	}

	//@ghuang Check if GPA is valid between 2.0 and 4.0
	public static boolean validateGpa(double gpa){
		return(gpa >= Student.MIN_GPA && gpa <= Student.MAX_GPA);
	}

	//@ghuang insertion sort
	public static void sortStudents(Student[] s){
		int numStudents = Student.getStudentCount();

		for(int i = 1; i < numStudents; i++){
			int k = i;
			while(k > 0 && s[k].getGpa() > s[k-1].getGpa()){
				Student temp = s[k-1];
				s[k-1] = s[k];
				s[k] = temp;
				k--;
			}
		}
	}

	//@ghuang selection sort
	public static void sortStudents1(Student[] s){
		Student min;
		int k = 0;

		for(int i = Student.getStudentCount() - 1; i > 0; i--){
			min = s[0];
			for(int j = 1; j < i; j++){
				if(min.getGpa() > s[j].getGpa()){
					min = s[j];
					k = j;
				}
			}
			if(s[i].getGpa() > min.getGpa()){
				Student temp = s[i];
				s[i] = s[k];
				s[k] = temp;
			}
		}
	}

	//@ghuang radix sort
	public static void sortStudents2(Student[] s){
		int count = Student.getStudentCount();
		Student[] round1 = new Student[count];
		Student[] round2 = new Student[count];
		Student[] round3 = new Student[count];

		//sort by 100th place
		int count1 = 0;
		for(int i = 9; i >= 0; i--){
			for(int k = 0; k < count; k++){
				if((s[k].getGpa()*100)%10 == i){
					round1[count1] = s[k];
					count1++;
				}
			}
		}

		//sort by 10th place
		int count2 = 0;
		for(int i = 9; i >= 0; i--){
			for(int k = 0; k < count; k++){
				double num = (round1[k].getGpa()*100)%100;
				num = num - (num%10);
				if(num/10 == i){
					round2[count2] = round1[k];
					count2++;
				}
			}
		}

		//sort by 1's place
		int count3 = 0;
		for(int i = 9; i >= 0; i--){
			for(int k = 0; k < count; k++){
				double num = (round2[k].getGpa()*100);
				num = num - (num%100);
				if(num/100 == i){
					round3[count3] = round2[k];
					count3++;
				}
			}
		}

		//sort the original student array
		for(int i = 0; i < count; i++){
			s[i] = round3[i];
		}
	}

	//@ghuang writes array into new text file
	public static void write(Student[] s, String outPath){
		PrintWriter pw = null;
		int num;
		String name;
		double gpa;

		try{
			pw = new PrintWriter(outPath);
			for(int i = 0; i < Student.getStudentCount(); i++){
				if(s[i] != null){
					num = i+1;
					name = s[i].getName();
					gpa = s[i].getGpa();
					pw.write(num + "- " + name + " : " + gpa + "\n");
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}

	//@ghuang binary search by gpa
	public static void search(Student[] s){
		double searchGpa;
		int foundMin = 0;
		int foundMax = 0;
		String message = "";

		try{ //ask for gpa to search by
			searchGpa = Double.parseDouble(JOptionPane.showInputDialog("Enter students GPA to search for: "));
		}catch(NumberFormatException e){
			searchGpa = 0;
		}
		if(searchGpa >= Student.MIN_GPA && searchGpa <= Student.MAX_GPA){
			foundMin = binarySearch(s, searchGpa);
			if(foundMin == -1){//gpa entered isn't in the system
				JOptionPane.showMessageDialog(null, "GPA entered does not exist!");
			}
			else{//find range if more than 1 people have the same gpa
				foundMax = foundMin;
				do{
					if(s[foundMin - 1].getGpa() == searchGpa){
						foundMin--;
					}
				}while(foundMin != 0 && s[foundMin - 1].getGpa() == searchGpa);
				do{
					if(s[foundMax + 1].getGpa() == searchGpa){
						foundMax++;
					}
				}while(foundMax != (Student.getStudentCount() - 1) && s[foundMax + 1].getGpa() == searchGpa);
			}
			message += "Students with " + searchGpa + " GPA\n\n";
			for(int i = foundMin; i <= foundMax; i++){
				message += s[i].getName() + "\n";
			}
			JOptionPane.showMessageDialog(null, message);
		}
		else{
			JOptionPane.showMessageDialog(null, "Error! invalid GPA entered!");
		}
	}

	//@ghuang search to find index number with search gpa
	public static int binarySearch(Student[] s, double searchGpa){
		int min = 0;
		int max = Student.getStudentCount();

		while(min < max){
			int mid = (min + max) / 2;
			if(searchGpa == s[mid].getGpa()){
				return mid;
			}
			else if(searchGpa < s[mid].getGpa()) min = mid + 1;
			else max = mid;
		}
		//if gpa does not exist
		return -1;
	}

	public static void copy(Student[] student, Student[] s){
		for(int i = 0; i < Student.getStudentCount(); i++){
			s[i] = student[i];
		}
	}
}
