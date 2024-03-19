package P0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);

    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max)
                    return number;
                else
                    System.out.print("Please input between [" + min + ", " + max + "]: ");
                continue;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while (true) {
            String input = scanner.nextLine();
            try {
                double number = Double.parseDouble(input);
                if (number % 0.5 != 0) {
                    System.out.println("Please input .5 or integer number");
                    continue;
                }
                if (number < min || number > max) {
                    System.out.print("Please input between [" + min + ", " + max + "]: ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an double number: ");
            }
        }
    }

    public String inputString(String mess, String regex) {
        System.out.print(mess);
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.print("Please input match regex: " + regex);
                continue;
            }
            if (input.trim().isEmpty()) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }

    public String inputDate(String mess, String regex) {
        while (true) {
            System.out.print(mess);
            String dateInput = scanner.nextLine();
            if (!dateInput.matches(regex)) {
                System.out.println("Date must be in the format dd-MM-yyyy");
            } else if (!checkDateExist(dateInput)) {
                System.out.println("Date does not exist");
            } else if (!checkDateBeforeCurrentDate(dateInput)) {
                System.out.println("Date must be greater or equal to the current date");
            } else {
                return dateInput;
            }
        }
    }

    private static boolean checkDateExist(String dateInput) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            simpleDateFormat.parse(dateInput);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean checkDateBeforeCurrentDate(String dateInput) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        try {
            Date inputDate = simpleDateFormat.parse(dateInput);
            return !inputDate.before(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }
}
