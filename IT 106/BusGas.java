/*
Name: George Huang
Date: 4/17/2016
Course/Section: IT 106.001
Assignment: Programming Assignment 8

Description:
This program generates a message with the total amount of routes driven by the mason shuttle,
the amount of times each route was driven, and the total amount of gasoline to cover the routes.
The program will continually ask the user to enter routes until 106 routes have been entered or
the user enters "Done". Once the user enters all the routes, the program will calculate how many
of each route will run, the total number of routes entered, and the amount of gasoline to cover
all the routes

USER INPUT:

STFC - Science and Technology to Fairfax Campus
FCST - Fairfax Campus to Science and Technology
FCMT - Fairfax Campus to Metro
MTFC - Metro to Fairfax Campus
Done - Exits the program

If the user enters anything else, the program will display an error message and ask for the user
to enter something else. Entering Done will stop the program asking for more routes.

The total routes are calculated by counting how many user inputs that were routes

The total miles is a sum of the total miles driven with the distance for each route to travel.

STFC and FCST increases the total miles by 21
FCMT and MTFC increases the total miles by 7

The total amount of gasoline is calculated by dividing the total miles by 24

If the route count is 0, then the program will return a message saying no shuttle were run today

If the route count is greater than 0, the program will return a message with the following

Number of routes the shuttle will run
Number of times each route were run
The amount of Gasoline needed to cover the routes in Gallons
*/
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BusGas
{
   public static void main(String[] args)
   {  
      
      ArrayList<String> routes = getRouteList(); //initialize arraylist
      int route_Count = routes.size(); //get the size of of the array, count how many routes were entered
      int[] route_Tally = new int[4]; //initialize array for a tally for each route that was run
      String total_Gas = ""; //total amount of gas
      if (route_Count > 0) //if there is at least 1 route entered, run this
      {
         int total_Miles = getTotalMiles(routes, route_Count);//method to get the total miles driven
         route_Tally = getRouteTally(routes, route_Count); //method to count how many times each route was driven
         total_Gas = getTotalGas(total_Miles); //method to calculate total amount of Gas needed
      }
      String print_Message = getPrintMessage(route_Count, route_Tally, total_Gas);//get the message to print out
      JOptionPane.showMessageDialog(null, print_Message);//prints out ending message
      
   }
   public static ArrayList<String> getRouteList() //method to get the list of routes
   {
      int route_Count = 0; //keeps count of how many routes have been entered
      ArrayList<String> routes = new ArrayList<String>(); //initalize arraylist for routes
      String route_Input = ""; //initalize string for input
      do
      {
      route_Input = getRoute(); //method to get route input
      if(!route_Input.equals("Done"))
         {
            routes.add(route_Input); //add to arraylist
            route_Count++; //count increases
         }
      }while (route_Count < 106 && !route_Input.equals("Done"));
      return routes; //return arraylist of routes
   }
   public static String getRoute() //method to get user input for routes
   {
      String route_Input = ""; 
      do
      {
         route_Input = JOptionPane.showInputDialog("Enter Route Code\n(Enter Done to Exit)"); //prompt for input
         if(!route_Input.equals("Done") && !route_Input.equals("STFC") && !route_Input.equals("FCST") && !route_Input.equals("FCMT") && !route_Input.equals("MTFC"))
         {
            JOptionPane.showMessageDialog(null, "You have entered an invalid route"); //display if invalid user input
         }
      }while(!route_Input.equals("Done") && !route_Input.equals("STFC") && !route_Input.equals("FCST") && !route_Input.equals("FCMT") && !route_Input.equals("MTFC"));//exit condition is valid input
      return route_Input;//returns valid user input
   }
   public static int getTotalMiles(ArrayList<String> routes, int route_Count) //method to get total miles
   {
      int total_Miles = 0;//miles counter
      for(int routes_Index = 0; routes_Index < route_Count; routes_Index++) //goes through each element in arraylist
      {
         if(routes.get(routes_Index).equals("STFC") || routes.get(routes_Index).equals("FCST"))//if it's one of these two routes, increase miles count by 21
         {
            total_Miles += 21;
         }
         else //anything else would increase the miles count by 7
         {
            total_Miles += 7;
         }
      }
      return total_Miles; //return total miles
         
   }
   public static int[] getRouteTally(ArrayList<String> routes, int route_Count)//method to tally each route driven
   {
      //initalize variable to count each route driven
      int fcstTally = 0;
      int stfcTally = 0;
      int fcmtTally = 0;
      int mtfcTally = 0;
      for(int routes_Index = 0; routes_Index < route_Count; routes_Index++)//goes though each element and count how many of each were entered
      {
         switch (routes.get(routes_Index))
         {
            //if matches, increases respective count
            case "FCST": fcstTally++; 
                     break;
            case "STFC": stfcTally++;
                     break;
            case "FCMT": fcmtTally++;
                     break;
            case "MTFC": mtfcTally++;
                     break;
            
         }
      }

      int[] routeTally = {fcstTally, stfcTally, fcmtTally, mtfcTally};//turns the tally into an array
      return routeTally;//return the count
   }
   public static String getPrintMessage(int route_Count,int[] route_Tally, String total_Gas)//method to get return message
   {
      String print_Message = ""; //initalize return message string
      if(route_Count == 0) //if no routes were entered
      {
         print_Message = "No shuttles were run today!";
      }
      else //if routes were entered, generate return message
      {
         print_Message+= "***********George Mason Shuttle Report************\n\n";
         print_Message+= "Number of routes completed: " + route_Count + "\n\n";
         print_Message+= "*******Number of Times Each Route Travelled*******\n";
         print_Message+= "Fairfax Campus to Science and Technology Campus: " + route_Tally[0];
         print_Message+= "\nScience and Technology Campus to Fairfax Campus: " + route_Tally[1];
         print_Message+= "\nFairfax Campus to Metro: " + route_Tally[2];
         print_Message+= "\nMetro to Fairfax Campus: " + route_Tally[3];
         print_Message+= "\n\n\n";
         print_Message+= "Total Amount of Gasoline: " + total_Gas + " Gallons";
         
      }
      return print_Message; //return message
   }
   public static String getTotalGas(int total_Miles)//method to calculate the total amount of gallons of gas needed
   {
      double total_Gas_Double = total_Miles/24.0; //divide miles driven by 24 mpg
      String total_Gas = String.format("%1$,.3f", total_Gas_Double);
      return total_Gas; //return total gas
   }
   
}