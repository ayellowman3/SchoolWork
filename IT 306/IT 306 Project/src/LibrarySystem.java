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

public class LibrarySystem{
    public static void main(String[] args){
        String userPath = "./user.txt";
        User[] user = new User[1000];
        popUser(user, userPath);
        mainGUI(user);
    }

    public static void mainGUI(User[] user){
        if(User.getCount() == 0){
            System.out.println("create admin");
        }
    }

    public static void popUser(User[] user, String path){
        int counter = 0;
        File file = new File(path);

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String nextLine;

            String type;
            String email;
            String password;

            while((nextLine = br.readLine()) != null){
                type = stripType(nextLine);
                email = stripMid(nextLine, 1, 2);
                password = stripLast(nextLine);
                if(type.equals("Admin")){
                    user[counter] = new Admin(email, password);
                }
                else if(type.equals("Employee")){
                    user[counter] = new Employee(email, password);
                }
                else{
                    user[counter] = new User(email, password);
                }
                counter++;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
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

}
