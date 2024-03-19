//Sort one-dimensional array with bubble sort algorithm. 


import java.util.Arrays;
import java.util.Scanner;

public class Main053 {

    public static Scanner scanner = new Scanner(System.in);

    public static String checkInputString() {
        // loop until user input true value
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int num = Integer.parseInt(checkInputString());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.print("Enter again: ");
            }
        }
    }

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

    public static int checkInputArray() {
        while (true) {
            int num = Integer.parseInt(checkInputString());
            if (num < 0) {
                System.out.println("Wrong");
                System.out.print("Enter again: ");
            } else {
                return num;
            }
        }
    }

    public static int inputSize() {
        System.out.print("Size: ");
        int n = checkInputArray();
        return n;
    }

    public static int[] inputValueArray(int size) {
        int[] a = new int[size];
        int i;
        for (i = 0; i < a.length; i++) {
            System.out.print("element" + (i + 1) + ": ");
            a[i] = checkInputInt();
        }
        return a;
    }

    public static void BubbleSort(int[] arr, int switches) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (((arr[j] - arr[j + 1]) * switches) > 0) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static int[] sortAscending(int[] a) {
        int[] result = Arrays.copyOf(a, a.length);
        BubbleSort(result, 1);
        return result;
    }

    public static int[] sortDescending(int[] a) {
        int[] result = Arrays.copyOf(a, a.length);
        BubbleSort(result, -1);
        return result;
    }

    public static void displayArray(int[] a, String x) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]") ;
            if (i < a.length - 1)
                System.out.print(x);
        }
        System.out.println();
    }

    public static int Menu() {
        System.out.println("1. enter array");
        System.out.println("2. sort ascend");
        System.out.println("3. sort descend");
        System.out.println("4. exit");
        System.out.print("choice: ");
        int choice = checkInputInRange(1, 4);
        return choice;

    }

    public static void main(String[] args) {
        int[] a = new int[0];
        while (true) {
            int choice = Menu();
            switch (choice) {
                case 1:
                    int n = inputSize();
                    a = inputValueArray(n);
                    break;
                case 2:
                    displayArray(sortAscending(a), "->");
                    break;
                case 3:
                    displayArray(sortDescending(a), "<-");
                    break;
                case 4:
                    return;
            }
        }
    }
}
