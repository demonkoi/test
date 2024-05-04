package pat;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task extends JFrame {

    static ArrayList<TaskDetails> taskList = new ArrayList<TaskDetails>();
    String userName, firstName, lastName;

    public Task(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        taskScreen();
    }

    public void taskScreen() {
        final String optionsTask[] = { "Add task", "Show Report", "Quit" };
        int option = JOptionPane.showOptionDialog(null, "Choose an option", "POE", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optionsTask, optionsTask[0]);
        switch (option) {
            case 0:
                addTask();
                break;
        }
    }

    public void addTask() {
        int num = Integer.parseInt(JOptionPane.showInputDialog("how many tasks you want to add?"));
        for (int i = 0; i < num; i++) {

            final String optionsStatys[] = { "To Do", "Doing", "Done" };
            String taskName = JOptionPane.showInputDialog("Enter the task name");
            String taskDescription = JOptionPane.showInputDialog("Enter the task description");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration"));
            int taskNumber = Task.taskList.size() + 1;
            int taskStatus = JOptionPane.showOptionDialog(null, "Choose a option", "POE", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, optionsStatys, optionsStatys[0]);
            if (!checkTaskDescription(taskDescription)) {
                addTask();
                return;
            }
            TaskDetails task = new TaskDetails(taskName, taskDescription, taskDuration, firstName, lastName,
                    taskNumber, taskStatus);
            taskList.add(task);
        }
        JOptionPane.showMessageDialog(null, "Total hours: " + returnTotalHours());
    }

    public boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Task description successfully captured");
            return true;
        }
    }

    private static int returnTotalHours() {
        int totalhours = 0;
        for (TaskDetails task : taskList) {
            totalhours += task.taskDuration;
        }
        return totalhours;
    }
}

class TaskDetails {
    final String tab = "    ";
    String taskName, taskDescription, userName, password, firstName, lastName, taskID;
    int taskStatus, taskDuration, taskNumber, index;

    public TaskDetails(String taskName, String taskDescription, int taskDuration, String firstName, String lastName,
            int taskNumber, int taskStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskID = taskID(firstName, lastName);
        this.index = Task.taskList.size();
        // Task.taskList.add(this);

        JOptionPane.showMessageDialog(null, taskStatus + tab + firstName + tab + lastName + tab + taskNumber + tab
                + taskName + tab + taskDescription + tab + taskID + tab + taskDuration);
    }

    // check this method
    public String taskID(String firstName, String lastName) {
        return taskName.substring(0, 2) + ":" + taskNumber + ":"
                + firstName.substring(firstName.length() - 3, firstName.length());
    }

}
