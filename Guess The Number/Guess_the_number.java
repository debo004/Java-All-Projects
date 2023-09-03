import java.util.*;

class PlayerProfile {
    private String username;
    private int gamesPlayed;
    private int gamesWon;
    private double averageTries;

    public PlayerProfile(String username) {
        this.username = username;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.averageTries = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public double getAverageTries() {
        return averageTries;
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

    public void incrementGamesWon() {
        gamesWon++;
    }

    public void updateAverageTries(int numberOfTries) {
        averageTries = ((averageTries * (gamesPlayed - 1)) + numberOfTries) / gamesPlayed;
    }
}

public class Guess_the_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        List<PlayerProfile> playerProfiles = new ArrayList<>();
        PlayerProfile currentPlayer = null;

        System.out.println("Welcome to the Guess the Number game!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. New Game");
            System.out.println("2. Create Player Profile");
            System.out.println("3. View Player Profile");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                if (currentPlayer == null) {
                    System.out.println("Please create a player profile before starting a game.");
                    continue;
                }
                playGame(scanner, random, currentPlayer);
            } else if (choice == 2) {
                scanner.nextLine(); // Consume newline
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                currentPlayer = createPlayerProfile(playerProfiles, username);
            } else if (choice == 3) {
                if (currentPlayer == null) {
                    System.out.println("Please create a player profile before viewing it.");
                } else {
                    viewPlayerProfile(currentPlayer);
                }
            } else if (choice == 4) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static PlayerProfile createPlayerProfile(List<PlayerProfile> playerProfiles, String username) {
        for (PlayerProfile profile : playerProfiles) {
            if (profile.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Welcome back, " + username + "!");
                return profile;
            }
        }

        PlayerProfile newProfile = new PlayerProfile(username);
        playerProfiles.add(newProfile);
        System.out.println("Welcome, " + username + "! Your player profile has been created.");
        return newProfile;
    }

    private static void viewPlayerProfile(PlayerProfile playerProfile) {
        System.out.println("\nPlayer Profile for " + playerProfile.getUsername());
        System.out.println("Games Played: " + playerProfile.getGamesPlayed());
        System.out.println("Games Won: " + playerProfile.getGamesWon());
        System.out.println("Average Tries: " + playerProfile.getAverageTries());
    }

    private static void playGame(Scanner scanner, Random random, PlayerProfile currentPlayer) {
        int lowerBound, upperBound, maxAttempts, timeLimitInSeconds;
        int selectedDifficulty;
        int score = 0;

        System.out.println("Select a difficulty level:");
        System.out.println("1. Easy (1-10, 10 seconds per guess)");
        System.out.println("2. Medium (1-50, 20 seconds per guess)");
        System.out.println("3. Hard (1-100, 30 seconds per guess)");
        System.out.print("Enter your choice: ");
        selectedDifficulty = scanner.nextInt();

        switch (selectedDifficulty) {
            case 1:
                lowerBound = 1;
                upperBound = 10;
                maxAttempts = 3;
                timeLimitInSeconds = 10;
                break;
            case 2:
                lowerBound = 1;
                upperBound = 50;
                maxAttempts = 5;
                timeLimitInSeconds = 20;
                break;
            case 3:
                lowerBound = 1;
                upperBound = 100;
                maxAttempts = 7;
                timeLimitInSeconds = 30;
                break;
            default:
                lowerBound = 1;
                upperBound = 100;
                maxAttempts = 7;
                timeLimitInSeconds = 30;
        }

        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        System.out.println("You have " + timeLimitInSeconds + " seconds for each guess.");

        while (!hasGuessedCorrectly && numberOfTries < maxAttempts) {
            System.out.print("Attempt " + (numberOfTries + 1) + "/" + maxAttempts + ": Enter your guess: ");

            long startTime = System.currentTimeMillis();
            int userGuess = scanner.nextInt();
            long endTime = System.currentTimeMillis();
            long elapsedTimeInSeconds = (endTime - startTime) / 1000;

            numberOfTries++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
            } else if (userGuess < randomNumber) {
                System.out.println("Try a higher number.");
            } else if (userGuess > randomNumber) {
                System.out.println("Try a lower number.");
            } else {
                int baseScore = 1000;
                int attemptsPenalty = (maxAttempts - numberOfTries) * 100;
                int timePenalty = (int) Math.max(0, timeLimitInSeconds - elapsedTimeInSeconds) * 10;
                score = baseScore - attemptsPenalty - timePenalty;

                System.out.println("Congratulations! You've guessed the number (" + randomNumber + ") correctly in "
                        + numberOfTries + " tries.");
                System.out.println("Your score for this game is: " + score);
                hasGuessedCorrectly = true;
                currentPlayer.incrementGamesPlayed();
                currentPlayer.updateAverageTries(numberOfTries);
                if (hasGuessedCorrectly) {
                    currentPlayer.incrementGamesWon();
                }
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
            currentPlayer.incrementGamesPlayed();
        }
    }
}
