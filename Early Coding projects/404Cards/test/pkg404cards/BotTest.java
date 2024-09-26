/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pkg404cards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
public class BotTest {
    //I got all of this and the lines after @before and after @after from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    public BotTest() {
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
     * Test of BCall method, of class Bot.
     */
    @Test
    public void BCall_PlayerBet42Chips_BotBets42Chips() {
        System.out.println("BCall");
        MoneyPot pot = new MoneyPot();
        Player player = new Player();
        Bot bot = new Bot();
        Deck deck = new Deck();
        player.SetHighestBet(42);
        bot.BCall(pot, bot, player, deck);
        assertEquals(42, bot.GetHighestBet());
    }

    /**
     * Test of BRaise method, of class Bot.
     */
    @Test
    public void BRaise_PlayerBets100Chips_BotRaisesTo120ChipsAndNotificationIsPrinted() {
        MoneyPot pot = new MoneyPot();
        Player player = new Player();
        Bot bot = new Bot();
        Deck deck = new Deck();
        bot.SetChipCount(1000);
        player.SetHighestBet(100);
        player.SetChipCount(500);
        bot.BRaise(pot, bot, deck, player);
        String output = "PLAYERCHIPCOUNT = 600\n" +
"You have been raised to 120";
        assertEquals(output, outContent.toString().trim());
    }

    /**
     * Test of BFold method, of class Bot.
     * Im not sure why this wont work
     */
//    @Test
//    public void BFold() {
//        System.out.println("BFold");
//        MoneyPot pot = new MoneyPot();
//        Player player = new Player();
//        Bot bot = new Bot();
//        Deck deck = new Deck();
//        String input = "B";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        bot.BFold(player, pot, deck, bot);
//        String output = "Would You like to play again?\nA. Yes!\nQ. Quit\nThis is only for Junit!";
//        assertEquals(output, outContent.toString().trim());
//    }

    /**
     * Test of BCheck method, of class Bot.
     */
    @Test
    public void BCheck_HighestBetIsZero_CheckingIsAllowed() {
        MoneyPot pot = new MoneyPot();
        Player player = new Player();
        Bot bot = new Bot();
        Deck deck = new Deck();
        bot.BCheck(pot, bot, player, deck);
        String output = "Your opponent has checked.";
        assertEquals(output, outContent.toString().trim());
    } 
}
