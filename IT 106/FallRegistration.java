/*
Name: George Huang
Date: 3/22/2016
Course/Section: IT 106.001
Assignment: Programming Assignment 6

Description:
The program generates a student's list of courses registered at GMU for fall
semester of 2016.The program has a main menu which is accessed in the beginning
of the program and is accessed after it completes a function. The main menu will
prompt for 1 of 4 functions. If anything else was entered in the main menu, then
the user is informed of an invalid entry and asked to reprompt. The first option
is to add a course to registration. The program will then ask for the course name
and the number of credits. If either of the entries are invalid, then the user is
informed and then reprompted. If the entries are valid, then the names are added 
to parallel arrays. If there are 9 classes already registered, the program will not
allow any more classes to be registered. The second option removes a course that 
is already registered. If there are no classes registered, then the user is 
informed there is no classes to remove. If there is at least one class registered, 
then the user is prompet for a course to remove. If the entry is valid, then then 
program will check if that course was registered for. If the course wasn't registered
for, the program will inform the user that the class wasn't registered for. If the
course was registered for, then course is then removed from the schedule. The third
option is to print out the schedule. The schedule shows the list of classes and next
to the list of classes are the amount of credits for each course. At the bottom, the
total number of credits are printed out. The fourth option is to exit the program. To
exit, the user will have to enter 4 in the main menu.

The main menu is an Integer input. There are only 4 valid input for the main menu. Any
thing else entered would provide an error message.
The following inputs are the only valid input

1:Add Course
2:Remove Course
3:Print List
4:Exit

If 1 is entered, it will ask for two inputs

First input would be a String input for the name of the course
The String input can't be an empty string

Second input would be a integer input for the number of credits for the course
The integer enters must be at least 0

If 2 is entered, it will ask for one input

The input asked would be a String input for the name of the course he/she would like
to remove. The String input can't be an empty string. At least one course must be
registered for it to print out

If 3 is entered, then a list of registered is printed. At least one course must be 
registered for it to print out

The program returns:
course list
course credits
total number of credits

If 4 is entered, then the program exits.
*/

import javax.swing.JOptionPane;

