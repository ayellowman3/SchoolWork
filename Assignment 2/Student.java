//Student Class
public class Student{
	//Constants
	public final static double MIN_GPA = 2.0;
	public final static double MAX_GPA = 4.0;
	public final static int MAX_NUM_STUDENTS = 1000;
	
	//Counter
	private static int studentCount = 0;
	
	//instance variables
	private String name; //student's name
	private double gpa; //student's gpa

	//constructor
	public Student(){
		studentCount++;
	}

	public Student(String name, double gpa){
		this();
		this.name = name;
		this.gpa = gpa;
	}

	//mutators
	public boolean setName(String name){
		this.name = name;
		return true;
	}

	public boolean setGpa(double gpa){
		this.gpa = gpa;
		return true;
	}

	//accessors
	public String getName(){//returns student's name
		return name;
	}

	public double getGpa(){//returns student's gpa
		return gpa;
	}

	public static int getStudentCount(){//returns number of students
		return studentCount;
	}

	//validator
	public boolean validGpa(double gpa){//returns true if valid gpa
		return (gpa >= MIN_GPA && gpa <= MAX_GPA);
	}
}