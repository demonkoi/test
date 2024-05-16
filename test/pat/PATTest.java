/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pat;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jethr
 */
public class PATTest {

    Login log = new Login();

    @Test
    public void everything() {
        checkLogin();
        checkPassword();
        checkUserName();
        testLogin();
        testPassword();
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

    public void testPassword() {
        assertFalse(log.checkPasswordComplexity("password"));
        assertTrue(log.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    /**
     * Test of main method, of class PAT.
     */
}