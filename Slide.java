import java.util.ArrayList;
import java.util.Arrays;

public class Slide{
	
	private int number0 = 0;
	private int number1 = -1;
	private ArrayList<String> tags;
	private int numtags = 0;
	

	public Slide(int num0, int num1, ArrayList<String> newtags0, ArrayList<String> newtags1){
		this.number0 = num0;
		this.number1 = num1;
		
		for (int i = 0; i < newtags0.size(); i++){
			for (int j = 0; j < newtags1.size(); j++){
				if (!(newtags0.get(i).equals(newtags1.get(j)))) {
					this.tags.add(newtags0.get(i));
				}	
			}
		}
		this.tags.addAll(newtags1);
		
		this.numtags = tags.size();
	}
	
	public Slide(int num0, ArrayList<String> newtags){
		this.number0 = num0;
		this.tags = newtags;
		this.numtags = tags.size();
	}
	
	
	public int getNumber0(){
		
		return this.number0;
	}
	
	public int getNumber1(){
		
		return this.number1;
	}
	
	public ArrayList<String> getTags(){
		
		return this.tags;
	}
	
	public int getNumTags(){
		
		return this.numtags;
	}
	
}
	
	
	
	
