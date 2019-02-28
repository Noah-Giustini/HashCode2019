
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
        
        
        
        
    
    
    }
    
    public static void printArray(String[] a){
        for (int i = 0; i< a.length; i++){
            System.out.print(a[i]+ ", ");
        }
        System.out.println();
    }


}