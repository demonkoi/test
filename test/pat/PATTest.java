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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author jethr
 */
public class PATTest {
    
    public PATTest() {
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
    
    @Test public void everything(){
               login log = new login();
    //assertTrue(log.loginUser("kyl_1", "Ch&&sec@ke99!"));
//        
        assertEquals(true,log.checkUsername("kyl_1"));
        assertEquals(false,log.checkUsername("kyle!!!!!"));
       assertEquals(true,log.checkPasswordComplexity("Ch&&sec@ke99!"));
       assertEquals(false,log.checkPasswordComplexity("password"));
       
        assertTrue(log.loginUser("j_dea", "Liebrman!@#$5"));
        assertFalse(log.loginUser("asf", "askj)-w"));
        assertTrue(log.checkUsername("asd_s"));
        assertFalse(log.checkUsername("akjer33krs_"));
        
    }

    /**
     * Test of main method, of class PAT.
     */
    @Test
    public void testMain() {
        
        
//        System.out.println("main");
//        String[] args = null;
//        PAT.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of entryScreen method, of class PAT.
     */
    @Test
    public void testEntryScreen() {
        System.out.println("entryScreen");
        PAT.entryScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of taskScreen method, of class PAT.
     */
    @Test
    public void testTaskScreen() {
        System.out.println("taskScreen");
        PAT instance = new PAT();
        instance.taskScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
