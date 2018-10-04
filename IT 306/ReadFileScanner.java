package Module03;

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

public class ReadFileScanner {

	//read a file using scanner
	public static int readFile(String path){
		File file = new File(path);
		int sum = 0;
		Scanner in = null;
		try{
			in = new Scanner(file);
			while(in.hasNext()){
				String line = in.nextLine(); 
				Scanner lineScanner = new Scanner(line);
				while(lineScanner.hasNext()){
					float number = lineScanner.nextFloat();
					sum+= number;
					System.out.println("read file:"+ number);
				}
			}
		}catch(FileNotFoundException e){
			//the file does not exist, or it is inaccessible.
			e.printStackTrace();
		}
		finally{
	
			in.close();
		}
		
		return sum;
	}
	
	
	//read a file gradually using a buffer
	public static int readFileBuffer(String path){
		File file= new File(path);
		int sum=0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String nextLine;
			while((nextLine=br.readLine()) != null){
				float number = Float.parseFloat(nextLine);
				System.out.println("readFileBuffer:" + number + "\n");
				sum+= number;
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
//		catch(FileNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		catch(IOException e){
//			e.printStackTrace();
//		}

		return sum;
	}
	
	//read a file using FileInoutStream
	public static int readFileInputStream(String path){
		int sum = 0;
		File file = new File(path);
		int length = (int) file.length();
		byte[] buffer=new byte[length]; 
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			System.out.println("\n\nreadFileInputStream starts:");
			while (fis.read(buffer)!= -1);{
				String token =new String(buffer);
				System.out.println( token);
				Scanner bufferScan = new Scanner(token);
				while(bufferScan.hasNext()){
					float number = Float.parseFloat(bufferScan.next());
					sum+=number;
				}
				
				
			}
			fis.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return sum;
		
	}
	
	
	//write to a file using printWriter
	public static void writeToFile(String path,String content){
		PrintWriter pw = null;
		try{ 
			pw = new PrintWriter(path); //enhancement of printStream object.
			pw.write("\n" + content);
		}
		catch(FileNotFoundException e){
			System.out.print(e.getCause()); //printStream object.
		}
		finally{
			pw.close();
		}
	}
	
	//append
	public static void writeToFileWFileOutputStream(String path, String content){
		PrintWriter pw = null; 
		try {
			pw = new PrintWriter(new FileOutputStream(path, true));
			pw.append("\n"+content);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}
	
	
	//append to a file using PrintWriter+BufferedWriter+FileWriter
	public static void appendToFile(String path,String content){
		PrintWriter pw = null;
		try{ 
			pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(path), true))); //enhancement of printStream object.
			pw.write("\n" + content);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch(FileNotFoundException e){
//			System.out.print(e.getCause()); //printStream object.
//		} 
		finally{
			pw.close();
		}
	}
	
	
	@SuppressWarnings("finally")
	public static boolean readWebpage(String webAddress){ 
		if(!webAddress.startsWith("http://")) return false;
		
		System.out.println("readWebpage starts here:");
		boolean flag = false;
		PrintWriter pw = null; 
		
		try {
			URL connection = new URL(webAddress);
			File output = new File("IT306_2014/Module03/web.txt");
			Scanner in =new Scanner(connection.openStream());
			
			pw = new PrintWriter(output);
			System.out.print("readWebpage starts here:");
			while(in.hasNext()){
				String token = in.next(); 
				System.out.println(token);
				pw.write(token);
			}
			flag = true;
		} catch(UnknownHostException e){
			System.out.println("Error: unknown host");
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Malformed URL");
		} catch(IOException e){
			System.out.println("Error: I/O Problem");
		}
		finally{
//			pw.close();
			return flag;
		}
		
	}
}