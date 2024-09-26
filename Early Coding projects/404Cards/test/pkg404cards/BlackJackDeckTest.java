/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
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
public class BlackJackDeckTest {
    
    public BlackJackDeckTest() {
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
     * Test of MakeDeck method, of class BlackJackDeck.
     */
    @Test
    public void testMakeDeck() {
        System.out.println("MakeDeck");
        BlackJackDeck instance = new BlackJackDeck();
        instance.MakeDeck();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Shuffle method, of class BlackJackDeck.
     */
    @Test
    public void testShuffle() {
        System.out.println("Shuffle");
        ArrayList<BlackJackCard> deck = null;
        BlackJackDeck instance = new BlackJackDeck();
        instance.Shuffle(deck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
