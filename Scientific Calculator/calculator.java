import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        while (true) {
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Square Root (sqrt)");
            System.out.println("6. Sine (sin)");
            System.out.println("7. Cosine (cos)");
            System.out.println("8. Tangent (tan)");
            System.out.println("9. Inverse Sine (asin)");
            System.out.println("10. Inverse Cosine (acos)");
            System.out.println("11. Inverse Tangent (atan)");
            System.out.println("12. Exponentiation (^)");
            System.out.println("13. Natural Logarithm (log)");
            System.out.println("14. Absolute Value (abs)");
            System.out.println("15. Factorial (!)");
            System.out.println("16. 1 / x");
            System.out.println("17. 10 ^ x");
            System.out.println("18. Square (x ^ 2)");
            System.out.println("19. Cube (x ^ 3)");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting the calculator.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Your Operands : ");
                    double x = scanner.nextDouble();
                    double y = scanner.nextDouble();
                    result = x + y;
                    System.out.println(x + " + " + y + " = " + result + "\n");
                    break;
                case 2:
                    System.out.print("Enter Your Operands : ");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    result = a - b;
                    System.out.println(a + " - " + b + " = " + result + "\n");
                    break;
                case 3:
                    System.out.print("Enter Your Operands : ");
                    double c = scanner.nextDouble();
                    double d = scanner.nextDouble();
                    result = c * d;
                    System.out.println(c + " * " + d + " = " + result + "\n");
                    break;
                case 4:
                    System.out.print("Enter Your Operands : ");
                    double e = scanner.nextDouble();
                    double f = scanner.nextDouble();
                    result = e / f;
                    System.out.println(e + " / " + f + " = " + result + "\n");
                    break;
                case 5:
                    System.out.print("Enter Your Operand : ");
                    double g = scanner.nextDouble();
                    result = Math.sqrt(g);
                    System.out.println("Result: " + result + "\n");
                    break;
                case 6:
                    System.out.print("Enter Your angle : ");
                    double h = scanner.nextDouble();
                    result = Math.sin(Math.toRadians(h));
                    System.out.println("sin ( " + h + " ) = " + result + "\n");
                    break;
                case 7:
                    System.out.print("Enter Your angle : ");
                    double i = scanner.nextDouble();
                    result = Math.cos(Math.toRadians(i));
                    System.out.println("cos ( " + i + " ) = " + result + "\n");
                    break;
                case 8:
                    System.out.print("Enter Your angle : ");
                    double j = scanner.nextDouble();
                    result = Math.tan(Math.toRadians(j));
                    System.out.println("tan ( " + j + " ) = " + result + "\n");
                    break;
                case 9:
                    System.out.print("Enter Your Operand : ");
                    double l = scanner.nextDouble();
                    result = Math.toDegrees(Math.asin(l));
                    System.out.println("sin ^ -1 ( " + l + " ) = " + result + "\n");
                    break;
                case 10:
                    System.out.print("Enter Your Operand : ");
                    double u = scanner.nextDouble();
                    result = Math.toDegrees(Math.acos(u));
                    System.out.println("cos ^ -1 ( " + u + " ) = " + result + "\n");
                    break;
                case 11:
                    System.out.print("Enter Your Operand : ");
                    double v = scanner.nextDouble();
                    result = Math.toDegrees(Math.atan(v));
                    System.out.println("tan ^ -1 ( " + v + " ) = " + result + "\n");
                    break;
                case 12:
                    System.out.print("Enter the Base: ");
                    double m = scanner.nextDouble();
                    System.out.print("Enter the Exponent: ");
                    double n = scanner.nextDouble();
                    result = Math.pow(m, n);
                    System.out.println(m + " ^ " + n + " = " + result + "\n");
                    break;
                case 13:
                    System.out.print("Enter Your Operand : ");
                    double o = scanner.nextDouble();
                    result = Math.log(o);
                    System.out.println("log (" + o + ") = " + result + "\n");
                    break;
                case 14:
                    System.out.print("Enter Your Operand : ");
                    double p = scanner.nextDouble();
                    result = Math.abs(p);
                    System.out.println("| " + p + " | = " + result + "\n");
                    break;
                case 15:
                    System.out.print("Enter Your Operand : ");
                    int fact = scanner.nextInt();
                    result = factorial(fact);
                    System.out.println(fact + " ! = " + result + "\n");
                    break;
                case 16:
                    System.out.print("Enter Your Operand : ");
                    double x_1 = scanner.nextDouble();
                    result = 1 / x_1;
                    System.out.println("1 / " + x_1 + " = " + result + "\n");
                    break;
                case 17:
                    System.out.print("Enter Your Operand : ");
                    int s = scanner.nextInt();
                    result = Math.pow(10, s);
                    System.out.println("10 ^ " + s + " = " + result + "\n");
                    break;
                case 18:
                    System.out.print("Enter the Base: ");
                    double sq = scanner.nextDouble();
                    result = Math.pow(sq, 2);
                    System.out.println(sq + " ^ " + 2 + " = " + result + "\n");
                    break;
                case 19:
                    System.out.print("Enter the Base: ");
                    double cu = scanner.nextDouble();
                    result = Math.pow(cu, 3);
                    System.out.println(cu + " ^ " + 3 + " = " + result + "\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static double factorial(double x) {
        if (x < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return x;
        }

        double result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

}
