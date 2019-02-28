import java.util.ArrayList<E>;
import java.lang.Integer;

public class Photo{

        private String orientation;
        private int numTags;
        private ArrayList<String> tags;
        private int identifier;

        public Photo (String[] line, int lineNum){
                this.identifier = lineNum;
                this.orientation = line[0];
                this.numTags = Integer.parseInt(line[1]);
                for (i=2, i++, line.length - 1){
                        tags.add(line[i]);
                }
        }

        public String getOrientation(){
                return this.orientation;
        }
        public int getNumTags(){
                return this.numTags;
        }
        public ArrayList<string> getTags(){
                return this.tags;
        }
        public int getIdentifier(){
                return this.identifier;
        }
}