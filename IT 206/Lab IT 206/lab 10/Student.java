public class Student{
	private String name;
	private Faculty facultyName;

	public Student(String name,	Faculty facultyName){
		this.name = name;
		this.facultyName = facultyName;
	}

	public String toString(){
		return "Student name: " + name
		+ facultyName.toString();
	}
}