public class FallRegistration
{
   public static void main(String[] args)
   {  
      //initialize section
      final int max_Classes = 9;
      //main menu user selection
      int user_Selection = 0;
      
      //create parallel arrays
      String[] class_List = new String[9];
      int[] class_List_Credit = new int[9];
      
      //menu selection one add courses
      String add_Course;
      int add_Course_Credit = 0;
      boolean already_Reg;

      //menu selection two remove courses
      String remove_Course;
      boolean remove_Not_Reg;
      
      
      //tracks number of classes registered. increase and decrease
      //in menu selection one and two
      int class_Count = 0;
      
      //menu selection 3
      //create the print message variables
      String print_message = "";
      int total_Num_Credit = 0;
      
      
      while(user_Selection != 4)
      {
         //reset main menu user selection
         user_Selection = 0;
         
         //prompt for user selection in main menu
         try
         {
            user_Selection = Integer.parseInt(JOptionPane.showInputDialog("Select one of the following options:\n1) Add New Course\n2) Remove Course\n3) Print Schedule\n4) Exit"));
         }
         catch (NumberFormatException e)
         {
         }
         
         //user input is 1
         if (user_Selection == 1)
         {
            //if 9 classes isn't reached
            if (class_Count != max_Classes)
            {
               //reset string to empty and boolean
               add_Course = "";
               already_Reg = false;
               
               //prompt for course name until valid
               while(add_Course.equals(""))
               {
                  add_Course = JOptionPane.showInputDialog("Enter course id");
                  if (add_Course.equals(""))
                  {
                     JOptionPane.showMessageDialog(null, "Course Entered Is Invalid!!!");
                  }
               }
               
               //checks if course name is already registered
               for(int reg_Index = 0; reg_Index < max_Classes; reg_Index++)
               {
                  //if already registered, error message
                  if(add_Course.equals(class_List[reg_Index]))
                  {
                     already_Reg = true;
                     JOptionPane.showMessageDialog(null, "You have already registered for " + add_Course);
                     break;
                  }
               }
               //reset course credit to 0;
               add_Course_Credit = 0;
               //if course isn't already registered, prompt for credit
               while (add_Course_Credit ==0 && !already_Reg)
               {
                  try
                  {
                     add_Course_Credit = Integer.parseInt(JOptionPane.showInputDialog("Enter credit for " + add_Course));
                  }
                  //if invalid input, reset input to 0
                  catch(NumberFormatException e)
                  {
                     add_Course_Credit = 0;
                  }
                  //if input is negative;
                  if(add_Course_Credit <= 0)
                  {
                     JOptionPane.showMessageDialog(null, "Invalid amount of credits entered");
                     add_Course_Credit = 0;
                  }
               }
               //inputs are valid
               if(!already_Reg)
               {  
                  //add course to array
                  class_List[class_Count] = add_Course;
                  //add credit to array
                  class_List_Credit[class_Count] = add_Course_Credit;
                  //increase class count
                  class_Count++;
               }
            }
            //if class count equals 9
            else
            {
               JOptionPane.showMessageDialog(null, "You can't add any more classes, you have reached a max amount of classes");
            }
         }
         
         //user input 2
         else if(user_Selection == 2)
         {
            //reset variables for course to remove
            remove_Course = "";
            remove_Not_Reg = true;
            
            while(remove_Course.equals(""))
            {  
               //if you are not registered for any classes
               if(class_Count == 0)
               {
                  JOptionPane.showMessageDialog(null, "You are not registered for any classes. You don't have any classes to remove");
                  break;
               }
               //prompt for course to remove
               remove_Course = JOptionPane.showInputDialog("Enter course id you would like to remove:");
               //if nothing is entered for course to remove
               if (remove_Course.equals(""))
               {
                  JOptionPane.showMessageDialog(null, "Course Entered Is Invalid!!!");
                  
               }
               //check array for classes
               for( int remove_Index = 0; remove_Index < max_Classes; remove_Index++)
               {  
                  //if found in array
                  if(remove_Course.equals(class_List[remove_Index]))
                  {
                     //course was registered for is true
                     remove_Not_Reg = false;
                     //decrease class count
                     class_Count--;
                     //resort the array for credit and courses
                     for( int resort_Index = remove_Index; resort_Index < 8; resort_Index ++)
                     {
                        class_List[resort_Index] = class_List[resort_Index + 1];
                        class_List_Credit[resort_Index] = class_List_Credit[resort_Index + 1];
                     }
                     //reset the end of both array
                     class_List[8] = null;
                     class_List_Credit[8] = 0;
                     //gives message of removed course
                     JOptionPane.showMessageDialog(null, "You have removed " + remove_Course + " from your schedule");
                  }
               }
            }
            //if class entered isn't in course array
            if(remove_Not_Reg == true && class_Count != 0)
            {
               JOptionPane.showMessageDialog(null, "Error! You weren't registered for " + remove_Course);
            }

         }
         //if user input is 3
         else if(user_Selection == 3)
         {  
            //reset print message
            print_message = "*******GMU Fall 2016*******\n****Registered Courses***\n\n";
            total_Num_Credit = 0;
            
            //create a list with classes and it's credit
            for(int i = 0; i < max_Classes; i++)
            {
               
               if(class_List[i] != null)
               {
                  print_message += i+1 + ") " + class_List[i] + ": " + class_List_Credit[i] + "\n";
                  total_Num_Credit += class_List_Credit[i];
               }
            }
            
            //added total credits to the message
            print_message += "\nTotal Number of Credits: " + total_Num_Credit;
            //check if there are classes
            if(class_Count > 0)
            {
               JOptionPane.showMessageDialog(null, print_message);
            }
            //if no classes are registered for, error message
            else
            {
               JOptionPane.showMessageDialog(null, "You are not registered for any classes");
            }
         }
         //if user input is 4
         else if(user_Selection == 4)
         {
            //centinal value
         }
         //in main menu input isn't valid
         else
         {
            //error message
            JOptionPane.showMessageDialog(null, "Sorry, you have entered an invalid input");
         }      
      }
   }
}
