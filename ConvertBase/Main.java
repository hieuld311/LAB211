package ConvertBase;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int outRadix;
            int choice = Menu.menuChoice();
            switch (choice) {
                case 1:
                    outRadix = Menu.OutRadix();
                    String binary = Validate.checkInputBinary();
                    Menu.displayResult(binary, 2, outRadix);
                    break;
                case 2:
                    outRadix = Menu.OutRadix();
                    String decimal = Validate.checkInputDecimal();
                    Menu.displayResult(decimal, 10, outRadix);
                    break;
                case 3:
                    outRadix = Menu.OutRadix();
                    String hexa = Validate.checkInputHexaDecimal();
                    Menu.displayResult(hexa, 16, outRadix);
                    break;
                case 4:
                    System.out.println("End.");
                    return;
            }
        }
    }
}
