package pat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Task extends JFrame implements ActionListener {
    DefaultTableModel model;
    JTable table;;
    static ArrayList<TaskDetails> taskList = new ArrayList<TaskDetails>();
    static ArrayList<TaskDetails> taskFilter = new ArrayList<TaskDetails>();
    String userName, firstName, lastName;
    JButton bdelete, bsearch, blongest;
    JTextField tsearch;
    JCheckBox cdone, cdoing, ctodo, call;
    JLabel ldone, ldoing, ltodo, lall;
    static String[] namestuff = { "Task Name", "Task Description", "Task Duration", "First Name", "Last Name",
            "Task Number", "Task Status" };
    static String[][] testdata = { { "micah", "micah", "micah", "micah", "micah", "micah", "micah" },
            { "Connor", "Connor", "Connor", "Connor", "Connor", "Connor", "Connor" } };

    public Task(String userName, String firstName, String lastName) {
        setSize(800, 800);
        setLayout(null); // Set the layout manager to null
        model = new DefaultTableModel();
        table = new JTable(model);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // model.setColumnIdentifiers(namestuff);
        Arrays.stream(namestuff).forEach(model::addColumn);
        Arrays.stream(testdata).forEach(model::addRow);

        table.setBounds(10, 240, 600, getHeight() - 240);
        model.addColumn(namestuff);
        model.addRow(testdata);
        table.setModel(model);
        buttonSettings();

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        taskScreen();
    }

    public void refreshTable() {
        model.getDataVector().removeAllElements();
        taskList.forEach(task -> {
            model.addRow(new Object[] { task.taskName, task.taskDescription, task.taskDuration, task.firstName,
                    task.lastName, task.taskNumber, task.taskStatus });
        });
        model.fireTableDataChanged();
    }

    public void buttonSettings() {

        bdelete = new JButton("Delete");
        bsearch = new JButton("Search");
        bdelete.setBounds(10, 10, 200, 50);
        bsearch.setBounds(10, 70, 200, 50);
        bdelete.addActionListener(e -> {
            String search = tsearch.getText();
            for (TaskDetails task : taskList) {
                if (task.taskName.equals(search)) {
                    taskList.remove(task);
                }
            }
        });
        bsearch.addActionListener(e -> {
            Boolean todo, doing, done;
            String search = tsearch.getText();
            taskFilter.clear();
            todo = ctodo.isSelected();
            doing = cdoing.isSelected();
            done = cdone.isSelected();

            for (TaskDetails task : taskList) {
                if (task.taskName.equals(search)) {
                    switch (task.taskStatus) {
                        case 0:
                            if (todo) {
                                taskFilter.add(task);
                            }
                            break;
                        case 1:
                            if (doing) {
                                taskFilter.add(task);
                            }
                            break;
                        case 3:
                            if (done) {
                                taskFilter.add(task);
                            }
                            break;
                    }
                }
            }
        });
        tsearch = new JTextField("Input text here");
        tsearch.setBounds(10, 130, 200, 50);

        call = new JCheckBox();
        cdone = new JCheckBox();
        cdoing = new JCheckBox();
        ctodo = new JCheckBox();

        lall = new JLabel("All");
        ltodo = new JLabel("To Do");
        ldoing = new JLabel("Doing");
        ldone = new JLabel("Done");

        lall.setBounds(650, 550, 150, 50);
        ltodo.setBounds(650, 600, 150, 50);
        ldoing.setBounds(650, 650, 150, 50);
        ldone.setBounds(650, 700, 150, 50);

        call.setBounds(620, 560, 20, 20);
        ctodo.setBounds(620, 610, 20, 20);
        cdoing.setBounds(620, 660, 20, 20);
        cdone.setBounds(620, 710, 20, 20);

        call.addActionListener(e -> {
            if (call.isSelected()) {
                cdone.setSelected(true);
                cdoing.setSelected(true);
                ctodo.setSelected(true);
            } else {
                cdone.setSelected(false);
                cdoing.setSelected(false);
                ctodo.setSelected(false);
            }
        });
        add(bdelete);
        add(bsearch);
        add(table);

        add(tsearch);

        add(call);
        add(cdone);
        add(cdoing);
        add(ctodo);

        add(lall);
        add(ldone);
        add(ldoing);
        add(ltodo);
    }

    public void taskScreen() {
        final String optionsTask[] = { "Add task", "Show Report", "Quit" };
        int option = JOptionPane.showOptionDialog(null, "Choose an option", "POE", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optionsTask, optionsTask[0]);
        switch (option) {
            case 0:
                addTask();
                break;
            case 1:
                PAT.frame.setVisible(true);
                // Add code for "Show Report" option
                break;
            default:
                System.exit(option);
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

    @Override
    public void actionPerformed(ActionEvent arg0) {

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
