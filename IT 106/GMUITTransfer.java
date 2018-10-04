/*
Name: George Huang
Date: 2/28/2016
Course/Section: IT 106.001
Assignment: Programming Assignment 4

Description:
The program calculates the eligibility for a student to transfer to an IT major.
The program prompts for the student's name, IT 106 grade, and GPA. If there are no errors with 
any of the inputs, then the student is informed on his or her eligibility to transfer to the IT
department. The program will keep prompting for Student's name, IT 106 Grade, and GPA until the
sentinal value is entered or the total number of accepted students is 27. Once the sentinal value
is entered or the total number of accepted students has reached 27, the program prints out a summary
of the total number of students entered, total number of students accepted and the total amount of 
scholarship money awarded.

The student name would be a string input.

The student's IT 106 grade would be a string input. The possible string input are based off of GMU's
grading scale and the eligibility to transfer is based on the student IT 106 Grade.

Eligible transfer IT 106 grade:
A+
A
A-
B+
B
B-
C+
C

Ineligible transfer IT 106 grade:
C-
D
F

The student's GPA would be a double input. The range of valid GPA is on the 4.0 scale. The possible 
double input is within the range of 0.0 to 4.0 inclusive. Student eligibility and scholarship money
awarded is based on GPA student's GPA

GPA below 3.0:
Student is ineligible

GPA is 3.0 or above:
Student is eligible to transfer and could be possible for a scholarship

If either student's GPA or IT 106 Grade is ineligible to transfer then the user is informed that he is
not eligible to transfer.

If the student is eligible to transfer, then the student is informed that he is eligible to transfer
and the amount of scholarship money is based on the student GPA.
Scholarship award money:

Below a 3.4: No scholarship money
At least 3.4 and less then 3.6: $1060
At least 3.6: $2060

Once the user informs that there are no more students to enter or 27 students have been accepted, the
program returns a summary message:

number of students accepted
number of students entered
total scholarship amount awarded

*/
import javax.swing.JOptionPane;

