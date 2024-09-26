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
public class BlackJackCardTest {
    
    public BlackJackCardTest() {
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
     * Test of GetSuit method, of class BlackJackCard.
     */
    @Test
    public void testGetSuit() {
        System.out.println("GetSuit");
        BlackJackCard instance = new BlackJackCard();
        String expResult = "";
        String result = instance.GetSuit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetSuit method, of class BlackJackCard.
     */
    @Test
    public void testSetSuit() {
        System.out.println("SetSuit");
        String suit = "";
        BlackJackCard instance = new BlackJackCard();
        instance.SetSuit(suit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetValue method, of class BlackJackCard.
     */
    @Test
    public void testGetValue() {
        System.out.println("GetValue");
        BlackJackCard instance = new BlackJackCard();
        int expResult = 0;
        int result = instance.GetValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetValue method, of class BlackJackCard.
     */
    @Test
    public void testSetValue() {
        System.out.println("SetValue");
        int value = 0;
        BlackJackCard instance = new BlackJackCard();
        instance.SetValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetFace method, of class BlackJackCard.
     */
    @Test
    public void testGetFace() {
        System.out.println("GetFace");
        BlackJackCard instance = new BlackJackCard();
        String expResult = "";
        String result = instance.GetFace();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetFace method, of class BlackJackCard.
     */
    @Test
    public void testSetFace() {
        System.out.println("SetFace");
        String face = "";
        BlackJackCard instance = new BlackJackCard();
        instance.SetFace(face);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BlackJackCard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BlackJackCard instance = new BlackJackCard();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
