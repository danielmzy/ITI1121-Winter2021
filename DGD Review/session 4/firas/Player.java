import java.util.Random;

public class Player {
    public static enum hand {rock, paper, scissors};

//    final static String ROCK = "ROCK";
//    final static String PAPER = "PAPER";
//    final static String SCISSORS = "SCISSORS";

    private String name;
    public int score;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static int compareHands(hand myHand, hand otherHand){
        if(otherHand.equals(myHand)){
            return 0;
        } else if(otherHand.equals(hand.paper) && myHand.equals(hand.scissors)
                || otherHand.equals(hand.scissors) && myHand.equals(hand.rock)
                || otherHand.equals(hand.rock) && myHand.equals(hand.paper)){
            return 1;
        } else {
            return 2;
        }
    }

    public hand getRandomHand(){
        Random rand = new Random();
        int n = rand.nextInt(3);
        if(n == 0){
            return hand.rock;
        } else  if (n == 1){
            return hand.paper;
        } else {
            return hand.scissors;
        }
    }


}