public class GMUITTransfer
{
   public static void main(String[] args)
   {
      //Counters to keep track of the number of students entered and accepted
      int num_Of_Students_Entered = 0;
      int num_Of_Students_Accepted = 0;
      
      //Track if an input is invalid
      boolean error = false;
      
      //Variable for user input
      String student_Name = "";
      double GPA = 0;
      String student_IT_106_Grade = "";
      
      //Track if user input is a passing grade to transfer to it 106      
      boolean passing_GPA = true;
      boolean passing_IT_106_Grade = true;
      
      //conditions for an acceptable gpa to transfer to IT 106
      double min_Passing_GPA = 3.0;
      
      //condition to end while loop. max number of accepted students is 27
      int max_Num_Of_Accepted_Students = 27;
      
      //The limits of GPA inputed
      double min_Valid_GPA = 0;
      double max_Valid_GPA = 4.0;
      
      //The amount of possible scholarships students can earn to transfer
      int scholarship_Money_34_36 = 1060;
      int scholarship_Money_36_40 = 2060;
      
      //output for each individual student on their transfer status
      String transfer_Message = "";
      
      //count the total amount of money 
      int total_Scholarship_Awarded = 0;
      //final output message
      String final_Output_Summary = "GMU Information Technology Transfer Summary";

      do
      {
         //keeps track if students it 106 grade is eligible to transfer
         passing_IT_106_Grade = true;
         //keeps track if students gpa is eligible to transfer
         passing_GPA = true;
         //prompt for student name
         student_Name = JOptionPane.showInputDialog("Please enter student's name:\n(Enter \"-1\" if there are no more students to enter)");
         //check if student name is valid. if not, reprompt
         while(student_Name.equals(""))
         {
            JOptionPane.showMessageDialog(null, "Student's name entered is invalid");
            student_Name = JOptionPane.showInputDialog("Please enter student's name:\n(Enter \"-1\" if there are no more students to enter)");
         }
         if(!student_Name.equals("-1"))
         {
            student_IT_106_Grade = "";
            //prompt for student grade
            while(student_IT_106_Grade.equals(""))
            {
               student_IT_106_Grade = JOptionPane.showInputDialog("Enter " + student_Name + "'s IT 106 Grade:");
               //check if student grade input is valid and is passing or failing grade
               switch (student_IT_106_Grade)
               {
                  case "A+": passing_IT_106_Grade = true;  break;
                  case "A": passing_IT_106_Grade = true;   break;
                  case "A-": passing_IT_106_Grade = true;  break;
                  case "B+": passing_IT_106_Grade = true;  break;
                  case "B": passing_IT_106_Grade = true;   break;
                  case "B-": passing_IT_106_Grade = true;  break;
                  case "C+": passing_IT_106_Grade = true;  break;
                  case "C": passing_IT_106_Grade = true;   break;
                  case "C-": passing_IT_106_Grade = false; break;
                  case "D": passing_IT_106_Grade = false;  break;
                  case "F": passing_IT_106_Grade = false;  break;
                  default: student_IT_106_Grade = "";      break;
               }
               if(student_IT_106_Grade.equals(""))
               {
                  JOptionPane.showMessageDialog(null, "Grade entered is invalid");
               }
               
            }
         }
         if(!student_Name.equals("-1"))
         {  
            GPA = -1;
            //passing_GPA = true;
            //prompt for student's gpa
            while(GPA == -1)
            {
               //check if student's gpa is even a double
               try
               {
               GPA = Double.parseDouble(JOptionPane.showInputDialog("Enter " + student_Name + "'s current GPA"));
               }
               catch (NumberFormatException e)
               {
                  JOptionPane.showMessageDialog(null, "GPA entered is invalid");
                  GPA = -1;
                  GPA = Double.parseDouble(JOptionPane.showInputDialog("Enter " + student_Name + "'s current GPA"));

               }
               //check if GPA is out of range, too high or too low
               if (GPA < min_Valid_GPA || GPA > max_Valid_GPA)
               {
                  JOptionPane.showMessageDialog(null, "GPA entered is invalid");
                  GPA = -1;
               }
               //check if GPA entered is passing
               else if(GPA < min_Passing_GPA)
               {
                  passing_GPA = false;
               }
            }
         }
         if(!student_Name.equals("-1"))
         {
            //if student's gpa and it 106 grade is passing
            if(passing_IT_106_Grade && passing_GPA)
            {
               //generates passing transfer message
               transfer_Message = "Congratulations ";
               transfer_Message += student_Name;
               transfer_Message += "!\nYou are eligible to transfer to IT at GMU.\n";
               //adds that ineligible for a transfer scholarship
               if(GPA<3.4)
               {
                  transfer_Message += "Unfortunately, you don't qualify for a transfer scholarship.";
               }
               //adds that eligible for the lower amount for scholarship
               else if(GPA >=3.4 && GPA < 3.6)
               {
                  total_Scholarship_Awarded += scholarship_Money_34_36;
                  transfer_Message += "I'm happily to inform you that you are awarded a scholarship of $1060.";
               }
               //adds that eligibl for the highest amount for scholarship
               else
               {
                  total_Scholarship_Awarded += scholarship_Money_36_40;
                  transfer_Message += "I'm happily to inform you that you are awarded a scholarship of $2060.";
               }
               JOptionPane.showMessageDialog(null, transfer_Message);
               //increase the count for students entered and accepted
               num_Of_Students_Entered++;
               num_Of_Students_Accepted++;
            }
            //either gpa or it 106 grade is ineligible
            else
            {
               JOptionPane.showMessageDialog(null, "Sorry " + student_Name + ", you are not eligible to transfer to GMU's IT major");
               //increase the count for students entered
               num_Of_Students_Entered ++;
            }
         }
      //condition for do while loop. max of 27 students accepted or sentinal value is entered
      } while(num_Of_Students_Accepted < max_Num_Of_Accepted_Students && !student_Name.equals("-1"));
      
      
      
      //creates a final output summaey of the number of total students accepted, number of students entered and the total amount of scholarships given out
      final_Output_Summary += "\nNumber of Students Accepted: " + num_Of_Students_Accepted;
      final_Output_Summary += "\nNumber of Students Entered: " + num_Of_Students_Entered;
      final_Output_Summary += "\nTotal Scholarship Awarded: $" + total_Scholarship_Awarded;
      JOptionPane.showMessageDialog(null, final_Output_Summary);
   }
}