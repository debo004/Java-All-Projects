import java.util.Scanner;

public class matrix_calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMatrix Calculator Menu:");
            System.out.println("1. Matrix Addition");
            System.out.println("2. Matrix Subtraction");
            System.out.println("3. Matrix Multiplication");
            System.out.println("4. Matrix Transpose");
            System.out.println("5. Scalar Multiplication");
            System.out.println("6. Calculate Determinant (Square Matrix Only)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performMatrixOperation("Addition", scanner);
                    break;
                case 2:
                    performMatrixOperation("Subtraction", scanner);
                    break;
                case 3:
                    performMatrixMultiplication(scanner);
                    break;
                case 4:
                    performMatrixTranspose(scanner);
                    break;
                case 5:
                    performScalarMultiplication(scanner);
                    break;
                case 6:
                    calculateDeterminant(scanner);
                    break;
                case 7:
                    System.out.println("Exiting Matrix Calculator. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-7).");
            }
        }
    }

    public static void enterMatrixElements(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void performMatrixOperation(String operation, Scanner scanner) {
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int columnsA = scanner.nextInt();

        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int columnsB = scanner.nextInt();

        if (rowsA != rowsB || columnsA != columnsB) {
            System.out.println("Matrix " + operation + " is not possible. Matrices must have the same dimensions.");
            return;
        }

        int[][] matrixA = new int[rowsA][columnsA];
        int[][] matrixB = new int[rowsB][columnsB];

        System.out.println("Enter elements of Matrix A:");
        enterMatrixElements(scanner, matrixA);

        System.out.println("Enter elements of Matrix B:");
        enterMatrixElements(scanner, matrixB);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        int[][] resultMatrix;

        if (operation.equals("Addition")) {
            resultMatrix = addMatrices(matrixA, matrixB);
            System.out.println("Result of Matrix Addition (A + B):");
        } else {
            resultMatrix = subtractMatrices(matrixA, matrixB);
            System.out.println("Result of Matrix Subtraction (A - B):");
        }

        printMatrix(resultMatrix);
    }

    public static void performMatrixMultiplication(Scanner scanner) {
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int columnsA = scanner.nextInt();

        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int columnsB = scanner.nextInt();

        if (columnsA != rowsB) {
            System.out
                    .println("Matrix multiplication is not possible. Columns of Matrix A must equal rows of Matrix B.");
            return;
        }

        int[][] matrixA = new int[rowsA][columnsA];
        int[][] matrixB = new int[rowsB][columnsB];

        System.out.println("Enter elements of Matrix A:");
        enterMatrixElements(scanner, matrixA);

        System.out.println("Enter elements of Matrix B:");
        enterMatrixElements(scanner, matrixB);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);

        System.out.println("Result of Matrix Multiplication (A * B):");
        printMatrix(resultMatrix);
    }

    public static void performMatrixTranspose(Scanner scanner) {
        System.out.print("Enter the number of rows for Matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter elements of the Matrix:");
        enterMatrixElements(scanner, matrix);

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] transposedMatrix = transposeMatrix(matrix);

        System.out.println("Transposed Matrix:");
        printMatrix(transposedMatrix);
    }

    public static void performScalarMultiplication(Scanner scanner) {
        System.out.print("Enter the number of rows for Matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter elements of the Matrix:");
        enterMatrixElements(scanner, matrix);

        System.out.print("Enter the scalar value: ");
        int scalar = scanner.nextInt();

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] scaledMatrix = scalarMultiply(matrix, scalar);

        System.out.println("Result of Scalar Multiplication:");
        printMatrix(scaledMatrix);
    }

    public static void calculateDeterminant(Scanner scanner) {
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int columnsA = scanner.nextInt();

        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int columnsB = scanner.nextInt();

        int[][] matrixA = new int[rowsA][columnsA];
        int[][] matrixB = new int[rowsB][columnsB];

        System.out.println("Enter elements of Matrix A:");
        enterMatrixElements(scanner, matrixA);

        System.out.println("Enter elements of Matrix B:");
        enterMatrixElements(scanner, matrixB);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        if (rowsA == columnsA) {
            int determinantA = calculateDeterminant(matrixA);
            System.out.println("Determinant of Matrix A: " + determinantA);
            int determinantB = calculateDeterminant(matrixB);
            System.out.println("Determinant of Matrix B: " + determinantB);
        } else {
            System.out.println("Determinant calculation is not possible. It must be a square matrix.");
        }
    }

    // function to add two matrices
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int columns = matrixA[0].length;
        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return resultMatrix;
    }

    // function to substract two matrices
    public static int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int columns = matrixA[0].length;
        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        return resultMatrix;
    }

    // function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int columnsA = matrixA[0].length;
        int columnsB = matrixB[0].length;

        int[][] resultMatrix = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }

    // function to make transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] resultMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }

        return resultMatrix;
    }

    // function to do scalar multiplication of two matrices
    public static int[][] scalarMultiply(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix[i][j] * scalar;
            }
        }

        return resultMatrix;
    }

    // function to calculate the determinant of a matrix
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < n; i++) {
            determinant += matrix[0][i] * cofactor(matrix, 0, i);
        }

        return determinant;
    }

    // function to calculate the cofactor of a matrix
    public static int cofactor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        int minorRow = 0;
        int minorCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row && j != col) {
                    minor[minorRow][minorCol++] = matrix[i][j];
                    if (minorCol == n - 1) {
                        minorCol = 0;
                        minorRow++;
                    }
                }
            }
        }

        return (int) Math.pow(-1, row + col) * calculateDeterminant(minor);
    }
}
