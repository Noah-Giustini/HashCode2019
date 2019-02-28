import java.util.ArrayList;
import java.util.Arrays;

public class VerticalCombo{
	
	private ArrayList<Photo> photos = new ArrayList<Photo>();
	private ArrayList<Slide> verticalslides = new ArrayList<Slide>();
	

	public VerticalCombo(ArrayList<Photo> vertphotos){	
		
		this.photos = vertphotos;
		generatePairs();
		
	}
	
	private void generatePairs(){
		
		int goal = 0;
		
		while(this.photos.size() >= 2) {
			Photo newph = this.photos.get(0);
			
			int best = 1;
			int score = 100;
			
			for (int j = 1; j < this.photos.size(); j++){
				
				int tstscore = 0;
				
				Photo tstph = this.photos.get(j);
				
				for (int x = 0; x < newph.getTags().size(); x++){
					for (int y = 0; y < tstph.getTags().size(); y++){
					
						if (newph.getTags().get(x).equals(tstph.getTags().get(y))){
							tstscore += 1;
						}		
					}
				}
				
				if (score > tstscore){
					
					score = tstscore;
					best = j;
				}
				
				if (score == 0){
					break;
				}	
			}
			
			verticalslides.add(new Slide(newph.getIdentifier(), this.photos.get(best).getIdentifier(), newph.getTags(), this.photos.get(best).getTags()));
			this.photos.remove(best);
			this.photos.remove(0);
			
			
		}
		
	}
	
	public ArrayList<Slide> getSlides(){
		
		return this.verticalslides;
	}
	
}
	
