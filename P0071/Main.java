package P0071;

public class Main {
    public static void main(String[] args) {
        Validate valid = new Validate();
        View view = new View();
        while (true) {
            displayMenu();
            int choice = valid.inputInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    view.inputTask();
                    break;
                case 2:
                    view.deleteTask();
                    break;
                case 3:
                    view.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1. Add Task\n"
                + "2. Delete task\n"
                + "3. Display Task\n"
                + "4. exit");
    }
}