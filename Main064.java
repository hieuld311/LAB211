//Check data format. 
// Program Specifications
// Create a program that allows inputting phone number, email, Date and checking their format
// Input phone number must be numbers.
// Input phone number must contain 10 numbers.
// Input email must follow standard email format.
// Input date must follow the dd/MM/yyyy format.


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main064 {

    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}";
    private static final String EMAIL_VALID = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static String checkInputString() {
        // loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static String checkInputPhone() {
        while (true) {
            try {
                String phoneCheck = in.nextLine().trim();
                String resultCheck = String.valueOf(phoneCheck);
                if (!resultCheck.matches(PHONE_VALID)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must be number");
                System.out.print("Phone number: ");
            }
        }
    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
            String date = in.nextLine().trim();
            if (isValidDate(date))
                return date;
            else {
                System.out.println("Date must in correct form:");
                System.out.print("Date: ");
            }
        }
    }

    public static String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
                System.out.print("Email: ");
            } else {
                return emailCheck;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Email: ");
        String email = checkInputEmail();
        System.out.print("Phone number: ");
        String phone = checkInputPhone();
        System.out.print("Date: ");
        String date = checkInputDate();
        System.out.println(email + " " + phone + " " + date);
    }

}
