package Lecture_2.Activity2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class VotingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathCandidates= "./src/Lecture_2/Activity2/candidate.txt"; 
		String pathVoters = "src/Lecture_2/Activity2/voters.txt";
		Candidate[] candidates =null;
		Voter[] voters =null;
		try{
			candidates = getCandidates(pathCandidates);
			voters = getVoters(pathVoters);
			Candidate winner = getWinner(candidates , voters);
			JOptionPane.showMessageDialog(null, "The winner is: " + winner.toString());
		}
		catch(FileNotFoundException e){
			
		}catch(IOException e){
			
		}
	}
	
	
	public static Candidate[] getCandidates(String path) throws FileNotFoundException,
	IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line; 
		Scanner scan = null; 
		int count=0;
		while((line = br.readLine()) !=null){
			count++;
		}
		
		br = new BufferedReader(new FileReader(new File(path)));
		Candidate c; 
		String name;
		int code; 
		Candidate[] candids = new Candidate[count];
		int i=0;
		while((line = br.readLine()) !=null){
			scan =new Scanner(line);
			scan.useDelimiter(",");
			name = scan.next(); 
			code = Integer.parseInt(scan.next().trim());
			c= new Candidate(name , code);
			candids[i++]=c;
		}

		return candids;
		
	}
	
	public static Voter[] getVoters(String path) throws FileNotFoundException,
	IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line; 
		Scanner scan = null; 
		int count=0;
		while((line = br.readLine()) !=null){
			count++;
		}
		
		br = new BufferedReader(new FileReader(new File(path)));
		Voter v; 
		char gender;
		int code; 
		Voter[] voters = new Voter[count];
		int i=0;
		while((line = br.readLine()) !=null){
			scan =new Scanner(line);
			scan.useDelimiter(",");
			gender = scan.next().trim().charAt(0); 
			code = Integer.parseInt(scan.next().trim());
			v= new Voter(gender);
			v.setVote(code);
			voters[i++]=v;
		}

		return voters;
		
	}
	public static Candidate getWinner(Candidate[] candids, Voter[] voters){
		Bucket[] bins = new Bucket[10]; 
		for(int h = 0; h < bins.length; h++){
			bins[h] = new Bucket(voters.length, h);
		}
		for(int i = 0; i < voters.length; i++){
			bins[voters[i].getVote()-1].add(voters[i]);
		}
		int winner = 0;
		for(int x = 0; x < bins.length; x++){
			if(bins[x].getSize() > winner){
				winner = bins[x].getSize();
			}
		
		String = "Hi Steven";
		return candids[winner-1];
	}

}
