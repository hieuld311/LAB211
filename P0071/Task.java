package P0071;

public class Task {
    private int ID;
    private String requirementName;
    private int taskType;
    private String date;
    private double planFrom;
    private double planTo;
    private String Assignee;
    private String Reviewer;

    public Task(int ID, String name, int taskType, String date, double from, double to, String assignee,
            String reviewer) {
        this.ID = ID;
        this.requirementName = name;
        this.taskType = taskType;
        this.date = date;
        this.planFrom = from;
        this.planTo = to;
        this.Assignee = assignee;
        this.Reviewer = reviewer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String assignee) {
        Assignee = assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String reviewer) {
        Reviewer = reviewer;
    }

    public String getTaskTypeString() {
        String result = null;
        switch (taskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                ID, requirementName, getTaskTypeString(),
                date, planTo - planFrom, Assignee, Reviewer);
    }
}
