/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

/**
 *
 * @author lnber
 */
public class BlackJackCard {
    //==========================================================================
    // PROPERTIES (INSTANCE VARIABLES)
    //==========================================================================
    private String suit = "";
    public String GetSuit() { return suit; }
    public void SetSuit(String suit) { this.suit = suit; }
    
    private int value = 0;
    public int GetValue() { return value;}
    public void SetValue(int value) { this.value = value; }
    
    private String face = "";
    public String GetFace() { return face; }
    public void SetFace(String face) { this.face = face; }
    
    //==========================================================================
    // CONSTRUCTORS
    //==========================================================================
    /**
     * Default Constructor
     */
    public BlackJackCard() {}
    
    /**
     * Constructor for Suit and Face
     * @param suit
     * @param face 
     */
    public BlackJackCard(String suit, String face) {
        SetSuit(suit);
        SetFace(face);
    }
    
    /**
     * Full constructor
     * @param suit
     * @param value
     * @param face 
     */
    public BlackJackCard(String suit, int value, String face) {
        SetSuit(suit);
        SetValue(value);
        SetFace(face);
    }
        
    //==========================================================================
    // METHODS
    //==========================================================================
    /**
     * Method to return the face and suit of the card.
     * @return GetFace & GetSuit
     */
    @Override
    public String toString() {
        return GetFace() + " of " + GetSuit();
    }
    
    
}
