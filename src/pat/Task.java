package pat;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Task {

   
    static ArrayList<TaskDetails> taskList = new ArrayList<TaskDetails>();
    String userName, firstname, lastname;
    public Task(String userName, String firstname, String lastname) {
        this.userName = userName;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public void taskScreen(){
        final String optionsTask[] = { "Add task", "Show Report", "Quit" };
        int option = JOptionPane.showOptionDialog(null, "Choose an option", "PAT", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optionsTask, optionsTask[0]);
        switch (option) {
            case 0:
                addTask();
                break;
        }
    }
    public void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter the task name");
        String taskDescription = JOptionPane.showInputDialog("Enter the task description");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration"));
        int taskNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter the task number"));
        TaskDetails task = new TaskDetails(taskName, taskDescription, taskDuration,firstname,lastname,taskNumber);
    }
   
}
class TaskDetails {
    String taskName, taskDescription,userName,password,firstname,lastname;
    int taskStatus,taskDuration,taskNumber, taskid;
    public TaskDetails(String taskName, String taskDescription, int taskDuration,String firstName,String lastName,int taskNumber) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        Task.taskList.add(this);
    }
}
