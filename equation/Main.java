public class Main {
     public static void main(String[] args) {
          EquationSolver eSolver = new EquationSolver();
          while (true) {
               int option = eSolver.option();
               switch (option) {
                    case 1:
                         eSolver.calculateEquation();
                         break;
                    case 2:
                         eSolver.calculateQuadraticEquation();
                         break;
                    case 3:
                         System.exit(0);
               }
          }
     }
}
