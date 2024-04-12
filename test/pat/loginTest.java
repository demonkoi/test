/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jethr
 */
public class loginTest {
    
    public loginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class login.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        login instance = new login();
        instance.createUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        login instance = new login();
        String expResult = "";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        login instance = new login();
        boolean expResult = false;
        boolean result = instance.loginUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class login.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String userName = "";
        login instance = new login();
        boolean expResult = false;
        boolean result = instance.checkUsername(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkName method, of class login.
     */
    @Test
    public void testCheckName() {
        System.out.println("checkName");
        login instance = new login();
        boolean expResult = false;
        boolean result = instance.checkName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        login instance = new login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setuserName method, of class login.
     */
    @Test
    public void testSetuserName() {
        System.out.println("setuserName");
        login instance = new login();
        instance.setuserName();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setpassword method, of class login.
     */
    @Test
    public void testSetpassword() {
        System.out.println("setpassword");
        login instance = new login();
        instance.setpassword();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setfirstname method, of class login.
     */
    @Test
    public void testSetfirstname() {
        System.out.println("setfirstname");
        login instance = new login();
        instance.setfirstname();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setlastname method, of class login.
     */
    @Test
    public void testSetlastname() {
        System.out.println("setlastname");
        login instance = new login();
        instance.setlastname();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveUser method, of class login.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        login instance = new login();
        instance.saveUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class login.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        login instance = new login();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class login.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        login instance = new login();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class login.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        login instance = new login();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class login.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        login instance = new login();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
