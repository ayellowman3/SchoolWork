import javax.swing.JOptionPane;

public class University{
	public static void main(String[] args){
		String name;
		String facultyName;
		String department;
		int maxNumStudents;
		name = getString("Enter student's name: ", "Error! Name entered is invalid!");
		facultyName = getString("Enter student's faculty advisor: ", "Error! Invalid name is entered!");
		department = getString("Enter " + facultyName + "\'s department", "Error! Invalid department entered!");
		maxNumStudents = getInt("Enter max number of students " + facultyName + " is allowed to advist: ", "Error! Invalid number of students entered!");
		Faculty f = new Faculty(facultyName, department, maxNumStudents);
		Student s = new Student(name, f);
		JOptionPane.showMessageDialog(null, s.toString());

	}
	public static String getString(String message, String errorMessage){
		boolean error;
		String input;
		do{
			input = JOptionPane.showInputDialog(message);
			error = validateString(input);
			if(error){
				JOptionPane.showMessageDialog(null, errorMessage);
			}
		}while(error);
		return input;
	}

	public static int getInt(String message, String errorMessage){
		int input;
		do{
			try{
				input = Integer.parseInt(JOptionPane.showInputDialog(message));
			}
			catch(NumberFormatException e){
				input = -1;
			}
			if(input <= 0){
				JOptionPane.showMessageDialog(null, errorMessage);
			}
		}while(input <= 0);
		return input;
	}
   public static boolean validateString(String input){
      return(input.equals(""));
   }

}