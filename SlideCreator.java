
import java.io.*;

import java.util.*;

public class SlideCreator {
    
    
    public static void main (String[] args ) throws FileNotFoundException{
        ArrayList<Photo> verticalPhotos = new ArrayList<Photo>();
        ArrayList<Photo> horizontalPhotos = new ArrayList<Photo>();
        
        String fileName = "a_example.txt";
        File theFile  = new File(fileName);
        Scanner reader = new Scanner(theFile);
        int i = 0;
        int total =  reader.nextInt();
        
        //Sort the photos into Horizontal or Vertial
        while (reader.hasNext()){
            String theLine = reader.nextLine();
            //System.out.println(theLine);
            String[] data = theLine.split(" ");
    
            if (data[0].equals("H")){
                //printArray(data);
                horizontalPhotos.add(new Photo(data, i));
            } else {
                 //printArray(data);
                verticalPhotos.add(new Photo(data, i));
            }
            i++;
        }
        
        
        
        //Generate the Slides 
        ArrayList<Slide> horizontalSlides = new ArrayList<Slide>();
        
        
        
        ArrayList<Slide> verticalSlides = VerticalCombo(verticalPhotos);
        
        //Combine all Slides and place in Heap order 
        
        
        //HeapSort all slides so its maxtags to least tags 
        
        
        
        //Go through the ArrayList and  compare the first one to the next to find the best pair
        
        ArrayList<Slide> orderedSlidesByNumOfTags = new ArrayList<Slide>();
        int currBest = 0; 
        
        while (!orderedSlidesByNumOfTags.isEmpty()){
            currBest = 0;
            Slide firstSlide = orderedSlidesByNumOfTags.get(0);
            ArrayList<String> firstTags = firstSlide.getTags();
            int firstTagNum = firstSlide.getNumTags();
            
            
            for (int j = 1; j< orderedSlidesByNumOfTags.size(); j++){
                Slide second = orderedSlidesByNumOfTags.get(j);
                
                int secondTagNum = second.getNumTags();
                ArrayList<String> secondTags = second.getTags();
                int both = 0;
                int onlyFirst = 0; 
                int onlySecond = 0; 
                
                if (firstTagNum < secondTagNum){
                    for (int e = 0; e < firstTagNum; e++){
                        if (secondTags.contains(firstTags.get(e))){
                            both++;
                        }else{
                            onlyFirst++;
                        }
                        
                    }
                    onlySecond = secondTagNum - both;
                    
                    currBest = Math.min(both, Math.min(onlyFirst, onlySecond));
                    
                }
                
            }
            
            
            
        }
        
        
        
    
    
    }
    
    public static void printArray(String[] a){
        for (int i = 0; i< a.length; i++){
            System.out.print(a[i]+ ", ");
        }
        System.out.println();
    }


}