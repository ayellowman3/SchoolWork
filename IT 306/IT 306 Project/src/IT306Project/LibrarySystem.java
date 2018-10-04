/*
 * Project phase 4
 * George Huang, G00775631, ghuang3@masonlive.gmu.edu
 * Ryan Evans, G00954546, revans17@masonlive.gmu.edu
 * Steven Chen, G00652234, schen27@masonlive.gmu.edu
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
import java.util.ArrayList;
import java.util.*;



public class LibrarySystem{
    public static void main(String[] args){
        String userPath = "./user.txt";
        String resourcePath = "./resource.txt";

        ArrayList<User> user = new ArrayList<User>();

        ArrayList<Resource> resource = new ArrayList<Resource>();
        popUser(user, userPath);
        popResource(resource, resourcePath);
        mainGUI(user, resource);
        writeUser(user, userPath);
        writeResource(resource, resourcePath);
    }

    public static void mainGUI(ArrayList<User> user, ArrayList<Resource> resource){
        if(user.size() == 0){
            createAdmin(user);
            mainGUI(user, resource);
        }
        else{
            loginMenu(user, resource);
        }
    }

    public static void loginMenu(ArrayList<User> user, ArrayList<Resource> resource){

        int option = -1;
        String message = "Welcome\n" +
                        "[1] Login\n" +
                        "[2] Create new account\n" +
                        "[0] Exit";
        while(option != 0){
            option = getIntInput(message, 0, 2);
            switch(option){
                case 1:
                    login(user, resource);
                    break;
                case 2:
                    createNewUser(user);
                    break;
                case 3:
                    break;
                default:
                    option = 0;
                    break;
            }
        }
    }

    public static void login(ArrayList<User> user, ArrayList<Resource> resource){
        String username;
        String password;

        username = stringInput("Enter username");
        password = stringInput("Enter password");

        for (int i = 0; i < user.size(); i++) {
           if(user.get(i).getUsername().equals(username)){
               if(user.get(i).getPassword().equals(password)){
                   successLogin(user.get(i), user, resource);
               }else{
                   System.out.println("invalid Password");
               }
           }
      }
    }

    public static void successLogin(User user, ArrayList<User> users, ArrayList<Resource> resource){
        if(user instanceof Admin){
            adminGUI(users, resource);
        }
        else if(user instanceof Employee){
            employeeGUI(users, resource);
        }else{
            System.out.println("hi3");
            userGUI(resource);
        }
    }

    public static void userGUI(ArrayList<Resource> resource){
        ArrayList<Resource> tempResource = new ArrayList<Resource>();
        tempResource = copyResource(resource);

        String gui = "[1] Display resources\n" +
                    "[0] Exit";
        int option = -1;
        while(option != 0){
            option = getIntInput(gui, 0, 1);
            switch(option){
                case 1:
                    displayResources(tempResource);
                    break;
                case 2:
                    break;
                default:
                    option = 0;
                    break;
            }
        }

    }

    public static void employeeGUI(ArrayList<User> user, ArrayList<Resource> resource){
        ArrayList <Resource> tempResource = new ArrayList<Resource>();
        tempResource = copyResource(resource);

        String gui = "[1] Search for Resource\n"+
                 "[2] Checkout\n"+
                 "[3] Return\n"+
                 "[4] Update Resource\n"+
                 "[5] Add Resource\n"+
                 "[0] Exit";
        int option = -1;
        while(option != 0){
            option = getIntInput(gui, 0, 5);
            switch(option){
                case 1:
                    displayResources(tempResource);
                    break;
                case 2:
                    checkout(user, resource);
                    break;
                case 3:
                    returnResource(user, resource);
                    break;
                case 4:
                    updateResource(resource);
                    tempResource = copyResource(resource);
                    break;
                case 5:
                    addResource(resource);
                    tempResource = copyResource(resource);
                    break;
                case 6:
                    break;

            }
        }
    }

    public static void adminGUI(ArrayList<User> user, ArrayList<Resource> resource){
        ArrayList <Resource> tempResource = new ArrayList<Resource>();
        tempResource = copyResource(resource);

        String gui ="[1] Search for Resource\n"+
                    "[2] Checkout\n"+
                    "[3] Return\n"+
                    "[4] Update Resource\n"+
                    "[5] Add Resource\n"+
                    "[6] Add Employee\n"+
                    "[7] Modify Employee\n"+
                    "[8] Delete User\n"+
                    "[0] Exit";
        int option = -1;
        while(option != 0){
            option = getIntInput(gui, 0, 8);
            switch(option){
                case 1:
                    displayResources(tempResource);
                    break;
                case 2:
                    checkout(user, resource);
                    break;
                case 3:
                    returnResource(user, resource);
                    break;
                case 4:
                    updateResource(resource);
                    tempResource = copyResource(resource);
                    break;
                case 5:
                    addResource(resource);
                    tempResource = copyResource(resource);
                    break;
                case 6:
                    addEmployee(user);
                    break;
                case 7:
                    modifyEmployee(user);
                    break;
                case 8:
                    deleteUser(user);
                    break;

            }
        }
    }

    public static void displayResources(ArrayList<Resource> resource){
        String display;

        display = "List of resources\n\n[1]Sort\n[2]Filter\n[0]Exit\n";
        for(int i = 0; i < resource.size(); i++){
            display += "\n" + resource.get(i).getID() + ": " + resource.get(i).getName() + " ";
            if(resource.get(i).getCheckedOut()){
                display += "Checked Out";
            }else{
                display += "In stock";
            }
        }

        int input = getIntInput(display, 0, 2);
        switch(input){
            case 1:
                sort(resource);
                break;
            case 2:
                filter(resource);
                break;
        }
    }

    public static void filter(ArrayList<Resource> resource){
        ArrayList <Resource> tempResource = new ArrayList<Resource>();
        tempResource = copyResource(resource);

        String gui = "[1] Author\n"+
                 "[2] Genre\n"+
                 "[0] Exit";
        int option;
        option = getIntInput(gui, 0, 2);
            switch(option){
                case 1:
                    filterAuthor(tempResource);
                    break;
                case 2:
                    filterCategory(tempResource);
                    break;
                case 0:

                    break;
        }
    }
    public static void filterAuthor(ArrayList<Resource> resource){
        String aut = stringInput("Enter author's name: ");
        ArrayList<Resource> temp = new ArrayList<Resource>();
        for(int i = 0; i < resource.size(); i++){
            System.out.println(resource.get(i).getAuthor());
            if(resource.get(i).getAuthor().equals(aut)){
                temp.add(resource.get(i));
            }
        }
        displayResources(temp);
    }
    public static void filterCategory(ArrayList<Resource> resource){
        String gen = stringInput("Enter genre: ");
        ArrayList<Resource> temp = new ArrayList<Resource>();
        for(int i = 0; i < resource.size(); i++){
            if(resource.get(i).getGenre().equals(gen)){
                temp.add(resource.get(i));
            }
        }
        displayResources(temp);
    }

    public static void sort(ArrayList<Resource> resource){
        String message = "What would you like to sort by?\n\n" +
                        "[1] ID\n" +
                        //"[2] Title\n" +
                        "[0] Exit";

        int input = getIntInput(message, 0, 1);
        switch(input){
            case 1:
                sortByID(resource);
                break;
            case 2:
                //sortByTitle(resource);
                break;
            case 0:
                break;
        }
    }

    public static void sortByID(ArrayList<Resource> resource){
        Collections.sort(resource, new ComparatorByID());
        displayResources(resource);
    }

    /*public static void sortByTitle(ArrayList<Resource> resource){

        displayResources(resource);
    }*/

    public static void popUser(ArrayList<User> user, String path){
        int counter = 0; File file = new File(path);

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String nextLine;
            //Admin : 1 : George : Huang : ghuang3 : password : ghuang3@masonlive.gmu.edu : 13259 Middleton Farm Ln : 1

            String type;
            String userID;
            String fName;
            String lName;
            String username;
            String password;
            String email;
            String address;
            String resource;

            while((nextLine = br.readLine()) != null){
                type = stripType(nextLine);
                userID = stripMid(nextLine, 1, 2);
                fName = stripMid(nextLine, 2, 3);
                lName = stripMid(nextLine, 3, 4);
                username = stripMid(nextLine, 4, 5);
                password = stripMid(nextLine, 5, 6);
                email = stripMid(nextLine, 6, 7);
                address = stripMid(nextLine, 7, 8);
                resource = stripLast(nextLine);

                if(type.equals("Admin")){
                    user.add(new Admin(userID, fName, lName, username, password, email, address, resource));
                }
                else if(type.equals("Employee")){
                    user.add(new Employee(userID, fName, lName, username, password, email, address, resource));
                }
                else{
                    user.add(new User(userID, fName, lName, username, password, email, address, resource));
                }
                counter++;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void popResource(ArrayList<Resource> re, String path){
        int counter = 0;
        File file = new File(path);

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String nextLine;
            String id;
            String type;
            String name;
            String genre;
            String authorID;
            String year;
            String userID;
            Boolean checkedOut;

            while((nextLine = br.readLine()) != null){
                //1 : Book : Taco : Non-Fiction : 1 : 2017 : 1 : True

                id = stripType(nextLine);
                type = stripMid(nextLine, 1, 2);
                name = stripMid(nextLine, 2, 3);
                genre = stripMid(nextLine, 3, 4);
                authorID = stripMid(nextLine, 4, 5);
                year = stripMid(nextLine, 5, 6);
                userID = stripMid(nextLine, 6, 7);
                checkedOut = stripLast(nextLine).equals("True");
                re.add(new Resource(id, type, name, genre, authorID, year, userID, checkedOut));
                counter++;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void writeUser(ArrayList<User> user, String path){
        PrintWriter pw = null;
        String userID;
        String fName;
        String lName;
        String username;
        String password;
        String email;
        String address;
        String resource;

        String write;

        final String Space = " : ";
        try{
            pw = new PrintWriter(path);
            for(int i = 0; i < user.size(); i++){
                if(user.get(i) != null){
                    userID = user.get(i).getUserID();
                    fName = user.get(i).getFName();
                    lName = user.get(i).getLName();
                    username = user.get(i).getUsername();
                    password = user.get(i).getPassword();
                    email = user.get(i).getEmail();
                    address = user.get(i).getAddress();
                    resource = user.get(i).getResource();
                    if(i > 0){
                        write = "\n";
                    }else{
                        write = "";
                    }
                    if(user.get(i) instanceof Admin){
                        write += "Admin" + Space;
                    }else if(user.get(i) instanceof Employee){
                        write += "Employee" + Space;
                    }else{
                        write += "User" + Space;
                    }
                    write += userID + Space + fName + Space + lName + Space + username + Space + password + Space + email + Space + address + Space + resource;

                    ;
                    pw.write(write);
                }
            }
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
    }

    public static void writeResource(ArrayList<Resource> re, String path){
        PrintWriter pw = null;
        String write;

        String id;
        String type;
        String name;
        String genre;
        String author;
        String year;
        String userID;
        String checkedOut;
        final String Space = " : ";
        try{
            pw = new PrintWriter(path);
            for(int i = 0; i < re.size(); i++){
                if(re.get(i) != null){
                    id = re.get(i).getID();
                    type = re.get(i).getType();
                    name = re.get(i).getName();
                    genre = re.get(i).getGenre();
                    author = re.get(i).getAuthor();
                    year = re.get(i).getYear();
                    userID = re.get(i).getUserID();
                    if(re.get(i).getCheckedOut()){
                        checkedOut = "True";
                    }else{
                        checkedOut = "False";
                    }
                    if(i > 0){
                        write = "\n";
                    }else{
                        write = "";
                    }
                    write += id + Space + type + Space + name + Space + genre + Space +
                    author + Space +
                    year + Space +
                    userID + Space +
                    checkedOut;
                    pw.write(write);
                }
            }
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
    }

    public static String stripType(String line){
        int first = 0;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ':'){
                return line.substring(0, i-1);
            }
        }
        return "";
    }

    public static String stripMid(String line, int uno, int dos){
        int counter = 0;
        int first = 0;
        int second = 0;

        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ':'){
                counter++;
                if(counter == uno){
                    first = i;
                }
                if(counter == dos){
                    second = i;
                }
            }
        }
        return line.substring(first + 2, second - 1);
    }

    public static String stripLast(String line){
        int last = 0;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ':'){
                last = i;
            }
        }

        return line.substring(last+2, line.length());
    }

    public static void createAdmin(ArrayList<User> user){
        String userID;
        String fName;
        String lName;
        String username;
        String password;
        String email;
        String address;
        String resource;

        fName = stringInput("Enter admin's first name");
        lName = stringInput("Enter admin's last name");
        username = usernameInput(user, "Enter admin's username");
        password = passwordInput(user, "Enter admin's password");
        email = emailInput("Enter admin's email");
        address = stringInput("Enter admin's address");

        user.add(new Admin("1", fName, lName, username, password, email, address, "0"));
    }

    public static void createNewUser(ArrayList<User> user){

        String userID;
        String fName;
        String lName;
        String username;
        String password;
        String email;
        String address;
        String resource;

        int nextID = User.getLastUserID() + 1;
        userID = "" + nextID;
        fName = stringInput("Enter user's first name");
        lName = stringInput("Enter user's last name");
        username = usernameInput(user, "Enter user's username");
        password = passwordInput(user, "Enter user's password");
        email = emailInput("Enter user's email");
        address = stringInput("Enter user's address");

        JOptionPane.showMessageDialog(null, "Your user ID is: " + userID);
        user.add(new User(userID, fName, lName, username, password, email, address, "0"));
    }

    public static void addEmployee(ArrayList<User> user){

        String userID;
        String fName;
        String lName;
        String username;
        String password;
        String email;
        String address;
        String resource;

        int nextID = User.getLastUserID() + 1;
        userID = "" + nextID;
        fName = stringInput("Enter employee's first name");
        lName = stringInput("Enter employee's last name");
        username = usernameInput(user, "Enter employee's username");
        password = passwordInput(user, "Enter employee's password");
        email = emailInput("Enter employee's email");
        address = stringInput("Enter employee's address");

        JOptionPane.showMessageDialog(null, "Your user ID is: " + userID);
        user.add(new Employee(userID, fName, lName, username, password, email, address, "0"));
    }

    public static String stringInput(String message){
        String s = "";
        s = JOptionPane.showInputDialog(message);
        if(s.equals("")){
            JOptionPane.showMessageDialog(null, "Error! Invalid input!");
            s = stringInput(message);
        }
        return s;
    }

    public static int getIntInput(String message, int min, int max){
        int input = 0;
        try{
            input = Integer.parseInt(JOptionPane.showInputDialog(message));
        }catch(NumberFormatException e){
            input = 0;
        }
        if(input < min || input > max){
            JOptionPane.showMessageDialog(null, "Error! Invalid input entered!");
            input = getIntInput(message, min, max);
        }
        return input;
    }

    public static String usernameInput(ArrayList<User> user, String s){
        String username;
        username = stringInput(s);
        for(int i = 0; i < user.size(); i++){
            if(username.equals(user.get(i).getUsername())){
                JOptionPane.showMessageDialog(null, "Error, Username is already used");
                return usernameInput(user, s);
            }
        }
        return username;
    }

    public static String passwordInput(ArrayList<User> user, String s){
        String password;
        password = stringInput(s);
        if(!validatePW(password)){
            JOptionPane.showMessageDialog(null, "Error, Password does not meet requirments\n8 character length\n1 uppercase\n1 lowercase\n1 number");
            return passwordInput(user, s);
        }
        return password;
    }

    public static boolean validatePW(String pw){

        boolean uc = false;
        boolean lc = false;
        boolean nu = false;

        if(pw.length() < 8){
            return false;
        }
        for(int i = 0; i < pw.length();i++){
            if(Character.isDigit(pw.charAt(i))){
                nu = true;
            }
            if(Character.isLowerCase(pw.charAt(i))){
                lc = true;
            }
            if(Character.isUpperCase(pw.charAt(i))){
                uc = true;
            }
        }
        System.out.println(uc && lc && nu);
        return(uc && lc && nu);
    }

    public static String emailInput(String s){
        String email;
        email = stringInput(s);
        if(!validateEmail(email)){
            JOptionPane.showMessageDialog(null, "Error, Please enter a valid email\n(1+)@(1+).(2-4)");
            return emailInput(s);
        }
        return email;
    }

    public static boolean validateEmail(String email){
        int at = 0;
        int atIndex = 0;
        int p = 0;
        int lastP = 0;
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@'){
                at++;
                atIndex = i;
            }
        }
        if(at < 1 || at > 1){
            return false;
        }
        for(int i = atIndex; i < email.length(); i++){
            if(email.charAt(i) == '.'){
                p++;
                lastP = i;
            }
        }
        if(p < 1){
            return false;
        }
        if(atIndex < 1){
            return false;
        }
        if(lastP - atIndex <= 1){
            return false;
        }
        int el = email.length();
        if(el - lastP < 3 || el - lastP > 5 ){
            return false;
        }
        return true;
    }

    public static ArrayList<Resource> copyResource(ArrayList<Resource> resource){
        ArrayList<Resource> tempResource = new ArrayList<Resource>();
        for(int i = 0; i < resource.size(); i++){
            tempResource.add(resource.get(i));
        }
        return tempResource;
    }

    public static void checkout(ArrayList<User> users, ArrayList<Resource> resources){
        String userID;
        String bookID;

        User user = null;
        Resource resource = null;

        userID = stringInput("Enter user ID for checkout: ");
        bookID = stringInput("Enter resource id for checkout: ");
        for(int i = 0; i < users.size(); i++){
            if(userID.equals(users.get(i).getUserID())){
                user = users.get(i);
                break;
            }
        }
        for(int i = 0; i < resources.size(); i++){
            if(bookID.equals(resources.get(i).getID())){
                resource = resources.get(i);
                break;
            }
        }

        if(user == null){
            JOptionPane.showMessageDialog(null, "Error! User or  could not be found");
        }else if(resource == null){
            JOptionPane.showMessageDialog(null, "Error!  or Resource could not be found");
        }else{
            if(user.getResource().equals("0")){
                if(resource.getCheckedOut() == false){
                    user.setResource(resource.getID());
                    resource.setUserID(user.getUserID());
                    resource.setCheckedOut(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Sorry! The resource is already checked out");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Sorry! The user already has a resource checked out");
            }
        }
    }

    public static void returnResource(ArrayList<User> users, ArrayList<Resource> resources){
        String resourceID;
        Resource resource = null;
        resourceID = stringInput("Enter resource id for return: ");


        for(int i = 0; i < resources.size(); i++){
            if(resourceID.equals(resources.get(i).getID())){
                resource = resources.get(i);
                break;
            }
        }

        if(resource == null){
            JOptionPane.showMessageDialog(null, "The resource can not be found");
        }else{
            if(resource.getCheckedOut()){
                for(int i = 0; i < users.size(); i++){
                    if(resource.getUserID().equals(users.get(i).getUserID())){
                        users.get(i).setResource("0");
                        resource.setUserID("0");
                        resource.setCheckedOut(false);
                    }
                }
                JOptionPane.showMessageDialog(null, "Success, the resource has been returned");
            }else{
                JOptionPane.showMessageDialog(null, "The resource isn't checked out");
            }
        }
    }

    public static void updateResource(ArrayList<Resource> resource){
        String display = displayResourcesTitle(resource);

        int edit = getIntInput(display, 0, resource.size());
        if(edit>0){
            update(resource.get(edit - 1));
        }
    }

    public static String displayResourcesTitle(ArrayList<Resource> resource){
        String display = "Which resource would you like to update?\n";


        for(int i = 0; i < resource.size(); i++){
            display += "\n[" + (i + 1) + "]" + resource.get(i).getName();
        }
        display+="\n[" + 0 + "] Exit";
        return display;
    }

    public static void update(Resource resource){
        //VHS : Cat : Fiction : 2 : 2016 : 0 : False
        String newUpdate;
        String display = "What would you like to update?"+
        "[1] Type: " + resource.getType() + "\n" +
        "[2] Title: " + resource.getName() + "\n" +
        "[3] Genre: " + resource.getGenre() + "\n" +
        "[4] Author: " + resource.getAuthor() + "\n" +
        "[5] Year: " + resource.getYear() + "\n" +
        "[0] Exit";

        int edit = getIntInput(display, 0,5);

        switch(edit){
            case 1:
                newUpdate = edit("type", resource.getType());
                resource.setType(newUpdate);
                break;
            case 2:
                newUpdate = edit("title", resource.getName());
                resource.setName(newUpdate);
                break;
            case 3:
                newUpdate = edit("genre", resource.getGenre());
                resource.setGenre(newUpdate);
                break;
            case 4:
                newUpdate = edit("author", resource.getAuthor());
                resource.setAuthor(newUpdate);
                break;
            case 5:
                newUpdate = edit("year", resource.getYear());
                resource.setYear(newUpdate);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "should not reach here");
        }
    }

    public static String edit(String e, String current){
        String change;
        change = stringInput("Change " + e + " from " + current + " to: ");
        return change;
    }

    public static void addResource(ArrayList<Resource> resource){
        //2 : VHS : Cat : Fiction : 2 : 2020 : 0 : False
        String id;
        String type;
        String name;
        String genre;
        String author;
        String year;
        String userID = "0";
        Boolean checkedOut = false;

        int nextID = Resource.getLastID() + 1;
        id = "" + nextID;
        type = stringInput("What type is the resource");
        name = stringInput("What is the name of the resource");
        genre = stringInput("What genre is the resource");
        author = stringInput("Who is the author");
        year = stringInput("What year is it published");

        resource.add(new Resource(id, type, name, genre, author, year, userID, checkedOut));
    }

    public static void modifyEmployee(ArrayList<User> user){
        ArrayList<User> users = new ArrayList<User>();
        users = filterEmployeeList(user);

        String display = getEmployeeList(users);

        int edit = getIntInput(display, 0, users.size());
        if(edit>0){
            update(users.get(edit - 1), user);
        }

    }

    public static ArrayList<User> filterEmployeeList(ArrayList<User> user){
        ArrayList<User> users = new ArrayList<User>();
        for(int i = 0; i < user.size(); i++){
            if(user.get(i) instanceof Employee || user.get(i) instanceof Admin){
                users.add(user.get(i));
            }
        }
        return users;
    }

    public static String getEmployeeList(ArrayList<User> user){
        String display = "Which employee would you like to update?\n";
        for(int i = 0; i < user.size(); i++){
            display += "\n[" + (i + 1) + "]" + user.get(i).getFName() + " " + user.get(i).getLName();
        }

        display+="\n[" + 0 + "] Exit";
        return display;
    }

    public static void update(User user, ArrayList<User> users){
        //User : 1002 : Panda : Huang : panda : password : ayellowman@gmail.com : 123 x street : 0
        String newUpdate;
        String display = "What would you like to update?\n\n"+
        "[1] First Name: " + user.getFName() + "\n" +
        "[2] Last Name: " + user.getLName() + "\n" +
        "[3] Username: " + user.getUsername() + "\n" +
        "[4] Password: " + user.getPassword() + "\n" +
        "[5] Email: " + user.getEmail() + "\n" +
        "[6] Address: " + user.getAddress() + "\n";
        if(user instanceof Admin){
            display += "[7] Make Employee \n";
        }else{
            display += "[7] Make Admin \n";
        }
        display += "[0] Exit";

        int edit = getIntInput(display, 0,7);

        switch(edit){
            case 1:
                newUpdate = edit("First Name", user.getFName());
                user.setFName(newUpdate);
                break;
            case 2:
                newUpdate = edit("Last Name", user.getLName());
                user.setLName(newUpdate);
                break;
            case 3:
                newUpdate = edit("Username", user.getUsername());
                user.setUsername(newUpdate);
                break;
            case 4:
                newUpdate = edit("Password", user.getPassword());
                user.setPassword(newUpdate);
                break;
            case 5:
                newUpdate = edit("Email", user.getEmail());
                user.setEmail(newUpdate);
                break;
            case 6:
                newUpdate = edit("Address", user.getAddress());
                user.setAddress(newUpdate);
                break;
            case 7:
                changeEmployeeType(user, users);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "should not reach here");
        }
    }

    public static void changeEmployeeType(User user, ArrayList<User> users){
        User u;
        if(user instanceof Admin){
            u = new Employee(user.getUserID(), user.getFName(), user.getLName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAddress(), user.getResource());
        }else{
            u = new Admin(user.getUserID(), user.getFName(), user.getLName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAddress(), user.getResource());
        }
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserID().equals(u.getUserID())){
                users.set(i, u);
            }
        }
    }

    public static void deleteUser(ArrayList<User> users){
        String display = "Which employee would you like to Delete?\n";
        for(int i = 0; i < users.size(); i++){
            display += "\n[" + (i + 1) + "]" + users.get(i).getFName() + " " + users.get(i).getLName();
        }
        display+="\n[" + 0 + "] Exit";

        int delete = getIntInput(display, 0, users.size());
        if (delete > 0) {
            if(users.get(delete - 1).getResource() == "0"){
                users.remove(delete - 1);
            }else{
                JOptionPane.showMessageDialog(null, "Can't delete user. User has a resource checked out");
            }
        }
    }
}
