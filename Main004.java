//Quick sort algorithm. 



import java.util.Random;
import java.util.Scanner;

public class Main004 {
    public static Scanner sn = new Scanner(System.in);
    public static Random rd = new Random();

    public static void quickSort(int a[], int t, int p) {
        if (t < p) {
            int i = t, j = p;
            int pivot = a[(t + p) / 2];         
            while (i < j) {
                while (a[i] < pivot)
                    i++;
                while (a[j] > pivot)
                    j--;    
                if (i <= j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }
            }
            quickSort(a, t, j);
            quickSort(a, i, p);
        }
    }

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
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        displayArray(arr);
    }

}
