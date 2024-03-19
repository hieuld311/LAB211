// Write a program to takes input date as [dd/mm/yyyy] format and compare with the second the day.

// Function details:
// User enter the first date with [dd/mm/yyyy] format 
// User enter the second date with [dd/mm/yyyy] format 
// Compare and display

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main0103 {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static boolean isValidDate(String date) {
        dateFormat.setLenient(false);
        try {
            Date d = dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static String checkInputDate() {
        while (true) {
            String date = scanner.nextLine().trim();
            if (isValidDate(date))
                return date;
            else {
                System.out.println("Date not exists.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static void compareDate(String date1, String date2) {
        try {
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);
            if (d1.before(d2)) {
                System.out.println("Date 1 is before Date 2.");
            } else if (d1.after(d2)) {
                System.out.println("Date 1 is after Date 2.");
            } else {
                System.out.println("Date 1 and Date 2 are equal.");
            }
        } catch (ParseException e) {
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the first Date: ");
        String date1 = checkInputDate();
        System.out.print("Enter the second Date: ");
        String date2 = checkInputDate();
        compareDate(date1, date2);
    }
}
