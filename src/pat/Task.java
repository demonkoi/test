package pat;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class Task extends JFrame {
    DefaultTableModel model;
    JTable table;;
    static ArrayList<TaskDetails> taskList = new ArrayList<TaskDetails>();
    static ArrayList<TaskDetails> taskFilter = new ArrayList<TaskDetails>();
    String userName, firstName, lastName;
    JButton bdelete, bsearch, badduser, blong, bpressme;
    JSpinner stime;
    JTextField tsearch, ttaskname, tfirstname, tlastname, tdescription;
    JCheckBox cdone, cdoing, ctodo, call;
    JRadioButton rdone, rdoing, rtodo;
    JLabel ldone, ldoing, ltodo, ldone1, ldoing1, ltodo1, lall, ltaskname, lfirstname, llastname, ldescription;

    public Task(String userName, String firstName, String lastName) {

        loadTask(); // load task from file
        setSize(800, 800);
        setLayout(null); // Set the layout manager to null
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        model = new DefaultTableModel();
        table = new JTable(model);

        // model.setColumnIdentifiers(namestuff);
        // Arrays.stream(namestuff).forEach(model::addColumn);
        // Arrays.stream(testdata).forEach(model::addRow);

        table.setBounds(10, 240, 600, getHeight() - 240);

        model.addColumn("Task Name"); // Add column headers to the table model
        model.addColumn("Task Description");
        model.addColumn("Task Duration");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Task Number");
        model.addColumn("Task Status");
        model.addColumn("Task ID");

        buttonSettings();
        refreshTable(taskList);

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        taskScreen();
    }

    public void refreshTable(ArrayList<TaskDetails> taskList) {
        // clear the table
        model.getDataVector().removeAllElements();
        // add the new data
        taskList.forEach(task -> {
            model.addRow(new Object[] { task.taskName, task.taskDescription, task.taskDuration, task.firstName,
                    task.lastName, task.taskNumber, task.taskStatus, task.taskID });
        });
        // refresh the table
        model.fireTableDataChanged();
    }

    public void buttonSettings() {

        // component initilisation
        bdelete = new JButton("Delete");
        bsearch = new JButton("Search");
        badduser = new JButton("Add Task");
        blong = new JButton("Longest Task");
        bpressme = new JButton("press me");

        tsearch = new JTextField("Input text here");
        ttaskname = new JTextField();
        tdescription = new JTextField();
        tfirstname = new JTextField(firstName);
        tlastname = new JTextField(lastName);

        rdoing = new JRadioButton("Doing");
        rdone = new JRadioButton("Done");
        rtodo = new JRadioButton("To Do");

        call = new JCheckBox();
        cdone = new JCheckBox();
        cdoing = new JCheckBox();
        ctodo = new JCheckBox();

        lall = new JLabel("All");
        ltodo = new JLabel("To Do");
        ldoing = new JLabel("Doing");
        ldone = new JLabel("Done");
        ldone1 = new JLabel("Done");
        ldoing1 = new JLabel("Doing");
        ltodo1 = new JLabel("To Do");

        SpinnerModel sm = new SpinnerNumberModel(0, null, null, 1);
        stime = new JSpinner(sm);

        ltaskname = new JLabel("Task Name");
        lfirstname = new JLabel("First Name");
        llastname = new JLabel("Last Name");
        ldescription = new JLabel("Description");

        // component bounds

        lall.setBounds(650, 550, 150, 50);
        ltodo.setBounds(650, 600, 150, 50);
        ldoing.setBounds(650, 650, 150, 50);
        ldone.setBounds(650, 700, 150, 50);
        ldone1.setBounds(250, 100, 70, 30);
        ldoing1.setBounds(250, 140, 70, 30);
        ltodo1.setBounds(250, 170, 70, 30);

        ltaskname.setBounds(220, 30, 90, 30);
        ldescription.setBounds(320, 30, 90, 30);
        lfirstname.setBounds(420, 30, 90, 30);
        llastname.setBounds(520, 30, 90, 30);

        stime.setBounds(300, 140, 50, 30);

        rdoing.setBounds(220, 100, 30, 30);
        rdone.setBounds(220, 140, 30, 30);
        rtodo.setBounds(220, 170, 30, 30);

        bdelete.setBounds(10, 10, 200, 50);
        bsearch.setBounds(10, 70, 200, 50);
        badduser.setBounds(500, 160, 100, 50);
        blong.setBounds(500, 100, 100, 50);
        bpressme.setBounds(620, 400, 100, 50);

        call.setBounds(620, 560, 20, 20);
        ctodo.setBounds(620, 610, 20, 20);
        cdoing.setBounds(620, 660, 20, 20);
        cdone.setBounds(620, 710, 20, 20);

        tsearch.setBounds(10, 130, 200, 50);
        ttaskname.setBounds(220, 50, 90, 30);
        tdescription.setBounds(320, 50, 90, 30);
        tfirstname.setBounds(420, 50, 90, 30);
        tlastname.setBounds(520, 50, 90, 30);

        // button group
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdoing);
        bg.add(rdone);
        bg.add(rtodo);

        // add components to frame
        add(bdelete);
        add(bsearch);
        add(badduser);
        add(blong);
        add(bpressme);
        add(table);

        add(tsearch);
        add(ttaskname);
        add(tfirstname);
        add(tlastname);
        add(tdescription);
        add(ttaskname);

        add(call);
        add(cdone);
        add(cdoing);
        add(ctodo);

        add(stime);

        add(rdone);
        add(rdoing);
        add(rtodo);

        add(lall);
        add(ldone);
        add(ldoing);
        add(ltodo);
        add(ldone1);
        add(ldoing1);
        add(ltodo1);
        add(ltaskname);
        add(lfirstname);
        add(llastname);
        add(ldescription);
        actionEvents();

        // set default values1
        tfirstname.setText(firstName);
        tlastname.setText(lastName);
    }

    public void actionEvents() {
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
        bpressme.addActionListener(e -> {
            JFrame frame2 = new JFrame();

            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.add(new Cube());
            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setVisible(true);
            frame2.setPreferredSize(new Dimension(600, 600));
            frame2.setBackground(Color.BLACK);

        });
        badduser.addActionListener(e -> {
            // get radiobutton
            int status = 0;
            if (rtodo.isSelected()) {
                status = 0;
            } else if (rdoing.isSelected()) {
                status = 1;
            } else if (rdone.isSelected()) {
                status = 2;
            }
            taskList.add(
                    new TaskDetails(ttaskname.getText(), tdescription.getText(), (int) stime.getValue(),
                            tfirstname.getText(), tlastname.getText(), status, 0));
            refreshTable(taskList);
            saveTask();
        });
        bdelete.addActionListener(e -> {
            String search = tsearch.getText();
            for (TaskDetails task : taskList) {
                if (task.taskName.equals(search)) {
                    taskList.remove(task);
                }
            }
            refreshTable(taskList);
            saveTask();
        });
        bsearch.addActionListener(e -> {
            Boolean todo, doing, done, flag;
            flag = false;
            String search = tsearch.getText();
            taskFilter.clear();
            todo = ctodo.isSelected();
            doing = cdoing.isSelected();
            done = cdone.isSelected();
            if (search.equals("")) {
                flag = true;
                return;
            }
            for (TaskDetails task : taskList) {
                if (task.taskName.equals(search) || flag) {
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
            refreshTable(taskFilter);
        });
        blong.addActionListener(e -> {
            int longest = 0;
            for (TaskDetails task : taskList) {
                if (task.taskDuration > longest) {
                    longest = task.taskDuration;
                }
            }
            JOptionPane.showMessageDialog(null, "Longest task is " + longest + " hours");
        });
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

    public void saveTask() {
        File f = new File("Tasks.txt");
        try {
            f.delete();
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (TaskDetails task : taskList) {
                fw.write(task.taskName + "," + task.taskDescription + "," + task.taskDuration +
                        "," + task.firstName + "," + task.lastName + "," + task.taskNumber + "," +
                        task.taskStatus + "," + task.taskID + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTask() {
        File f = new File("Tasks.txt");
        if (f.exists()) {
            try {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String[] task = sc.nextLine().split(",");
                    System.out.println(task[0] + "  " + task[1] + " " + task[2] + "  " + task[3] + "  " + task[4]
                            + "   " + task[5]);
                    TaskDetails t = new TaskDetails(task[0], task[1], Integer.parseInt(task[2]), task[3], task[4],
                            Integer.parseInt(task[5]), Integer.parseInt(task[6]));
                    taskList.add(t);
                }
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        saveTask();
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
