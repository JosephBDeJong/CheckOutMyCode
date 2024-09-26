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
public class Card {
    //==========================================================================
    //PROPERTIES
    //==========================================================================
    // I have this as a string so that we can put A, K, Q, J in as values. 
    private String cardValue = "";
    public String GetCardValue() { return cardValue; }
    public void SetCardValue(String cardValue) {  
        this.cardValue = cardValue; }
    
    private String cardSuit = "";
    public String GetCardSuit() { return cardSuit; }
    public void SetCardSuit(String cardSuit) {  
        this.cardSuit = cardSuit; }
    
    //==========================================================================
    //CONSTRUCTORS
    //==========================================================================
    /**
     * Default constructor
     */
    public Card(){}
    
    /**
     * Full constructor
     * @param cardValue
     * @param cardSuit 
     */
    public Card(String cardValue, String cardSuit){
        SetCardValue(cardValue);
        SetCardSuit(cardSuit);
    }
    //==========================================================================
    //METHODS
    //==========================================================================
    /**
     * Overriding the toString method to show the value and suit of the cards
     * @return 
     */
    @Override
    public String toString(){
        return GetCardValue() + " of " + GetCardSuit();
    }
    
    }

