/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pkg404cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lnber
 */
public class PlayerMoneyTest {
    
    public PlayerMoneyTest() {
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
     * Test of GetPot method, of class PlayerMoney.
     */
    @Test
    public void testGetPot() {
        System.out.println("GetPot");
        PlayerMoney instance = new PlayerMoney();
        int expResult = 0;
        int result = instance.GetPot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetPot method, of class PlayerMoney.
     */
    @Test
    public void testSetPot() {
        System.out.println("SetPot");
        int pot = 0;
        PlayerMoney instance = new PlayerMoney();
        instance.SetPot(pot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
