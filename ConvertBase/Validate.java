package ConvertBase;

import java.util.Scanner;

public class Validate {

    private static Scanner scanner = new Scanner(System.in);
    private static String BinaryValid = "[0-1]*";
    private static String DecimalValid = "[0-9]*";
    private static String HexaDecimalValid = "[0-9A-F]*";

    // check if input string is empty
    public static String checkInputString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty())
                return input;
            System.out.println("Input not empty.");
            System.out.print("Enter again: ");
        }
    }

    // check user input in range
    public static int checkInputInRange(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }

        }
    }

    // check input number in binary form
    public static String checkInputBinary() {
        System.out.print("Enter number in Binary form: ");
        while (true) {
            String input = checkInputString();
            if (input.matches(BinaryValid))
                return input;
            System.out.println("Input must be 0 or 1");
            System.out.print("Enter again: ");
        }
    }

    // check input number in decimal form
    public static String checkInputDecimal() {
        System.out.print("Enter number in Decimal form: ");
        while (true) {
            String input = checkInputString();
            if (input.matches(DecimalValid))
                return input;
            System.out.println("Input must be 0-9");
            System.out.print("Enter again: ");
        }
    }

    // check input in hexa form
    public static String checkInputHexaDecimal() {
        System.out.print("Enter number in HexaDecimal form: ");
        while (true) {
            String input = checkInputString();
            if (input.matches(HexaDecimalValid))
                return input;
            System.out.println("Input must be 0-9 and A-F");
            System.out.print("Enter again: ");
        }
    }
}