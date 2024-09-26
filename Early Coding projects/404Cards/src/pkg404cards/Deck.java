/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author josephdejong
 */
public class Deck {
    
    
    //==========================================================================
    //PROPERTIES
    //========================================================================== 
    private static final int SIZE_OF_DECK = 52;
    
    private static int playerCount = 2;
    public int GetPlayerCount() { return playerCount; }
    public void SetPlayerCount(int playerCount) {  
        this.playerCount = playerCount; }
    
    private static final Random number = new Random();
    
    String values[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
    public Card[] deck = new Card[SIZE_OF_DECK];
    ArrayList<Card> communityCards = new ArrayList<Card>();
    

    //==========================================================================
    //CONSTRUCTORS
    //==========================================================================
    //https://www.youtube.com/watch?v=HFHEs9DsO2I
        
    /**
     * Default constructor
     */
    public Deck(){
        for(int i = 0; i < deck.length; i++) {
            deck[i] = new Card(values[i % 13], suits[i / 13]);
        }
    }
    
    //==========================================================================
    //METHODS
    //==========================================================================
    /**
     * Method to fill up the deck
     */
    public void FillDeck(){
        for(int i = 0; i < deck.length; i++) {
            deck[i] = new Card(values[i % 13], suits[i / 13]);
    }
    }
    /**
     * Method to shuffle the deck
     * https://www.geeksforgeeks.org/collections-shuffle-method-in-java-with-examples/#
     */
    public void Shuffle(){
        Collections.shuffle(Arrays.asList(deck)); 
    }
    
    /**
     * Method is never used in final production just used to show what the user and bot have for cards
     * https://stackoverflow.com/questions/7762848/increment-variable-names
     */
    public void DealCards(){
       ArrayList<Card> hands = new ArrayList<Card>();
       for(int i = 0; i < (2 * GetPlayerCount()); i++){       
           hands.add(deck[i]);
       }
       //Take this sout out for the final version
       System.out.println(hands.toString());
    }
    
    /**
     * Method to deal cards at the flop
     * @param communityCards
     * @return 
     */
    public String DealFlop(ArrayList<Card> communityCards){
        for(int i = 0; i < 3; i++){
            communityCards.add(deck[i + (2 * GetPlayerCount())]);
        }
        return communityCards.toString();
    }
    
    /**
     * Method to deal cards at the turn
     * @param communityCards
     * @return 
     */
    public String DealTurn(ArrayList<Card> communityCards){ 
        communityCards.add(deck[3 + (2 * GetPlayerCount())]);
        return communityCards.toString();  
    }
    
    /**
     * Method to deal cards at the river
     * @param communityCards
     * @return 
     */
    public String DealRiver(ArrayList<Card> communityCards){ 
            communityCards.add(deck[4 + (2 * GetPlayerCount())]);
            return communityCards.toString();  
    }
    
    /**
     * Method to display the players cards
     * @param playerHand
     * @return 
     */
    public String DisplayPlayerCards(ArrayList<Card> playerHand){
        playerHand.add(deck[0]);
        playerHand.add(deck[1]);
        return playerHand.toString();
    }
    
    /**
     * Method to add cards to the bot's hand
     * @param botHand 
     */
    public void SetBotCards(ArrayList<Card> botHand){
        botHand.add(deck[2]);
        botHand.add(deck[3]);
    }
    }
    

