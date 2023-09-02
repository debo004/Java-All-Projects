import java.util.Scanner;

class ATM {
    float Balance;
    int PIN = 9434;

    public void CheckPin() {
        System.out.println("Enter your PIN : ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();

        if (enteredpin != PIN) {
            System.out.println("Enter a valid PIN");
        }

        else {
            menu();
        }
    }

    public void menu() {
        System.out.println("Enter your choice : ");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposite Money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkBalance();
        }

        else if (opt == 2) {
            withdrawMoney();
        }

        else if (opt == 3) {
            depositMoney();
        }

        else if (opt == 4) {
            return;
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is : " + Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter your amount to withdraw : ");
        Scanner sc = new Scanner(System.in);
        float money = sc.nextFloat();

        if (money > Balance) {
            System.out.println("Sorry ! Insufficient Money");
        }

        else {
            Balance = Balance - money;
            System.out.println("Money withdrawal successful . Thank you !");
            menu();
        }
    }

    public void depositMoney() {
        System.out.println("Enter your amount to deposit : ");
        Scanner sc = new Scanner(System.in);
        float money = sc.nextInt();

        Balance = Balance + money;
        System.out.println("Money deposited successfully . Thank you !");
        menu();
    }
}

public class atm_machine {
    public static void main(String args[]) {

        ATM object = new ATM();
        object.CheckPin();
    }
}