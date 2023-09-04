import java.util.Random;
import java.util.Scanner;

public class snake_water_gun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int computerScore = 0, userScore = 0, draws = 0;
        int rounds;

        System.out.println("Welcome to Snake, Water, Gun Game!");
        System.out.println("You will play against the computer.");

        System.out.print("Enter the number of rounds to play: ");
        rounds = scanner.nextInt();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            System.out.println("Choose your weapon:");
            System.out.println("1. Snake");
            System.out.println("2. Water");
            System.out.println("3. Gun");
            System.out.print("Enter your choice (1/2/3): ");
            int userChoice = scanner.nextInt();

            int computerChoice = random.nextInt(3) + 1;
            System.out.println("Computer's choice:");

            switch (computerChoice) {
                case 1:
                    System.out.println("Snake");
                    break;
                case 2:
                    System.out.println("Water");
                    break;
                case 3:
                    System.out.println("Gun");
                    break;
            }

            int result = determineWinner(userChoice, computerChoice);
            if (result == 0) {
                System.out.println("It's a tie!");
                draws++;
            } else if (result == 1) {
                System.out.println("You win this round!");
                userScore++;
            } else {
                System.out.println("Computer wins this round.");
                computerScore++;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your score: " + userScore);
        System.out.println("Computer's score: " + computerScore);
        System.out.println("Draws: " + draws);

        if (userScore > computerScore) {
            System.out.println("Congratulations! You win the game!");
        } else if (computerScore > userScore) {
            System.out.println("Computer wins the game. Better luck next time!");
        } else {
            System.out.println("It's a tie! The game ends in a draw.");
        }

        scanner.close();
    }

    private static int determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return 0; // Tie
        } else if ((userChoice == 1 && computerChoice == 2) ||
                (userChoice == 2 && computerChoice == 3) ||
                (userChoice == 3 && computerChoice == 1)) {
            return 1; // User wins
        } else {
            return -1; // Computer wins
        }
    }
}
