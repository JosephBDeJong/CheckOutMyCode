/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pkg404cards;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class MoneyPotTest {
    //I got all of this and the lines after @before and after @after from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    public MoneyPotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    /**
     * Test of IsPotGood method, of class MoneyPot.
     */
    @Test
    public void IsPotGood_PlayerAndBotHaveBetTheSameAmountForTheFlop_BettingRoundEnds() {
        Player player = new Player();
        Bot bot = new Bot();
        MoneyPot pot = new MoneyPot();
        Deck deck = new Deck();
        player.SetHighestBet(0);
        bot.SetHighestBet(0);
        pot.IsPotGood(player, bot, pot, deck);
        String expectedOutput = "Betting round finished";
        
        assertEquals(expectedOutput, outContent.toString().trim());
    }
    
}
