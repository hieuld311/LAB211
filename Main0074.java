//Write a calculator program (from DCPS’s project)
// Program Specifications
// Write a calculator program have functions: addition, subtraction, multiplication functions for matrix.

// Function details: 
// Function 1: Display a menu and ask users to select an option.
// * Users run the program. The program prompts users to select an option.
// * Users select an option, perform Function 2.
// Function 2: Perform function based on the selected option.
// o Prompt users input number of row, number of column of 2 matrixes.
// o Prompt  users input values of matrixes must be the number. If users input values that are not a number, display notification on the screen: “Values of matrix must be the number”.

// * Option 1: Addition matrixes
// o Display result.
// * Option 2: Subtraction matrixes
// o Display result.
// * Option 3: Multiplication matrixes
// o Display result.
// * Option 4: Exit program.


import java.util.Scanner;

public class Main0074 {
    private static final Scanner scanner = new Scanner(System.in);

    public static int option() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3.Multiplication Matrix");
        System.out.println("4.Exit");
        System.out.print("Your choice: ");
        int opt = checkInputInRange(1, 4);
        return opt;
    }

    public static int checkInputInRange(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(checkInputString());
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

    public static int[][] inputMatrix(int n) {
        System.out.print("Enter row matrix" + n + ": ");
        int row = inputSize();
        System.out.print("Enter column matrix" + n+": ");
        int col = inputSize();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Matrix" + n + "[" + i + "][" + j + "]: ");
                matrix[i][j] = checkInputInt();
            }
        }
        return matrix;
    }

    private static int inputSize() {
        while (true) {
            try {
                String input = checkInputString();
                int num = Integer.parseInt(input);
                if (num > 0)
                    return num;
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

    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]"+ "\t");
            }
            System.out.println();
        }
    }

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int result[][] = new int[row1][col1];
        if (row1 != row2 || col1 != col2) {
            System.err.println("Matrix can't be added");
            return null;
        } else {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        }
        return result;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int result[][] = new int[row1][col1];
        if (row1 != row2 || col1 != col2) {
            System.err.println("Matrix can't be Subtracted");
            return null;
        } else {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }
        return result;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int result[][] = new int[row1][col2];
        if (col1 != row2) {
            System.err.println("Matrix can't be multiplied");
            return null;
        } else {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < col1; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }
        return result;
    }

    public static void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, String mess) {
        if (result == null) return;
        else {
            displayMatrix(matrix1);
            System.out.println(mess);
            displayMatrix(matrix2);
            System.out.println("=");
            displayMatrix(result);
        }
    }

    public static void main(String[] args) {
        while (true) {
            int[][] matrix1 = null;
            int[][] matrix2 = null;
            int[][] result = null;
            int choice = option();
            switch (choice) {
                case 1:
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    result = additionMatrix(matrix1, matrix2);
                    displayResult(matrix1, matrix2, result, "+");
                    break;
                case 2:
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    result = subtractionMatrix(matrix1, matrix2);
                    displayResult(matrix1, matrix2, result, "-");
                    break;
                case 3:
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    result = multiplicationMatrix(matrix1, matrix2);
                    displayResult(matrix1, matrix2, result, "*");
                    break;
                case 4:
                    return;
            }
        }
    }
}
