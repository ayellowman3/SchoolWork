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

public class Application{
	public static void main(String[] args){
		String empPath = "./src/Employee.txt";
		String itemPath = "./src/Item.txt";
		mainGUI(empPath, itemPath);
	}

	public static void mainGUI(String empPath, String itemPath){
		Employee[] emp = new Employee[100];
		Item[] item = new Item[100];
		popEmployee(emp, empPath);
		popItem(item, itemPath);
		//displayAll(item);
		String display =   "\n"
		                +  "              Welcome              \n\n"
		                +  "[1] Admin Login\n"
		                +  "[2] Employee Login\n"
		                +  "[3] Exit\n";
		
		int input = 0;
		boolean login = false;
		do{
			input = getIntInput(display);
			switch (input){
				case 1: login = adminLogin(emp);
				break;
				case 2: login = employeeLogin(emp);
				break;
				case 3: 
				break;
				default:
				input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error, Invalid command entered!");
			}
			if(login){
				if(input == 1){
					adminGUI(emp, item);
				}
				else{
					empGUI(item);
				}
			}
			login = false;

		}while (input != 3);
	}
	
	public static void popEmployee(Employee[] emp, String empPath){
		int counter = 0;
		File file = new File(empPath);

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String nextLine;

			String type;
			String fName;
			String lName;
			String email;
			String password;

			while((nextLine = br.readLine()) != null){
				type = strStripFront(nextLine);
				fName = strStripMid(nextLine, 1, 2);
				lName = strStripMid(nextLine, 2, 3);
				email = strStripMid(nextLine, 3, 4);
				password = strStripLast(nextLine);
				if(type.equals("Admin")){
					emp[counter] = new Admin(fName, lName, email, password);
				}
				else{
					emp[counter] = new Employee(fName, lName, email, password);
				}
				counter++;
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void popItem(Item[] item, String itemPath){
		int counter = 0;
		File file = new File(itemPath);

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String nextLine;

			String type;
			double cost;
			int quantity;
			int sold;
			
			while((nextLine = br.readLine()) != null){
				type = strStripFront(nextLine);
				cost = Double.parseDouble(strStripMid(nextLine, 1, 2));
				quantity = Integer.parseInt(strStripMid(nextLine, 2, 3));
				sold = Integer.parseInt(strStripMid(nextLine, 3, 4));
				if(type.equals("Clothes")){
					String brand = strStripMid(nextLine, 4, 5);
					String color = strStripMid(nextLine, 5, 6);;
					int s = Integer.parseInt(strStripMid(nextLine, 6, 7));
					int m = Integer.parseInt(strStripMid(nextLine, 7, 8));
					int l = Integer.parseInt(strStripMid(nextLine, 8, 9));
					int xl = Integer.parseInt(strStripLast(nextLine));
					item[counter] = new Clothes(cost, quantity, sold, brand, color, s, m, l, xl);
					counter++;
				}
				else if(type.equals("Books")){
					String title = strStripMid(nextLine, 4, 5);
					String author = strStripMid(nextLine, 5, 6);
					String genre = strStripLast(nextLine);
					item[counter] = new Books(cost, quantity, sold, title, author, genre);
					counter++;
				}
				else{	
					String name = strStripMid(nextLine, 4, 5);
					int min_age = Integer.parseInt(strStripMid(nextLine, 5, 6));
					int max_age = Integer.parseInt(strStripLast(nextLine));
					item[counter] = new Toys(cost, quantity, sold, name, min_age, max_age);
					counter++;
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String strStripFront(String line){
		int first = 0;
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == ':' && first == 0){
				first = i;
			}
		}
		return line.substring(0, first - 1);
	}

	public static String strStripMid(String line, int uno, int dos){
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

	public static String strStripLast(String line){
		int last = 0;
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == ':'){
				last = i;
			}
		}
		return line.substring(last + 2, line.length());
	}

	public static boolean adminLogin(Employee[] emp){
		String login;
		String password;
		Boolean found = false;

		login = JOptionPane.showInputDialog("Enter user ID: ");
		password = JOptionPane.showInputDialog("Enter password");

		for(int i = 0; i < emp[0].getCount(); i++){
			if(login.equals(emp[i].getEmail())){
				found = true;
				if(password.equals(emp[i].getPassword())){
					if(emp[i] instanceof Admin){
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null, "Employees do not have administrative privilages");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Error! Invalid password entered!");
				}
			}
		}
		if(!found){
			JOptionPane.showMessageDialog(null, "Error! user login does not exist!");
		}
		return false;
	}

	public static void adminGUI(Employee[] emp, Item[] item){
		String display = "Admin menu\n\n" +  
						"[1] Order Items\n" +
						"[2] Add New Items\n" +
						"[3] Delete Items\n" +
						"[4] Add New Employee\n" +
						"[5] View Items\n" +
						"[6] Sort Items\n" +
						"[7] Search Items\n" +
						"[8] Exit";
		int input = 0;
		do{
			input = getIntInput(display);
			switch(input){
				case 1: orderItem(item);
					break;
				case 2:	addNewItem(item);
					break;
				case 3: deleteItem(item);
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				default:
					input = 0;
				}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
		}while(input != 8);
	}

	public static void empGUI(Item[] item){	
		String display = "Employee Menu\n\n" + 
						"[1] View Items\n" +
						"[2] Sort Items\n" +
						"[3] Search Items\n" +
						"[4] Exit";
	}
				
	public static boolean employeeLogin(Employee[] emp){
		String login;
		String password;
		boolean found = false;

		login = JOptionPane.showInputDialog("Enter user ID: ");
		password = JOptionPane.showInputDialog("Enter password");

		for(int i = 0; i < emp[0].getCount(); i++){
			if(login.equals(emp[i].getEmail())){
				found = true;
				if(password.equals(emp[i].getPassword())){
					return true;
				}
				else{
					JOptionPane.showMessageDialog(null, "Error! Invalid password entered!");
				}
			}
		}
		if(!found){
			JOptionPane.showMessageDialog(null, "Error! user login does not exist!");
		}
		return false;
	}

	public static void orderItem(Item[] item){
		String types =  "Which type of item would you like to reorder\n\n" +
						"[1] Clothes\n" +
						"[2] Books\n" +
						"[3] Toys\n" +
						"[4] Exit";
		int input = 0;
		do{
			input = getIntInput(types);
			switch(input){
				case 1: orderClothes(item);
					break;
				case 2: orderBooks(item);
					break;
				case 3: orderToys(item);
					break;
				case 4:
					break;
				default:
					input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
		}while(input != 4);
		write(item, "./src/testItem.txt");
	}

	public static void orderClothes(Item[] item){
		int count = 0;
		Item[] cItem = new Item[100];
		for(int i = 0; i < item[0].getCount(); i++){
			if(item[i] instanceof Clothes){
				cItem[count] = item[i];
				count++;
			}
		}
		String list = listItem(cItem, count);
		int input = 0;
		do{
			input = getIntInput(list);
			if(input < 1 || input > 1 + count){
				input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
			else if(input != 1 + count){
				orderClothesSize((Clothes) cItem[input - 1]);
			}
		}while (input != 1 + count);
	}

	public static void orderClothesSize(Clothes c){
		String message = "What size " + c.getColor() + " " + c.getBrand() +" you like to reorder?\n\n" + 
						"[1] s: " + c.getS() +
						"\n[2] m: " + c.getM() +
						"\n[3] l: " + c.getL() +
						"\n[4] xl: " + c.getXl() +
						"\n[5] Exit";
		int input = 0;
		do{
			input = getIntInput(message);
			switch(input){
				case 1: c.setS(c.getS() + getIntInput("How many would you like to order?"));
					break;
				case 2: c.setM(c.getM() + getIntInput("How many would you like to order?"));
					break;
				case 3: c.setL(c.getL() + getIntInput("How many would you like to order?"));
					break;
				case 4: c.setXl(c.getXl() + getIntInput("How many would you like to order?"));
					break;
				case 5:
					break;
				default:
					input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
			message = "What size " + c.getColor() + " " + c.getBrand() +" you like to reorder?\n" + 
						"\n[1] s: " + c.getS() +
						"\n[2] m: " + c.getM() +
						"\n[3] l: " + c.getL() +
						"\n[4] xl: " + c.getXl() +
						"\n[5] Exit";
		}while(input != 5);
	}

	public static void orderBooks(Item[] item){
		int count = 0;
		Item[] bItem = new Item[100];
		for(int i = 0; i < item[0].getCount(); i++){
			if(item[i] instanceof Books){
				bItem[count] = item[i];
				count++;
			}
		}
		String list = listItem(bItem, count);
		int input = 0;
		do{
			input = getIntInput(list);
			if(input < 1 || input > 1 + count){
				input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
			else if(input != 1 + count){
				int numToOrder = getIntInput("How many copies would you like to order?");
				bItem[input - 1].setQuantity(bItem[input - 1].getQuantity() + numToOrder);
				list = listItem(bItem, count);
			}
		}while (input != 1 + count);
	}

	public static void orderToys(Item[] item){
		int count = 0;
		Item[] tItem = new Item[100];
		for(int i = 0; i < item[0].getCount(); i++){
			if(item[i] instanceof Toys){
				tItem[count] = item[i];
				count++;
			}
		}

		String list = listItem(tItem, count);
		int input = 0;
		do{
			input = getIntInput(list);
			if(input < 1 || input > 1 + count){
				input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
			else if(input != 1 + count){
				int numToOrder = getIntInput("How many "+ ((Toys) tItem[input-1]).getName() +" would you like to order?");
				tItem[input - 1].setQuantity(tItem[input - 1].getQuantity() + numToOrder);
				list = listItem(tItem, count);
			}
		}while(input != 1 + count);
	}

	public static void addNewItem(Item[] item){
		String types = "Which type of item would you like to add\n\n" +
						"[1] Clothes\n" +
						"[2] Books\n" +
						"[3] Toys\n" +
						"[4] Exit";
		int input = 0;
		do{
			input = getIntInput(types);
			switch(input){
				case 1: addClothes(item);
					break;
				case 2: addBooks(item);
					break;
				case 3: addToys(item);
					break;
				case 4:
					break;
				default:
					input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
		}while(input != 4);
		write(item, "./src/testItem.txt");
	}

	public static void addClothes(Item[] item){
		int index = Item.getCount();
		double price;
		int quantity;
		int sold = 0;
		String brand;
		String color;
		int s;
		int m; 
		int l;
		int xl;

		price = getValidDouble("What is the price of the item?");
		brand = getValidStrInput("What is the brand of the Clothes?");
		color = getValidStrInput("What is the color of the Clothes?");
		s = getValidIntInput("How many size S are there?");
		m = getValidIntInput("How many size M are there?");
		l = getValidIntInput("How many size L are there?");
		xl = getValidIntInput("How many size XL are there?");
		quantity = s + m + l + xl;
		item[index] = new Clothes(price, quantity, sold, brand, color, s, m, l, xl);
	}
	
	public static void addBooks(Item[] item){
		int index = Item.getCount();
		double price;
		int quantity;
		int sold = 0;
		String title;
		String author;
		String genre;

		price = getValidDouble("What is the price of the book?");
		quantity = getValidIntInput("How many copies are there?");
		title = getValidStrInput("What is the title of the book?");
		author = getValidStrInput("Who is the book by?");
		genre = getValidStrInput("What is the genre of the book");

		item[index] = new Books(price, quantity, sold, title, author, genre);
	}

	public static void addToys(Item[] item){
		int index = Item.getCount();
		double price;
		int quantity;
		int sold = 0;
		String name;
		int min_age;
		int max_age;

		name = getValidStrInput("What is the name of the toy?");
		price = getValidDouble("What is the price of the toy?");
		quantity = getValidIntInput("How much of the toys do we have?");
		min_age = getValidIntInput("What is the recommended minimum age?");
		max_age = getValidIntInput("What is the recommended maximum age?");

		item[index] = new Toys(price, quantity, sold, name, min_age, max_age);
	}

	public static void deleteItem(Item[] item){
		String types = "Delete items menu\n\n" +
						"[1] Clothes\n" + 
						"[2] Books\n" +
						"[3] Toys\n" +
						"[4] View All\n" +
						"[5] Exit";
		int input = 0;
		do{
			input = getIntInput(types);
			switch(input){
				case 1: //deleteClothes(Item[] item);
					break;
				case 2: //deleteBooks(Item[] item);
					break;
				case 3: //deleteToys(Item[] item);
					break;
				case 4: deleteAll(item);
					break;
				default:
					input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
		}while(input != 4);
		write(item, "./src/testItemDeleted.txt");
	}

	public static void deleteAll(Item[] item){
		String list = listItemAll(item, item[0].getCount(), "Which item would you like to remove?");
		int input;
		do{
			input = getIntInput(list);
			if(input <1 || input > 1 + item[0].getCount()){
				input = 0;
			}
			if(input == 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid selection made.");
			}
			else if(input != 1 + item[0].getCount()){
				
			}
		}while(input != 1 + item[0].getCount());
	}
	public static double getValidDouble(String s){
		double d;
		do{
			try{
				d = Double.parseDouble(JOptionPane.showInputDialog(s));
			}catch(NumberFormatException e){
				d = -1;
			}
			if(d < 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid input entered!");
			}
		}while(d < 0);
		return d;
	}

	public static String getValidStrInput(String s){
		String str = "";
		do{
			str = JOptionPane.showInputDialog(s);
			if(str.equals("")){
				JOptionPane.showMessageDialog(null, "Error! Invalid input entered!");
			}
		}while (str.equals(""));
		return str;
	}

	public static int getValidIntInput(String s){
		int i;
		do{
			try{
				i = Integer.parseInt(JOptionPane.showInputDialog(s));
			}catch(NumberFormatException e){
				i = -1;
			}
			if(i < 0){
				JOptionPane.showMessageDialog(null, "Error! Invalid input entered!");
			}
		}while(i < 0);
		return i;
	}

	public static String listItemAll(Item[] item, int count, String header){
		String message = header + "\n";
		for(int i = 0; i < count; i++){
			if(item[0] instanceof Clothes){
				message += "\n[" + (i + 1) + "] " + ((Clothes) item[i]).getColor() + " " + ((Clothes) item[i]).getBrand();
			}
			if(item[0] instanceof Books){
				message += "\n[" + (i + 1) + "] " + ((Books) item[i]).getTitle() + " : " + (item[i].getQuantity());
			}
			if(item[0] instanceof Toys){
				message += "\n[" + (i + 1) + "] " + ((Toys) item[i]).getName() + " : " + (item[i].getQuantity());
			}
		}
		
		message += "\n[" + (count + 1) + "] Exit";
		return message;
	}

	public static String listItem(Item[] item, int count){
		String message = "Which item would you like to reorder?\n";
		if(item[0] instanceof Clothes){
			for(int i = 0; i < count; i++){
				message += "\n[" + (i + 1) + "] " + ((Clothes) item[i]).getColor() + " " + ((Clothes) item[i]).getBrand();
			}
		}
		if(item[0] instanceof Books){
			for(int i = 0; i < count; i++){
				message += "\n[" + (i + 1) + "] " + ((Books) item[i]).getTitle() + " : " + (item[i].getQuantity());
			}
		}
		if(item[0] instanceof Toys){
			for(int i = 0; i < count; i++){
				message += "\n[" + (i + 1) + "] " + ((Toys) item[i]).getName() + " : " + (item[i].getQuantity());
			}
		}
		message += "\n[" + (count + 1) + "] Exit";
		return message;
	}

	public static int getIntInput(String s){
		int input = 0;
		try{
			input = Integer.parseInt(JOptionPane.showInputDialog(s));
		}catch(NumberFormatException e){
			input = -1;
		}
		if(input < 0){
			//JOptionPane.showMessageDialog(null, "Error! Invalid input entered!");
			return 0;
		}
		return input;
	}

	public static void displayAll(Item[] item){
		String message = "";
		for(int i = 0; i < item[0].getCount(); i++){
			message += item[i].toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}

	public static void write(Item[] item, String path){
		PrintWriter pw = null;
		String type;
		double cost;
		int quantity;
		int sold;
		String str = "";
		try{
			pw = new PrintWriter(path);
			for(int i = 0; i < item[0].getCount(); i++){
				cost = item[i].getCost();
				quantity = item[i].getQuantity();
				sold = item[i].getNumItemSold();
				if(item[i] instanceof Clothes){
					type = "Clothes";
					//shirt	
					String brand = ((Clothes) item[i]).getBrand();
					String color = ((Clothes) item[i]).getColor();
					int s = ((Clothes) item[i]).getS();
					int m = ((Clothes) item[i]).getM();
					int l = ((Clothes) item[i]).getL();
					int xl = ((Clothes) item[i]).getXl();
				
					str = getItemString(i, type, cost, quantity, sold, brand, color, s, m, l, xl);
				}
				else if(item[i] instanceof Books){
					type = "Books";
					//books
					String title = ((Books) item[i]).getTitle();
					String author = ((Books) item[i]).getAuthor();
					String genre = ((Books) item[i]).getGenre();
				
					str = getItemString(i, type, cost, quantity, sold, title, author, genre);
				}
				
				else{
					type = "Toys";
					//toys
					String name = ((Toys) item[i]).getName();
					int min_age = ((Toys) item[i]).getMin_age();
					int max_age = ((Toys) item[i]).getMax_age(); 
					str = getItemString(i, type, cost, quantity, sold, name, min_age, max_age);
	
				}
				pw.write(str);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
	//for Clothes
	public static String getItemString(int i, String type, double cost, int quantity, int sold, String brand, String color, int s, int m, int l, int xl){
		String str = "";
		if(i > 0){
			str = "\n";
		}
		str += type;
		str += txtFormat(cost);
		str += txtFormat(quantity);
		str += txtFormat(sold);
		str += txtFormat(brand);
		str += txtFormat(color);
		str += txtFormat(s);
		str += txtFormat(m);
		str += txtFormat(l);
		str += txtFormat(xl);
		return str;
	}

	//for Books
	public static String getItemString(int i, String type, double cost, int quantity, int sold, String title, String author, String genre){
		String s = "";
		if(i > 0){
			s = "\n";
		}
		s += type; 
		s += txtFormat(cost);
		s += txtFormat(quantity);
		s += txtFormat(sold);
		s += txtFormat(title);
		s += txtFormat(author);
		s += txtFormat(genre);
		
		return s;
	}

	//for Toys
	public static String getItemString(int i, String type, double cost, int quantity, int sold, String name, int min_age, int max_age){
		String s = "";
		if(i > 0){
			s = "\n";
		}
		s += type;
		s += txtFormat(cost);
		s += txtFormat(quantity);
		s += txtFormat(sold);
		s += txtFormat(name);
		s += txtFormat(min_age);
		s += txtFormat(max_age);
		
		return s;
	}

	public static String txtFormat(String s){
		return " : " + s;
	}

	public static String txtFormat(int i){
		return " : " + i;
	}

	public static String txtFormat(double d){
		String s = " : " + d;
		if(((d*100)%10) == 0){
			s += "0";
		}
		return s;
	}
}