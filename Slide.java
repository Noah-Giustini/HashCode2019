import java.util.ArrayList;
import java.util.Arrays;

public class Slide{
	
	private int number0 = 0;
	private int number1 = -1;
	private ArrayList<String> tags;
	

	public Slide(int num0, int num1, ArrayList<String> newtags){
		this.number0 = num0;
		this.number1 = num1;
		this.tags = newtags;
	}
	
	public Slide(int num0, ArrayList<String> newtags){
		this.number0 = num0;
		this.tags = newtags;
	}
	
	
	public int getNumber0(){
		
		return this.number0;
	}
	
	public int getNumber1(){
		
		return this.number1;
	}
	
	public ArrayList<String> getAmount(){
		
		return this.tags;
	}
	
}
	
	
	
	
