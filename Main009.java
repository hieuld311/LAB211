//Fibonacci Sequence
// Program Specifications
//        Design a program that displays 45 sequence Fibonacci.

public class Main009 {
    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci:");
        displayfibo(5);
    }

    // in day fibo gom n so
    public static void displayfibo(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci3(i)); // in ra tung so fibo o vi tri i
            if (i < n - 1)
                System.out.print(", ");
        }
    }

    // tim so fibo thu n
    public static int fibonacci3(int n) {
        if (n <= 1)
            return n;
        else {
            return fibonacci3(n - 1) + fibonacci3(n - 2);
        }
    }
}
