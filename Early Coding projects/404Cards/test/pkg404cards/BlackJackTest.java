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
import static pkg404cards.BlackJack.HandTotal;

/**
 *
 * @author lnber
 */
public class BlackJackTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    public BlackJackTest() {
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

    // https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
    // Used Omar Elshal's answer to figure out how to test scanner inputs.
    
    /**
     * Test of Betting method, of class BlackJack, to make sure the bet is registered as the correct amount.
     */
    @Test
    public void Betting_UserBets5_BetGetAmountEquals5() {
        BlackJackBet playerBet = new BlackJackBet(0);
        PlayerMoney playerMoney = new PlayerMoney(100);
        BlackJack instance = new BlackJack();
        
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        instance.Betting(playerBet, playerMoney);
        int expResult = 5;
        assertEquals(expResult, playerBet.GetAmount());
    }

    /**
     * Test of StartDeal method, of class BlackJack, to make sure the right cards are displayed..
     */
    @Test
    public void StartDeal_PrintsPlayerHandAndDealerCard_PrintsTheRightCards() {
        BlackJackDeck deck = new BlackJackDeck();
        deck.MakeDeck();
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        ArrayList<BlackJackCard> dealerHand = new ArrayList();
        BlackJack instance = new BlackJack();
        instance.StartDeal(playerHand, dealerHand, deck.cardHolder);
        String expResult = "You currently have: " + playerHand + " for a total amount of: " +
                HandTotal(playerHand) + System.lineSeparator() + "The Dealer is currently showing a(n) " + dealerHand.get(1).GetFace();
        assertEquals(expResult, outContent.toString().trim());
    }

    /**
     * Test of Hit method, of class BlackJack, to make sure that the new card added is correct.
     */
    @Test
    public void Hit_UserChoosesToHit_GivesThemTheCorrectCard() {
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        BlackJackDeck deck = new BlackJackDeck();
        BlackJackBet playerBet = new BlackJackBet(5);
        BlackJackCard one = new BlackJackCard("Hearts", 2, "2");
        BlackJackCard two = new BlackJackCard("Hearts", 3, "3");
        BlackJackCard three = new BlackJackCard("Hearts", 4, "4");
        playerHand.add(one);
        playerHand.add(two);
        deck.cardHolder.add(three);
        BlackJack instance = new BlackJack();
        instance.Hit(playerHand, deck.cardHolder, playerBet);
        String expResult = "4";
        assertEquals(expResult, playerHand.get(2).GetFace());
    }

    /**
     * Test of PlayerBust method, of class BlackJack, to ensure that it prints the proper statement.
     */
    @Test
    public void PlayerBust_OutputsToConsole_OutputsTheCorrectStatementAndAmount() {
        BlackJack instance = new BlackJack();
        BlackJackBet playerBet = new BlackJackBet(10);
        PlayerMoney playerMoney = new PlayerMoney(100);
        instance.playerBet.SetAmount(10);
        instance.PlayerBust();
        String expResult = "You busted! You lost: $" + playerBet.GetAmount();
        assertEquals(expResult, outContent.toString().trim());
    }

    /**
     * Test of DealerHit method, of class BlackJack, to make sure that the new card added is correct.
     */
    @Test
    public void DeakerHit_DealerGetsNewCard_GivesThemTheCorrectCard() {
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        BlackJackDeck deck = new BlackJackDeck();
        BlackJackCard one = new BlackJackCard("Hearts", 10, "10");
        BlackJackCard two = new BlackJackCard("Hearts", 5, "5");
        BlackJackCard three = new BlackJackCard("Hearts", 4, "4");
        playerHand.add(one);
        playerHand.add(two);
        deck.cardHolder.add(three);
        BlackJack instance = new BlackJack();
        int total = 0;
        instance.DealerHit(playerHand, deck.cardHolder, total);
        String expResult = "4";
        assertEquals(expResult, playerHand.get(2).GetFace());
    }

    /**
     * Test of Stay method, of class BlackJack, to ensure that they are told that they push when they accurate.
     */
    @Test
    public void Stay_PlayerAndDealerHandsEqual_NoMoneyLostOrWonTellsUserTheyPushed() {
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        playerHand.add(new BlackJackCard("Hearts", 10, "10"));
        playerHand.add(new BlackJackCard("Hearts", 7, "7"));
        ArrayList<BlackJackCard> dealerHand = new ArrayList();
        dealerHand.add(new BlackJackCard("Spades", 10, "10"));
        dealerHand.add(new BlackJackCard("Spades", 7, "7"));
        BlackJackBet playerBet = new BlackJackBet(10);
        BlackJackDeck deck = new BlackJackDeck();
        BlackJack instance = new BlackJack();
        instance.Stay(playerHand, dealerHand, playerBet, deck.cardHolder);
        String expResult = "You chose to stay with a hand of: " + playerHand + ". This totals to a value of: " + HandTotal(playerHand) + System.lineSeparator()
         + "The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + "." + System.lineSeparator() +
                "You and the Dealer push! You did not lost or win any money.";
        assertEquals(expResult, outContent.toString().trim());
    }

    /**
     * Test of DoubleDown method, of class BlackJack, to ensure that the user's bet is doubled
     */
    @Test
    public void DoubleDown_PlayerDoublesDownWithBetOf10_DoublesTheirBetToBe20() {
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        playerHand.add(new BlackJackCard("Hearts", 10, "10"));
        playerHand.add(new BlackJackCard("Spades", 10, "10"));
        ArrayList<BlackJackCard> dealerHand = new ArrayList();
        BlackJackDeck deck = new BlackJackDeck();
        deck.MakeDeck();
        BlackJack instance = new BlackJack();
        instance.playerBet.SetAmount(10);
        instance.DoubleDown(playerHand, deck.cardHolder, dealerHand);
        int expResult = 20;
        assertEquals(expResult, instance.playerBet.GetAmount());
    }

