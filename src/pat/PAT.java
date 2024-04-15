//source code for the main class of the project
package pat;
//NB: the Tast class is still in development and not yet implemented and there are artifacts of that 
//in the code
import javax.swing.JOptionPane;
public class PAT {
    private static final String optionEnter[] = { "Login", "Register", "Exit" };
    //create login instance
    static Login log = new Login();
    public static void main(String[] args) {
        System.out.println("Hello World!");
        entryScreen();
    }

    // method to display the entry screen
    public static void entryScreen() {
        
        int option = JOptionPane.showOptionDialog(null, "Choose an option", "PAT", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optionEnter, optionEnter[0]);
        switch (option) {
            case 0:
                String username = JOptionPane.showInputDialog("Enter your username");
                String password = JOptionPane.showInputDialog("Enter your password");
                if (log.loginUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    // task task = new task(log.getUserName(), log.getPassword(),
                    // log.getFirstName(),
                    // log.getLastName());
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed");
                }
                break;
            case 1:
                log.createUser();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    // method to display the task screen not yet implemented
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
// -----------------------