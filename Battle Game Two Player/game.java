import java.util.Scanner;
import java.util.Random;

class Player {
    String username;
    int health;
    int armor;
    int weaponDamage;

    public Player(String username) {
        this.username = username;
        Random random = new Random();
        this.health = random.nextInt(5) + 1;
        this.armor = random.nextInt(5) + 1;
        this.weaponDamage = random.nextInt(5) + 1;
    }

    public int attack() {
        Random random = new Random();
        return random.nextInt(weaponDamage) + 1;
    }

    public void takeDamage(int damage) {
        int effectiveDamage = Math.max(damage - armor, 0);
        health -= effectiveDamage;
    }

    public void displayStats() {
        System.out.println("|-----------------------------------|");
        System.out.println("|           Player Stats            |");
        System.out.println("|-----------------------------------|");
        System.out.println("| Player: " + username);
        System.out.println("| Health: " + health);
        System.out.println("| Armor: " + armor);
        System.out.println("| Weapon Damage: " + weaponDamage);
        System.out.println("|-----------------------------------|");
    }
}

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Battle Game!");
        System.out.println("Player 1, enter your username: ");
        String player1Username = scanner.nextLine();

        System.out.println("Player 2, enter your username: ");
        String player2Username = scanner.nextLine();

        Player player1 = new Player(player1Username);
        Player player2 = new Player(player2Username);

        int round = 1;

        while (player1.health > 0 && player2.health > 0) {
            System.out.println("Round " + round);
            System.out.println();
            player1.displayStats();
            System.out.println();
            player2.displayStats();
            System.out.println();

            int player1Damage = player1.attack();
            int player2Damage = player2.attack();

            player2.takeDamage(player1Damage);
            player1.takeDamage(player2Damage);

            System.out
                    .println(player1.username + " attacks " + player2.username + " for " + player1Damage + " damage.");
            System.out
                    .println(player2.username + " attacks " + player1.username + " for " + player2Damage + " damage.");

            System.out.println(player1.username + " has " + player1.health + " health remaining.");
            System.out.println(player2.username + " has " + player2.health + " health remaining.");

            if (player1.health <= 0 || player2.health <= 0) {
                break;
            }

            round++;
            System.out.println();
        }

        if (player1.health <= 0 && player2.health <= 0) {
            System.out.println("It's a tie!");
        } else if (player1.health <= 0) {
            System.out.println(player2.username + " wins!");
        } else {
            System.out.println(player1.username + " wins!");
        }

        scanner.close();
    }
}
