//Linear search algorithm.
// Program Specifications

//Design a program that allows users to input the number of array. Generate random integer in number range input.  After that allows users to input search number. Display the array and index of search number in array.
       

import java.util.Random;
import java.util.Scanner;

public class Main0010 {

    static Scanner sn = new Scanner(System.in);
    static Random rd = new Random();

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

    // Linear search
    public static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }

    // display array
    public static void displayArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // display output
    public static void displayOutput(int[] a, int n) {
        int index = linearSearch(a, n);
        if (index == -1)
            System.out.println("Value not found");
        else
            System.out.println("Found " + n + " at index: " + index);
    }

    public static void main(String[] args) {
        int size = inputSizeOfArray();
        int[] a = inputValueOfArray(size);
        int x = inputSearchValue();
        System.out.print("The array: ");
        displayArray(a);
        displayOutput(a, x);
    }
}
