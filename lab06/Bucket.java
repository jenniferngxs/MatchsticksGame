//A abstraction of a "Bucket" utilized by a LearningAIPlayer
//in the Matchsticks game
//Each bucket stores some number of Marbles which correspond to a number
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.RuntimeException;

public class Bucket{
    
    //The number associated with the bucket
    //(i.e. this is bucket #7)
    private int bucketNum;    
    //stores all the marbles in the bucket;        
    private ArrayList<Integer> marbles;  
    
    public static Random rand = new Random();

    public Bucket(int bucketNum){ 
        this.bucketNum = bucketNum;
    }
    public Bucket(int bucketNum, ArrayList<Integer> marbles){
        this(bucketNum);
        this.marbles = marbles;

    }
    
    //Part 3.3 Adds a marble of the argument number
    public void addMarble(int marbleNum){
        marbles.add(marbleNum);
        marbles.add(marbleNum);
                      
    }
    
    //Part 3.3 removes a random marble from the bucket.  Returns the
    //number associated with the removed marble.
    //Throws an IllegalArgumentException if the bucket is empty
    public int removeRandomMarble(){  
        int marbleToRemove = rand.nextInt(marbles.size()-1)+1;
        marbles.remove(marbles.indexOf(marbleToRemove));
        if (marbles.size()==0){
            marbles.add(marbleToRemove);
            throw new IllegalArgumentException();
        } 
        return marbleToRemove;
    }
    
    
    //Part 3.3 returns the number of marbles in the bucket
    public int getSize(){
        int size = marbles.size();
        return size; 
    }
    
    //Part 3.3 Should report the bucket number and what marbles are inside
    //Will be utilized for debug text!
    //Ex: "Bucket #7: 1, 2, 2, 3"
    public String toString(){
        String report = "Bucket #" + bucketNum +": ";
        for (int i = 0; i < marbles.size(); i++) {
            report += marbles.get(i).toString() + " ";
        }
        return report;
    
}
}