
import java.io.*;

import java.util.*;

public class SlideCreator {
    
    
    public static void main (String[] args ) throws FileNotFoundException{
        ArrayList<Photo> verticalPhotos = new ArrayList<Photo>();
        ArrayList<Photo> horizontalPhotos = new ArrayList<Photo>();
        
        String fileName = "";
        File theFile  = new File(fileName);
        Scanner reader = new Scanner(theFile);
        int i = 0;
        int total =  reader.nextInt();
        while (reader.hasNext()){
            String theLine = reader.nextLine();
            String[] data = theLine.split(theLine);
            if (data[0].equals("H")){
                horizontalPhotos.add(new Photo(data, i));
            } else {
                verticalPhotos.add(new Photo(data, i));
            }
            
            
            
            i++;
        }
        
        
        
        
    
    
    }


}