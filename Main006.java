//Binary search algorithm. 



import java.util.Random;
import java.util.Scanner;

public class Main006 {

    public static Scanner sn = new Scanner(System.in);
    public static Random rd = new Random();

    // check input is positive or not
    public static int checkInput() {
        while (true) {
            try {
                int value = Integer.parseInt(sn.nextLine().trim());
                if (value > 0)
                    return value;
                else {
                    System.out.println("Please enter a positve number.");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value.");
                System.out.print("Please enter again: ");
            }
        }
    }

    // input the size of array
    public static int inputSizeOfArray() {
        System.out.println("Enter number of array:");
        int n = checkInput();
        return n;
    }

    // input the search value
    public static int inputSearchValue() {
        System.out.println("Enter search value:");
        int x = checkInput();
        return x;
    }

    // generate values of array
    public static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt(n);
        }
        return a;
    }

    // Binary search
    public static int binarySearch(int[] a, int x) {
        int left = a[0];
        int right = a[a.length - 1];
        while (left <= right) {
            int mid = ((left + right) / 2);
            if (a[mid] < x) {
                left = mid + 1;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else
                return mid;
        }
        return -1;
    }

    // bubble sort
    public static void BubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    // display array
    public static void displayArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();
    }

    // display output
    public static void displayOutput(int[] a, int n) {
        int index = binarySearch(a, n);
        if (index == -1)
            System.out.println("Value not found");
        else
            System.out.println("Found " + n + " at index: " + index);
    }

    public static void main(String[] args) {
        int size = inputSizeOfArray();
        int[] a = inputValueOfArray(size);
        int x = inputSearchValue();
        BubbleSort(a);
        System.out.print("Sorted array: ");
        displayArray(a);
        displayOutput(a, x);
    }
}
