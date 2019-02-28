import java.util.ArrayList;
import java.util.Arrays;

public class VerticalCombo{
	
	private ArrayList<Photo> photos;
	private ArrayList<Slide> verticalslides;
	

	public VerticalCombo(ArrayList<Photo> vertphotos){	
		
		this.photos = vertphotos;
		generatePairs();
		
	}
	
	private void generatePairs(){
		
		int goal = 0;
		
		while(this.photos.get(0) != null) {
			Photo newph = this.photos.get(0);
			
			int j = 1;
			int best = 1;
			int score = 100;
			
			while(this.photos.get(j) != null) {
				
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
			this.photos.remove(0);
			this.photos.remove(best);
			
			
		}
		
	}
	
	public ArrayList<Slide> getSlides(){
		
		return this.verticalslides;
	}
	
}
	
