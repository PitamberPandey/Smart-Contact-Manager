import java.util.;

public class RockPaperScissorsMultiplayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, enter your move (rock, paper, or scissors):");
        String player1Move = getMove(scanner);

        clearScreen();

        System.out.println("Player 2, enter your move (rock, paper, or scissors):");
        String player2Move = getMove(scanner);

        determineWinner(player1Move, player2Move);

        scanner.close();
    }

    private static String getMove(Scanner scanner) {
        String move = scanner.nextLine().toLowerCase();
        while (!isValidMove(move)) {
            System.out.println("Invalid move. Please enter rock, paper, or scissors:");
            move = scanner.nextLine().toLowerCase();
        }
        return move;
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    private static void determineWinner(String player1Move, String player2Move) {
        System.out.println("Player 1 chose: " + player1Move);
        System.out.println("Player 2 chose: " + player2Move);

        if (player1Move.equals(player2Move)) {
            System.out.println("It's a tie!");
        } else if ((player1Move.equals("rock") && player2Move.equals("scissors")) ||
                (player1Move.equals("scissors") && player2Move.equals("paper")) ||
                (player1Move.equals("paper") && player2Move.equals("rock"))) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    private static void clearScreen() {
        // This method attempts to clear the console screen for privacy.
        // It might not work on all platforms.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
