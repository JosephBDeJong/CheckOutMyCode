/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pkg404cards;

import java.io.ByteArrayOutputStream;
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
public class DeckTest {
    
    
    public DeckTest() {
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
     * Test of Shuffle method, of class Deck.
     */
    @Test
    public void Shuffle_DeckIsNewPackOrder_DeckBecomesRandomOrder() {
        System.out.println("Shuffle");
        Deck instance = new Deck();
        Deck unShuffled = new Deck();
        instance.Shuffle();
        assertNotEquals(unShuffled, instance);
    }

    /**
     * Test of DealFlop method, of class Deck.
     */
    @Test
    public void DealFlop_AddingThreeCardsToTheCommunityCards_FullFlopDisplayed() {
        System.out.println("DealFlop");
        Deck instance = new Deck();
        ArrayList<Card> cards = new ArrayList<>();
        String output = "[5 of Hearts, 6 of Hearts, 7 of Hearts]";
        assertEquals(output, instance.DealFlop(cards).trim());
    }

    /**
     * Test of DealTurn method, of class Deck.
     */
    @Test
    public void DealTurn_AddingOneMoreCardToTheCommunityCards_ReturnsTheNextCardInTheDeck() {
        System.out.println("DealTurn");
        Deck instance = new Deck();
        ArrayList<Card> cards = new ArrayList<>();
        String output = "[8 of Hearts]";
        assertEquals(output, instance.DealTurn(cards));
    }

    /**
     * Test of DealRiver method, of class Deck.
     */
    @Test
    public void DealRiver_AddingOneMoreCardToTheCommunityCards_ReturnsTheNextCardInTheDeck() {
        System.out.println("DealRiver");
        Deck instance = new Deck();
        ArrayList<Card> cards = new ArrayList<>();
        String output = "[9 of Hearts]";
        assertEquals(output, instance.DealRiver(cards));
    }

    /**
     * Test of DisplayPlayerCards method, of class Deck.
     */
    @Test
    public void DisplayPlayerCards_FillArrayListWithTwoCards_PlayerCardsSavedInAnArrayList() {
        System.out.println("DisplayPlayerCards");
        ArrayList<Card> playerHand = new ArrayList<Card>();
        Deck instance = new Deck();
        String output = "[Ace of Hearts, 2 of Hearts]";
        assertEquals(output, instance.DisplayPlayerCards(playerHand));
    }

    /**
     * Test of SetBotCards method, of class Deck.
     */
    @Test
    public void SetBotCards_BotTakesTwoCards_BotHasAnArrayListWithTwoCardObjects() {
        System.out.println("SetBotCards");
        ArrayList<Card> botHand = new ArrayList<Card>();
        Deck instance = new Deck();
        instance.SetBotCards(botHand);
        assertEquals(2, botHand.size());
    }
    
}
