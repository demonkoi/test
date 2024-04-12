/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pat.login;

/**
 *
 * @author jethr
 */
public class codeTest {
    
    public codeTest() {
    }
     login log = new login();
    @BeforeAll
    public static void setUpClass() {
    }
    @Test
    public void testLogin(){
           assertEquals(true, log.checkUsername("us_e"));
        assertEquals(false, log.checkUsername("user"));
    }
      @Test
    public void testCreateUser() {
        assertTrue(log.checkUsername("kyl_1"));
        assertFalse(log.checkUsername("kyle!!!!!"));
        assertTrue(log.checkPasswordComplexity("Ch&&sec@ke99!”"));
        assertFalse(log.checkPasswordComplexity("password"));
    }
}
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
