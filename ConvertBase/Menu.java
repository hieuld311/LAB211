package ConvertBase;

import java.math.BigInteger;

public class Menu {

    // choose base to convert
    public static int menuChoice() {
        System.out.println("1. Convert from Binary");
        System.out.println("2. Convert from Decimal");
        System.out.println("3. Convert from Hexadecimal");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputInRange(1, 4);
        return choice;
    }

    // choose base to convert to
    public static int OutRadix() {
        System.out.println("1. Convert to Binary");
        System.out.println("2. Convert to Decimal");
        System.out.println("3. Convert to Hexadecimal");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputInRange(1, 3);
        int outRadix;
        if (choice == 1)
            outRadix = 2;
        else if (choice == 2)
            outRadix = 10;
        else
            outRadix = 16;
        return outRadix;
    }

    // convert from 10 to any base
    public static String decimalTo(String number, int outRadix) {
        BigInteger decimal = new BigInteger(number);
        BigInteger outRad = BigInteger.valueOf(outRadix);
        String result = "";
        
        while (!decimal.equals(BigInteger.ZERO)) {
            int remainder = decimal.remainder(outRad).intValue();
            if (remainder < 10) {
                result = remainder + result;
            } else {
                result = (char) ('A' - 10 + remainder) + result;
            }
            decimal = decimal.divide(outRad);
        }
        if (result.isEmpty())
            result += "0";
        return result;
    }

    // convert from any base to 10
    public static String toDecimal(String number, int inRadix) {
        BigInteger result = BigInteger.ZERO;
        BigInteger inRad = BigInteger.valueOf(inRadix);

        for (int charIdx = 0; charIdx < number.length(); charIdx++) {
            char inChar = number.charAt(charIdx);
            if (inChar >= '0' && inChar <= '9') {
                result = result.multiply(inRad).add(BigInteger.valueOf(inChar - '0'));
            } else {
                result = result.multiply(inRad).add(BigInteger.valueOf(inChar - 'A' + 10));
            }
        }
        return result.toString();
    }

    // display convert result
    public static void displayResult(String number, int inRadix, int outRadix) {
        String outputValue = decimalTo(toDecimal(number, inRadix), outRadix);
        System.out.println("Output value: " + outputValue);
        System.out.println();
    }
}