    /**
     * Test of AfterSplitOptions method, of class BlackJack, to ensure that the right statement is printed.
     */
    @Test
    public void AfterSplitOptions_UserStays_PrintsTheStatementTellingTheUserThatTheyStayed() {
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        playerHand.add(new BlackJackCard("Hearts", 10, "10"));
        playerHand.add(new BlackJackCard("Hearts", 7, "7"));
        ArrayList<BlackJackCard> dealerHand = new ArrayList();
        dealerHand.add(new BlackJackCard("Spades", 10, "10"));
        dealerHand.add(new BlackJackCard("Spades", 7, "7"));
        BlackJackDeck deck = new BlackJackDeck();
        deck.MakeDeck();
        BlackJack instance = new BlackJack();
        instance.playerBet.SetAmount(10);
        String input = "B";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        instance.AfterSplitOptions(playerHand, dealerHand, deck.cardHolder);
        String expResult = "You chose to stay with a hand of: " + playerHand + ". This totals to a value of: " + HandTotal(playerHand);
        assertEquals(expResult, outContent.toString().trim());
    }

    /**
     * Test of Deal method, of class BlackJack, to ensure that the card added is the same as the one from the deck.
     */
    @Test
    public void Deal_RemovingCardFromDeck_CardAddedToHandIsSameAsOneRemovedFromDeck() {
        ArrayList<BlackJackCard> hand = new ArrayList();
        hand.add(new BlackJackCard("Hearts", 10, "10"));
        hand.add(new BlackJackCard("Hearts", 7, "7"));
        ArrayList<BlackJackCard> deck = new ArrayList();
        deck.add(new BlackJackCard("Spades", 7, "7"));
        String expResult = deck.get(0).toString();
        BlackJack.Deal(hand, deck);
        assertEquals(expResult, hand.get(2).toString());
    }

    /**
     * Test of HandTotal method, of class BlackJack, to ensure that the total is the correct value.
     */
    @Test
    public void HandTotal_PlayerHas10And7_HandTotalEquals17() {
        ArrayList<BlackJackCard> hand = new ArrayList();
        hand.add(new BlackJackCard("Hearts", 10, "10"));
        hand.add(new BlackJackCard("Hearts", 7, "7"));
        int expResult = 17;
        assertEquals(expResult, BlackJack.HandTotal(hand));
    }

    /**
     * Test of BlackJackClause method, of class BlackJack, to ensure that it prints that the player pushes when they and the dealer both have Blackjack.
     */
    @Test
    public void BlackJackClause_BothPlayerAndDealerHaveBlackjack_PrintsThatTheyPush() {
        boolean PBJCheck = true;
        boolean DBJCheck = true;
        BlackJackBet playerBet = new BlackJackBet(10);
        PlayerMoney playerMoney = new PlayerMoney(100);
        BlackJackDeck deck = new BlackJackDeck();
        deck.MakeDeck();
        ArrayList<BlackJackCard> dealerHand = new ArrayList();
        dealerHand.add(new BlackJackCard("Hearts", 10, "10"));
        dealerHand.add(new BlackJackCard("Hearts", 11, "Ace"));
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        playerHand.add(new BlackJackCard("Spades", 10, "10"));
        playerHand.add(new BlackJackCard("Spades", 11, "Ace"));
        BlackJack instance = new BlackJack();
        String expResult = "You have BlackJack! The Dealer will now show their hand." + System.lineSeparator() + 
            "The Dealer has a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace() + System.lineSeparator() +
            "You and the Dealer BOTH have BlackJack! The hand is a push.";
        instance.BlackJackClause(PBJCheck, DBJCheck, playerBet, playerMoney, deck.cardHolder, dealerHand, playerHand);
        assertEquals(expResult, outContent.toString().trim());
    }

    /**
     * Test of BlackJackClauseSplit method, of class BlackJack, to ensure that it prints that the player pushes when they and the dealer both have Blackjack.
     */
    @Test
    public void BlackJackClauseSplit_BothTheHandAndDealerHaveBlackjack_PrintsThatTheyPush() {
        boolean PBJCheck = true;
        boolean DBJCheck = true;
        BlackJackBet playerBet = new BlackJackBet(10);
        PlayerMoney playerMoney = new PlayerMoney(100);
        BlackJackDeck deck = new BlackJackDeck();
        deck.MakeDeck();
        ArrayList<BlackJackCard> dealerHand = new ArrayList();
        dealerHand.add(new BlackJackCard("Hearts", 10, "10"));
        dealerHand.add(new BlackJackCard("Hearts", 11, "Ace"));
        ArrayList<BlackJackCard> playerHand = new ArrayList();
        playerHand.add(new BlackJackCard("Spades", 10, "10"));
        playerHand.add(new BlackJackCard("Spades", 11, "Ace"));
        BlackJack instance = new BlackJack();
        String expResult = "You have BlackJack! The Dealer will now show their hand." + System.lineSeparator() + 
            "The Dealer has a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace() + System.lineSeparator() +
            "You and the Dealer BOTH have BlackJack! The hand is a push.";
        instance.BlackJackClauseSplit(PBJCheck, DBJCheck, playerBet, playerMoney, deck.cardHolder, dealerHand, playerHand);
        assertEquals(expResult, outContent.toString().trim());
    }
    
}
