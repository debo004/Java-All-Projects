import java.util.Scanner;

public class tictactoe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        boolean gameIsRunning = true;
        int moves = 0;

        while (gameIsRunning) {
            displayBoard();
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (isValidMove(row, col)) {
                makeMove(row, col);
                moves++;
                if (checkWin(row, col)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameIsRunning = false;
                } else if (moves == 9) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameIsRunning = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static int[] getPlayerMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
        int row = sc.nextInt() - 1;
        int col = sc.nextInt() - 1;
        return new int[] { row, col };
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static boolean checkWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                || (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                || (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer
                        && board[2][2] == currentPlayer)
                || ((row + col) == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer
                        && board[2][0] == currentPlayer);
    }
}
