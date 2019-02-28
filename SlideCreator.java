
import java.io.*;

import java.util.*;

public class SlideCreator {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Photo> verticalPhotos = new ArrayList<Photo>();
        ArrayList<Photo> horizontalPhotos = new ArrayList<Photo>();

        String fileName = "a_example.txt";
        File theFile = new File(fileName);
        Scanner reader = new Scanner(theFile);
        int i = 0;
        int total = reader.nextInt();

        //Sort the photos into Horizontal or Vertial
        while (reader.hasNext()) {
            String theLine = reader.nextLine();
            //System.out.println(theLine);
            String[] data = theLine.split(" ");

            if (data[0].equals("H")) {
                //printArray(data);
                horizontalPhotos.add(new Photo(data, i));
            } else {
                //printArray(data);
                verticalPhotos.add(new Photo(data, i));
            }
            i++;
        }

        //Generate the Slides 
//Generate the Slides 
        ArrayList<Slide> Slides = new VerticalCombo(verticalPhotos).getSlides();
        
        for (int m = 0; m < horizontalPhotos.size(); m++){
			
			Slides.add(new Slide(horizontalPhotos.get(m).getIdentifier(), horizontalPhotos.get(m).getTags()));
		}
        
        
        //Place Slides in Heap order 
        ArrayMaxHeap maxheap = new ArrayMaxHeap(Slides);
        ArrayList<Slide> orderedSlidesByNumOfTags = maxheap.getArray();
        //HeapSort all slides so its maxtags to least tags 
        
        
        //Combine all Slides and place in Heap order 
        //HeapSort all slides so its maxtags to least tags 
        //Go through the ArrayList and  compare the first one to the next to find the best pair
 
        int currBest = 0;
        int idxOfBest = 0;
        Slide firstSlide = orderedSlidesByNumOfTags.get(0);
        ArrayList<Slide> finalShow = new Arraylist<Slide>();

        while (orderedSlidesByNumOfTags.size() != 1) {
            currBest = 0;
            idxOfBest = 0;
            ArrayList<String> firstTags = firstSlide.getTags();
            int firstTagNum = firstSlide.getNumTags();

            for (int j = 1; j < orderedSlidesByNumOfTags.size(); j++) {
                Slide second = orderedSlidesByNumOfTags.get(j);

                int secondTagNum = second.getNumTags();
                ArrayList<String> secondTags = second.getTags();
                int both = 0;
                int onlyFirst = 0;
                int onlySecond = 0;

                if (firstTagNum < secondTagNum) {
                    for (int e = 0; e < firstTagNum; e++) {
                        if (secondTags.contains(firstTags.get(e))) {
                            both++;
                        } else {
                            onlyFirst++;
                        }

                    }
                    onlySecond = secondTagNum - both;
                } else {
                    for (int e = 0; e < secondTagNum; e++) {
                        if (firstTags.contains(secondTags.get(e))) {
                            both++;
                        } else {
                            onlySecond++;
                        }

                    }
                    onlyFirst = firstTagNum - both;
                }

                int calc = Math.min(both, Math.min(onlyFirst, onlySecond));

                if (calc > currBest) {
                    currBest = calc;
                    idxOfBest = j;
                }

                if (calc < secondTagNum / 2) {
                    break;
                }

            }

            finalShow.add(orderedSlidesByNumOfTags.get(0));
            orderedSlidesByNumOfTags.set(0, orderedSlidesByNumOfTags.get(idxOfBest));
            orderedSlidesByNumOfTags.remove(orderedSlidesByNumOfTags.get(idxOfBest));

        }
        finalShow.add(orderedSlidesByNumOfTags.get(0));
        
        PrintWriter p = new PrintWriter(new FileWriter(new File("submission.txt")));
       p.println(finalShow.size());
        for (int k = 0; k < finalShow.size(); k++  ){
            String s = ""  + finalShow.get(k).getNumber0();
            if (finalShow.get(k).getNumber1() != -1){
                s += " " + finalShow.get(k).getNumber1();
            }
        
            p.println(s);
        
        }
        
    
    
    
    }

    public static void printArray(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

}
