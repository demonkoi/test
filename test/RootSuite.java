/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pat.login;

/**
 *
 * @author jethr
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({pat.PatSuite.class})
public class RootSuite {
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testCreateUser() {
            login log = new login();
            System.out.println("call");
               // assertFalse(log.loginUser("kyleeeee","password"));
        
    }
    @Test
    public void testLogin(){
        login log = new login();
        
    
        
        assertTrue(log.loginUser("kyl_1", "Ch&&sec@ke99!"));
        
        assertTrue(log.checkUsername("kyl_1"));
        
        assertFalse(log.checkUsername("kyle!!!!!"));
        
        assertTrue(log.checkPasswordComplexity("Ch&&sec@ke99!"));
        
        assertFalse(log.checkPasswordComplexity("password"));
        
    }

    @After
    public void tearDown() throws Exception {
    }
}
    

