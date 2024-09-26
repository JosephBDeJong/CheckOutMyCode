/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author lnber
 */
public class BlackJackDeck extends BlackJackCard {
    //==========================================================================
    // PROPERTIES (INSTANCE VARIABLES)
    //==========================================================================
    protected ArrayList<BlackJackCard> cardHolder;
    
    String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String faces[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    int values[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private BlackJackCard AHearts = new BlackJackCard("Hearts", 1, "Ace");
    private BlackJackCard ADiamonds = new BlackJackCard("Diamonds", 1, "Ace");
    private BlackJackCard AClubs = new BlackJackCard("Clubs", 1, "Ace");
    private BlackJackCard ASpades = new BlackJackCard("Spades", 1, "Ace");
    private final int SIZE_OF_DECK = 48;
    
    
    //==========================================================================
    // CONSTRUCTORS
    //==========================================================================
    /**
     * Default Constructor for BlackJackDeck
     */
    public BlackJackDeck() {
        cardHolder = new ArrayList<BlackJackCard>();
    }
    
    //==========================================================================
    // METHODS
    //==========================================================================
    /**
     * Method to make a new deck. Clears old contents and re-adds all 52 cards, then shuffles the deck.
     */
    public void MakeDeck() {
        // Clearing the deck
        cardHolder.clear();
        // Adding the new cards
        cardHolder.add(AHearts);
        cardHolder.add(ADiamonds);
        cardHolder.add(AClubs);
        cardHolder.add(ASpades);
        for(int i = 0; i < SIZE_OF_DECK; i++) {
            cardHolder.add(new BlackJackCard(suits[i/12], values[i % 12], faces[i % 12]));
        }
        // Shuffling deck
        Shuffle(cardHolder);
    }
    
    /**
     * Method to shuffle the contents of a deck
     * @param deck 
     */
    public void Shuffle(ArrayList<BlackJackCard> deck) {
        Collections.shuffle(deck);
    }
    
    
}
