import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class EquationSolver {
     private static final Scanner sc = new Scanner(System.in);

     private List<Float> calculateEquation(float a, float b) {
          // if (a == 0) {
          // if (b == 0) {
          // return new ArrayList<>();
          // } else {
          // return null;
          // }
          // } else {
          // return new ArrayList<>(List.of(-b / a));
          // }
          if (b == 0) {
               return new ArrayList<>(List.of(b));
          } else {
               if (a == 0)
                    return null;
               else
                    return new ArrayList<>(List.of(-b / a));
          }
     }

     private List<Float> calculateQuadraticEquation(float a, float b, float c) {
          if (a == 0) {
               return calculateEquation(b, c);
          }
          float delta = b * b - 4 * a * c;
          if (delta < 0) {
               return null;
          } else {
               return new ArrayList<>(
                         List.of((-b + (float) Math.sqrt(delta)) / (2 * a),
                                   (-b - (float) Math.sqrt(delta)) / (2 * a)));
          }

     }

     public void calculateEquation() {
          System.out.println("----- Calculate Equation -----");
          float a = checkIn("Enter A: ");
          float b = checkIn("Enter B: ");
          List<Float> checkNumbers = new ArrayList<>(List.of(a, b));
          List<Float> result = calculateEquation(a, b);
          if (result == null) {
               System.out.println("No solution");
          }
          if (result.isEmpty()) {
               System.out.println("Infinitely many solutions");
          } else {
               checkNumbers.add(result.get(0));
               System.out.printf("Solution: x = %.3f\n", result.get(0));
          }
          System.out.print("Number is Odd: ");
          System.out.println(getNumbersString(x -> isOdd(x), checkNumbers));
          System.out.print("Number is Even: ");
          System.out.println(getNumbersString(x -> !isOdd(x), checkNumbers));
          System.out.print("Number is Perfect Square: ");
          System.out.println(getNumbersString(x -> isPerfectSquare(x), checkNumbers));
          System.out.println("---------------------------------");
     }

     public void calculateQuadraticEquation() {
          System.out.println("----- Calculate Quadratic Equation -----");
          float a = checkIn("Enter A: ");
          float b = checkIn("Enter B: ");
          float c = checkIn("Enter C: ");
          List<Float> checkNumbers = new ArrayList<>(List.of(a, b, c));
          List<Float> result = calculateQuadraticEquation(a, b, c);
          if (result == null) {
               System.out.println("No solution");
          } else if (a == 0) {
               checkNumbers.add(result.get(0));
               System.out.printf("Solution: x = %.3f\n", result.get(0));
          } else {
               checkNumbers.addAll(result);
               System.out.printf("Solution: x1 = %.3f, x2 = %.3f\n", result.get(0), result.get(1));
          }
          System.out.print("Number is Odd: ");
          System.out.println(getNumbersString(x -> isOdd(x), checkNumbers));
          System.out.print("Number is Even: ");
          System.out.println(getNumbersString(x -> !isOdd(x), checkNumbers));
          System.out.print("Number is Perfect Square: ");
          System.out.println(getNumbersString(x -> isPerfectSquare(x), checkNumbers));
          System.out.println("---------------------------------");
     }

     private Float checkIn(String message) {
          while (true) {
               try {
                    System.out.print(message);
                    float input = Float.parseFloat(sc.nextLine());
                    return input;
               } catch (NumberFormatException e) {
                    System.out.println("Please input number");
               }
          }
     }

     public int option() {
          System.out.println("========== Equation Program ==========");
          System.out.println("1. Calculate Superlative Equation");
          System.out.println("2. Calculate Quadratic Equation");
          System.out.println("3. Exit");
          System.out.print("Please choice one option: ");
          return checkOption();
     }

     private int checkOption() {
          while (true) {
               try {
                    int option = Integer.parseInt(sc.nextLine());
                    if (option == 1 || option == 2 || option == 3) {
                         return option;
                    } else {
                         throw new NumberFormatException();
                    }
               } catch (NumberFormatException e) {
                    System.out.print("Invalid option, try again: ");
               }
          }
     }

     private boolean isOdd(float number) {
          return number % 2 != 0;
     }

     private boolean isPerfectSquare(float number) {
          if (number < 0) {
               return false;
          }
          int root = (int) Math.sqrt(number);
          return root * root == number;
     }

     private String getNumbersString(Predicate<Float> predicate, List<Float> numbers) {
          StringBuilder sb = new StringBuilder();
          for (float number : numbers) {
               if (predicate.test(number)) {
                    sb.append(number + ", ");
               }
          }
          if (!sb.isEmpty()) {
               sb.delete(sb.length() - 2, sb.length());
          }
          return sb.toString();
     }
}