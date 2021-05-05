public class Game {
    private final Player player1;
    private final Player player2;
    private int round;
    private boolean gameFinished;
    private final int maxScore;

    public Game(Player player1, Player player2,int maxScore){
        this.maxScore = maxScore;
        this.player1 = player1;
        this.player2 = player2;
        this.round = 0;
    }

    public int getRound(){
        return round;
    }

    public int getMaxScore(){
        return maxScore;
    }

    public boolean isGameFinished(){
        return this.gameFinished;
    }

    public void runGame(){
        while(!this.isGameFinished()){
            System.out.println(this.newRound());
        }
    }

    public String newRound(){
        this.round++;

        String roundResult = "";
        if(this.gameFinished){
            return roundResult;
        }

        int result = Player.compareHands(player1.getRandomHand(), player2.getRandomHand());
        incrementPlayersScores(result);


        roundResult += this.toString();

        if(player1.score >= this.maxScore){
            roundResult += "\n" + player1.getName() + " won!";
            roundResult += "\ngame finished";
            this.gameFinished = true;
        }
        if(player2.score >= this.maxScore){
            roundResult += "\n" + player2.getName() + " won!";
            roundResult += "\ngame finished";
            this.gameFinished = true;
        }

        return roundResult;
    }

    private void incrementPlayersScores(int result){
        if(result == 1){
            player1.score++;
        } else if(result == 2) {
            player2.score++;
        }
    }

    public String toString(){
        String result = "*********\n";
        result += "Game between " + player1.getName() + " and " + player2.getName() + ".\n";
        result += "Round: " + this.round + "\n";
        result += "Score 1 = " + player1.score + " | Score 2 = " + player2.score;
        return result;
    }
}
