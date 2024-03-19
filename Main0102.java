// Write a program to takes input date as [dd/mm/yyyy] format and find out the day of entered date.

// Function details:
// User enter date with [dd/mm/yyyy] format 
// Check user input date exits
// Determine day of week with input date


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main0102 {
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

    public static String getDayOfWeek(String date) {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String dayOfWeekStr = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                dayOfWeekStr = "Sunday";
                break;
            case Calendar.MONDAY:
                dayOfWeekStr = "Monday";
                break;
            case Calendar.TUESDAY:
                dayOfWeekStr = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                dayOfWeekStr = "Wednesday";
                break;
            case Calendar.THURSDAY:
                dayOfWeekStr = "Thursday";
                break;
            case Calendar.FRIDAY:
                dayOfWeekStr = "Friday";
                break;
            case Calendar.SATURDAY:
                dayOfWeekStr = "Saturday";
                break;
        }
        return dayOfWeekStr;

    }

    public static void main(String[] args) {
        System.out.print("Please enter date with format [dd/mm/yyyy]: ");
        String date = checkInputDate();
        System.out.println("Your day is: " + getDayOfWeek(date));
    }
}
