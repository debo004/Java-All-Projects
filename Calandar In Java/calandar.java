import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class calandar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        scanner.close();

        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 1);

            System.out.println(date.getMonth() + " " + year);
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            // Calculate the day of the week for the first day of the month
            DayOfWeek firstDayOfWeek = date.getDayOfWeek();
            int offset = firstDayOfWeek.getValue() % 7; // Convert to 0-based index

            for (int i = 0; i < offset; i++) {
                System.out.print("    ");
            }

            // Print the days of the month
            while (date.getMonthValue() == month) {
                System.out.printf("%3d ", date.getDayOfMonth());

                date = date.plusDays(1);

                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    System.out.println();
                }
            }

            if (date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                System.out.println();
            }

            System.out.println();
        }
    }
}
