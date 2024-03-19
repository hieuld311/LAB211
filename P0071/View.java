package P0071;

public class View {

    Manager manager = new Manager();
    Validate check = new Validate();

    void inputTask() {
        System.out.println("---------------Add Task---------------");
        String reqName = check.inputString("Requirement Name: ", "[A-Za-z0-9\\s]+");
        int taskTypeID = check.inputInt("Task type: ", 1, 4);
        String date = check.inputDate("Date: ", "\\d{2}[-]\\d{2}[-]\\d{4}");
        double planFrom = check.inputDouble("From: ", 8, 17);
        double planTo = check.inputDouble("To: ", planFrom + 0.5, 17.5);
        String assignee = check.inputString("Assignee: ", "[A-Za-z0-9\\s]+");
        String reviewer = check.inputString("Reviewer: ", "[a-zA-Z0-9\\s]+");

        int result = manager.addTask(reqName, taskTypeID, date, planFrom, planTo, assignee, reviewer);
        if (result == -1)
            System.out.println("Cannot add duplicate task!");
        else
            System.out.println("Task added successfully!");
    }

    void deleteTask() {
        System.out.println("-------------Del Task---------------");
        int ID = check.inputInt("ID: ", 0, Integer.MAX_VALUE);
        manager.deleteTask(ID);
    }

    void displayTask() {
        manager.displayTask();
    }
}
