//Selection sort algorithm.



import java.util.Random;
import java.util.Scanner;

public class Main003 {

    public static Scanner sn = new Scanner(System.in);
    public static Random rd = new Random();

    // check user input is postive and integer
    public static int checkInput() {
        while (true) {
            try {
                int result = Integer.parseInt(sn.nextLine().trim());
                if (result > 0)
                    return result;
                else if ((String.valueOf(result)).isEmpty()){
                    result = 1;
                    return result;
                }
                else {
                    System.out.println("Please enter positive input.");
                    System.out.print("Enter again: ");
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

    // insertion sort
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            int t = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > t) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = t;
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
        insertionSort(arr);
        System.out.println("Sorted array: ");
        displayArray(arr);
    }

}
