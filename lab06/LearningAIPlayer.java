import java.util.*;
import java.util.ArrayList;

public class LearningAIPlayer implements Player{
    
    //stores turn history
    private ArrayList<Integer> history;

    public static ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1));
    public static ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,2));
    public static ArrayList<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr4 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr5 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr6 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr7 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr8 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr9 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static ArrayList<Integer> arr10 = new ArrayList<Integer>(Arrays.asList(1,2,3));

    private static Bucket bucket1 = new Bucket(1,arr1);
    private static Bucket bucket2 = new Bucket(2,arr2);
    private static Bucket bucket3 = new Bucket(3,arr3);
    private static Bucket bucket4 = new Bucket(4,arr4);
    private static Bucket bucket5 = new Bucket(5,arr5);
    private static Bucket bucket6 = new Bucket(6,arr6);
    private static Bucket bucket7 = new Bucket(7,arr7);
    private static Bucket bucket8 = new Bucket(8,arr8);
    private static Bucket bucket9 = new Bucket(9,arr9);
    private static Bucket bucket10 = new Bucket(10,arr10);

    private static ArrayList<Bucket> BucketArr = new ArrayList<Bucket>(Arrays.asList(bucket1,bucket2,bucket3,bucket4,bucket5,bucket6,bucket7,bucket8,bucket8,bucket9,bucket10));
    private ArrayList<Integer> usedBuckets;
    private ArrayList<Integer> usedMarbles;
    public void init(int startingSticks, int playerNum){
        history = new ArrayList<Integer>();
        usedBuckets = new ArrayList<Integer>();
        usedMarbles = new ArrayList<Integer>();
    }
    
    //Randomly chooses a number of sticks 
    public int takeTurn(int remainingSticks){
        Bucket b = BucketArr.get(remainingSticks);
        usedBuckets.add(remainingSticks);
        int usedMarble = b.removeRandomMarble();
        usedMarbles.add(usedMarble);
        history.add(usedMarble);
        return usedMarble;
    }
    
    public String getDebugInfo(){
        //Print turn history for the current game
        String debug = "Previous Moves: ";
        if (history.size() == 0)
            return debug + "no turns taken yet!";
        for(int i = 0; i < history.size(); i++){
            debug += "Turn " + (i+1) + ": " + history.get(i);
            if (i != history.size()-1)
                debug += ", ";
        }
        for (int b = 0; b < BucketArr.size(); b++){
            if (usedBuckets.contains(b)){
                System.out.println(BucketArr.get(b).toString() + " ---OUTSIDE:" + usedMarbles.get(usedBuckets.indexOf(b)).toString());
            }
            else{
                System.out.println(BucketArr.get(b).toString());
            }  
        }
        return debug;
    }
    
    public void gameOver(boolean didPlayerWin){
        //clear the history for the next game
        history = new ArrayList<Integer>();
        if (didPlayerWin){
            for (int i = 0; i<usedBuckets.size(); i++){
                BucketArr.get(i).addMarble(usedMarbles.get(i));
        }
    }
}
    
    public String getPlayerType(){
        return "Learning AI";
    }
    
}