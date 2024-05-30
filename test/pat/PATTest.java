/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pat;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 *
 * @author jethr
 */
public class PATTest {

    Task task = new Task();
    Login log = new Login();
    static ArrayList<TaskDetails> testData = new ArrayList<TaskDetails>();

    @Test
    public void everything() {
        checkLogin();
        checkPassword();
        checkUserName();
        testLogin();
        addData();
        testhours();
        testDescription();
        testTaskID();
    }

    @Test
    public void testTask() {
        addData();
        testhours();
        testDescription();
        testTaskID();
    }

    public void addData() {
        testData.add(
                new TaskDetails("Login Feature", "Create Login to Authenticate users", 8, "Robyn", "Harrison", 1, 0));
        testData.add(new TaskDetails("add task feature", "Create Add Task feature tp add task users", 10, "Mike",
                "Smith", 2, 1));
    }

    @Test
    public void checkUserName() {
        assertEquals(true, log.checkUsername("kyl_1"));
        assertEquals(false, log.checkUsername("kyle!!!!!"));
    }

    @Test
    public void checkPassword() {
        assertEquals(false, log.checkPasswordComplexity("password"));
        assertEquals(true, log.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void checkLogin() {
        assertTrue(log.loginUser("j_dea", "Liebrman!@#$5"));
        assertFalse(log.loginUser("asf", "askj)-w"));
    }

    @Test
    public void testLogin() {
        assertTrue(log.checkUsername("asd_s"));
        assertFalse(log.checkUsername("akjer33krs_"));
    }

    @Test
    public void testDescription() {
        testData.forEach(e -> {
            assertTrue(task.checkTaskDescription(e.taskDescription));
        });
    }

    @Test
    public void testhours() {
        assertEquals(12, task.returnTotalHours(testData));
    }

    @Test
    public void testTaskID() {
        assertEquals("AD:1:BYN", testData.get(1).taskID);
    }
    /**
     * Test of main method, of class PAT.
     */
}