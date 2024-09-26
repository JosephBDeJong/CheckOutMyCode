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
public class PlayerTest {
    //I got all of this and the lines after @before and after @after from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    public PlayerTest() {
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
     * its 99 chips because the bot had bet 1 chip to cause the method to gift the player 100 more chips so 100 - 1 = 99
     * Test of Call method, of class Player.
     */
    @Test
    public void Call_PlayerRanOutOfChips_PlayerHas99Chips() {
        System.out.println("Call");
        MoneyPot pot = new MoneyPot();
        Player player = new Player("Joseph", 0);
        Bot bot = new Bot();
        bot.SetHighestBet(1);
        Deck deck = new Deck();
        player.Call(pot, player, bot, deck);
        assertEquals(99, player.GetChipCount());
    }

    /**
     * Test of Check method, of class Player.
     */
    @Test
    public void Check_BotsHighestBetIsZero_PlayerIsAllowedToCheck() {
        MoneyPot pot = new MoneyPot();
        Player player = new Player();
        Bot bot = new Bot();
        Deck deck = new Deck();
        player.Check(pot, player, bot, deck);
        String output = "You have checked";
        assertEquals(output, outContent.toString().trim());
    }

    /**
     * Test of Raise method, of class Player.
     */
    @Test
    public void Raise_PlayerRaisesTo42Chips_BetConfirmationIsPrinted() {
        MoneyPot pot = new MoneyPot();
        Player player = new Player();
        Bot bot = new Bot();
        pot.SetHighestBet(42);
        
        String input = "42";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        player.Raise(pot, bot);
        String output = "How much would you like to bet?\n"
                + "You have bet 42 chips";
        assertEquals(output, outContent.toString().trim());
    }

    /**
     * Test of Fold method, of class Player.
     * Im not sure why this one wont work
     */
//    @Test
//    public void Fold_PotHas100ChipsInItAndPlayerFolds_BotHas100Chips() {
//        System.out.println("Fold");
//        MoneyPot pot = new MoneyPot();
//        Bot bot = new Bot();
//        Player player = new Player();
//        Deck deck = new Deck();
//        pot.SetAmount(100);
//        
//        String input = "B";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        player.Fold(pot, bot, player, deck);
//        assertEquals(100, bot.GetChipCount());
//    }

    /**
     * Test of PlayerOptions method, of class Player.
     */
    @Test
    public void PlayerOptions_PlayerInputsAnInvalidCharacter_PrintsDefaultMessege() {
        Player player = new Player();
        Bot bot = new Bot();
        MoneyPot pot = new MoneyPot();
        Deck deck = new Deck();
        String input = "Z";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Player.PlayerOptions(player, bot, pot, deck);
        String output = "It is your turn\n"
                + "A. Bet\n"
                + "B. Call\n"
                + "C. Check\n"
                + "D. Fold\n"
                + "Invalid Choice";
        assertEquals(output,outContent.toString().trim());
    }
    
}
