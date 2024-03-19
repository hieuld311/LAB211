package P0071;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    List<Task> tasks = new ArrayList<>();
    public int addTask(String requirementName, int taskTypeID, String date, double planFrom, double planTo,
            String assignee, String reviewer) {
        if (checkDuplicate(date, planFrom, planTo, assignee)) {
            return -1;
        } else {
            int ID;
            if (tasks.isEmpty()) {
                ID = 1;
            } else {
                ID = tasks.get(tasks.size() - 1).getID() + 1;
            }
            Task task = new Task(ID, requirementName, taskTypeID, date, planFrom, planTo, assignee, reviewer);
            tasks.add(task);
            return task.getID();
        }
    }

    private boolean checkDuplicate(String date, double planFrom, double planTo, String assignee) {
        for (Task task : tasks) {
            if (task.getDate().compareTo(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {
                if (planFrom < task.getPlanTo() && planTo > task.getPlanFrom()) {
                    return true;
                }
            }
        }
        return false;
    }

    //
    public void deleteTask(int id) {
        if (tasks.isEmpty()) {
            System.out.println("No task");
            return;
        }
        for (Task task : tasks) {
            if (task.getID() == id) {
                tasks.remove(task);
                System.out.println("Delete successfully");
                return;
            }
        }
        System.out.println("ID does not exist");
    }

    void displayTask() {
        if (tasks.isEmpty()) {
            System.out.println("No task");
            return;
        }
        System.out.println(
                "------------------------------------------------- Task -------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Name", "Task Type", "Date", "Time",
                "Assignee", "Reviewer");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
