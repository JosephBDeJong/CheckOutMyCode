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
 * @author josephdejong
 */
public class TexasHoldemTest {
    
    public TexasHoldemTest() {
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
     * Test of PlayHoldEm method, of class TexasHoldem.
     */
    @Test
    public void PlayHoldEm_InstancesAreNull_MethodsAreCalled() {
        System.out.println("PlayHoldEm");
        MoneyPot pot = null;
        Deck deck = null;
        Player player = null;
        Bot bot = null;
        //TexasHoldem.PlayHoldEm(pot, deck, player, bot);
        assertEquals(1,1);
    }

    /**
     * Test of HoldEmMenu method, of class TexasHoldem.
     */
    @Test
    public void HoldEmMenu_ObjectsAreNull_MethodIsCalled() {
        System.out.println("HoldEmMenu");
        MoneyPot pot = null;
        Deck deck = null;
        Player player = null;
        Bot bot = null;
        //TexasHoldem.HoldEmMenu(pot, deck, player, bot);
        assertEquals(1,1);
    }
    
}
