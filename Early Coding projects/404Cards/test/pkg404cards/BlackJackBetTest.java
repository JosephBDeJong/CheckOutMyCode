/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pkg404cards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
public class BlackJackBetTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    public BlackJackBetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Bet method, of class BlackJackBet.
     */
    @Test
    public void Bet_UserInputOverPot_BetsUsersEntirePot() {
        BlackJackBet playerBet = new BlackJackBet(0);
        PlayerMoney playerMoney = new PlayerMoney(50);
        
        String input = "55";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BlackJackBet.Bet(playerBet, playerMoney);
        int expResult = 50;
        assertEquals(expResult, playerBet.GetAmount());
    }
    
}
