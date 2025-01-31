import java.io.Console;

public class game {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available. Please run this program from a terminal.");
            System.exit(1);
        }

        System.out.println("Player 1, enter your move (rock, paper, or scissors):");
        String player1Move = getMove(console);

        clearScreen();

        System.out.println("Player 2, enter your move (rock, paper, or scissors):");
        String player2Move = getMove(console);

        determineWinner(player1Move, player2Move);
    }

    private static String getMove(Console console) {
        char[] moveArray = console.readPassword();  // Input is invisible as it's typed
        String move = new String(moveArray).toLowerCase();  // Convert char array to string and make it lowercase
        while (!isValidMove(move)) {
            System.out.println("Invalid move. Please enter rock, paper, or scissors:");
            moveArray = console.readPassword();  // Prompt again if input is invalid
            move = new String(moveArray).toLowerCase();
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
        // Attempt to clear the console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
