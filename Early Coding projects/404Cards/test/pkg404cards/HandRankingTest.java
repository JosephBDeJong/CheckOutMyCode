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
 * @author josephdejong
 */
public class HandRankingTest {
    //I got all of this and the lines after @before and after @after from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    public HandRankingTest() {
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
     * Test of WhoIsWinner method, of class HandRanking.
     */
    @Test
    public void WhoIsWinner_PlayerWins_NewChipNumberIsNotified() {
        Player player = new Player("Joseph", 100);
        Bot bot = new Bot("Dior", 100);
        MoneyPot pot = new MoneyPot();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String output = "Who Won?\n"
                + "Select 1 for Joseph\n"
                + "Select 2 for Dior\n"
                + "For a tie select 3\n"
                + "You win!!!!!\n"
                + "You now have 100 chips";
                
        HandRanking.WhoIsWinner(player, bot, pot);
        assertEquals(output, outContent.toString().trim());
    }
    
}
