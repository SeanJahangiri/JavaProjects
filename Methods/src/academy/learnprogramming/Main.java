package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        int highSCore = calculateScore(true,800,5,100 );
        System.out.println("Your final score was " + highSCore);

        highSCore = calculateScore(true,10000,8,200);
        System.out.println("Your final score was " + highSCore);

        int highScorePosition = calculateHighScorePositions(1500);
        displayHighScorePosition("Tim" , highScorePosition);

        highScorePosition = calculateHighScorePositions(900);
        displayHighScorePosition("Bob" , highScorePosition);

        highScorePosition = calculateHighScorePositions(400);
        displayHighScorePosition("Percy" , highScorePosition);

        highScorePosition = calculateHighScorePositions(50);
        displayHighScorePosition("Gilbert" , highScorePosition);
    }

    public static void displayHighScorePosition(String playerName, int highScorePosition){
        System.out.println(playerName + " managed to get into position " + highScorePosition + " on the high score table");
    }

    public static int calculateHighScorePositions(int playerScore){

        if(playerScore >= 1000) {
            return 1;
        } else if(playerScore >= 500 && playerScore < 1000) {
            return 2;
        } else if(playerScore >= 100 && playerScore < 500) {
            return 3;
        } else {
            return 4;
        }
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }

        return -1;
    }
}
