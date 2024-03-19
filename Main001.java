//Bubble sort algorithm.




import java.util.Random;
import java.util.Scanner;

public class Main001 {

    public static Scanner sn = new Scanner(System.in);
    public static Random rd = new Random();

    // check user input is postive and integer
    public static int checkInput() {
        while (true) {
            try {
                String str = sn.nextLine().trim();
                int num;
                if (str.equals("")) {
                    num = 1;
                    return num;
                } else {
                    num = Integer.parseInt(str);
                    if (num > 0)
                        return num;
                    else {
                        System.out.println("Please enter positive input.");
                        System.out.print("Enter again: ");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.print("Enter again: ");
            }
        }
    }

    // input number of array
    public static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInput();
        return n;
    }

    // input value of array
    public static int[] inputValueOfArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(n);
        }
        return arr;
    }

    // BubbleSort
    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {       
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    // display array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = inputSizeOfArray();
        int[] arr = inputValueOfArray(size);
        System.out.println("Unsorted array: ");
        displayArray(arr);
        BubbleSort(arr);
        System.out.println("Sorted array: ");
        displayArray(arr);
    }
}
