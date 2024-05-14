/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PAT {
    private static final String optionEnter[] = { "Login", "Register", "Exit" };
    static JFrame frame = new JFrame();

    public static void main(String[] args) {
        // frame.setVisible(true);
        entryScreen();

    }

    public static void entryScreen() {
        Login log = new Login();
        int option = JOptionPane.showOptionDialog(null, "Choose an option", "PAT", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optionEnter, optionEnter[0]);

        String username;
        String password;
        Boolean flag = false;
        switch (option) {
            case 0:
                do {
                    username = JOptionPane.showInputDialog("Enter your username");
                    password = JOptionPane.showInputDialog("Eneter your password");
                    flag = log.loginUser(username, password);
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Login successful");
                        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login failed");
                    }
                    System.out.println(flag);
                    Task task = new Task(log.getUserName(), username, password);
                } while (!flag);
                break;
            case 1:
                log.createUser();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    public void taskScreen() {
        final String optionsTask[] = { "Add task", "Show Report", "Exit" };
        int option = JOptionPane.showOptionDialog(null, "Choose an option", "PAT", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optionsTask, optionsTask[0]);
        switch (option) {
            case 0:
                // task t = new task(log.getUserName(), log.getPassword(), log.getFirstName(),
                // log.getLastName());
                break;

        }

    }
}
// assertTrue(register.checkUsername("kyl_1"));
// assertFalse(register.checkUsername("kyle!!!!!"));
// assertTrue(register.checkPasswordComplexity("Ch&&sec@ke99!”"));
// assertFalse(register.checkPasswordComplexity("password"));