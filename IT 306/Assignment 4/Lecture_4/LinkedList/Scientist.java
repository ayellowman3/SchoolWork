package Lecture_4.LinkedList;


public class Scientist implements Comparable<Scientist>{

	private String name;

	public Scientist(){}

	public Scientist(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public String toString(){
		return name;
	}

	public int compareTo(Scientist o){
		if(this.name.compareToIgnoreCase(o.getName())<0) return -1;
		else if(this.name.compareToIgnoreCase(o.getName())> 0) return 1;
		else return 0;
	}
}
