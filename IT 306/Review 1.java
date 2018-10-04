package Fall2017_Module1;

import javax.swing.JOptionPane;

/*
 * Review1: Modularizing Tasks
 * Recording an array of student objects
 * MAX number of students is 100
 * Read data using JOP
 * Print Data using JOP
 * you can define the class student inside this file if it is not public. 
 * This "Student" class can only be accessed within the scope of "Review1" class.
 */

class Student{
	/*
	 * A student has the following attributes:
	 * Name:String ; GPA:double; id:int;
	 * constructors
	 */
	String name; 
	double gpa; 
	static int total =0; 
	
	Student() { //default construcotr
		total++; 
	} 
	
	//special purpose construcotr
	Student(String name, double gpa){
		this(); 
		this.name  = name; 
		this.gpa = gpa; 
	}
	
	void setName(String name){ this.name = name; }
	void setGpa(double gpa) {this.gpa = gpa; }
	String getName() { return name; }
	double getGpa() { return gpa; }
	
	public String toString(){
		return name + "," + gpa; 
	}
	
	static int getTotal() {return total; }
}

public class Review1 {

	
	public static void main(String[] args) {
		//IPO: Input, Process, Output
		
		//TODO: create a multi-choice menu
		String menu= "Enter a task: 1- input a student record\n" +
				"2-Get the student with the maximum GPA\n3-Print all student records" +
				"4-Exit."; 
		int choice = 0; 
		Student[] records = new Student[100];
		do{ choice =  Integer.parseInt(JOptionPane.showInputDialog(menu)); 
			switch (choice){ 
			case 1: 
				boolean flag= add(JOptionPane.showInputDialog("Enter student name and GPA (e.g., John Brown,3.4)" +
							"--GPA is a number between 0.0 and 4.0") , records);
				JOptionPane.showMessageDialog (null, "Sucess: " + flag); 
				break;
			case 2: 
				JOptionPane.showMessageDialog(null, getMAX(records)) ; 
				break;
			case 3: 
				JOptionPane.showMessageDialog(null, output(records)) ; 
				break;
			}
		}while(choice!=4);
		System.exit(0);
	}
	
	
	public static boolean add(String input , Student[] students){
		String name = input.substring(0, input.indexOf(",")); 
		double gpa = Double.parseDouble(input.substring(input.indexOf(",")+1).trim());
		//Student s = new Student(name,gpa); 
		Student s = new Student(); 
		s.setName(name); 
		s.setGpa(gpa); 
		if (Student.total >= 100 ) return false;
		int ix = Student.total; 
		students[ix-1] = s; 
		return true; 
	}
	
	public static Student getMAX(Student[] students){
		if(Student.total == 0 ) return null;
		if(Student.total==1) return students[0]; 
		Student max = students[0];
		for(int i = 1; i< Student.total; i++){
			if(max.getGpa()< students[i].getGpa()){
				max = students[i]; 
			}
		}
		return max; 
	}
	
	public static String output(Student[] students){
		String outputString = ""; 
		if (Student.total==0) 		return null;
		for(int i=0; i< Student.total; i++) {
			outputString+= students[i]+" ,"; 
		}
		return outputString; 
	}

}