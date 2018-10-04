public class Faculty{
	private String facultyName;
	private String department;
	private int maxNumStudents;

	public Faculty(String facultyName,String department, int maxNumStudents){
		this.facultyName = facultyName;
		this.department = department;
		this.maxNumStudents = maxNumStudents;		
	}

	public String toString(){
		return "\nFaculty Name: " + facultyName
		+ "\nDepartment: " + department
		+ "\nMax number of students: " + maxNumStudents;
	}
}