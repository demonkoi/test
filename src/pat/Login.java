package pat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Login {
    private String userName, password, firstname, lastname;

    public void createUser() {
        setfirstname();
        setlastname();
        setuserName();
        setpassword();
        JOptionPane.showMessageDialog(null, registerUser());
    }

    public String registerUser() {
        if (!checkUsername(userName))
            return "Username must be at least 5 characters long and contain an underscore.";
        else if (!checkPasswordComplexity(password))
            return "Password must be at least 8 characters long and contain at least one uppercase letter, one digit, and one special character.";
        else {
            saveUser();
            return "password and username formatted correctly user has been created";
        }

    }

    // read from user file and check if user has entered username password correctly
    public boolean loginUser(String userName, String password) {
        try {
            File file = new File("userDetails.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String userData = sc.nextLine();
                // check if the username and password are in the file

                // split usernate into data array
                String[] data = userData.split(" ", 0);
                if (userName.equals(data[0]) && password.equals(data[1])) {
                    this.userName = data[0];
                    this.password = data[1];
                    this.firstname = data[2];
                    this.lastname = data[3];
                    sc.close();
                    return true;
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("invalid username or password");
            e.printStackTrace();
        }
        return false;
    }

    // check if the username satisfies the requirements
    public boolean checkUsername(String userName) {
        if (userName.length() < 6 && userName.contains("_")) {
            System.out.println("Password succesfully captured");
            return true;
        } else {
            System.out.println("the username is not formatted, please"
                    + "ensure that your username contains a underscore"
                    + "and is no more than 5 characters in length");
            return false;
        }
    }

    // check name length
    public boolean checkName() {
        if (firstname.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // checks password complexity to
    public boolean checkPasswordComplexity(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasRightNum = false;
        boolean hasNoSpace = false;
        if (password.length() > 7) {
            hasRightNum = true;
        }
        for (int i = 0; i < password.length(); i++) {
            // check uppercase
            int ascii = (int) password.charAt(i);
            if (Character.isUpperCase(password.charAt(i))) {
                hasLetter = true;
            }
            // check char
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
            if ((ascii > 32 && (ascii < 48)) ||
                    (ascii > 57 && (ascii < 65)) ||
                    (ascii > 90 && (ascii < 97)) ||
                    (ascii > 122)) {
                hasSpecial = true;
            }
            if (password.charAt(i) == ' ') {
                hasNoSpace = true;
            }

        }
        if (hasLetter && hasDigit && hasSpecial && hasRightNum && !hasNoSpace) {
            System.out.println("password successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure"
                    + "that the password contains at least 8 characters, a capital Letter."
                    + "a number and a special character");
            return false;
        }
    }

    // set methods
    // ------------------------------------------------------------------------------//
    // set username
    public void setuserName() {
        userName = JOptionPane.showInputDialog("username", "Enter username: ");
        while (!checkUsername(userName)) {
            JOptionPane.showMessageDialog(null,
                    "Username must be at least 5 characters long and contain an underscore.");
            userName = JOptionPane.showInputDialog("Enter username: ");
        }
        JOptionPane.showMessageDialog(null, "Username successfully captured.");
    }

    // set password
    public void setpassword() {
        password = JOptionPane.showInputDialog("Enter password: ");
        while (!checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null,
                    "Password must be at least 8 characters long and contain at least one uppercase letter, one digit, and one special character.");
            password = JOptionPane.showInputDialog("Enter password: ");
        }
        JOptionPane.showMessageDialog(null, "password successfully captured.");
    }

    // set firstname
    public void setfirstname() {
        firstname = JOptionPane.showInputDialog("Enter first name:");
        while (!checkName()) {
            firstname = JOptionPane.showInputDialog("Enter first name:");
        }
    }

    // set lastname
    public void setlastname() {
        lastname = JOptionPane.showInputDialog("Enter last name:");
        while (!checkName()) {
            lastname = JOptionPane.showInputDialog("Enter last name:");
        }

    }

    // save user to file
    public void saveUser() {
        try {
            File users = new File("userDetails.txt");
            if (users.createNewFile()) {
                System.out.println("File created: " + users.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("userDetails.txt", true);
            myWriter.write(userName + " " + password + " " + firstname + " " + lastname);
            myWriter.write(System.getProperty("line.separator"));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // get methods
    // ------------------------------------------------------------------------------//
    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
// --------------------------------------EOF----------------------------------------------------
// ending comments "comment something here"
