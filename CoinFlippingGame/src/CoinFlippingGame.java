import java.util.Scanner;

public class CoinFlippingGame {
    // player1 always wins with randomly chosen flip
    public static void playGame(String player1) {
        String flipResult = (Math.random() < 0.5) ? "heads" : "tails";
        System.out.println(player1 + " won with a flip of " + flipResult);
    }

    public static void main(String[] args) {
        String response;
        Scanner input = new Scanner(System.in);
        do {
            playGame("Player1");
            System.out.println("Play Again?");
            response = input.nextLine();
        } while ((response.startsWith("y")) || (response.startsWith("Y")));
    }
}



